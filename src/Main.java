public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		String scramble = "U' F' D B R B R B2 L2 F2 L2 D' R2 U' R2 F2 R2 F2 U2 R'";
		Control controller = new Control(cube, scramble);
	}
}
