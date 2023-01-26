package HARDGAME;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScoreBoard extends JPanel{

private int p1_score;
private int p2_score;

private final int WINNING_SCORE = 10;


private boolean p1_wins = false;
private boolean p2_wins = false;

private JLabel score1, score2;


public ScoreBoard(){
	p1_score = 0;
	p2_score = 0;
	
	score1 = new JLabel();
	score1.setText("P1: " + p1_score);
	score1.setFont(new Font("Monospaced",Font.BOLD,25));
	score1.setForeground(Color.WHITE);
	
	score2 = new JLabel();
	score2.setText("P2: " + p2_score);
	score2.setFont(new Font("Monospaced",Font.BOLD,25));
	score2.setForeground(Color.WHITE);
	
	this.setOpaque(false);
	this.add(score1);
	this.add(score2);
}

public void pointP1(){
	p1_score++;
	if(p1_score == WINNING_SCORE){
		p1_wins = true;
	}
	score1.setText("P1: " + p1_score);
}

public void pointP2(){
	p2_score++;
	
	if(p2_score == WINNING_SCORE){
		p2_wins = true;
	}
	score2.setText("P2: " + p2_score);
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
