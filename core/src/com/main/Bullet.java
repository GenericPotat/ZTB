package com.main;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    int x, y, w, h;
    int speed, dt, md; //dt = distance travelled, md = maximum distance that can be travelled
    float angle;
    String type;
    boolean active = true;
    Sprite sprite;

    Bullet(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;
        sprite = new Sprite(Tables.resources.get("bullet_" + type) == null ? Resources.bullet : Tables.resources.get("bullet_" + type));
        w = Tables.bullet_resources.get(type) == null ? Resources.bullet.getWidth() : Tables.bullet_resources.get(type).getWidth();
        h = Tables.bullet_resources.get(type) == null ? Resources.bullet.getHeight() : Tables.bullet_resources.get(type).getHeight();;
        speed = 5;
        dt = 0;
        md = 300;
        angle = calc_angle();
        sprite.setPosition(x, y);
        sprite.setRotation((float)Math.toDegrees(calc_angle()) - 90f);


    }

    void draw(SpriteBatch batch){
        sprite.draw(batch);
        //batch.draw(Tables.bullet_resources.get(type) == null ? Resources.bullet : Tables.bullet_resources.get(type), x, y);
    }

    void update(){
         x += Math.cos(angle) * speed;
         y += Math.sin(angle) * speed;
         sprite.setPosition(x, y);
         dt += Math.abs(Math.cos(angle)) * speed + Math.abs(Math.sin(angle)) * speed;
         active = dt < md;
         hitzombie();
    }

    Rectangle hitbox(){ return new Rectangle(x, y, w, h);}

    float calc_angle(){

        Zombie closest = null;
        for(Zombie z : Game.zombies){
            if(closest == null) { closest = z; continue; }
            float hypotenuseCurrent = (float) Math.sqrt(((y - z.y) * (y - z.y)) + (x - z.x) * (x - z.x));
            float hypotenuseClosest = (float) Math.sqrt(((y - closest.y) * (y - closest.y)) + (x - closest.x) * (x - closest.x));
            if(hypotenuseCurrent < hypotenuseClosest) closest = z;


        }
        float zx = closest.x + (float)closest.w / 2, zy = closest.y + (float)closest.h / 2;
        return (float) ((float)Math.atan((y - zy)/(x - zx)) + (x >= zx ? Math.PI : 0));
    }

    void hitzombie(){
        if(Game.zombies.isEmpty()) return;
        for(Zombie z : Game.zombies) {
            if (z.gethitbox().contains(hitbox())) {
                z.hp--;
                this.active = false;
            }
        }
    }

}