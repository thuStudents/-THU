package de.thu;

public class NightLifeItems {
    private String nightName;
    private int nightImage;

    public NightLifeItems(String nameP, int imageP) {
        this.nightName = nameP;
        this.nightImage = imageP;
    }

    public String getNightName() {
        return nightName;
    }

    public void setNightName(String nightName) {
        this.nightName = nightName;
    }

    public int getNightImage() {
        return nightImage;
    }

    public void setNightImage(int nightImage) {
        this.nightImage = nightImage;
    }
}
