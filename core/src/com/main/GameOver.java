package com.main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOver extends Scene {

    mButton m1, m2;


    GameOver(){
        title = "Game Over";
        font.getData().setScale(3f);
        layout.setText(font, title);
        m1 = new mButton("Main Menu", (1024 / 2) - (150 / 2), 325, 150, 75, Color.DARK_GRAY);
        m2 = new mButton("Try Again", (1024 / 2) - (150 / 2), 200, 150, 75, Color.GREEN);

    }

    void tap(int x, int y){
        if(m1.hitbox().contains(x, y)); {
            Main.started = false;
            Main.info = false;
            Main.lose = false;
        }
        if(m2.hitbox().contains(x, y)); {
            Main.lose = false;
            Main.started = true;
            Main.game = new Game();
        }
    }

    void draw(SpriteBatch batch){
        ScreenUtils.clear(new Color(0x00444444));
        font.draw(batch, layout, 1024 / 2 - layout.width / 2, 565);
        m1.draw(batch);
        m2.draw(batch);


    }


}
