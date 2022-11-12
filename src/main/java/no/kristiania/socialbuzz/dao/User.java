package no.kristiania.socialbuzz.dao;

import java.util.ArrayList;
import java.util.List;

public class User{
    long id_user;
    String username;
    String name;
    String tlf;
    List<Email> emails = new ArrayList<>();

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void addEmail(Email mail) {
        emails.add(mail);
    }
    public List<Email> getEmails() {
        return emails;
    }

    public void EditMail(Email mail, int id) {
        emails.set(id,mail);
    }
}
