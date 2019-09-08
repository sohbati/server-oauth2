package com.rsp.myserver.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AccountInfoResponse extends Response implements Serializable {
    @JsonProperty("accountOwner")
    private String accountOwner;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("currencyCode")
    private String currencyCode;

}
