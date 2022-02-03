package com.main;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Resources {
    // TODO: UI Elements
    static Texture bg = new Texture(Gdx.files.internal("bg_lab.png"));
    static Texture button_cannon = new Texture(Gdx.files.internal("CannonIcon.png"));
    static Texture button_cannon_fire = new Texture(Gdx.files.internal("FireCannonIcon.png"));
    static Texture button_cannon_super = new Texture(Gdx.files.internal("SuperCannonIcon.png"));
    static Texture button_cannon_double = new Texture(Gdx.files.internal("doubleCannonIcon.png"));
    static Texture button_cannon_laser = new Texture(Gdx.files.internal("laserCannonIcon.png"));
    static Texture button_cannon_mounted = new Texture(Gdx.files.internal("mountedCannonIcon.png"));
    static Texture button_wall = new Texture(Gdx.files.internal("WallIcon.png"));

    static Texture button_play = new Texture(Gdx.files.internal("play.png"));

    static Texture button_pause = new Texture(Gdx.files.internal("pause.png"));
    static Texture button_start = new Texture(Gdx.files.internal("startButton.png"));
    static Texture button_exit = new Texture(Gdx.files.internal("exitButton.png"));
    static Texture button_close = new Texture(Gdx.files.internal("x.png"));
    static Texture locked = new Texture(Gdx.files.internal("locked.png"));
    static Texture selected = new Texture(Gdx.files.internal("border.png"));
    static Texture tooltip_bg = new Texture(Gdx.files.internal("ttbg.png"));
    static Texture red_bar = new Texture(Gdx.files.internal("red_bar.png"));
    static Texture green_bar = new Texture(Gdx.files.internal("green_bar.png"));
    static Texture wall = new Texture(Gdx.files.internal("Wall.png"));
    // TODO: Cannons
    static Texture cannon = new Texture(Gdx.files.internal("Cannon.png"));
    static Texture cannon_fire = new Texture(Gdx.files.internal("Firecannon.png"));
    static Texture cannon_super = new Texture(Gdx.files.internal("SuperCannon.png"));
    static Texture cannon_double = new Texture(Gdx.files.internal("doubleCannon.png"));
    static Texture cannon_laser = new Texture(Gdx.files.internal("laserCannon.png"));
    static Texture cannon_mounted = new Texture(Gdx.files.internal("mountedCannon.png"));

    // TODO: Zombies
    static Texture zombie = new Texture(Gdx.files.internal("Zombies.png"));
    static Texture zombie_fast = new Texture(Gdx.files.internal("Fastzombies.png"));
    static Texture zombie_dif = new Texture(Gdx.files.internal("DifZombies.png"));
    static Texture zombie_speedy = new Texture(Gdx.files.internal("speedy_zombie.png"));
    static Texture zombie_riot = new Texture(Gdx.files.internal("riotzombieBIG.png"));


    static Texture bullet = new Texture(Gdx.files.internal("Bullet.png"));
    static Texture bullet_missile = new Texture(Gdx.files.internal("missile.png"));

    // TODO: Sounds
    static Sound sfx_bullet = Gdx.audio.newSound(Gdx.files.internal("Bullet.mp3"));

    // TODO: Effects
    static Texture click_effect = new Texture(Gdx.files.internal("click_effect.png"));
    static Texture blood_effect = new Texture(Gdx.files.internal("blood_effect.png"));

    // TODO: Bullets
    static Texture bullet_super = new Texture(Gdx.files.internal("superbullet.png"));
    static Texture bullet_fire = new Texture(Gdx.files.internal("firebullet.png"));

    //Predefined Textures
    static Texture red = createTexture(Color.RED);
    static Texture green = createTexture(Color.GREEN);
    static Texture tan = createTexture(Color.TAN);

    //Methods
    static Texture createTexture(Color color){
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(color);
        p.fillRectangle(0, 0, 1, 1);
        return new Texture(p);
    }

    static Color inverse_color(Color color){
        return new Color(1f - color.r, 1f - color.g, 1f - color.b, 1f);
    }

}
