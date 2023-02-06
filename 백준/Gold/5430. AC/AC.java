import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			String p = br.readLine(); // RDD
			
			int arrlen = Integer.parseInt(br.readLine()); 
			Deque<Integer> arrX = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for(int j = 0; j < arrlen; j++) {
				arrX.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flip = false;
			boolean err = false;
			for (char pi : p.toCharArray()) {
				switch (pi) {
				case 'R':
					flip = (flip) ? false : true; // true이면 false, false이면 true 변환
					break;

				case 'D':
					if (arrX.size() == 0) {
						err = true;
					} else {
						if (flip) { // 뒤집어있는 경우
							arrX.pollLast();
						} else {
							arrX.pollFirst();
						}
					}

					break;
				}
			}

			// output
			if (err) {
				sb.append("error");//.append("\n");
			} else {
				if (flip) { // 뒤집어있는 경우
					sb.append("[");

					Iterator<Integer> reverseIterator = arrX.descendingIterator();
					while (reverseIterator.hasNext()) {
						Integer elem = reverseIterator.next();
						sb.append(elem).append(",");
					}
					if (sb.length() > 1) { // , 없애기
						sb.delete(sb.length() - 1, sb.length());
					}
					sb.append("]");//.append("\n");

				} else {
					sb.append("[");
					Iterator<Integer> iterator = arrX.iterator();
					while (iterator.hasNext()) {
						Integer elem = iterator.next();
						sb.append(elem).append(",");
					}

					if (sb.length() > 1) { // , 없애기
						sb.delete(sb.length() - 1, sb.length());
					}
					sb.append("]");//.append("\n");
				}
			}

			System.out.println(sb);
		}
	}
}