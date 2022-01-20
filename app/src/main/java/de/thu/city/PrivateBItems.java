package de.thu.city;

public class PrivateBItems {
    private String privateBName, privateBDes, privateBAdd;
    private int privateBImage;

    public PrivateBItems(String nameP, int imageP, String des, String add) {
        this.privateBName = nameP;
        this.privateBImage = imageP;
        this.privateBDes = des;
        this.privateBAdd=add;
    }

    public String getPrivateBDes() {
        return privateBDes;
    }

    public void setPrivateBDes(String privateBDes) {
        this.privateBDes = privateBDes;
    }

    public String getPrivateBAdd() {
        return privateBAdd;
    }

    public void setPrivateBAdd(String privateBAdd) {
        this.privateBAdd = privateBAdd;
    }

    public String getPrivateBName() {
        return privateBName;
    }

    public void setPrivateBName(String privateBName) {
        this.privateBName = privateBName;
    }

    public int getPrivateBImage() {
        return privateBImage;
    }

    public void setPrivateBImage(int privateBImage) {
        this.privateBImage = privateBImage;
    }
}
