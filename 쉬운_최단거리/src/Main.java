import java.util.*;
import java.io.*;


public class Main {
    static int[][] map, dis;
    static boolean[][] visited;
    static Queue<Integer[]> queue = new LinkedList<Integer[]>();
    static int M, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        dis = new int[N][M];
        visited = new boolean[N][M];
        int gM=0, gN=0;


        for(int i=0;i<N;i++){
            StringTokenizer lineSt = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(lineSt.nextToken());
                dis[i][j] = -1;
                if(map[i][j] == 2){
                    gN = i;
                    gM = j;
                }
                else if(map[i][j] == 0){
                    dis[i][j] = 0;
                }
            }
        }
        
        visited[gN][gM] = true;
        bfs(gN, gM);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                bw.write(dis[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }


    public static void bfs(int startN, int startM) {
        Integer[] start = {startN, startM, 0};
        queue.add(start);

        while(!queue.isEmpty()){
            Integer[] node = queue.poll();

            int n = node[0];
            int m = node[1];
            int cnt = node[2];

            if(map[n][m] == 0){    
                visited[n][m] = true;
                continue;
            }

            dis[n][m] = cnt;
            
            if(m+1 < M && !visited[n][m+1]){
                queue.add(new Integer[]{n,m+1,cnt+1});
                visited[n][m+1] = true;
            }
            if(m-1 >= 0 && !visited[n][m-1]){
                queue.add(new Integer[]{n, m-1, cnt+1}); 
                visited[n][m-1] = true;
            }
            if(n+1 < N && !visited[n+1][m]){
                queue.add(new Integer[]{n+1, m, cnt+1}); 
                visited[n+1][m] = true;
            }
            if(n-1 >= 0 && !visited[n-1][m]){
                queue.add(new Integer[]{n-1, m ,cnt+1});
                visited[n-1][m] = true;
            }
        }
    }
}