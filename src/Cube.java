import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cube {
	private int stateNumber = 0;
	private ArrayList<Color[][]> faces = new ArrayList<Color[][]>();
	private ArrayList<Color> facesColor = new ArrayList<Color>();
	private int up;
	private int down;
	private int left;
	private int right;
	private int back;
	private int front;
	
	public Cube() {
		for(int i = 0; i < 6; i++) {
			faces.add(new Color[3][3]);
		}
		facesColor.add(Color.WHITE);//up
		up = 0;
		facesColor.add(Color.YELLOW);//down
		down = 1;
		facesColor.add(Color.ORANGE);//left
		left = 2;
		facesColor.add(Color.RED);//right
		right = 3;
		facesColor.add(Color.BLUE);//back
		back = 4;
		facesColor.add(Color.GREEN);//front
		front = 5;
		for(int i = 0; i < faces.size() && i < facesColor.size(); i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					faces.get(i)[j][k] = facesColor.get(i);
				}
			}
		}
	}
	public void upTwo() {
		up();
		up();
	}
	public void upPrime(){
		up();
		up();
		up();
	}
	public void rightTwo() {
		right();
		right();
	}
	public void rightPrime(){
		right();
		right();
		right();
	}
	public void frontTwo() {
		front();
		front();
	}
	public void frontPrime(){
		front();
		front();
		front();
	}
	public void leftTwo() {
		left();
		left();
	}
	public void leftPrime(){
		left();
		left();
		left();
	}
	public void downTwo() {
		down();
		down();
	}
	public void downPrime(){
		down();
		down();
		down();
	}
	public void backTwo() {
		back();
		back();
	}
	public void backPrime(){
		back();
		back();
		back();
	}
	public void back() {
		turnFace(back);
		Color temp0 = faces.get(up)[0][0];
		Color temp1 = faces.get(up)[0][1];
		Color temp2 = faces.get(up)[0][2];
		faces.get(up)[0][0] = faces.get(right)[0][2];
		faces.get(up)[0][1] = faces.get(right)[1][2];
		faces.get(up)[0][2] = faces.get(right)[2][2];
		faces.get(right)[0][2] = faces.get(down)[2][2];
		faces.get(right)[1][2] = faces.get(down)[2][1];
		faces.get(right)[2][2] = faces.get(down)[2][0];
		faces.get(down)[2][2] = faces.get(left)[2][0];
		faces.get(down)[2][1] = faces.get(left)[1][0];
		faces.get(down)[2][0] = faces.get(left)[0][0];
		faces.get(left)[2][0] = temp0;
		faces.get(left)[1][0] = temp1;
		faces.get(left)[0][0] = temp2;
	}
	public void down() {
		turnFace(down);
		Color[] temp = faces.get(front)[2];
		faces.get(front)[2] = faces.get(left)[2];
		faces.get(left)[2] = faces.get(back)[2];
		faces.get(back)[2] = faces.get(right)[2];
		faces.get(right)[2] = temp;
		
	}
	public void left() {
		turnFace(left);
		Color temp0 = faces.get(up)[0][0];
		Color temp1 = faces.get(up)[1][0];
		Color temp2 = faces.get(up)[2][0];
		faces.get(up)[0][0] = faces.get(back)[2][2];
		faces.get(up)[1][0] = faces.get(back)[1][2];
		faces.get(up)[2][0] = faces.get(back)[0][2];
		faces.get(back)[2][2] = faces.get(down)[0][0];
		faces.get(back)[1][2] = faces.get(down)[1][0];
		faces.get(back)[0][2] = faces.get(down)[2][0];
		faces.get(down)[0][0] = faces.get(front)[0][0];
		faces.get(down)[1][0] = faces.get(front)[1][0];
		faces.get(down)[2][0] = faces.get(front)[2][0];
		faces.get(front)[0][0] = temp0;
		faces.get(front)[1][0] = temp1;
		faces.get(front)[2][0] = temp2;
	}
	public void right() {
		turnFace(right);
		Color temp0 = faces.get(up)[2][2];
		Color temp1 = faces.get(up)[1][2];
		Color temp2 = faces.get(up)[0][2];
		faces.get(up)[2][2] = faces.get(front)[2][2];
		faces.get(up)[1][2] = faces.get(front)[1][2];
		faces.get(up)[0][2] = faces.get(front)[0][2];
		faces.get(front)[2][2] = faces.get(down)[2][2];
		faces.get(front)[1][2] = faces.get(down)[1][2];
		faces.get(front)[0][2] = faces.get(down)[0][2];
		faces.get(down)[2][2] = faces.get(back)[0][0];
		faces.get(down)[1][2] = faces.get(back)[1][0];
		faces.get(down)[0][2] = faces.get(back)[2][0];
		faces.get(back)[0][0] = temp0;
		faces.get(back)[1][0] = temp1;
		faces.get(back)[2][0] = temp2;
		}
	public void front() {
		turnFace(front);
		Color temp0 = faces.get(up)[2][0];
		Color temp1 = faces.get(up)[2][1];
		Color temp2 = faces.get(up)[2][2];
		faces.get(up)[2][0] = faces.get(left)[2][2];
		faces.get(up)[2][1] = faces.get(left)[1][2];
		faces.get(up)[2][2] = faces.get(left)[0][2];
		faces.get(left)[2][2] = faces.get(down)[0][2];
		faces.get(left)[1][2] = faces.get(down)[0][1];
		faces.get(left)[0][2] = faces.get(down)[0][0];
		faces.get(down)[0][2] = faces.get(right)[0][0];
		faces.get(down)[0][1] = faces.get(right)[1][0];
		faces.get(down)[0][0] = faces.get(right)[2][0];
		faces.get(right)[0][0] = temp0;
		faces.get(right)[1][0] = temp1;
		faces.get(right)[2][0] = temp2;
	}
	public void up() {
		turnFace(up);
		Color[] temp = faces.get(front)[0];
		faces.get(front)[0] = faces.get(right)[0];
		faces.get(right)[0] = faces.get(back)[0];
		faces.get(back)[0] = faces.get(left)[0];
		faces.get(left)[0] = temp;
	}
	private void turnFace(int i) {
		Color temp = faces.get(i)[0][0];
		faces.get(i)[0][0] = faces.get(i)[2][0];
		faces.get(i)[2][0] = faces.get(i)[2][2];
		faces.get(i)[2][2] = faces.get(i)[0][2];
		faces.get(i)[0][2] = temp;
		temp = faces.get(i)[0][1];
		faces.get(i)[0][1] = faces.get(i)[1][0];
		faces.get(i)[1][0] = faces.get(i)[2][1];
		faces.get(i)[2][1] = faces.get(i)[1][2];
		faces.get(i)[1][2] = temp;
	}
	private String returnEmptySpace() {
		return("\r\n 0 0 0 \r\n 0 0 0 \r\n 0 0 0 ");
	}
	private String returnColorString(Color[] color) {
		StringBuffer string = new StringBuffer();
		for(int i = 0; i < color.length; i++) {
			if(color[i] == Color.WHITE) {
					string.append("\r\n 255 255 255");
			}else if(color[i] == Color.YELLOW) {
					string.append("\r\n 255 255 0 ");
			}else if(color[i] == Color.ORANGE) {
					string.append("\r\n 255 165 0 ");
			}else if(color[i] == Color.RED) {
					string.append("\r\n 255 0 0 ");
			}else if(color[i] == Color.GREEN) {
					string.append("\r\n 0 255 0 ");
			}else if(color[i] == Color.BLUE) {
					string.append("\r\n 0 0 255 ");
			}
		}
		return string.toString();
	}
	private String returnColorStringReversed(Color[] color) {
		StringBuffer string = new StringBuffer();
		for(int i = color.length - 1; i >= 0; i--) {
			if(color[i] == Color.WHITE) {
					string.append("\r\n 255 255 255");
			}else if(color[i] == Color.YELLOW) {
					string.append("\r\n 255 255 0 ");
			}else if(color[i] == Color.ORANGE) {
					string.append("\r\n 255 165 0 ");
			}else if(color[i] == Color.RED) {
					string.append("\r\n 255 0 0 ");
			}else if(color[i] == Color.GREEN) {
					string.append("\r\n 0 255 0 ");
			}else if(color[i] == Color.BLUE) {
					string.append("\r\n 0 0 255 ");
			}
		}
		return string.toString();
	}
	public void printState(){
		try {
		 FileWriter file = new FileWriter("C:\\Users\\aarus\\AppData\\RubiksCube\\cubeState" + stateNumber + ".ppm");
		 stateNumber++;
	      file.write("P3\r\n12 9\r\n255");
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(up)[0]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(up)[1]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(up)[2]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(left)[0]));
	      file.write(returnColorString(faces.get(front)[0]));
	      file.write(returnColorString(faces.get(right)[0]));
	      file.write(returnColorString(faces.get(back)[0]));
	      file.write(returnColorString(faces.get(left)[1]));
	      file.write(returnColorString(faces.get(front)[1]));
	      file.write(returnColorString(faces.get(right)[1]));
	      file.write(returnColorString(faces.get(back)[1]));
	      file.write(returnColorString(faces.get(left)[2]));
	      file.write(returnColorString(faces.get(front)[2]));
	      file.write(returnColorString(faces.get(right)[2]));
	      file.write(returnColorString(faces.get(back)[2]));
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(down)[0]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(down)[1]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.write(returnColorString(faces.get(down)[2]));
	      file.write(returnEmptySpace());
	      file.write(returnEmptySpace());
	      file.close();
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}