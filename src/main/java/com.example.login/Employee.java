package com.example.login;

public class Employee {

    String employeeID;
    String name;
    String grade;

    public Employee(String name, String grade, String employeeID) {
        this.employeeID = employeeID;
        this.name = name;
        this.grade = grade;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeDetails(){
        return this.name+this.grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
