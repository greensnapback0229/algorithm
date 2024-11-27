import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static Integer[] dp = new Integer[11];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int T[] = new int[N];


        for(int i=0;i<N;i++){
            T[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int n=0;n<N;n++){
            for(int i=4;i<=T[n];i++){
                if(dp[i] == null){
                    dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
                }
            }
            bw.write(String.format("%d\n", dp[T[n]]));
        }
        
        bw.close();
        
    }
}
