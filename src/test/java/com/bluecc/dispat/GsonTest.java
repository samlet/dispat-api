package com.bluecc.dispat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.sql.Timestamp;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class GsonTest {
    static class TestSqlData{
        public TestSqlData(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        java.sql.Timestamp timestamp;

        @Override
        public String toString() {
            return "TestSqlData{" +
                    "timestamp=" + timestamp +
                    '}';
        }
    }
    static class TestSqlData2{
        public java.sql.Timestamp timestamp;
        public String name;

        public TestSqlData2(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            // return ToStringBuilder.reflectionToString(this, JSON_STYLE);
            return new ReflectionToStringBuilder(this, JSON_STYLE, null,
                    null, false, false, true)
                    .toString();
        }
    }

    @Test
    public void testSqlTypes(){
        Gson gson= new GsonBuilder().create();
        TestSqlData data=new TestSqlData(Timestamp.valueOf("2021-03-19 12:49:25.883"));
        String json=gson.toJson(data);
        System.out.println(json);
        TestSqlData newData=gson.fromJson(json, TestSqlData.class);
        System.out.println(newData);
    }

    @Test
    public void testSqlTypes2(){
        Gson gson= new GsonBuilder().create();
        TestSqlData2 data=new TestSqlData2(Timestamp.valueOf("2021-03-19 12:49:25.883"));
        String json=gson.toJson(data);
        System.out.println(json);
        TestSqlData2 newData=gson.fromJson(json, TestSqlData2.class);
        System.out.println(newData);
    }
}
