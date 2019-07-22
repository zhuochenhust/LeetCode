package string;

public class RobotReturnToOrigin_657 {
	public boolean judgeCircle(String moves) {
        int h = 0, v = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                v ++;
            } else if (c == 'D') {
                v --;
            } else if (c == 'L') {
                h ++;
            } else if (c == 'R') {
                h --;
            }
        }
        return v == 0 && h == 0;
    }
}
