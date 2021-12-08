package de.thu.ulm.cafe;

public class CafeItems {

    String cafe_name, cafe_time;
    int cafe_image;
    boolean expanded_c;

    public CafeItems(String cafe_name, String cafe_time, int cafe_image) {
        this.cafe_name = cafe_name;
        this.cafe_time = cafe_time;
        this.cafe_image = cafe_image;

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

    public void setCafe_time(String cafe_time) {
        this.cafe_time = cafe_time;
    }

    public int getCafe_image() {
        return cafe_image;
    }

    public void setCafe_image(int cafe_image) {
        this.cafe_image = cafe_image;
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
