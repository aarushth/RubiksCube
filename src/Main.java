public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		String scramble = "D' F2 R2 D' L2 F2 U2 R2 F2 D' B2 R D2 B' R' F' R2 D2 R B' R'";
		Control controller = new Control(cube, scramble);
		
	}
}
