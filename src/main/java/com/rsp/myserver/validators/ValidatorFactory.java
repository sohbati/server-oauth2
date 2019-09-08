package com.rsp.myserver.validators;

import com.rsp.myserver.enumerations.CommandType;

public class ValidatorFactory {

    public static Validator getValidator(CommandType type) {
        if (CommandType.GET_ACCOUNT_INFO.equals(type)) {
            return new GetAccoutInfoValidator();
        }
        if (CommandType.WITHDRAW.equals(type)) {
            return new WithdrawValidator();
        }
        if (CommandType.DEPOSIT.equals(type)) {
            return new DepositValidator();
        }
        return null;
    }
}
