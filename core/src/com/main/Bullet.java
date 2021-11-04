package com.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    int x, y, w, h;
    int speed, dt, md; //dt = distance travelled, md = maximum distance that can be travelled
    float angle;
    String type;
    boolean active = true;

    Bullet(String type, int x, int y){
        this.type = type;
        this.x = x;
        this.y = y;

        w = Tables.bullet_resources.get(type) == null ? Resources.bullet.getWidth() : Tables.bullet_resources.get(type).getWidth();
        h = Tables.bullet_resources.get(type) == null ? Resources.bullet.getHeight() : Tables.bullet_resources.get(type).getHeight();;
        speed = 5;
        dt = 0;
        md = 300;
        angle = calc_angle();


    }

    void draw(SpriteBatch batch){
        batch.draw(Tables.bullet_resources.get(type) == null ? Resources.bullet : Tables.bullet_resources.get(type), x, y);
    }

    void update(){
         x += Math.cos(angle) * speed;
         y += Math.sin(angle) * speed;
         dt += Math.cos(angle) * speed + Math.sin(angle) * speed;
         active = dt < md;
         hitzombie();
    }

    Rectangle hitbox(){ return new Rectangle(x, y, w, h);}

    float calc_angle(){

        float zx = Main.zombies.get(0).x + (float)Main.zombies.get(0).w / 2, zy = Main.zombies.get(0).y + (float)Main.zombies.get(0).h / 2;
        return (float)(Math.atan((y - zy)/(x - zx)) + (x >= zx ? Math.PI : 0));
    }

    void hitzombie(){
        if(Main.zombies.isEmpty()) return;
        for(Zombie z : Main.zombies) {
            if (z.gethitbox().contains(hitbox())) {
                z.hp--;
                this.active = false;
            }
        }
    }

}