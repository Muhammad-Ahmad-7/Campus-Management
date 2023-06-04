package com.example.login;

import java.util.ArrayList;

public class Campus {

    ArrayList<Department> departments;

    Director director;
    private String campusName;
    private String campusCity;
    private int campusRank;


    void addDepartment(Department department){
        departments.add(department);
    }

    void removeDepartment(Department department){
        departments.remove(department);
    }

    Department getDepartment(String departmentName){
        for (Department tempDepartment: departments){
            if (tempDepartment.getDepartmentName() == departmentName){
                return tempDepartment;
            }
        }
        return null;
    }

    public Campus(ArrayList<Department> departments, Director director, String campusName, String campusCity, int campusRank) {
        this.departments = departments;
        this.director = director;
        this.campusName = campusName;
        this.campusCity = campusCity;
        this.campusRank = campusRank;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getCampusCity() {
        return campusCity;
    }

    public void setCampusCity(String campusCity) {
        this.campusCity = campusCity;
    }

    public int getCampusRank() {
        return campusRank;
    }

    public void setCampusRank(int campusRank) {
        this.campusRank = campusRank;
    }

    @Override
    public String toString() {
        return "CampusName{" +
                "departments=" + departments +
                ", campusName='" + campusName + '\'' +
                ", campusCity='" + campusCity + '\'' +
                ", campusRank=" + campusRank +
                '}';
    }
}
