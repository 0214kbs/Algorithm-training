import java.io.*;
import java.util.*;

public class Main {

    static char[] arr;
    static int[] check;
    static int l, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        check = new int[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);

        br.close();
    }

    public static void dfs(int level, int length) {
        if(length == l) {
            StringBuilder sb = new StringBuilder();
            int vowel = 0;
            int consonant = 0;

            for (int i = 0 ; i < c; i++) {
                if (check[i] == 1) {
                    if (isVowel(arr[i])) {
                        vowel++;
                    } else {
                        consonant++;
                    }

                    sb.append(arr[i]);
                }
            }

            if (vowel >= 1 && consonant >= 2) {
                System.out.println(sb);
            }

        } else {
            for (int i = level; i < c; i++) {
                check[i] = 1;
                dfs(i+1, length+1);
                check[i] = 0;
            }
        }
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

}