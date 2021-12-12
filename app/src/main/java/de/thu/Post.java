package de.thu;

public class Post {

    private String date;
    private String email;
    private String post;

    public Post() {
    }

    public Post(String date, String email, String post) {
        this.date = date;
        this.email = email;
        this.post = post;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
