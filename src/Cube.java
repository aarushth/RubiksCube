import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cube {
	private ArrayList<Main.Color[][]> faces = new ArrayList<Main.Color[][]>();
	private ArrayList<Main.Color> facesColor = new ArrayList<Main.Color>();
	private Main.Color[][] up = new Main.Color[3][3];
	private Main.Color[][] down = new Main.Color[3][3];
	private Main.Color[][] left = new Main.Color[3][3];
	private Main.Color[][] right = new Main.Color[3][3];
	private Main.Color[][] back = new Main.Color[3][3];
	private Main.Color[][] front = new Main.Color[3][3];
	

	private void initializeArrays() {
		faces.add(up);
		faces.add(down);
		faces.add(left);
		faces.add(right);
		faces.add(back);
		faces.add(front);
		facesColor.add(Main.Color.YELLOW);
		facesColor.add(Main.Color.WHITE);
		facesColor.add(Main.Color.ORANGE);
		facesColor.add(Main.Color.RED);
		facesColor.add(Main.Color.GREEN);
		facesColor.add(Main.Color.BLUE);
	}
	public Cube() {
		initializeArrays();
		for(int i = 0; i < faces.size() && i < facesColor.size(); i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					faces.get(i)[j][k] = facesColor.get(i);
				}
			}
		}
	}
	
	public void turnUp() {
		Main.Color temp = up[0][0];
		up[0][0] = up[2][0];
		up[2][0] = up[2][2];
		up[2][2] = up[0][2];
		up[0][2] = temp;
		Main.Color[] temp2 = front[0];
		front[0] = right[0];
		right[0] = back[0];
		back[0] = left[0];
		left[0] = temp2;
	}
	private String returnWhiteSpace() {
		return("\r\n 0 0 0 \r\n 0 0 0 \r\n 0 0 0 ");
	}
	public void printState(){
		try {
		 FileWriter file = new FileWriter("C:\\Users\\aarus\\AppData\\cubeState.ppm");
	      file.write("P3\r\n 12 9 r\n65535");
	      file.write(returnWhiteSpace());
	      
	      
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
