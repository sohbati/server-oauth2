package com.rsp.myserver.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ToString
public class DepositRequest extends Request implements Serializable {
    private String accountNumber;
    private String currencyCode;
    private String referenceNumber;
    private String actionType;
    private BigDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private String transTime;
    private String extraData;
}
