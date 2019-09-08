package com.rsp.myserver.dto.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AccountInfoRequest extends Request implements Serializable {
    private String accountNumber;
}