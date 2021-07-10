import java.util.Scanner;

public class B2675 {
//백준 실행시에는 B2675 대신 Main으로 해야됨

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			int n= sc.nextInt();
			
			for(int i=0;i<n;i++) {

				int num = sc.nextInt();
				String str = sc.next();

				for(int j=0;j<str.length();j++) {
					for(int k=0;k<num;k++) {
						System.out.print(str.charAt(j));
					}
				}
				System.out.println();			
			}		
			sc.close();		
	}

}
