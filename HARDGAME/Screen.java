package HARDGAME;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class Screen extends JPanel implements Runnable, KeyListener{

private Player p1;
private boolean p1_up = false;
private boolean p1_down = false;


private Player p2;
private boolean p2_up = false;
private boolean p2_down = false;


private Ball b;
private boolean b_right = true;
private boolean b_up = true;


private ScoreBoard score;


private Thread thread;


public Screen(Player player_1, Player player_2, Ball ball, ScoreBoard board){
	
	p1 = player_1;
	
	p2 = player_2;
	
	
	b = ball;
	
	
	score = board;
	
	
	this.setFocusable(true);
	this.addKeyListener(this);
	
	this.add(board);
	
	thread = new Thread(this);
	thread.start();	
}

public void paintComponent(Graphics g){
	setOpaque(false);
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	

	g2.setColor(Color.BLACK);
	g2.fillRect(p1.getX(), p1.getY(), p1.getWidth(), p1.getHeight());
	
	g2.fillRect(p2.getX(), p2.getY(), p2.getWidth(), p2.getHeight());
	
	//draw ball
	g2.setColor(Color.WHITE);
	g2.fillOval(b.getX(), b.getY(), b.getWidth(), b.getHeight());
}

@Override
public void run() {
	// TODO Auto-generated method stub
	
	
	try{
		Thread.sleep(1000);
	}
	catch(InterruptedException e){
		
	}
	
	
	while(true){
		
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e){
			
		}
		moveBall();
		movePlayer(1);
		movePlayer(2);
	}
}

public void movePlayer(int p){
	if(p == 1){
		if(p1_up && p1.getY() > 0){
			p1.setY(p1.getY() - p1.getSpeed());
		}
		else if(p1_down && p1.getY() < (this.getHeight() - p1.getHeight())){
			p1.setY(p1.getY() + p1.getSpeed());
		}
	}
	else if(p == 2){
		if(p2_up && p2.getY() > 0){
			p2.setY(p2.getY() - p2.getSpeed());
		}
		else if(p2_down && p2.getY() < (this.getHeight() - p2.getHeight())){
			p2.setY(p2.getY() + p2.getSpeed());
		}
	}
	repaint();
}

public void moveBall(){
	
	if(b_right && hitPaddle(true)){ 
		b.setX(b.getX() - b.getSpeed());
		b_right = false;
	}
	else if(b_right && b.getX() < (this.getWidth() - b.getWidth())){ 
		b.setX(b.getX() + b.getSpeed());
	}
	else if(b_right && b.getX() >= (this.getWidth() - b.getWidth())){ 
		b.setOriginalPos();
		b_right = false;
		score.pointP2();
		
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e){
			
		}
	}
	
	else if(!b_right && hitPaddle(false)){ 
		b.setX(b.getX() + b.getSpeed());
		b_right = true;
	}
	else if(!b_right && b.getX() > 0){ 
		b.setX(b.getX() - b.getSpeed());
	}
	else if(!b_right && b.getX() <= 0){ 
		b.setOriginalPos();
		b_right = true;
		score.pointP1();
		
		try{
			Thread.sleep(500);
		}
		catch(InterruptedException e){
			
		}
	}
	
	
	if(b_up && b.getY() > 0){ 
		b.setY(b.getY() - b.getSpeed());
	}
	else if(b_up && b.getY() <= 0){ 
		b.setY(b.getY() + b.getSpeed());
		b_up = false;
	}
	else if(!b_up && b.getY() < (this.getHeight() - b.getHeight())){ 
		b.setY(b.getY() + b.getSpeed());
	}
	else if(!b_up && b.getY() >= (this.getHeight() - b.getHeight())){ 
		b.setY(b.getY() - b.getSpeed());
		b_up = true;
	}
}

public boolean hitPaddle(boolean is_right_dir){
	if(is_right_dir){
		if(b.getX() >= p1.getX() && b.getX() < (p1.getX() + p1.getWidth()) && b.getY() >= p1.getY() && b.getY() <= p1.getY() + p1.getHeight()){
			return true;
		}
		else{
			return false;
		}
	}
	else{
		if(b.getX() <= p2.getX() && b.getX() > (p2.getX() - p2.getWidth()) && b.getY() >= p2.getY() && b.getY() <= p2.getY() + p2.getHeight()){
			return true;
		}
		else{
			return false;
		}
	}
}

@Override
public void keyPressed(KeyEvent evt) {
	// TODO Auto-generated method stub
	if(evt.getKeyCode() == 38){ 
		p1_down = false;
		p1_up = true;
	}
	else if(evt.getKeyCode() == 40){ 
		p1_down = true;
		p1_up = false;
	}
	else if(evt.getKeyCode() == 65){ 
		p2_down = false;
		p2_up = true;
	}
	else if(evt.getKeyCode() == 90){ 
		p2_down = true;
		p2_up = false;
	}
}

@Override
public void keyReleased(KeyEvent evt) {
	// TODO Auto-generated method stub
	if(evt.getKeyCode() == 38){ 
		p1_up = false;
	}
	else if(evt.getKeyCode() == 40){
		p1_down = false;
	}
	else if(evt.getKeyCode() == 65){ 
		p2_up = false;
	}
	else if(evt.getKeyCode() == 90){
		p2_down = false;
	}
}

@Override
public void keyTyped(KeyEvent evt) {
	// TODO Auto-generated method stub
	
}
}

