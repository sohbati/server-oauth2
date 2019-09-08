package com.rsp.myserver.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ErrorDTO {
    private String code;
    private String description;

}
