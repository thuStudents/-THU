package de.thu.ulm.accomodation;

public class ResidentialBuildingsItems {
    private String residentialbName;
    private String residentialbDesc;
    private int residentialBImage;

    public ResidentialBuildingsItems(String nameR, String desR, int imageR) {
        this.residentialbName = nameR;
        this.residentialbDesc = desR;
        this.residentialBImage = imageR;
    }

    public String getResidentialbName() {
        return residentialbName;
    }

    public void setResidentialbName(String residentialbName) {
        this.residentialbName = residentialbName;
    }

    public String getResidentialbDesc() {
        return residentialbDesc;
    }

    public void setResidentialbDesc(String residentialbDesc) {
        this.residentialbDesc = residentialbDesc;
    }

    public int getResidentialBImage() {
        return residentialBImage;
    }

    public void setResidentialBImage(int residentialBImage) {
        this.residentialBImage = residentialBImage;
    }
}
