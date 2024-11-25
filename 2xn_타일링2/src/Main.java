
import java.io.*;
import java.util.*;
public class Main {

    static int dp[] = new int[1001];
    static int accSum[] = new int[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        dp[1] = 1;
        dp[2] = 3;

        accSum[1] = 1;
        accSum[2] = 4;

        for(int i =3;i<=N;i++){
            if(i%2 == 1){
                dp[i] = accSum[i-1] + 1;
            }

            else{
                dp[i] = accSum[i-1] + 2;
            }

            accSum[i] = (accSum[i-1] + dp[i]) % 10007;
        }

        System.out.println(dp[N]);
        
    }
}