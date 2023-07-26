import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int score;
        int sum=0;
        for(int i=0;i<5;i++){
            score=sc.nextInt();
            if(score<40)    score=40;
            sum+=score;
        }
        System.out.println(sum/5);
        sc.close();
    }
}