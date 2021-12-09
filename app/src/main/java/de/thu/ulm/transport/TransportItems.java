package de.thu.ulm.transport;

public class TransportItems {
    private String transportName, transportDes;
    private int transportImage;

    public TransportItems(String transportName, String transportDes, int transportImage) {
        this.transportName = transportName;
        this.transportDes = transportDes;
        this.transportImage = transportImage;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportDes() {
        return transportDes;
    }

    public void setTransportDes(String transportDes) {
        this.transportDes = transportDes;
    }

    public int getTransportImage() {
        return transportImage;
    }

    public void setTransportImage(int transportImage) {
        this.transportImage = transportImage;
    }
}
