
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static Integer[] dp;

    int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        dp = new Integer[num+1];
        dp[0] = 0;
        dp[1] = 0;
        

        bw.write(String.valueOf(dp(num)));

        bw.flush();
        br.close();
    }

    public static int dp(int N){
        
        if(dp[N] == null){
            
            if(N % 6 == 0){
                dp[N] =  Math.min(dp(N-1), Math.min(dp(N/3), dp(N/2))) + 1;
            }

            else if(N % 3 == 0){
                dp[N] = Math.min(dp(N/3), dp(N-1)) + 1;
            }        
    
            else if(N % 2 == 0){
                dp[N] = Math.min(dp(N/2), dp(N-1)) + 1;
            }
            
            else{
                dp[N] = dp(N-1) + 1;
            }
        }
        return dp[N];
        
    }
}
