package samsung_expert;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class KthPrefix {
    static int N;
    static ArrayList<String> str;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            N = sc.nextInt();
            String s = sc.next();
            str = new ArrayList<String>();
            for(int i=0;i<s.length();i++){
                str.add(s.substring(i));
            }
            Collections.sort(str);
            if(N>s.length()){
                System.out.println("#"+test_case+" none");
            }
            else{
                System.out.println("#"+test_case+" "+str.get(N-1));
            }
        }
    }
}
