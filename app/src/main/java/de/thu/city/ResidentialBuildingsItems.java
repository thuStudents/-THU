package de.thu.city;

public class ResidentialBuildingsItems {
    private String residentialbName, residentialbContacts, residentialNum;
    private int residentialBImage;


    public ResidentialBuildingsItems(String nameR, int imageR, String residentialbContacts, String residentialNumber) {
        this.residentialbName = nameR;
        this.residentialBImage = imageR;
        this.residentialbContacts = residentialbContacts;
        this.residentialNum = residentialNumber;
    }

    public String getResidentialNum() {
        return residentialNum;
    }

    public void setResidentialNum(String residentialNum) {
        this.residentialNum = residentialNum;
    }

    public String getResidentialbContacts() {
        return residentialbContacts;
    }

    public void setResidentialbContacts(String residentialbContacts) {
        this.residentialbContacts = residentialbContacts;
    }

    public String getResidentialbName() {
        return residentialbName;
    }

    public void setResidentialbName(String residentialbName) {
        this.residentialbName = residentialbName;
    }

    public int getResidentialBImage() {
        return residentialBImage;
    }

    public void setResidentialBImage(int residentialBImage) {
        this.residentialBImage = residentialBImage;
    }
}
