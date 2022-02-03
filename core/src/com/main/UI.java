package com.main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UI {
    static int money, life, wave, score;
    static BitmapFont font = new BitmapFont();

    static void draw(SpriteBatch batch){
        //Draw all text
        font.setColor(Color.GOLD);
        font.draw(batch, "Money: " + money, 15, 585);
        font.setColor(Color.PINK);
        font.draw(batch, "Wave: " + wave, 15, 565);
        font.setColor(Color.LIME);
        font.draw(batch, "Life: " + life, 15, 545);
        font.setColor(Color.CYAN);
        font.draw(batch, "Score: " + score, 15, 525);
    }
}
