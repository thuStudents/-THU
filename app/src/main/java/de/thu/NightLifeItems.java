package de.thu;

public class NightLifeItems {
    private String nightName;
    private String nightDes;
    private int nightImage;

    public NightLifeItems(String nameP, String desP, int imageP) {
        this.nightName = nameP;
        this.nightDes = desP;
        this.nightImage = imageP;
    }

    public String getNightName() {
        return nightName;
    }

    public void setNightName(String nightName) {
        this.nightName = nightName;
    }

    public String getNightDes() {
        return nightDes;
    }

    public void setNightDes(String nightDes) {
        this.nightDes = nightDes;
    }

    public int getNightImage() {
        return nightImage;
    }

    public void setNightImage(int nightImage) {
        this.nightImage = nightImage;
    }
}
