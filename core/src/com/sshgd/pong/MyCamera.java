package com.sshgd.pong;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class MyCamera extends OrthographicCamera {

	public MyCamera() {
		super();
	}

	public MyCamera(float viewportWidth, float viewportHeight) {
		super(viewportWidth, viewportHeight);
		
	}
	
	public MyCamera(Vector2 viewport) {
		super(viewport.x,viewport.y);
	}
// Verifica daca un punct este in camera
	public boolean inView(float x, float y) {
		float leftX, rightX, bottom , top;
		leftX = this.position.x - (this.viewportWidth * .5f); //Jumatate din pozitia latimii din stanga
		rightX = this.position.x + (this.viewportHeight * .5f);//din dreapta
		bottom = this.position.y - (this.viewportHeight * .5f);
		top = this.position.y + (this.viewportHeight * .5f);
		return (((x > leftX) && (x < rightX)) && ((y < top) && (y > bottom)));
	}
	//Override folosind Vector2 in loc de float-uri
	public boolean inView(Vector2 point) {
		return inView( point.x, point.y);
	}
	
	public void resize(Vector2 size, boolean center) {
		this.viewportHeight = size.y;
		this.viewportWidth = size.x;
		if(center) this.position.set(size.x * .5f, size.y * .5f, 0);// plan 2D
		this.update();//Recalculeaza pozitia pe ecran;
	}
}
