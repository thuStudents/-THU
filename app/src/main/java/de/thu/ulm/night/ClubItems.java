package de.thu.ulm.night;

public class ClubItems {
    private String funName;
    private String funDes;
    private int funImage;

    public ClubItems(String nameP, String desP, int imageP) {
        this.funName = nameP;
        this.funDes = desP;
        this.funImage = imageP;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getFunDes() {
        return funDes;
    }

    public void setFunDes(String funDes) {
        this.funDes = funDes;
    }

    public int getFunImage() {
        return funImage;
    }

    public void setFunImage(int funImage) {
        this.funImage = funImage;
    }
}
