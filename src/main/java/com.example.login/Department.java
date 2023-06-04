package com.example.login;

import java.util.ArrayList;

public class Department {
    ArrayList<Lab> labs;
    private String departmentName;
    HOD hod;

    public Department(ArrayList<Lab> labs, String departmentName, HOD hod) {
        this.labs = labs;
        this.departmentName = departmentName;
        this.hod = hod;
    }

    public ArrayList<Lab> getLabs() {
        return labs;
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public HOD getHod() {
        return hod;
    }

    public void setHod(HOD hod) {
        this.hod = hod;
    }

    void addLab(Lab templab){
        labs.add(templab);
    }
    void removeLab(Lab tempLab){
        labs.remove(tempLab);
    }

    Lab getLab(String labName) {
        for (Lab tempLab : labs) {
            if (tempLab.getLabName() == labName) {
                return tempLab;
            }
        }
        return null;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "labs=" + labs +
                ", departmentName='" + departmentName + '\'' +
                ", hod=" + hod +
                '}';
    }
}
