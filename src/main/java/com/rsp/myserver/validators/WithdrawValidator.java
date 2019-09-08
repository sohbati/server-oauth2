package com.rsp.myserver.validators;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.dto.request.WithdrawFromAccountRequest;
import com.rsp.myserver.service.ErrorIntermediaryService;
import com.rsp.myserver.constants.ErrorConstants;
import org.apache.commons.lang3.StringUtils;

public class WithdrawValidator implements Validator {

    public ErrorDTO validateRequestData(Request request, ErrorIntermediaryService errorIntermediaryService) {

        WithdrawFromAccountRequest wRequest = (WithdrawFromAccountRequest)request;
        String accountNumber = wRequest.getAccountNumber();

        if (StringUtils.isEmpty(wRequest.getAccountNumber())) {
            return errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_INVALID_ACCOUNT_NUMBER);
        }

        if (StringUtils.isEmpty(wRequest.getCurrencyCode())) {
            return errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_INVALID_ISO_CURRENCY_CODE);
        }

        if (wRequest.getAmount() == null || wRequest.getAmount().signum() == 0) {
            return errorIntermediaryService.getErrorEntity(ErrorConstants.ERR_INVALID_REQUESTED_AMOUNT);
        }

        return errorIntermediaryService.getErrorEntity(ErrorConstants.NO_ERROR);
    }
}
