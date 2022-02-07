public class MoveParser {

	public boolean parse(String s, Cube c) {
		for(int i = 0; i < s.length(); i++) {
			if(!(s.charAt(i) == 'F' || s.charAt(i) == 'R' || s.charAt(i) == 'U' || s.charAt(i) == 'L' || s.charAt(i) == 'B' || s.charAt(i) == 'D' || s.charAt(i) == ' ' || s.charAt(i) == '\'' || s.charAt(i) == '2')) {
				return false;
			}
		}
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
				case 'F':
					switch(s.charAt(i+1)) {
						case ' ':
							c.front();
							break;
						case '2':
							c.frontTwo();
							break;
						case '\'':
							c.frontPrime();
							break;
					}
					i++;
					break;
				case 'R':
					switch(s.charAt(i+1)) {
						case ' ':
							c.right();
							break;
						case '2':
							c.rightTwo();
							break;
						case '\'':
							c.rightPrime();
							break;
					}
					i++;
					break;
				case 'U':
					switch(s.charAt(i+1)) {
						case ' ':
							c.up();
							break;
						case '2':
							c.upTwo();
							break;
						case '\'':
							c.upPrime();
							break;
					}
					i++;
					break;
				case 'L':
					switch(s.charAt(i+1)) {
						case ' ':
							c.left();
							break;
						case '2':
							c.leftTwo();
							break;
						case '\'':
							c.leftPrime();
							break;
					}
					i++;
					break;
				case 'B':
					switch(s.charAt(i+1)) {
						case ' ':
							c.back();
							break;
						case '2':
							c.backTwo();
							break;
						case '\'':
							c.backPrime();
							break;
					}
					i++;
					break;
				case 'D':
					switch(s.charAt(i+1)) {
						case ' ':
							c.down();
							break;
						case '2':
							c.downTwo();
							break;
						case '\'':
							c.downPrime();
							break;
					}
					i++;
					break;
			}
		}
		return true;
	}
}