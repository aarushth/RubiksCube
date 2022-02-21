import java.awt.Color;
import java.awt.Graphics;
import java.io.FileWriter;
import java.io.IOException;
import RubiksCube.*;

public class Buffer {
	private static int stateNumber = 0;
	private RubiksCube.Color[][] net = new RubiksCube.Color[15][11];
	
	public Buffer() {

	}
	private String getColor(RubiksCube.Color c) {
		if(c == null) {
			return "\r\n 0 0 0 ";
		}
		switch(c) {
		case WHITE:
			return "\r\n 255 255 255";
		case YELLOW:
			return"\r\n 255 255 0 ";
		case ORANGE:
			return"\r\n 255 165 0 ";
		case RED:
			return "\r\n 255 0 0 ";
		case GREEN:
			return "\r\n 0 255 0 ";
		case BLUE:
			return "\r\n 0 0 255 ";
		default:
			return null;
		}
	}
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
	/*
	private void frontParallelogram(int x, int y, int multiplier, Color c, Graphics g) {
		g.setColor(c);
		int[] xpoints = new int[4];
		xpoints[0] = x*multiplier;
		xpoints[1] = (x+2)*multiplier;
		xpoints[2] = (x+2)*multiplier;
		xpoints[3] = (x)*multiplier;
		int[] ypoints = new int[4];
		ypoints[0] = (y)*multiplier;
		ypoints[1] = (y-1)*multiplier;
		ypoints[2] = (y-3)*multiplier;
		ypoints[3] = (y-2)*multiplier;
		g.fillPolygon(new Polygon(xpoints, ypoints, 4));
	}
	private void rightParallelogram(int x, int y, int multiplier, Color c, Graphics g) {
		g.setColor(c);
		int[] xpoints = new int[4];
		xpoints[0] = x*multiplier;
		xpoints[1] = (x-2)*multiplier;
		xpoints[2] = (x-2)*multiplier;
		xpoints[3] = (x)*multiplier;
		int[] ypoints = new int[4];
		ypoints[0] = (y)*multiplier;
		ypoints[1] = (y-1)*multiplier;
		ypoints[2] = (y-3)*multiplier;
		ypoints[3] = (y-2)*multiplier;
		g.fillPolygon(new Polygon(xpoints, ypoints, 4));
	}
	private void upParallelogram(int x, int y, int multiplier, Color c, Graphics g) {
		g.setColor(c);
		int[] xpoints = new int[4];
		xpoints[0] = x*multiplier;
		xpoints[1] = (x+2)*multiplier;
		xpoints[2] = (x)*multiplier;
		xpoints[3] = (x-2)*multiplier;
		int[] ypoints = new int[4];
		ypoints[0] = (y)*multiplier;
		ypoints[1] = (y+1)*multiplier;
		ypoints[2] = (y+2)*multiplier;
		ypoints[3] = (y+1)*multiplier;
		g.fillPolygon(new Polygon(xpoints, ypoints, 4));
	}
	*/
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
	}
	public void printState(Piece[][][] cube) {
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
		try {
			 FileWriter file = new FileWriter("C:\\Users\\aarus\\AppData\\RubiksCube\\cubeState" + stateNumber++ + ".ppm");
			 file.write("P3\r\n15 11\r\n255");
			 for (i = 0; i < 11; i++) {
				 for (j = 0; j < 15; j++) {
						 file.write(getColor(net[j][i]));
				 }
			 }
			 file.close();
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}