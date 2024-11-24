    import java.util.*;
    import java.io.*;

    public class Main {

        static int[] dp = new int[1001];
        public static void main(String[] args) throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            dp[1] = 1;
            dp[2] = 2;

            for(int i =3;i<=n;i++){
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            }

            bw.write(String.valueOf(dp[n]));

            bw.close();
            
        }

    }
