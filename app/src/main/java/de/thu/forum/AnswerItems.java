package de.thu.forum;

/**
 * Constructor, getter and setter for the answers of forum posts
 */

public class AnswerItems {

    private String date;
    private String email;
    private String reply;

    public AnswerItems() {
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

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
