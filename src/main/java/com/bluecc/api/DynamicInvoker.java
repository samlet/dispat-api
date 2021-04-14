package com.bluecc.api;
import java.io.File;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class DynamicInvoker {
    public static Object[] bindParameters(Method method, String[] args) {
        List<Object> parameters = new ArrayList<Object>();
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0, len = parameterTypes.length; i < len; i++) {
            Class<?> type = parameterTypes[i];
            int remaining = Math.max(0, args.length - i);
            if (type.equals(String[].class)) {
                String[] rest = new String[remaining];
                System.arraycopy(args, 1, rest, 0, remaining);
                parameters.add(rest);
            } else if (remaining > 0) {
                parameters
                        .add(convertParameter(args[i], parameterTypes[i]));
            } else {
                parameters.add(null);
            }
        }
        return parameters.toArray();
    }

    private static Object convertParameter(String arg, Class<?> type) {
        if (type.equals(String.class)) {
            return arg;
        } else if (type.equals(Integer.class)) {
            return Integer.valueOf(arg, 10);
        } else if (type.equals(File.class)) {
            return new File(arg);
        } else {
            throw new UnsupportedOperationException("Unknown type " + type);
        }
    }
}
