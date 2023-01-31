package HARDGAME;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScoreBoard extends JPanel{
//variables
private int p1_score;
private int p2_score;

//final score
private final int WINNING_SCORE = 2;

//determine the winners
private boolean p1_wins = false;
private boolean p2_wins = false;

private JLabel score1, score2;

//constructor
public ScoreBoard(){
	p1_score = 0;
	p2_score = -1;
	
	score1 = new JLabel();
	score1.setText("" + p1_score);
	score1.setFont(new Font("Monospaced",Font.BOLD,25));
	score1.setForeground(Color.WHITE);
	
	score2 = new JLabel();
	score2.setText("" + p2_score);
	score2.setFont(new Font("Monospaced",Font.BOLD,25));
	score2.setForeground(Color.WHITE);
	
	this.setOpaque(false);
	this.add(score1);
	this.add(score2);
}

public void pointP1(){
	
	p1_score++;
	//if player 1 score enough points to win
	
	if(p1_score == WINNING_SCORE){
		p1_wins = true;
		score1.setText("Right Wins!");
		score2.setText("");
		
		
	}
	
	else{
		score1.setText(p1_score + " ");
	}
	
}

public void pointP2(){
	p2_score++;
	//if player 2 scores enough points to win
	
	if(p2_score == WINNING_SCORE){
		p2_wins = true;
		score2.setText("Left Wins!");
		score1.setText("");
		
	}
	
	
	else{
		score2.setText(" " + p2_score);
		
	}
	
	}
	



public int getScoreP1(){
	return p1_score;
}

public int getScoreP2(){
	return p2_score;
}

public boolean p1Wins(){
	return p1_wins;
}

public boolean p2Wins(){
	return p2_wins;
}
}
