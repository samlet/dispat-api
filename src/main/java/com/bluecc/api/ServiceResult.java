package com.bluecc.api;

public class ServiceResult<T extends OutputObject> {
    private T data;

    public ServiceResult(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

