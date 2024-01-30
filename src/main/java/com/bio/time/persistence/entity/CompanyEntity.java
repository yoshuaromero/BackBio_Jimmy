package com.bio.time.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

@Entity
@Table(name = "companies")
public class CompanyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "id_company_type")
    private Integer idCompanyType;
    @Column(name = "risk_level")
    private Integer riskLevel;
    @Column(name = "company_name")
    private String companyName;
    @Column (name ="create_by")
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
