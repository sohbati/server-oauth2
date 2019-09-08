package com.rsp.myserver.command;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.dto.response.AccountInfoResponse;
import com.rsp.myserver.dto.response.Response;
import com.rsp.myserver.enumerations.CommandType;
import com.rsp.myserver.persistence.second.repository.TestRepository;
import com.rsp.myserver.service.ErrorIntermediaryService;
import com.rsp.myserver.constants.ErrorConstants;
import com.rsp.myserver.util.PublicUtil;
import com.rsp.myserver.validators.Validator;
import com.rsp.myserver.validators.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountInfoCommand extends Command {

    @Autowired
    TestRepository testRepository;

    @Autowired
    ErrorIntermediaryService errorIntermediaryService;


    @Override
    public Response execute(Request request) {

        try {
            testRepository.callStoredProcedure();
        }catch (Exception e) {
            e.printStackTrace();
        }

        Validator validator = ValidatorFactory.getValidator(CommandType.GET_ACCOUNT_INFO);
        ErrorDTO errorDTO = validator.validateRequestData(request, errorIntermediaryService);

        if (!ErrorConstants.NO_ERROR.equals(errorDTO.getCode())) {
            return PublicUtil.generateErrorResponse(errorDTO);
        }

        AccountInfoResponse response = new AccountInfoResponse();
        response.setSuccess(true);
        response.setErrorDescription("");
        response.setErrorCode(ErrorConstants.NO_ERROR);
        //response.setMac(MAC);
        response.setAccountOwner("john customer");
        response.setAccountNumber("0123456789");
        response.setCurrencyCode("USD");

        return PublicUtil.generateOkResponse(response);
    }
}
