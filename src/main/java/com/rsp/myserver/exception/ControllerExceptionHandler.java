package com.rsp.myserver.exception;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.response.Response;
import com.rsp.myserver.service.ErrorIntermediaryService;
import com.rsp.myserver.constants.ErrorConstants;
import com.rsp.myserver.util.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Component
public class ControllerExceptionHandler {

    @Autowired
    ErrorIntermediaryService errorIntermediaryService;

    @ExceptionHandler(IpAddressInvalidException.class)
    public ResponseEntity ipInvalidException() {
        ErrorDTO entity =
                errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_OPERATION_FAILED);

        Response response = PublicUtil.generateErrorResponse(entity);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(MacInvalidException.class)
    public ResponseEntity macInvalidException() {
        ErrorDTO entity =
                errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_INVALID_MAC);
        Response response = PublicUtil.generateErrorResponse(entity);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
