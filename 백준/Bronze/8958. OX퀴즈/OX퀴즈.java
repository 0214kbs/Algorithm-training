import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String test;
        int score=0;int cnt=0;
        for(int i=0;i<n;i++){
        	test=sc.next();
        	char[] testArr = test.toCharArray();
        	for(int j=0;j<testArr.length;j++) {
        		if(testArr[j]=='O') {
        			cnt++;
        		}else cnt=0;
        		score=cnt+score;
        	}
        	System.out.println(score);
        	score=0; cnt=0;
        }
        
        }
    }