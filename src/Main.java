import java.util.ArrayList;


public class Main {
	public static void main(String args[]) {
		Cube cube = new Cube();
		MoveParser parser = new MoveParser();
		cube.printState();
		if(!parser.parseCheck("R' F2 D' F' B L' B2 D2 F' D' R2 L2 U' R2 U' D F2 L2 F2 R2", cube)) {
			System.out.println("invalid scramble");
		}
		cube.printState();
		
	}
}
