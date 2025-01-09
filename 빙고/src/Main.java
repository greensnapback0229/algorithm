import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[][] bingo = new boolean[6][6];
    static Coor[] coordinate = new Coor[26];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int result = 100;

        for(int i=1;i<=5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1;j<=5;j++){
                int num = Integer.parseInt(st.nextToken());
                coordinate[num] = new Coor(i,j);
            }
        }

        for(int i=1;i<=5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1;j<=5;j++){
                int num = Integer.parseInt(st.nextToken());
                
                int row = coordinate[num].row;
                int col = coordinate[num].col;

                bingo[row][col] = true;

                // checkBingo();
                // printBingo((i-1)*5 + j);
                if(checkBingo() >= 3 && result == 100){
                    result = (i-1)*5 + j;
                }
            }
        }
        System.out.println(result);
    }

    public static void printBingo(int stage){
        System.out.println("<stage" + stage + ">");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=5;j++){
                System.out.print( (bingo[i][j])?"O ":"X ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int checkBingo(){
        int result = 0;
        
        
        for(int i=1;i<=5;i++){
            int cntRow = 0;
            int cntCol = 0;
            for(int j=1;j<=5;j++){
                if(bingo[i][j] == true) cntCol++;  //가로확인
                if(bingo[j][i] == true) cntRow++;  //세로확인
            }

            if(cntRow == 5) result ++;
            if(cntCol == 5) result ++;
        }

        //대각선 확인
        int cntSlash = 0;
        int cntRevSlash = 0;
        for(int i=1;i<=5;i++){
            if(bingo[i][i]) cntSlash++;         //대각선1
            if(bingo[i][6-i]) cntRevSlash++;    //대각션2 
        }
    
        if(cntSlash == 5) result++;
        if(cntRevSlash == 5) result++;

        return result;
    }

    static class Box{

        public Box(int value){
            this.value = value;
            this.check = false;
        }

        int value; 
        boolean check;
    }

    static class Coor{
        int row;
        int col;

        public Coor(int row, int col){
            this.row = row;
            this.col = col;
        }
        
    }
}

