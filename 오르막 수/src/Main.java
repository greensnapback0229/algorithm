import java.io.*;

public class Main {

    static int MOD_CONST = 10007;
    static Integer dp[][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        dp = new Integer[N+1][10];

        for(int i=0;i<10;i++) dp[1][i] = 1;

        int sum = 0;
        for(int i=0;i<=9;i++){
            sum += recur(N, i) % MOD_CONST;
        }
        
        System.out.println(sum % MOD_CONST);
    }


    public static int recur(int level, int root){

        int sum = 0;
        if(dp[level][root] != null) return dp[level][root];
        
        for(int i=root;i<10;i++){
            sum = sum + recur(level-1, i) % MOD_CONST;
        }

        dp[level][root] = sum;
        return sum;
    }
}