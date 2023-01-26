package HARDGAME;


import java.awt.Color;

import javax.swing.JFrame;

public class Board extends JFrame{



private final int WIDTH = 600;
private final int HEIGHT = 400;

private final int P1_X = 550;
private final int P1_Y = 175;

private final int P2_X = 30;
private final int P2_Y = 175;


private final int P1_SPEED = 3;
private final int P2_SPEED = 3;


private final int B_SPEED = 2;


public Board(){
	
	super("Paddle Ball");
	
	
	this.setSize(WIDTH, HEIGHT);;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
	
	Player p1 = new Player(P1_X, P1_Y, P1_SPEED);	
	Player p2 = new Player(P2_X, P2_Y, P2_SPEED);
	
	
	Ball b = new Ball(B_SPEED);
	
	
	ScoreBoard sb = new ScoreBoard();
	
	
	this.getContentPane().setBackground(Color.blue);
	this.getContentPane().add(new Screen(p1, p2, b, sb));
}
}


