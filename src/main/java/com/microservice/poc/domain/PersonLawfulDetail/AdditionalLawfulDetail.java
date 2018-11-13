package com.microservice.poc.domain.PersonLawfulDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.poc.domain.AbstractModel;
import com.microservice.poc.domain.Response.ResponseErrors;
import lombok.Data;

import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalLawfulDetail extends AbstractModel {

    private String UUID;
    private String detailName;
    private String detailValue;

    private List<ResponseErrors> responseErrors;


}
