class Main {
	
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		arr = new int[3];
		
		for (int i = 0; i < 3; i++) {
			arr[i] = read();
		}
		
		mergeSort();
		System.out.println(arr[1]);
	}
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
	
	private static void mergeSort() {
		sort(0, 3);
	}
	
	private static void sort(int low, int high) {
		if (high - low < 2) {
			return;
		}
		
		int mid = (low + high) / 2;
		sort(0, mid);
		sort(mid, high);
		merge(low, mid, high);
	}
	
	private static void merge(int low, int mid, int high) {
		int[] temp = new int[high - low];
		int t = 0, l = low, h = mid;
		
		while (l < mid && h < high) {
			if (arr[l] < arr[h]) {
				temp[t++] = arr[l++];
				
			} else {
				temp[t++] = arr[h++];
			}
		}
		
		while (l < mid) {
			temp[t++] = arr[l++];
		}
		
		while (h < high) {
			temp[t++] = arr[h++];
		}
		
		for (int i = low; i < high; i++) {
			arr[i] = temp[i - low];
		}
	}
}
