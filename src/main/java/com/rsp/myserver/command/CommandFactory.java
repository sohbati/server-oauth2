package com.rsp.myserver.command;

import com.rsp.myserver.enumerations.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    @Autowired
    private AccountInfoCommand accountInfoCommand;

    @Autowired
    DepositCommand depositCommand;

    @Autowired
    WithdrawCommand withdrawCommand;

    public Command getCommand(CommandType type) {
        switch (type) {
            case DEPOSIT :
                return depositCommand;
            case WITHDRAW:
                return withdrawCommand;
            case GET_ACCOUNT_INFO:
                return  accountInfoCommand;
        }
        return null;
    }
}
