package com.rsp.myserver.command;

import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.request.Request;
import com.rsp.myserver.dto.response.DepositResponse;
import com.rsp.myserver.dto.response.Response;
import com.rsp.myserver.enumerations.CommandType;
import com.rsp.myserver.service.ErrorIntermediaryService;
import com.rsp.myserver.constants.ErrorConstants;
import com.rsp.myserver.util.PublicUtil;
import com.rsp.myserver.validators.Validator;
import com.rsp.myserver.validators.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepositCommand extends Command {

    @Autowired
    ErrorIntermediaryService errorIntermediaryService;

    @Override
    public Response execute(Request request) {
        Validator validator = ValidatorFactory.getValidator(CommandType.DEPOSIT);
        ErrorDTO errorDTO = validator.validateRequestData(request, errorIntermediaryService);

        if (!ErrorConstants.NO_ERROR.equals(errorDTO.getCode())) {
            return PublicUtil.generateErrorResponse(errorDTO);
        }

        DepositResponse response = new DepositResponse();
        return PublicUtil.generateOkResponse(response);
    }
}
