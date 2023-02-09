//package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] sour;
	static int[] bitt;
	static int min;
	static boolean[] select;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitt = new int[N];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			sour[i] = Integer.parseInt(st.nextToken());
			bitt[i] = Integer.parseInt(st.nextToken());
		}
		min = Math.abs(sour[0] - bitt[0]);
		func1(0);
		System.out.println(min);
	}

	static void func1(int srcIdx) {

		// 기저조건
		if (srcIdx == N) {
			int cal_sour = 1;
			int cal_bitt = 0;
			int falseN = 0;
			for (int i = 0; i < select.length; i++) {
				if (select[i]) {
					cal_sour *= sour[i];
					cal_bitt += bitt[i];
				} else
					falseN++;
			}
			if (falseN != N)
				min = Math.min(min, Math.abs(cal_sour - cal_bitt));
			return;
		}

		select[srcIdx] = true;
		func1(srcIdx + 1);
		select[srcIdx] = false;
		func1(srcIdx + 1);

	}
}
