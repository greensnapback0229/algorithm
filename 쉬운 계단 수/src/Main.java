import java.io.*;
import java.util.*;

public class Main {

    static Integer dp[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        dp = new Integer[N+1][10];
        
        for(int i=0;i<=9;i++){
            dp[1][i] = 1;
        }

        int sum = 0;
        for(int i=1;i<=9;i++){
            
            sum = (sum + recur(N, i)) % 1000000000;
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }

    public static int recur(int n, int root){

        if(dp[n][root] != null){
            return dp[n][root];
        }

        if(root == 0) {
            dp[n][root] = recur(n-1, root+1) % 1000000000;
            return dp[n][root];
        }

        else if(root == 9){
            dp[n][root] = recur(n-1, root-1) % 1000000000;
            return dp[n][root];   
        }

        else {
            dp[n][root] = (recur(n-1, root+1) + recur(n-1, root-1))  % 1000000000;
            return dp[n][root];
        }
        
    }
}
