package de.thu;

public class LatestUpdatesItems {

    int latestUpdatesImage;
    String latestUpdatesTitle, latestUpdatesDescription;

    public LatestUpdatesItems(int latestUpdatesImage, String latestUpdatesTitle, String latestUpdatesDescription) {
        this.latestUpdatesImage = latestUpdatesImage;
        this.latestUpdatesTitle = latestUpdatesTitle;
        this.latestUpdatesDescription = latestUpdatesDescription;
    }

    public int getLatestUpdatesImage() {
        return latestUpdatesImage;
    }

    public void setLatestUpdatesImage(int latestUpdatesImage) {
        this.latestUpdatesImage = latestUpdatesImage;
    }

    public String getLatestUpdatesTitle() {
        return latestUpdatesTitle;
    }

    public void setLatestUpdatesTitle(String latestUpdatesTitle) {
        this.latestUpdatesTitle = latestUpdatesTitle;
    }

    public String getLatestUpdatesDescription() {
        return latestUpdatesDescription;
    }

    public void setLatestUpdatesDescription(String latestUpdatesDescription) {
        this.latestUpdatesDescription = latestUpdatesDescription;
    }
}
