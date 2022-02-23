public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		String scramble = "D2 B2 L2 B2 F2 U R2 B2 U2 B2 F' R' D' L' B' D U' L B2 D2";
		Control controller = new Control(cube, scramble);
	}
}
