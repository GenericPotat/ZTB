package com.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	// GAME VARIABLES
	SpriteBatch batch;
	Random r;



	Zombie zombie;

	// CONTROL VARIABLES

	// GAME LISTS
	static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
	static ArrayList<Cannon> cannons = new ArrayList<Cannon>();
	static ArrayList<Button> buttons = new ArrayList<Button>();
	static ArrayList<Bullet> bullets = new ArrayList<Bullet>();


	@Override
	public void create () {
		batch = new SpriteBatch();
		r = new Random();
		setup();



	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		update();
		batch.begin();

		batch.draw(Resources.bg, 0, 0);

		for (Zombie z: zombies) z.draw(batch);
		for (Cannon c: cannons) c.draw(batch);
		for (Button b: buttons) b.draw(batch);
		for (Bullet b: bullets) b.draw(batch);




		batch.end();
	}

	void update(){
		tap(); //first in update
		spawn_zombies();
		for (Zombie z: zombies) z.update();
		for (Cannon c: cannons) c.update();
		for (Button b: buttons) b.update();
		for (Bullet b: bullets) b.update();


		housekeeping(); //last in update


	}

	void tap() {
		if(Gdx.input.justTouched()){
			int x = Gdx.input.getX(), y = Gdx.graphics.getHeight() - Gdx.input.getY();

			for(Cannon c : cannons) if(c.gethitbox().contains(x, y)) return;
			if(buildable(x, y)) cannons.add(new Cannon("ccc", x, y));

		}
	}

	boolean buildable(int x, int y){
		return (x < 1000 && ((y < 200 || y > 300) && y < 500 ));
	}

	void setup() {
		Tables.init();
		for (int i = 0; i < 5; i++){
			buttons.add(new Button("bbb", i * 75 + 25, 525));

		}

	}

	void housekeeping() {
		for(Zombie z : zombies) if(!z.active) { zombies.remove(z); break; }
		for(Bullet b : bullets) if(!b.active) { bullets.remove(b); break; }
	}

	void spawn_zombies() {
		if(!zombies.isEmpty()) return;

		for(int i = 0; i < 15; i++){
			zombies.add(new Zombie("zzz", 1024 + (i * 50), r.nextInt(450), 1));
		}
	}

	// END OF FILE, DON'T ADD BELOW THIS
	@Override
	public void dispose () {
		batch.dispose();
	}
}
