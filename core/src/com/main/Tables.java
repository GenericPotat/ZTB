package com.main;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Tables {
    static HashMap<String, Texture> cannon_resources = new HashMap<String, Texture>();
    static HashMap<String, Texture> button_resources = new HashMap<String, Texture>();
    static HashMap<String, Texture> zombie_resources = new HashMap<String, Texture>();
    static HashMap<String, Texture> bullet_resources = new HashMap<String, Texture>();
    static HashMap<String, Integer> balance = new HashMap<String, Integer>();

    static void init(){
        cannon_resources.put("fire", Resources.cannon_fire);
        cannon_resources.put("super", Resources.cannon_super);
        cannon_resources.put("laser", Resources.cannon_laser);
        cannon_resources.put("double", Resources.cannon_double);
        cannon_resources.put("mounted", Resources.cannon_mounted);

        button_resources.put("fire", Resources.button_cannon_fire);
        button_resources.put("super", Resources.button_cannon_super);
        button_resources.put("laser", Resources.button_cannon_laser);
        button_resources.put("double", Resources.button_cannon_double);
        button_resources.put("mounted", Resources.button_cannon_mounted);
        button_resources.put("play", Resources.button_play);
        button_resources.put("pause", Resources.button_pause);
        button_resources.put("start", Resources.button_start);
        button_resources.put("exit", Resources.button_exit);

        zombie_resources.put("fast", Resources.zombie_fast);
        zombie_resources.put("dif", Resources.zombie_dif);
        zombie_resources.put("speedy", Resources.zombie_speedy);
        zombie_resources.put("riot", Resources.zombie_riot);

        //cannon fire delays
        balance.put("delay_fire", 15);
        balance.put("delay_double", 45);

        //zombie speeds
        balance.put("speed_fast", 3);
        balance.put("speed_riot", 1);

        //zombie health
        balance.put("hp_fast", 4);
        balance.put("hp_riot", 10);

        //animation variables
        balance.put("cols_speedy", 6);
        balance.put("cols_laser", 16);
    }
}
