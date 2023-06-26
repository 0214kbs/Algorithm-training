import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum=0, cnt=0;
		int c =sc.nextInt();
		for(int i=0;i<c;i++) {
			int n = sc.nextInt();
			int[] score= new int[n];
			for(int j=0;j<n;j++) {
				score[j]=sc.nextInt();
				sum+=score[j];
			}
			double avr = sum/n;		
			for(int j=0;j<n;j++) {
				if(score[j]>avr)cnt++;
			}
			System.out.print(String.format("%.3f",(float)cnt/n*100));
			System.out.println("%");
			cnt=0;sum=0;
		}
		
		sc.close();
	}

}
