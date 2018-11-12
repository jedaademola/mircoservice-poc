package com.microservice.poc.domain;

import lombok.Data;

import java.util.List;

@Data
public class AdditionalLawfulDetail extends AbstractModel {

    private String UUID;
    private String detailName;
    private String detailValue;

    private List<ResponseError> responseError;


}
