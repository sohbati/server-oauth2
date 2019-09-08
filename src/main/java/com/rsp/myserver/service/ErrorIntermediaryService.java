package com.rsp.myserver.service;

import com.rsp.myserver.configuration.properties.ErrorMessagesConfig;
import com.rsp.myserver.dto.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorIntermediaryService {

    @Autowired
    ErrorMessagesConfig  errorMessagesConfig;

    public ErrorDTO getErrorEntity(String code, String extraDescription) {
        String description = errorMessagesConfig.getErrorDescription(code) +
                " " + extraDescription;

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setDescription(description);

        return errorDTO;
    }

    public ErrorDTO getErrorEntity(String code) {
        String description = errorMessagesConfig.getErrorDescription(code);

        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(code);
        errorDTO.setDescription(description);

        return errorDTO;
    }
}
