class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();
        int[] cards = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            cards[i] = read();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    if (sum > max && sum <= M) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
