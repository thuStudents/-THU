package de.thu;

public class PrivateBItems {
    private String privateBName;
    private int privateBImage;

    public PrivateBItems(String nameP, int imageP) {
        this.privateBName = nameP;
        this.privateBImage = imageP;
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
