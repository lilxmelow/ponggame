package HARDGAME;


public class Ball {

private final int WIDTH = 10;
private final int HEIGHT = 10;


private int x;
private int y;

private int speed;


public Ball(int s){
	x = 300;
	y = 200;
	speed = s;
}

public int getWidth(){
	return WIDTH;
}

public int getHeight(){
	return HEIGHT;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

public int getSpeed(){
	return speed;
}

public void setX(int nextX){
	x = nextX;
}

public void setY(int nextY){
	y = nextY;
}

public void setOriginalPos(){
	x = 300;
	y = 200;
}
}
