import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] nums = new int[str.length()];
		for(int i=0;i<str.length();i++) {
			nums[i] = Integer.parseInt(str.substring(i, i+1));
		}
		Arrays.sort(nums);
		
		for(int i=str.length()-1;i>=0;i--) {
			System.out.print(nums[i]);
		}
	}
}