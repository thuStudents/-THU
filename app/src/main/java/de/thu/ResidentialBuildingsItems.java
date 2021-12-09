package de.thu;

public class ResidentialBuildingsItems {
    private String residentialbName;
    private int residentialBImage;

    public ResidentialBuildingsItems(String nameR, int imageR) {
        this.residentialbName = nameR;
        this.residentialBImage = imageR;
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
