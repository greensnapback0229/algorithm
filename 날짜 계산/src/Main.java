import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cntE=1, cntS=1, cntM = 1, cnt=1;

        while(E != cntE || S != cntS || M != cntM){
            cntE++;
            cntS++;
            cntM++;

            if(cntE == 16) cntE = 1;
            if(cntS == 29) cntS = 1;
            if(cntM == 20) cntM = 1;

            cnt++;

        }

        System.out.println(cnt);


    }
}
