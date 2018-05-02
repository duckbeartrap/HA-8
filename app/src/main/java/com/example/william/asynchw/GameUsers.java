package com.example.william.asynchw;


import java.io.Serializable;

/**
 * Created by william on 5/2/18.
 */

public class GameUsers implements Serializable {

    private String username;
    private int scores;

    private String time;

    public GameUsers(String user, int score, String times){
        username = user;
        scores = score;

        time = times;
    }

    public String Username() {

        return username;

    }

    public int Score() {

        return scores;

    }

    public String Time() {

        return time;
    }
}
