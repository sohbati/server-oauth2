package com.rsp.myserver.command;

import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.dto.response.Response;

public abstract class Command<R extends Response> {

    public abstract R execute(Request request);
}
