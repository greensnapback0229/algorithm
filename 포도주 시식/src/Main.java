import java.util.*;
import java.io.*;


public class Main {

    static Integer[] wine;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        wine = new Integer[N+1];
        dp = new Integer[N+1];
        for(int i=1;i<=N;i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            System.out.println(wine[1]);
            return;
        }
        dp[0] = 0;
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        
        for(int i=3;i<=N;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+wine[i],dp[i-3]+wine[i]+wine[i-1]));
        }

        System.out.println(dp[N]);
    }
}
 