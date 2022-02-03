package com.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
	// GAME VARIABLES
	OrthographicCamera camera;
	SpriteBatch batch;
	static Start start;
	static Game game;
	static About about;
	static GameOver gameover;

	//CONTROL VARIABLES
	static boolean started = false, info = false, lose = false;

	Zombie zombie;

	// CONTROL VARIABLES
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1024, 600);
		start = new Start();
		game = new Game();
		about = new About();
		gameover = new GameOver();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		tap();
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(!started) if(info) about.draw(batch); else start.draw(batch);
		else if(lose) gameover.draw(batch); else game.draw(batch);
		batch.end();
	}

	void tap() {
		if(Gdx.input.justTouched()){
			Vector3 t = new Vector3();
			t.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(t);
			int x = (int)t.x, y = (int)t.y;
			if(!started) if(info) about.tap(x, y); else start.tap(x, y);
			else if(lose) gameover.tap(x, y); else game.tap(x, y);
		}
	}
	// END OF FILE, DON'T ADD BELOW THIS
	@Override
	public void dispose () {
		batch.dispose();
	}
}