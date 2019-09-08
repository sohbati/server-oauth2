package com.rsp.myserver.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private String mac;
    private boolean success;
    private String errorCode;
    private String errorDescription;

    public Response() {
    }

    public Response(String mac, Boolean isSuccess, String errorCode, String errorDescription) {
        this.mac = mac;
        this.success = isSuccess;
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
