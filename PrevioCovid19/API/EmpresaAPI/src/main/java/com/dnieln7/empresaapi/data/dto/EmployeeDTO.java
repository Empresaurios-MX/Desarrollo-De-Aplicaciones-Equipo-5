package com.dnieln7.empresaapi.data.dto;

public class EmployeeDTO {

    private String address;
    private String name;
    private String phone;

    public EmployeeDTO(String address, String name, String phone) {
        this.address = address;
        this.name = name;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
