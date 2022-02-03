package com.main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class About extends Scene {

    mButton m1;

    About(){
        title = "About";
        font.getData().setScale(3f);
        layout.setText(font, title);
        m1 = new mButton("Back", (1024 / 2) - (150 / 2), 325, 150, 75, Color.GRAY);

    }

    void tap(int x, int y){
        if(m1.hitbox().contains(x, y)) Main.info = false;
    }

    void draw(SpriteBatch batch){
        ScreenUtils.clear(new Color(0x00444444));
        font.draw(batch, layout, 1024 / 2 - layout.width / 2, 565);
        m1.draw(batch);


    }


}
