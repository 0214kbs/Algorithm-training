import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int overAvg =0;
        int n = sc.nextInt();

        for (int i = 0;i<n;i++){
            int cnt = sc.nextInt();           
            int[] score = new int[cnt];

            for(int j =0;j<cnt;j++){
                score[j] = sc.nextInt();
                sum += score[j];
            }
            double avr = sum/cnt;
            for(int j =0;j<cnt;j++){
                if(avr<score[j]){
                    overAvg ++;
                }
            }
            System.out.println((String.format("%.3f",(float)overAvg/cnt*100)+"%"));
            sum =0;
            overAvg =0;
        }
        
        sc.close();
    }
}
