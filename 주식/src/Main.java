import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        

        for(int i=0;i<cnt;i++){
            int arrayLength = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] stock = new int[arrayLength];
            for(int j=0;j<arrayLength;j++){
                stock[j] = Integer.parseInt(st.nextToken());                
            }

            bw.write(String.valueOf(calc(stock)) + "\n");
        }

        bw.close();

    }

    private static Long calc(int[] stock){
        int last = 0;
        Node[] nodeList = new Node[stock.length];

        for(int i=0;i<stock.length;i++){
            nodeList[i] = new Node(i, stock[i]);
        }

        Arrays.sort(nodeList, Comparator.comparingInt((Node n ) -> n.stock).reversed());
        long sum = 0;
        
        for(Node node : nodeList){
            int startIndex = 0;

            boolean stop = false;

            if(last != 0){
                startIndex = last;
                if(node.index < last) stop = true;
            }

            if(stop){
                continue;
            }

            last = node.index + 1;
            
            for(int i=startIndex;i<node.index;i++){
                sum += node.stock - stock[i];
                
                if(node.index == stock.length-1){
                    stop = true;
                }
            }

            if(stop) break;
        }
    
        return sum;
    }


    static class Node{
        int index;
        int stock;

        public Node(int index, int stock){
            this.index = index;
            this.stock = stock;
        }
    }
}
