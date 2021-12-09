package de.thu;

public class CinemaItems {

    private String cinema_name, cinema_address;
    private int cinema_image;
    private boolean extendable_cinema;

    public CinemaItems(String cinema_name, String cinema_address, int cinema_image) {
        this.cinema_name = cinema_name;
        this.cinema_address = cinema_address;
        this.cinema_image = cinema_image;
        this.extendable_cinema = false;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    public String getCinema_address() {
        return cinema_address;
    }

    public void setCinema_address(String cinema_address) {
        this.cinema_address = cinema_address;
    }

    public int getCinema_image() {
        return cinema_image;
    }

    public void setCinema_image(int cinema_image) {
        this.cinema_image = cinema_image;
    }

    public boolean isExtendable_cinema() {
        return extendable_cinema;
    }

    public void setExtendable_cinema(boolean extendable_cinema) {
        this.extendable_cinema = extendable_cinema;
    }
}
