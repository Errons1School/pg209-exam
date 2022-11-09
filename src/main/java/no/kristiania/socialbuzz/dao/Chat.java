package no.kristiania.socialbuzz.dao;

import java.util.List;

public class Chat implements Comparable<Chat>{
    long id_chat;
    String title;
    List<User> users;

    public long getId_chat() {
        return id_chat;
    }

    public void setId_chat(long id_chat) {
        this.id_chat = id_chat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    @Override
    public int compareTo(Chat chat) {
        return (int) (this.getId_chat() - chat.getId_chat());
    }

}
