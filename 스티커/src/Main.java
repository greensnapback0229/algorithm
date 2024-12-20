import java.io.*;
import java.util.*;


public class Main {

    static Integer[][][] data;
    static Integer[][][] dp;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Integer T = Integer.parseInt(br.readLine());

        data = new Integer[T][][];
        dp = new Integer[T][][];
        for(int i=0;i<T;i++){
            Integer N = Integer.parseInt(br.readLine());
            data[i] = new Integer[3][N+1];
            dp[i] = new Integer[3][N+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                
                int num = Integer.parseInt(st.nextToken());
                data[i][1][j] = num;
            }

            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                
                int num = Integer.parseInt(st.nextToken());
                data[i][2][j] = num;
            }
        }

        List<Integer> resultList = new ArrayList();
        for(int i=0;i<T;i++){
            
            int result1 = recur(i, 1, 1);
            int result2 = recur(i, 2, 1);

            int result = (result1 > result2) ? result1 : result2;
            resultList.add(result);
            //System.out.println(result);
        }

        for(Integer result : resultList ){
            bw.write(String.format("%d\n", result));
        }
        
        bw.close();

    }

    public static Integer recur(int T, int line, int index){
        //System.out.printf("%d %d %d %d ", T, line, index, data[T][line].length-1);
        //System.out.println(data[T][line][index]);
        int result1, result2, result;
        
        //값이 있으면 그냥 반환
        if(dp[T][line][index] != null) {
            return dp[T][line][index];
        }

        //마지막이면 그냥 반환
        if(index ==  data[T][line].length-1){
            return data[T][line][index];
        }


        if(index == data[T][line].length-2){
            if(line == 1){
                result = recur(T, line+1, index + 1);
            }
            
            else {
                result = recur(T, line-1, index + 1);
            }

            dp[T][line][index] = data[T][line][index] + result;

            return dp[T][line][index];
        }

        //라인 1, 2일때 각각 다르게 처리
        if(line == 1){
            result1 = recur(T, line+1, index + 1);
            result2 = recur(T, line+1, index + 2);
        }

        else{
            result1 = recur(T, line-1, index + 1);
            result2 = recur(T, line-1, index + 2);
        }
        
        result = (result1 > result2) ? result1 : result2;       //둘 중에 더 큰 수
        dp[T][line][index] = data[T][line][index] + result;         //더 큰수 + 현재 index의 값
        return dp[T][line][index];
    }
}