import java.io.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        for (int i=0;i<n;i++){
            String input = bf.readLine();
            String[] tmp = input.split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            bw.write(a+b+"\n");
            
        }
        bw.flush();
        bw.close();
    }
}