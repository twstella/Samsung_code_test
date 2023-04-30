import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;
public class Identical_Set {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();
            for(int i=0;i<n;i++){
                String str = br.readLine();
                char[] chs = str.toCharArray();
                Arrays.sort(chs);
                String tmp = new String(chs);
                set.add(tmp);
            }
            System.out.println(set.size());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
