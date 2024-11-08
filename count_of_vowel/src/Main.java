import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        List<String> sentences  = new ArrayList<String>();
        
        String nextSentence = new String();
        while(!nextSentence.equals("#")){
            nextSentence = sc.nextLine();
            sentences.add(nextSentence);
        }

        sentences.remove(sentences.size() - 1);

        int count = 0;
        for(String s : sentences ){
            for(char c : s.toCharArray()){
                if("aeiouAEIOU".indexOf(c) >= 0){
                    count++;         
                }
            }

            System.out.println(count);
            count = 0;
        }

        sc.close();
    }
}