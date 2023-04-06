class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        boolean[] counting = new boolean[2001];
        int N = read();

        while (N-- > 0) {
           counting[read() + 1000] = true;
        }

        for (int i = 0; i <= 2000; i++) {
            if (counting[i]) {
                sb.append(i - 1000).append('\n');
            }
        }

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
