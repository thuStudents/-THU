package de.thu;

public class RestaurantItems {

    private String restaurant_name, restaurant_address;
    private int restaurant_image;
    private boolean extendable_restaurant;

    public RestaurantItems(String restaurant_name, String restaurant_address, int restaurant_image) {
        this.restaurant_name = restaurant_name;
        this.restaurant_address = restaurant_address;
        this.restaurant_image = restaurant_image;
        this.extendable_restaurant = false;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_address() {
        return restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public int getRestaurant_image() {
        return restaurant_image;
    }

    public void setRestaurant_image(int restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public boolean isExtendable_restaurant() {
        return extendable_restaurant;
    }

    public void setExtendable_restaurant(boolean extendable_restaurant) {
        this.extendable_restaurant = extendable_restaurant;
    }
}
