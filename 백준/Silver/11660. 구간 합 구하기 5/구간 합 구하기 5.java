//package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] accu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		accu = new int[N + 1][N + 1];
		for (int j = 1; j <= N; j++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				accu[j][i] = Integer.parseInt(st.nextToken()) + accu[j][i - 1];
			}
		}
		// N개의 입력을 처리
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int fromx = Integer.parseInt(st.nextToken());
			int fromy = Integer.parseInt(st.nextToken());
			int tox = Integer.parseInt(st.nextToken());
			int toy = Integer.parseInt(st.nextToken());

			int sum = 0;

			for (int j = fromx; j <= tox; j++) {
				sum += (accu[j][toy] - accu[j][fromy - 1]);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
