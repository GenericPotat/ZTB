package com.main;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Zombie {
    int x, y, w, h, speed, hp, maxhp;
    String type;
    boolean active = true;

    // ANIMATION VARIABLES
    int rows, cols;
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time = 0.2f;

    Zombie(String type, int x, int y){

        this.type = type;
        this.x = x;
        this.y = y;
        this.speed = Tables.balance.get("speed_"+type) == null ? 10 : Tables.balance.get("speed_"+type);
        hp = Tables.balance.get("hp_"+type) == null ? 5 : Tables.balance.get("hp_"+type);
        maxhp = hp;
        rows = 1;
        cols = Tables.balance.get("cols_"+type) == null ? 4 : Tables.balance.get("cols_"+type);;
        w =  Tables.zombie_resources.get(type) == null ? Resources.zombie.getWidth() / cols : Tables.zombie_resources.get(type).getWidth() / cols;
        h =  Tables.zombie_resources.get(type) == null ? Resources.zombie.getHeight() / rows : Tables.zombie_resources.get(type).getHeight() / rows;

        init_animations();
    }

    void draw(SpriteBatch batch){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion) anim.getKeyFrame(frame_time, true);
        batch.draw(frame, x, y);
        batch.draw(Resources.red_bar, x, y - 5, w, 5);
        batch.draw(Resources.green_bar, x, y - 5, hp * ((float)w / (float)maxhp), 5);
    }

    void update(){
        x -= speed;

        UI.score += hp > 0 ? 0 : 1;
        UI.money += hp > 0 ? 0 : 5;
        UI.life -= x + w >  0 ? 0 : 1;

        active = x + w > 0 && hp > 0;
    }

    void init_animations(){
        // split texture into individual cells
        TextureRegion[][] sheet =
                TextureRegion.split(Tables.zombie_resources.get(type) == null ? Resources.zombie : Tables.zombie_resources.get(type), w, h);
        // init numbers of frames to maximum number possible (all rows * all cols)
        frames = new TextureRegion[rows * cols];
        //loop through the texture sheet and fill frames array with cells (in order)
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];
        //initialize the animation object
        anim = new Animation(frame_time, frames);

    }

    Rectangle gethitbox(){ return new Rectangle(x, y, w, h);}








}
