package com.bluecc.api;

public interface ServiceProcessor {
    <T extends OutputObject> ServiceResult<T> runSync(String serviceName, InputObject input);
}
