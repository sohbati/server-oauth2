package com.rsp.myserver.validators;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.service.ErrorIntermediaryService;

public interface Validator {


    public ErrorDTO validateRequestData(Request request, ErrorIntermediaryService errorIntermediaryService);

}
