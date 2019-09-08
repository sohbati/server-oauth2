package com.rsp.myserver.validators;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.request.DepositRequest;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.service.ErrorIntermediaryService;
import com.rsp.myserver.constants.ErrorConstants;
import org.apache.commons.lang3.StringUtils;

public class DepositValidator implements Validator {

    public ErrorDTO validateRequestData(Request request, ErrorIntermediaryService errorIntermediaryService) {
        DepositRequest wRequest = (DepositRequest)request;
        String accountNumber = wRequest.getAccountNumber();

        if (StringUtils.isEmpty(accountNumber)) {
            return errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_INVALID_ACCOUNT_NUMBER);
        }
        return errorIntermediaryService.getErrorEntity(ErrorConstants.NO_ERROR);
    }
}
