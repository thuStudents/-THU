package de.thu.ulm.accomodation;

public class PrivateBItems {
    private String privateBName;
    private String privateBDes;
    private int privateBImage;

    public PrivateBItems(String nameP, String desP, int imageP) {
        this.privateBName = nameP;
        this.privateBDes = desP;
        this.privateBImage = imageP;
    }

    public String getPrivateBName() {
        return privateBName;
    }

    public void setPrivateBName(String privateBName) {
        this.privateBName = privateBName;
    }

    public String getPrivateBDes() {
        return privateBDes;
    }

    public void setPrivateBDes(String privateBDes) {
        this.privateBDes = privateBDes;
    }

    public int getPrivateBImage() {
        return privateBImage;
    }

    public void setPrivateBImage(int privateBImage) {
        this.privateBImage = privateBImage;
    }
}
