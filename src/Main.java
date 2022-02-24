public class Main {
	public static void main(String[] args) {
		Cube cube = new Cube();
		String scramble = "D2 B2 L2 U2 B2 R2 B R2 U' L R' U2 L2 B' F2 D' F' L";
		Control controller = new Control(cube, scramble);
	}
}