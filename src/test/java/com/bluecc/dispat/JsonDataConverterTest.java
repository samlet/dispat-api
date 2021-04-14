package com.bluecc.dispat;

import com.uber.cadence.*;
import com.uber.cadence.converter.DataConverter;
import com.uber.cadence.converter.JsonDataConverter;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class JsonDataConverterTest {

    private final DataConverter converter = JsonDataConverter.getInstance();

    static class TestData {
        String val1;
        // TBase value;
        HistoryEvent val2;
        // TEnum value;
        EventType val3;

        public TestData(String val1, HistoryEvent val2, EventType val3) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TestData)) return false;
            TestData testData = (TestData) o;
            return Objects.equals(val1, testData.val1)
                    && Objects.equals(val2, testData.val2)
                    && val3 == testData.val3;
        }

        @Override
        public int hashCode() {

            return Objects.hash(val1, val2, val3);
        }
    }


    @Test
    public void testThriftFieldsInPOJO() {
        WorkflowExecutionStartedEventAttributes started =
                new WorkflowExecutionStartedEventAttributes()
                        .setExecutionStartToCloseTimeoutSeconds(11)
                        .setIdentity("testIdentity")
                        .setInput("input".getBytes(StandardCharsets.UTF_8))
                        .setWorkflowType(new WorkflowType().setName("workflowType1"))
                        .setTaskList(new TaskList().setName("taskList1"));

        HistoryEvent historyEvent =
                new HistoryEvent()
                        .setTimestamp(1234567)
                        .setEventId(321)
                        .setWorkflowExecutionStartedEventAttributes(started);

        TestData testData = new TestData("test-thrift", historyEvent, EventType.ActivityTaskCompleted);

        byte[] converted = converter.toData(testData);
        TestData fromConverted = converter.fromData(converted, TestData.class, TestData.class);
        assertEquals(new String(converted, StandardCharsets.UTF_8), testData, fromConverted);
    }

    @Test
    public void testThriftFieldsInPOJOArray() {
        WorkflowExecutionStartedEventAttributes started =
                new WorkflowExecutionStartedEventAttributes()
                        .setExecutionStartToCloseTimeoutSeconds(11)
                        .setIdentity("testIdentity")
                        .setInput("input".getBytes(StandardCharsets.UTF_8))
                        .setWorkflowType(new WorkflowType().setName("workflowType1"))
                        .setTaskList(new TaskList().setName("taskList1"));

        HistoryEvent historyEvent =
                new HistoryEvent()
                        .setTimestamp(1234567)
                        .setEventId(321)
                        .setWorkflowExecutionStartedEventAttributes(started);

        TestData testData = new TestData("test-thrift", historyEvent, EventType.ActivityTaskCompleted);

        byte[] converted = converter.toData("abc", testData);
        Object[] fromConverted = converter.fromDataArray(converted, String.class, TestData.class);
        assertEquals(new String(converted, StandardCharsets.UTF_8), "abc", fromConverted[0]);
        assertEquals(new String(converted, StandardCharsets.UTF_8), testData, fromConverted[1]);
    }


    public static void foo(List<UUID> arg) {}

    @Test
    public void testUUIDList() throws NoSuchMethodException {
        Method m = JsonDataConverterTest.class.getDeclaredMethod("foo", List.class);
        Type arg = m.getGenericParameterTypes()[0];

        List<UUID> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(UUID.randomUUID());
        }
        DataConverter converter = JsonDataConverter.getInstance();
        byte[] data = converter.toData(list);
        @SuppressWarnings("unchecked")
        List<UUID> result = (List<UUID>) converter.fromDataArray(data, arg)[0];
        assertEquals(result.toString(), list, result);
    }

    public static void threeArguments(int one, int two, String three) {}

    public static void aLotOfArguments(int one, int two, String three, Object obj, int[] intArr) {}

    @Test
    public void AdditionalInputArgumentsAreIgnored() throws NoSuchMethodException {
        Method m =
                JsonDataConverterTest.class.getDeclaredMethod(
                        "threeArguments", int.class, int.class, String.class);
        Type[] arg = m.getGenericParameterTypes();

        DataConverter converter = JsonDataConverter.getInstance();
        byte[] data = converter.toData(1, 2, "a string", "an extra string :o!!!");
        @SuppressWarnings("unchecked")
        Object[] deserializedArguments = converter.fromDataArray(data, arg);
        assertEquals(3, deserializedArguments.length);
        assertEquals(1, (int) deserializedArguments[0]);
        assertEquals(2, (int) deserializedArguments[1]);
        assertEquals("a string", deserializedArguments[2]);
    }
}

