package com.rsp.myserver.controller;

import com.rsp.myserver.aspect.SecurityAspect;
import com.rsp.myserver.dto.request.AccountInfoRequest;
import com.rsp.myserver.dto.request.DepositRequest;
import com.rsp.myserver.dto.request.WithdrawFromAccountRequest;
import com.rsp.myserver.dto.response.Response;
import com.rsp.myserver.enumerations.CommandType;
import com.rsp.myserver.service.SecondDBCmdExecuterService;
import com.rsp.myserver.service.ErrorIntermediaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping(value = "/api")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class.getName());

    @Autowired
    ErrorIntermediaryService errorIntermediaryService;

    @Autowired
    SecondDBCmdExecuterService secondDBCmdExecuterService;


    @PostMapping("/withdraw")
    @SecurityAspect
    public ResponseEntity withdrawFromAccount(@RequestBody WithdrawFromAccountRequest withdrawRequest, @RequestHeader Map<String, String> headers) {
        LOGGER.info("Withdraw service called...");

        Response response1 = secondDBCmdExecuterService.executeCommand(CommandType.WITHDRAW, withdrawRequest);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response1);
    }

    @PostMapping("/deposit")
    @SecurityAspect
    public ResponseEntity deposit(@RequestBody DepositRequest depositRequest, @RequestHeader Map<String, String> headers) {
        LOGGER.info("Deposit service called...");

        Response response1 = secondDBCmdExecuterService.executeCommand(CommandType.DEPOSIT, depositRequest);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response1);
    }


    @PostMapping("/getaccountinfo")
    @SecurityAspect
    public ResponseEntity getAccountInfo(@RequestBody AccountInfoRequest request, @RequestHeader Map<String, String> headers) {
        LOGGER.info("getaccountinfo service called...");

        Response response1 = secondDBCmdExecuterService.executeCommand(CommandType.GET_ACCOUNT_INFO, request);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response1);
    }

    @PostMapping("/test")
    public ResponseEntity test() {

        AccountInfoRequest request = new AccountInfoRequest();

        Response response1 = secondDBCmdExecuterService.executeCommand(CommandType.GET_ACCOUNT_INFO, request);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response1);
    }
}

