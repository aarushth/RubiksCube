import java.io.FileWriter;
import java.io.IOException;
import RubiksCube.*;

public class Buffer {
	private int stateNumber = 0;
	private Color[][] net = new Color[15][11];
	
	public Buffer() {

	}
	private String getColor(Color c) {
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
	
	
	
	public void printState(Piece[][][] cube) {
		//up
		for (int j = 2, p = 0; j >= 0 ; j--, p++){
			for (int i = 0, q = 4; i < 3 ;i++, q++){
				Color c = cube[i][j][2].getColorOfFace(Orientation.PositiveZ);
					net[q][p] = c;
			}
		}
		//left
		for (int k = 2, p = 4; k >= 0 ; k--, p++){
			for (int j=2, q = 0; j >= 0 ;j--, q++){
				Color c = cube[0][j][k].getColorOfFace(Orientation.NegativeX);
					net[q][p] = c;
			}
		}
		//front
		for (int j = 2, p = 4; j >= 0 ; j--, p++){
			for (int i=0, q = 4; i < 3 ;i++, q++){
				Color c = cube[i][0][j].getColorOfFace(Orientation.NegativeY);
					net[q][p] = c;
			}
		}
		//right
		for (int j = 2, p = 4; j >= 0 ; j--, p++){
			for (int i=0, q = 8; i < 3 ;i++, q++){
				Color c = cube[2][i][j].getColorOfFace(Orientation.PositiveX);
					net[q][p] = c;					
			}
		}
		//back
		for (int j = 2, p = 4; j >= 0 ; j--, p++){
			for (int i=0, q = 12; i < 3 ;i++, q++){
				Color c = cube[i][2][j].getColorOfFace(Orientation.PositiveY);
					net[q][p] = c;
			}
		}
		//down
		for (int j = 0, p = 8; j < 3 ; j++, p++){
			for (int i = 0, q = 4; i < 3 ;i++, q++){
				Color c = cube[i][j][0].getColorOfFace(Orientation.NegativeZ);
					net[q][p] = c;					
			}
		}
		try {
			 FileWriter file = new FileWriter("C:\\Users\\aarus\\AppData\\RubiksCube\\cubeState" + stateNumber + ".ppm");
			 file.write("P3\r\n15 11\r\n255");
			 for (int i = 0; i < 11; i++) {
				 for (int j = 0; j < 15; j++) {
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