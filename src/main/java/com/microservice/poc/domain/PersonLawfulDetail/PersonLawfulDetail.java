package com.microservice.poc.domain.PersonLawfulDetail;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microservice.poc.domain.AbstractModel;

import java.sql.Date;
import java.util.List;

//@Data

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonLawfulDetail extends AbstractModel {
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getEligibilityStatementCode() {
        return eligibilityStatementCode;
    }

    public void setEligibilityStatementCode(String eligibilityStatementCode) {
        this.eligibilityStatementCode = eligibilityStatementCode;
    }

    public String getNonCitCoaCode() {
        return nonCitCoaCode;
    }

    public void setNonCitCoaCode(String nonCitCoaCode) {
        this.nonCitCoaCode = nonCitCoaCode;
    }

    public String getFiveYearBarMet() {
        return fiveYearBarMet;
    }

    public void setFiveYearBarMet(String fiveYearBarMet) {
        this.fiveYearBarMet = fiveYearBarMet;
    }

    public String getQualifiedCitizenCode() {
        return qualifiedCitizenCode;
    }

    public void setQualifiedCitizenCode(String qualifiedCitizenCode) {
        this.qualifiedCitizenCode = qualifiedCitizenCode;
    }

    public String getLawfulPreseneCode() {
        return lawfulPreseneCode;
    }

    public void setLawfulPreseneCode(String lawfulPreseneCode) {
        this.lawfulPreseneCode = lawfulPreseneCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getAgencyAction() {
        return agencyAction;
    }

    public void setAgencyAction(String agencyAction) {
        this.agencyAction = agencyAction;
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AdditionalLawfulDetail> getAdditionalLawfulDetail() {
        return additionalLawfulDetail;
    }

    public void setAdditionalLawfulDetail(List<AdditionalLawfulDetail> additionalLawfulDetail) {
        this.additionalLawfulDetail = additionalLawfulDetail;
    }

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
