package samsung_expert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Iterator;


public class KthSubString {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test_case = 1;test_case<=T;test_case++){
                int N = Integer.parseInt(br.readLine());
                String s = br.readLine();
                TreeSet<String> str = new TreeSet<String>();
                for(int i=0;i<s.length();i++){
                    for(int j=i+1;j<=s.length();j++){
                        String k = s.substring(i,j);
                        str.add(k);
                            
                    }
                } 
                if(N>str.size()){
                    System.out.println("#"+test_case+" none");
                }
                else{
                    int cnt =0;
                    Iterator<String> it = str.iterator();
                    while(it.hasNext()){
                        cnt++;
                        if(cnt==N){
                            System.out.println("#"+test_case+" "+it.next());
                            break;
                        }
                        else{
                            it.next();
                        }
                        
                    }
                    
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
