import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());
        String[] fileNames = new String[line+1];
        
        for(int i=1;i<=line;i++){
            fileNames[i] = br.readLine();
        }

        int fileLength = fileNames[1].length();`
        String firstFile = fileNames[1];
        StringBuilder command = new StringBuilder(firstFile);


        for(int i=1;i<=line;i++){
            for(int j=0;j<fileLength;j++){
                if(fileNames[i].charAt(j) != firstFile.charAt(j)){
                    command.setCharAt(j, '?');
                }
            }
        }

        System.out.println(command);
    }
}