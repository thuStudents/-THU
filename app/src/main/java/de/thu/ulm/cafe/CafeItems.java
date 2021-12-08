package de.thu.ulm.cafe;

public class CafeItems {

    String cafe_name, cafe_time, cafe_address, cafe_t;
    int cafe_image;
    boolean expanded_c;

    public CafeItems(String cafe_name, String cafe_time, int cafe_image, String cafe_address, String cafe_t) {
        this.cafe_name = cafe_name;
        this.cafe_time = cafe_time;
        this.cafe_image = cafe_image;
        this.cafe_address = cafe_address;
        this.cafe_t = cafe_t;
        this.expanded_c = false;
    }

    public String getCafe_name() {
        return cafe_name;
    }

    public void setCafe_name(String cafe_name) {
        this.cafe_name = cafe_name;
    }

    public String getCafe_time() {
        return cafe_time;
    }

    public String getCafe_t() {
        return cafe_t;
    }

    public void setCafe_t(String cafe_t) {
        this.cafe_t = cafe_t;
    }

    public void setCafe_time(String cafe_time) {
        this.cafe_time = cafe_time;
    }

    public int getCafe_image() {
        return cafe_image;
    }

    public void setCafe_image(int cafe_image) {
        this.cafe_image = cafe_image;
    }

    public String getCafe_address() {
        return cafe_address;
    }

    public void setCafe_address(String cafe_address) {
        this.cafe_address = cafe_address;
    }

    public boolean isExpanded_c() {
        return expanded_c;
    }

    public void setExpanded_c(boolean expanded_c) {
        this.expanded_c = expanded_c;
    }

    @Override
    public String toString() {
        return "CafeItems{" +
                "cafe_name='" + cafe_name + '\'' +
                ", cafe_time='" + cafe_time + '\'' +
                ", cafe_image=" + cafe_image  +
                ", expanded_c=" + expanded_c +
                '}';
    }
}
