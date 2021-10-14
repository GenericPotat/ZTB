package com.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import javax.naming.spi.ResolveResult;

import jdk.internal.loader.Resource;

public class Cannon {
    int x, y, w, h;
    float angle;
    String type;

    Cannon(String type, int x, int y){
        this.type = type;
        w = Tables.cannon_resources.get(type) == null ? 50 : Tables.cannon_resources.get(type).getWidth();
        h = Tables.cannon_resources.get(type) == null ? 50 : Tables.cannon_resources.get(type).getHeight();
        this.x = gridlock(x - w / 2);
        this.y = gridlock(y - h / 2);

        angle = 0f;

    }

    void draw(SpriteBatch batch){
        batch.draw(Tables.cannon_resources.get(type) == null ? Resources.cannon : Tables.cannon_resources.get(type), x, y);
    }

    void update(){
        angle += 10f;
    }

    int gridlock(int n){
        return ((int)((n + 25) / 50) * 50);
    }

    Rectangle gethitbox(){ return new Rectangle(x, y, w, h);}

}

