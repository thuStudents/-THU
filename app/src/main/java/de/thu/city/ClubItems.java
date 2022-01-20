package de.thu.city;

public class ClubItems {
    private String funName, funAddress;
    private int funImage;
    private boolean extendable_club;

    public ClubItems(String nameP, int imageP, String addressP) {
        this.funName = nameP;
        this.funImage = imageP;
        this.funAddress = addressP;
        this.extendable_club = false;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public int getFunImage() {
        return funImage;
    }

    public void setFunImage(int funImage) {
        this.funImage = funImage;
    }

    public boolean isExtendable_club() {
        return extendable_club;
    }

    public void setExtendable_club(boolean extendable_club) {
        this.extendable_club = extendable_club;
    }

    public String getFunAddress() {
        return funAddress;
    }

    public void setFunAddress(String funAddress) {
        this.funAddress = funAddress;
    }

}