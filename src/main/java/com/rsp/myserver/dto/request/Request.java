package com.rsp.myserver.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Request {
    private String mac;

    public Request() {

    }

    public Request(String mac) {
        this.mac = mac;
    }
}
