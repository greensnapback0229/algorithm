import java.util.*;
import java.io.*;


/**
 * 단순 구현 문제인듯
 * gridy로 해결 가능한듯.
 * 규칙에 따라서 지붕선을 따라 갈때 현재의 높이보다 높은 기둥을 만날때까지 오른쪽으로 평행이동 
 * 현재 위치에서 다음으로 높은 기둥을 찾는 방법이 필요해보임
 * 기둥을 높이별로 정렬하고 현재 위치를 반영해서 다음으로 높은 기둥을 찾는 메서드를 작성?
 * visited로 방문했을 경우에 안찾아도 될듯함
 * 
 * 
 * 
 * 높은 기둥의 높이 
 * 1000개까지의 주어지므로 
 */
public class Main {

    static boolean[] visited;
    static int[][] columns;
    static int y = 0;
    static int x = 0;
    static int N;
    static int highest = 0, highestX=0, highestIndex = 0;

    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N =Integer.parseInt(br.readLine());

        columns = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            columns[i][0] = Integer.parseInt(st.nextToken());
            columns[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(columns, Comparator.comparingInt(arr -> arr[0]));

        for(int i=0;i<N;i++){
            if(columns[i][1] >= highest){
                highest = columns[i][1];
                highestIndex = i;
            }
        }
        
        int i = 0;
        x = columns[i][0];
        y = columns[i][1];
        
        int sum = 0;
        while(true){
            if(i < highestIndex){
                i = findNextHighestLeft(i);
                int nX = columns[i][0];
                int nY = columns[i][1];
                sum += (nX - x) * y;
                
                x = nX;
                y = nY;
            }
            
            else if (i >= highestIndex){
                i = findNextHighestRight(i);
                int nX = columns[i][0];
                int nY = columns[i][1];
                sum += (nX - x) * nY;
                
                x = nX;
                y = nY;
            }
            
            if(i == highestIndex ){
                sum += highest;
            }

            if(i == N-1) break;
        }
        System.out.println(sum);
    }

    public static int findNextHighestRight(int index) {
        int max = 0;
        int resultIndex = N-1;

        //왼쪽
        for(int i=index+1;i<N;i++){
            if(max <= columns[i][1]){
                max = columns[i][1];
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    public static int findNextHighestLeft(int index) {
        int currentHeight = columns[index][1];

        //왼쪽
        for(int i=index+1;i<N;i++){
            if(currentHeight <= columns[i][1]){
                return i;
            }
        }
        return 0;
    }
}