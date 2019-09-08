package com.rsp.myserver.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class WithdrawFromAccountRequest extends Request implements Serializable {
    private String accountNumber;
    private String currencyCode;
    private String referenceNumber;
    private String actionType;
    private BigDecimal amount;
    private Date transTime;
    private String extraData;
}