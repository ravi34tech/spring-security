package com.ravi.springsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravi.springsecurity.dto.EmployeeDto;

import java.util.Collections;
import java.util.List;

public class EmployeeBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static EmployeeDto getDto() {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(1L);
        return dto;
    }
}