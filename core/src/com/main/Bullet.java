package com.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    int x, y, w, h;
    float angle;
    String type;

    Bullet(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;

        w = Tables.bullet_resources.get(type) == null ? Resources.bullet.getWidth() : Tables.bullet_resources.get(type).getWidth();
        h = Tables.bullet_resources.get(type) == null ? Resources.bullet.getHeight() : Tables.bullet_resources.get(type).getHeight();;
        angle = 0f;

    }

    void draw(SpriteBatch batch){
        batch.draw(Tables.bullet_resources.get(type) == null ? Resources.bullet : Tables.bullet_resources.get(type), x, y);
    }

    void update(){
        angle += 10f;
    }

    Rectangle gethitbox(){ return new Rectangle(x, y, w, h);}

}