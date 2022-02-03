package com.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class Wall {
    int x, y, w, h;
    int hp = 10;
    boolean active = true;
    ArrayList<Cannon> cannons = new ArrayList<Cannon>();

    Wall(int x, int y, boolean mounted){
        this.x = gridlock(x);
        this.y = gridlock(y);
        w = Resources.wall.getWidth();
        h = Resources.wall.getHeight();
        if(mounted) load_cannons();
                //WallIcon
    }

    void load_cannons(){
        for(int i = 0; i < 10; i++) cannons.add(new Cannon("mounted", x, y + i * 50));
    }

    void update(){

        for (Cannon c : cannons) {
            c.update();
            if(!c.active) {cannons.remove(c); break;}
        }
        active = hp > 0;
        hitzombie();
    }

    int gridlock(int n){
        return ((int)((n) / 50) * 50);
    }


    void draw(SpriteBatch b){
        b.draw(Resources.wall, x, y);
        for (Cannon c : cannons) c.draw(b);
    }

    Rectangle gethitbox(){ return new Rectangle(x, y, w, h);}

    void hitzombie(){
        if(Game.zombies.isEmpty()) return;
        for(Zombie z : Game.zombies) {
            if(gethitbox().contains(z.x, z.y)){
                z.active = false;
                hp--;
            }
        }
    }
}
