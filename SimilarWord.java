//2607
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimilarWord {
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            String t = br.readLine();
            int[] m = new int[26];
            for(int i=0;i<t.length();i++){
                m[t.charAt(i)-'A']+=1;
            }
            int cnt =0;
            for(int i=0;i<N-1;i++){
                String k = br.readLine();
                int[] tmp  = new int[26];
                for(int j=0;j<26;j++)
                    tmp[j]=m[j];
                int same = 0;
                for(int j=0;j<k.length();j++){
                    if(tmp[k.charAt(j)-'A']>0){
                        tmp[k.charAt(j)-'A']--;
                        same++;
                    }
                }
                if(t.length()==k.length()){
                    if(same==t.length()||same==t.length()-1){
                        cnt++;
                    }
                }
                else if(t.length()-1==k.length()&&same==t.length()-1){
                    cnt++;
                }
                else if(t.length()+1==k.length()&&same==t.length()){
                    cnt++;
                }
                else continue;
            }
            System.out.println(cnt);
        }catch(IOException e){

        }
    }
}
