package com.bluecc.api.models.party.party;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

// Entity Person(party.party): Person
public class Person{
    // keys
    private String partyId;   // id

    // fields
    private String salutation;   // name
    private String firstName;   // name
    private String middleName;   // name
    private String lastName;   // name
    private String personalTitle;   // name
    private String suffix;   // name
    private String nickname;   // name
    private String firstNameLocal;   // name
    private String middleNameLocal;   // name
    private String lastNameLocal;   // name
    private String otherLocal;   // name
    private String memberId;   // id
    private String gender;   // indicator
    private java.sql.Date birthDate;   // date
    private java.sql.Date deceasedDate;   // date
    private Double height;   // floating-point
    private Double weight;   // floating-point
    private String mothersMaidenName;   // long-varchar
    private String oldMaritalStatus;   // indicator
    private String maritalStatusEnumId;   // id
    private String socialSecurityNumber;   // long-varchar
    private String passportNumber;   // long-varchar
    private java.sql.Date passportExpireDate;   // date
    private Double totalYearsWorkExperience;   // floating-point
    private String comments;   // comment
    private String employmentStatusEnumId;   // id
    private String residenceStatusEnumId;   // id
    private String occupation;   // name
    private Long yearsWithEmployer;   // numeric
    private Long monthsWithEmployer;   // numeric
    private String existingCustomer;   // indicator
    private String cardId;   // id-long

    // getters and setters
    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPersonalTitle() {
        return personalTitle;
    }

    public void setPersonalTitle(String personalTitle) {
        this.personalTitle = personalTitle;
    }
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getFirstNameLocal() {
        return firstNameLocal;
    }

    public void setFirstNameLocal(String firstNameLocal) {
        this.firstNameLocal = firstNameLocal;
    }
    public String getMiddleNameLocal() {
        return middleNameLocal;
    }

    public void setMiddleNameLocal(String middleNameLocal) {
        this.middleNameLocal = middleNameLocal;
    }
    public String getLastNameLocal() {
        return lastNameLocal;
    }

    public void setLastNameLocal(String lastNameLocal) {
        this.lastNameLocal = lastNameLocal;
    }
    public String getOtherLocal() {
        return otherLocal;
    }

    public void setOtherLocal(String otherLocal) {
        this.otherLocal = otherLocal;
    }
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }
    public java.sql.Date getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(java.sql.Date deceasedDate) {
        this.deceasedDate = deceasedDate;
    }
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getMothersMaidenName() {
        return mothersMaidenName;
    }

    public void setMothersMaidenName(String mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }
    public String getOldMaritalStatus() {
        return oldMaritalStatus;
    }

    public void setOldMaritalStatus(String oldMaritalStatus) {
        this.oldMaritalStatus = oldMaritalStatus;
    }
    public String getMaritalStatusEnumId() {
        return maritalStatusEnumId;
    }

    public void setMaritalStatusEnumId(String maritalStatusEnumId) {
        this.maritalStatusEnumId = maritalStatusEnumId;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public java.sql.Date getPassportExpireDate() {
        return passportExpireDate;
    }

    public void setPassportExpireDate(java.sql.Date passportExpireDate) {
        this.passportExpireDate = passportExpireDate;
    }
    public Double getTotalYearsWorkExperience() {
        return totalYearsWorkExperience;
    }

    public void setTotalYearsWorkExperience(Double totalYearsWorkExperience) {
        this.totalYearsWorkExperience = totalYearsWorkExperience;
    }
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getEmploymentStatusEnumId() {
        return employmentStatusEnumId;
    }

    public void setEmploymentStatusEnumId(String employmentStatusEnumId) {
        this.employmentStatusEnumId = employmentStatusEnumId;
    }
    public String getResidenceStatusEnumId() {
        return residenceStatusEnumId;
    }

    public void setResidenceStatusEnumId(String residenceStatusEnumId) {
        this.residenceStatusEnumId = residenceStatusEnumId;
    }
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public Long getYearsWithEmployer() {
        return yearsWithEmployer;
    }

    public void setYearsWithEmployer(Long yearsWithEmployer) {
        this.yearsWithEmployer = yearsWithEmployer;
    }
    public Long getMonthsWithEmployer() {
        return monthsWithEmployer;
    }

    public void setMonthsWithEmployer(Long monthsWithEmployer) {
        this.monthsWithEmployer = monthsWithEmployer;
    }
    public String getExistingCustomer() {
        return existingCustomer;
    }

    public void setExistingCustomer(String existingCustomer) {
        this.existingCustomer = existingCustomer;
    }
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this, JSON_STYLE, null,
                null, false, false, true)
                .toString();
    }
}
