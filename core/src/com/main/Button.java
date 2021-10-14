package com.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Button {
    int x, y, w, h;
    float angle;
    String type;

    Button(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;

        w = Tables.button_resources.get(type) == null ? 50 : Tables.button_resources.get(type).getWidth();
        h = Tables.button_resources.get(type) == null ? 50 : Tables.button_resources.get(type).getHeight();;
        angle = 0f;

    }

    void draw(SpriteBatch batch){
        batch.draw(Tables.button_resources.get(type) == null ? Resources.button_cannon : Tables.button_resources.get(type), x, y);
    }

    void update(){
        angle += 10f;
    }

    Rectangle gethitbox(){ return new Rectangle(x, y, w, h);}

}