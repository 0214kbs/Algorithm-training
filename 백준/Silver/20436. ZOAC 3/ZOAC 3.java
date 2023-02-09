import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	// 수정 사항 : "b"의 위치
	static char[][] left = { { 'q', 'w', 'e', 'r', 't' }, { 'a', 's', 'd', 'f', 'g' }, { 'z', 'x', 'c', 'v' } };
	static char[][] right = { { ' ', 'y', 'u', 'i', 'o', 'p' }, { ' ', 'h', 'j', 'k', 'l' }, { 'b', 'n', 'm' } };
	static Map<Character, Pair> leftKeyboard, rightKeyboard;
	static int time = 0;

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static Pair L, R;

	public static void main(String[] args) throws Exception {
		// setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		leftKeyboard = new HashMap<>();
		rightKeyboard = new HashMap<>();
		// key value
		for (int i = 0; i < left.length; i++) {
			for (int j = 0; j < left[i].length; j++) {
				leftKeyboard.put(left[i][j], new Pair(i, j));
			}
		}
		for (int i = 0; i < right.length; i++) {
			for (int j = 0; j < right[i].length; j++) {
				rightKeyboard.put(right[i][j], new Pair(i, j));
			}
		}

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = leftKeyboard.get(st.nextToken().charAt(0));
		R = rightKeyboard.get(st.nextToken().charAt(0));
		char[] charArr = br.readLine().toCharArray();
//		String input = br.readLine();

		// solution
		for (char c : charArr) {
			move(c);
		}
		System.out.println(time);

	}

	static void move(char c) { // 왼쪽 오른쪽 구분하고 거리 측정, 손가락 옮기기
		if (leftKeyboard.containsKey(c)) { // 왼쪽
			Pair p = leftKeyboard.get(c);
			time += (Math.abs(p.x - L.x) + Math.abs(p.y - L.y) + 1);
			L = p;
		} else {// 오른쪽
			Pair p = rightKeyboard.get(c);
			time += (Math.abs(R.x - p.x) + Math.abs(R.y - p.y) + 1);
			R = p;
		}
	}

}
