package de.thu.city;

public class BarItems {

    private String bar_name, bar_address;
    private int bar_image;
    private boolean extendable_bar;

    public BarItems(String bar_name, String bar_address, int bar_image) {
        this.bar_name = bar_name;
        this.bar_address = bar_address;
        this.bar_image = bar_image;
        this.extendable_bar = false;
    }

    public String getBar_name() {
        return bar_name;
    }

    public void setBar_name(String bar_name) {
        this.bar_name = bar_name;
    }

    public String getBar_address() {
        return bar_address;
    }

    public void setBar_address(String bar_address) {
        this.bar_address = bar_address;
    }

    public int getBar_image() {
        return bar_image;
    }

    public void setBar_image(int bar_image) {
        this.bar_image = bar_image;
    }

    public boolean isExtendable_bar() {
        return extendable_bar;
    }

    public void setExtendable_bar(boolean extendable_bar) {
        this.extendable_bar = extendable_bar;
    }
}
