class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		
		
		int left = 0;
		int right = N - 1;
		int answer1 = 0;
		int answer2 = 0;
		int min = Integer.MAX_VALUE;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (min > Math.abs(sum)) {
				min = Math.abs(sum);
				answer1 = left;
				answer2 = right;
			}
			
			if (sum >= 0) {
				right--;
				
			} else {
				left++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[answer1]).append(' ').append(arr[answer2]);
		
		System.out.print(sb);
	}
	
	private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        
        if (isNegative) {
        	n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return isNegative ? ~n + 1 : n;
    }
}
