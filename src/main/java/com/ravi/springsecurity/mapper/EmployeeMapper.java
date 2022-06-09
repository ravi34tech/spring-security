package com.ravi.springsecurity.mapper;

import com.ravi.springsecurity.dto.EmployeeDto;
import com.ravi.springsecurity.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeDto dto) {
        Employee entity = new Employee();
        BeanUtils.copyProperties(dto,entity);
        return entity;
    }

    public EmployeeDto toDto(Employee entities) {
        EmployeeDto dto = new EmployeeDto();
        BeanUtils.copyProperties(entities,dto);
        return dto;
    }

    public List<EmployeeDto> toDto(List<Employee> entities) {
        if(entities != null && !entities.isEmpty())  {
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
