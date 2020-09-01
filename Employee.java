package com.company;

public class Employee {

    private double salary;

    public Employee() {
        this.salary = 10000.0;
    }

    public static void updateSalary(Employee emp) {
        emp.salary = emp.salary + 10000.0;
        //Line-1
    }

    public double getSalary() {
        return this.salary;
    }
}