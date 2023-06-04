package com.example.login;

import java.util.ArrayList;
import java.util.Objects;

public class University {
    String name;
    ArrayList<Campus> campusList;

    void addCampus(Campus campus){
        campusList.add(campus);
    }

    void removeCampus(Campus campus){
        campusList.remove(campus);
    }
    Campus getCampus(String campusName){
        for (Campus campus: campusList){
            if (Objects.equals(campus.getCampusName(), campusName)){
                return campus;
            }
        }
        return null;
    }

    public University(String name, ArrayList<Campus> campusList) {
        this.name = name;
        this.campusList = campusList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Campus> getCampusList() {
        return campusList;
    }

    public void setCampusList(ArrayList<Campus> campusList) {
        this.campusList = campusList;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", campusList=" + campusList +
                '}';
    }
}
