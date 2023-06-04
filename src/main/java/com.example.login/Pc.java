package com.example.login;

public class Pc {
    private String name;
    private String core;

    private String pcId;
    private String ramSize;
    private String diskSize;
    private String lcd;
private String labName;

    public Pc(String name, String core, String ramSize, String diskSize, String lcd, String pcId, String labName) {
        this.name = name;
        this.core = core;
        this.pcId = pcId;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.lcd = lcd;
        this.labName = labName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getRamSize() {
        return ramSize;
    }

    public void setRamSize(String ramSize) {
        this.ramSize = ramSize;
    }

    public String getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(String diskSize) {
        this.diskSize = diskSize;
    }

    public String getLcd() {
        return lcd;
    }

    public void setLcd(String lcd) {
        this.lcd = lcd;
    }

    @Override
    public String toString() {
        return "Pc{" +
                "name='" + name + '\'' +
                ", core='" + core + '\'' +
                ", pcId='" + pcId + '\'' +
                ", ramSize='" + ramSize + '\'' +
                ", diskSize='" + diskSize + '\'' +
                ", lcd='" + lcd + '\'' +
                ", labName='" + labName + '\'' +
                '}';
    }
}

