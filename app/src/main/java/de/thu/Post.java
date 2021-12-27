package de.thu;

public class Post {

    private String date;
    private String email;
    private String post;
    private String id;

    public Post() {
    }

    public Post(String date, String email, String post, String id) {
        this.date = date;
        this.email = email;
        this.post = post;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
