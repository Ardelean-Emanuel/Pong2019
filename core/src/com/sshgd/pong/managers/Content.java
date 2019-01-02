package com.sshgd.pong.managers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;



public class Content {
		
	private HashMap <String,Music> music; //E ca un tabel unde folosim obiecte, si am dat la string valoarea de Music
	private HashMap <String,Sound> sound;
	private HashMap<String, BitmapFont> font;
	
	
	public Content() {
		music = new HashMap <String, Music>();
		sound = new HashMap <String, Sound>();
		font = new HashMap<String, BitmapFont>();
		
	}
	
	public void loadMusic(String folder, String path, String key, boolean looping) {
		Music m = Gdx.audio.newMusic(Gdx.files.internal(folder + "/" + path));// Se uita in folderul de assets
		m.setLooping(looping);
		music.put(key, m);
	}
	
	public Music getMusic(String key) {
		return music.get(key);
	}
	
	public void setVolumeAll (float vol) {
		for (Object o: music.values()) {
			Music music = (Music) o;
			music.setVolume(vol);
		}
	}
	
	public void loadSound(String folder, String path, String key) {
		Sound s = Gdx.audio.newSound(Gdx.files.internal(folder + "/" + path));
		sound.put(key, s);
	}

	public Sound getSound(String key) {
		return sound.get(key);
	}
	
	public void loadBitmapFont(String folder, String path, String key, int size, Color color) {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(folder+"/"+ path));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = size;
		parameter.color = color;
		BitmapFont main = generator.generateFont(parameter);
		font.put(key, main);
		generator.dispose(); 
	}
	
	public BitmapFont getFont(String key) {
		return font.get(key);
	}
	
	public void removeAll() {
		for(Object o : music.values()) {
			Music m = (Music) o;
			m.dispose();
		}
		for(Object o : sound.values()) {
			Sound s = (Sound) o;
			s.dispose();
		}
		for(Object o : font.values()) {
			BitmapFont bmf = (BitmapFont) o;
			bmf.dispose();
		}
	}
	
	public void stopSound() {
		for(Object o : sound.values()) {
			Sound s = (Sound) o;
			s.stop();
		}
	}
	
	public void stopMusic() {
		for(Object o : music.values()) {
			Music m = (Music) o;
			m.stop();
		}
	}
	
	public void stopAllSound() {
		stopSound();
		stopMusic();
	}

	
	
}
