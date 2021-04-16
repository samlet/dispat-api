package com.bluecc.api;

public class ServiceResult<T extends OutputObject> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private T data;
}

