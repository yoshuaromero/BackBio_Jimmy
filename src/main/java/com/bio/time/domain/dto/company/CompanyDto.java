package com.bio.time.domain.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class CompanyDto {
    private Integer id;
    @JsonProperty
    @Size(max = 13, message = "El tamaño máximo para el número de identificación es de 13 caracteres")
    private String idNumber;
    @Max(value = 99, message = "El tamaño máximo del tipo de compañia  es de 2 caracteres")
    private Integer idCompanyType;
    @Max(value = 9, message = "El tamaño máximo para el nivel de riesgo es de 1 carácter")
    private Integer riskLevel;
    @JsonProperty
    @Size(max = 3, min= 250, message = "El tamaño para el nombre de la compañia es minimo 3 y máximo 250 caracteres")
    private String companyName;
    private Integer createBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getIdCompanyType() {
        return idCompanyType;
    }

    public void setIdCompanyType(Integer idCompanyType) {
        this.idCompanyType = idCompanyType;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}
