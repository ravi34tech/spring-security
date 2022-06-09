package com.ravi.springsecurity.controller;

import com.ravi.springsecurity.dto.EmployeeDto;
import com.ravi.springsecurity.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/employee")
@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private  EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("id") Long id) {
        EmployeeDto employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<EmployeeDto>> pageQuery(EmployeeDto employeeDto, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<EmployeeDto> employeePage = employeeService.findByCondition(employeeDto, pageable);
        return ResponseEntity.ok(employeePage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated EmployeeDto employeeDto, @PathVariable("id") Long id) {
        employeeService.update(employeeDto, id);
        return ResponseEntity.ok().build();
    }
}