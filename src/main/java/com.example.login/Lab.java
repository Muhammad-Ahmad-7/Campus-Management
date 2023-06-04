package com.example.login;

import java.util.ArrayList;

public class Lab {
    ArrayList<Pc> pcArrayList = new ArrayList<>();

    LabStaff incharge;
    String staffName;
    String labName;
    String departmentName;
    boolean hasProjector;

    public Lab(LabStaff incharge, String labName, boolean hasProjector) {
        this.incharge = incharge;
        this.labName = labName;
        this.hasProjector = hasProjector;
    }

    public Lab(String staffName, String labName, boolean hasProjector) {
        this.staffName = staffName;
        this.labName = labName;
        this.hasProjector = hasProjector;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public ArrayList<Pc> getPcArrayList() {
        return pcArrayList;
    }

    public void setPcArrayList(ArrayList<Pc> pcArrayList) {
        this.pcArrayList = pcArrayList;
    }

    public LabStaff getIncharge() {
        return incharge;
    }

    public void setIncharge(LabStaff incharge) {
        this.incharge = incharge;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    //Adding PC object to the arraylist of pc
    void addPc(Pc tempPc){
        pcArrayList.add(tempPc);
    }
    void removePc(int pcId){
        for (Pc tempPc: pcArrayList){
            pcArrayList.remove(tempPc);
        }
    }

    Pc getComputer(int PcId) {
        for (Pc tempPc : pcArrayList) {
            if (Integer.parseInt(tempPc.getPcId()) == PcId) {
                return tempPc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "pcArrayList=" + pcArrayList +
                ", incharge=" + incharge +
                ", labName='" + labName + '\'' +
                ", hasProjector=" + hasProjector +
                '}';
    }
}
