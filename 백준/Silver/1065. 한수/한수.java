import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result=0;
		for(int i=1;i<=n;i++) {
			if(arithmetic_sequence(i)==1) result++;
		}
		System.out.println(result);
		sc.close();
		
	}
	
	public static int[] getDigits(int n){
		int[] digits= new int[3];
		for(int i=0;i<3;i++) {
			digits[i]=n%10;
			n=n/10;
		}
		
	    return digits;

	}
	
	public static int arithmetic_sequence(int n) {
		
		int cnt=0;
		if(n<100) cnt=1;
		else if(n==1000)	cnt=0;
		else {
			int[] digits = getDigits(n);
			if(digits[2]-digits[1]==digits[1]-digits[0])	cnt=1;
		}
		return cnt;
		
	}
}

