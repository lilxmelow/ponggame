package HARDGAME;


import java.awt.Color;

import javax.swing.JFrame;

public class Board extends JFrame{
//variables

//size of the board
private final int WIDTH = 600;
private final int HEIGHT = 400;

//starting location of the players
//player 1
private final int P1_X = 550;
private final int P1_Y = 175;
//player 2
private final int P2_X = 30;
private final int P2_Y = 175;

//speed of the players
private final int P1_SPEED = 3;
private final int P2_SPEED = 3;

//speed of the ball
private final int B_SPEED = 2;

//constructor
public Board(){
	//set the title of the frame
	super("Paddle Ball");
	
	//set frame information
	this.setSize(WIDTH, HEIGHT);;
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
	//create players
	Player p1 = new Player(P1_X, P1_Y, P1_SPEED);	
	Player p2 = new Player(P2_X, P2_Y, P2_SPEED);
	
	//create ball
	Ball b = new Ball(B_SPEED);
	
	//create the scoreboard
	ScoreBoard sb = new ScoreBoard();
	
	//draw the components
	this.getContentPane().setBackground(Color.blue);
	this.getContentPane().add(new Screen(p1, p2, b, sb));
}
}


