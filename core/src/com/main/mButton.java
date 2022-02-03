package com.main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Locale;

public class mButton {
    int x, y, w, h;
    String type;
    Color color;
    BitmapFont font;
    GlyphLayout layout;

    mButton(String type, int x, int y, int w, int h, Color color){
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        font = new BitmapFont();
        font.setColor(Resources.inverse_color(color));

        layout = new GlyphLayout();
        //layout.setText(font, type);
        while(layout.width < w - (2 * (float)(w / 10)) && layout.height < h - (3 * (float)(h / 10))){
            font.getData().setScale(font.getData().scaleX + 0.1f);
            layout.setText(font, type.substring(0, 1).toUpperCase() + type.substring(1));

        }
    }

    void draw(SpriteBatch batch){
        batch.draw(Resources.createTexture(color), x, y, w, h);
        font.draw(batch, layout, x + (float)w / 2 - layout.width / 2, y + (float)h / 2 + layout.height / 2 );
    }

    Rectangle hitbox() { return new Rectangle(x, y, w, h); }
}


