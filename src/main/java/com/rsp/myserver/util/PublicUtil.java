package com.rsp.myserver.util;

import com.rsp.myserver.constants.ErrorConstants;
import com.rsp.myserver.dto.ErrorDTO;
import com.rsp.myserver.dto.response.Response;

/**
 *
 */

public class PublicUtil {

    public static Response generateErrorResponse(ErrorDTO entity) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrorCode(entity.getCode());
        response.setErrorDescription(entity.getDescription());
        return response;
    }

    public static  <T extends Response> T generateOkResponse(T response) {
        response.setSuccess(true);
        response.setErrorCode(ErrorConstants.NO_ERROR);
        response.setErrorDescription("");
        return response;
    }
}
