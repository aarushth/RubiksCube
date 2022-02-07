import RubiksCube.*;
public class Cube {
	private Piece[][][] cube = new Piece[3][3][3];
	/*
	private static Face white = new Face(Color.WHITE, Orientation.PositiveZ);
	private static Face yellow = new Face(Color.YELLOW, Orientation.NegativeZ);
	private static Face green = new Face(Color.GREEN, Orientation.NegativeY);
	private static Face blue = new Face(Color.BLUE, Orientation.PositiveY);
	private static Face red = new Face(Color.RED, Orientation.PositiveX);
	private static Face orange = new Face(Color.ORANGE, Orientation.NegativeX);
	*/
	
	public Piece[][][] getCube(){
		return cube;
	}
	private Piece[][][] getCubeCopy(){
		Piece[][][] cubeCopy = new Piece[3][3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					cubeCopy[i][j][k] = cube[i][j][k];
				}
			}
		}
		return cubeCopy;
	}
	private Face whichXFace(int i) {
		if(i < 0 ) {
			return new Face(Color.ORANGE, Orientation.NegativeX);
		}else if(i > 0) {
			return new Face(Color.RED, Orientation.PositiveX);
		}else {
			return null;
		}
	}
	private Face whichYFace(int i) {
		if(i < 0) {
			return new Face(Color.GREEN, Orientation.NegativeY);
		}else if(i > 0) {
			return new Face(Color.BLUE, Orientation.PositiveY);
		}else {
			return null;
		}
	}
	private Face whichZFace(int i) {
		if(i < 0 ) {
			return new Face(Color.YELLOW, Orientation.NegativeZ);
		}else if(i > 0) {
			return new Face(Color.WHITE, Orientation.PositiveZ);
		}else {
			return null;
		}
	}
	public Cube() {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for(int k = -1; k < 2; k++) {
					switch(Math.abs(i) + Math.abs(j) + Math.abs(k)) {
					case 3:
						cube[i+1][j+1][k+1] = new Corner(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 2:
						cube[i+1][j+1][k+1] = new Edge(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 1:
						cube[i+1][j+1][k+1] = new Center(whichXFace(i), whichYFace(j), whichZFace(k));
						break;
					case 0:
						cube[i+1][j+1][k+1] = null;
					}
				}
			}
		}
	}
	public void up() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][2].rotate(Orientation.PositiveZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][2] = temp[2-j][i][2];
			}
		}
	}
	public void down() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][j][0].rotate(Orientation.NegativeZ);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][j][0] = temp[j][2-i][0];
			}
		}
	}
	public void right() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[2][i][j].rotate(Orientation.PositiveX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[2][i][j] = temp[2][2-j][i];
			}
		}
	}
	public void left() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[0][i][j].rotate(Orientation.NegativeX);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[0][i][j] = temp[0][j][2-i];
			}
		}
	}
	public void back() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][2][j].rotate(Orientation.PositiveY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][2][j] = temp[j][2][2-i];
			}
		}
	}
	public void front() {
		Piece[][][] temp = getCubeCopy();
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				cube[i][0][j].rotate(Orientation.NegativeY);
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cube[i][0][j] = temp[2-j][0][i];
			}
		}
	}
	public void upPrime() {
		up();
		up();
		up();
	}
	public void downPrime() {
		down();
		down();
		down();
	}
	public void leftPrime() {
		left();
		left();
		left();
	}
	public void rightPrime() {
		right();
		right();
		right();
	}
	public void backPrime() {
		back();
		back();
		back();
	}
	public void frontPrime() {
		front();
		front();
		front();
	}
	public void upTwo() {
		up();
		up();
	}
	public void downTwo() {
		down();
		down();
	}
	public void leftTwo() {
		left();
		left();
	}
	public void rightTwo() {
		right();
		right();
	}
	public void backTwo() {
		back();
		back();
	}
	public void frontTwo() {
		front();
		front();
	}
}
