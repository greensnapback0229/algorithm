import java.util.*;
import java.io.*;

/**
 * 
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String ballString = br.readLine();
        char[] balls = new char[N];
        
        int R = 0, B = 0;
        for(int i=0;i<N;i++){
            balls[i] = ballString.charAt(i);
            if(balls[i] == 'B') B++;
            if(balls[i] == 'R') R++;
        }

        int i =0;
        int r1=0, r2=0, cnt=0;

        while(i < N && (balls[0] == balls[i])){    //left
            cnt++;
            i++;
        }

        if( balls[0] == 'B') {
            r1 = B - cnt;
            if(r1 > R) r1 =R;
            
        }
        else{
            r1 = R - cnt;
            if(r1 > B) r1 =B;
        }

        i = N-1;
        cnt = 0;
        
        while(i > 0 && (balls[N-1] == balls[i])){  //right
            cnt++;
            i--;
        }

        if( balls[N-1] == 'B') {
            r2 = B - cnt;
            if(r2 > R) r2 =R;
        }
        else{
            r2 = R - cnt;
            if(r2 > B) r2 =B;
        }
        // System.out.printf("%d %d ", r1, r2);
        System.out.println(Math.min(r1,r2));
    }
}

