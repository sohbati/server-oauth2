package com.rsp.myserver.service;

import com.rsp.myserver.command.Command;
import com.rsp.myserver.command.CommandFactory;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.dto.response.Response;
import com.rsp.myserver.enumerations.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondDBCmdExecuterService {


    @Autowired
    CommandFactory commandFactory;

    public Response executeCommand(CommandType type, Request request) {
        Command command = commandFactory.getCommand(type);
        return command.execute(request);
    }
}
