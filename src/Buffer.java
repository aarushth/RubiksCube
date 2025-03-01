import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import RubiksCube.*;

public class Buffer {
	private boolean displaySolution = false;
	private String solution;
	private RubiksCube.Color[][] net = new RubiksCube.Color[15][11];
	private Color getColorFrame(RubiksCube.Color c) {
		if(c == null) {
			return Color.BLACK;
		}
		switch(c) {
		case WHITE:
			return Color.WHITE;
		case YELLOW:
			return Color.YELLOW;
		case ORANGE:
			return Color.ORANGE;
		case RED:
			return Color.RED;
		case GREEN:
			return Color.GREEN;
		case BLUE:
			return Color.BLUE;
		default:
			return null;
		}
	}
	public void displaySolution(String s){
		displaySolution = true;
		solution = s;
	}
	public void printStateFrame(Piece[][][] cube, Graphics g) {
		int i = 0;
		int j = 0;
		int k = 0;
		int p = 0;
		int q = 0;
		//up
		for (j = 2, p = 0, k = 2; j >= 0 ; j--, p++){
			for (i = 0, q = 4; i < 3 ;i++, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.PositiveZ);
					net[q][p] = c;
			}
		}
		//left
		for (k = 2, p = 4, i = 0; k >= 0 ; k--, p++){
			for (j=2, q = 0; j >= 0 ;j--, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.NegativeX);
					net[q][p] = c;
			}
		}
		//front
		for (k = 2, p = 4, j = 0; k >= 0 ; k--, p++){
			for (i = 0, q = 4; i < 3 ;i++, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.NegativeY);
					net[q][p] = c;
			}
		}
		//right
		for (k = 2, p = 4, i = 2; k >= 0 ; k--, p++){
			for (j = 0, q = 8; j < 3 ;j++, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.PositiveX);
					net[q][p] = c;					
			}
		}
		//back
		for (k = 2, p = 4, j = 2; k >= 0 ; k--, p++){
			for (i = 2, q = 12; i >=0 ;i--, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.PositiveY);
					net[q][p] = c;
			}
		}
		//down
		for (j = 0, p = 8, k = 0; j < 3 ; j++, p++){
			for (i = 0, q = 4; i < 3 ;i++, q++){
				RubiksCube.Color c = cube[i][j][k].getColorOfFace(Orientation.NegativeZ);
					net[q][p] = c;					
			}
		}
		for (i = 0; i < 11; i++) {
			 for (j = 0; j < 15; j++) {
				 g.setColor(getColorFrame(net[j][i]));
				 g.fillRect(j*65, i*65, 65, 65);
			 }
		 }
		 if(displaySolution){
			g.setFont(new Font("Areil", Font.PLAIN, 50));
			g.setColor(Color.CYAN);
			g.drawString(solution, 400, 400);
			displaySolution = false;
		}
	}
}