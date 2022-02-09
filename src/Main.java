;public class Main {
	public static void main(String[] args) {
		/*
		Cube cube = new Cube();
		Buffer buffer = new Buffer();
		MoveParser parser = new MoveParser();
		buffer.printState(cube.getCube());
		parser.parse("L' D2 L' B2 R D2 R' F2 L' U' B R D B F2 L2 F D2 ", cube);
		buffer.printState(cube.getCube());
		*/
		Cube cube = new Cube();
		Control controller = new Control(cube);
	}
}
