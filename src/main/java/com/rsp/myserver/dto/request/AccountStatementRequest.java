package com.rsp.myserver.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AccountStatementRequest extends Request {
    private String accountNumber;
    private String date;
}
