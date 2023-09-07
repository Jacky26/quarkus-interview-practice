package org.jc.controller.response;

import java.io.Serializable;

public class CommonResponse <T> implements Serializable {
    private String status;
    private T data;

    public CommonResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
