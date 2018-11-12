package com.microservice.poc.domain;


import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonLawfulDetail extends AbstractModel {

    private String UUID;

    private String eligibilityStatementCode;
    private String nonCitCoaCode;
    private String fiveYearBarMet;
    private String qualifiedCitizenCode;
    private String lawfulPreseneCode;
    private String responseCode;
    private String caseNumber;
    private String agencyAction;
    private Date grantDate;
    private String status;

    private List<AdditionalLawfulDetail> additionalLawfulDetail;

}
