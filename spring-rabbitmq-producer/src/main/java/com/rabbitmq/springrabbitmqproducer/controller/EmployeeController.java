package com.rabbitmq.springrabbitmqproducer.controller;

import com.rabbitmq.springrabbitmqproducer.entity.Employee;
import com.rabbitmq.springrabbitmqproducer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Received", HttpStatus.OK);
    }

    @GetMapping(value = "/remove")
    public ResponseEntity<String> removeEmployee() {

        employeeService.removeEmployee();
        return new ResponseEntity<>("Received", HttpStatus.OK);
    }

}
