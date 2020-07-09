package com.rabbitmq.springrabbitmqproducer.service;

import com.rabbitmq.springrabbitmqproducer.entity.Employee;

public interface EmployeeService {

    public void saveEmployee(Employee employee);
    public void removeEmployee();
}
