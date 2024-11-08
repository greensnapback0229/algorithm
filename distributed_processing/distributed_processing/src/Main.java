import java.io.*;
import java.util.*;

public class Main {

    private static final int CAPAVILITY = 10;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = calculateProcessing(a, b);
            results.add(result);
        }

        for (Integer result : results) {
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static int calculateProcessing(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++) {
            result = (result * a) % CAPAVILITY;
        }

        if(result == 0){
            result = 10;
        }
        
        return result;
    }
}
