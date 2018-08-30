package com.dreamtale.ck.entity.pojo;

public class CkUser {

    private Long id;

    private String phone;

    private String name;

    private Long districtNo;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getDistrictNo() {
        return districtNo;
    }

    public void setDistrictNo(Long districtNo) {
        this.districtNo = districtNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}