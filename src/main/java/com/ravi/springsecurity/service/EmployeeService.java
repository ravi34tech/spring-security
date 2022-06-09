package com.ravi.springsecurity.service;

import com.ravi.springsecurity.dto.EmployeeDto;
import com.ravi.springsecurity.mapper.EmployeeMapper;
import com.ravi.springsecurity.model.Employee;
import com.ravi.springsecurity.repository.EmployeeRepository;
import com.ravi.springsecurity.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee entity = employeeMapper.toEntity(employeeDto);
        return employeeMapper.toDto(employeeRepository.save(entity));
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto findById(Long id) {
        return employeeMapper.toDto(employeeRepository.findById(id).orElseThrow(ResourceNotFoundException::new));
    }

    public Page<EmployeeDto> findByCondition(EmployeeDto employeeDto, Pageable pageable) {
        Page<Employee> entityPage = employeeRepository.findAll(pageable);
        List<Employee> entities = entityPage.getContent();
        return new PageImpl<>(employeeMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public EmployeeDto update(EmployeeDto employeeDto, Long id) {
        findById(id);
        Employee entity = employeeMapper.toEntity(employeeDto);
        return save(employeeMapper.toDto(entity));
    }
}