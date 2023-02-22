package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class BinaryCode {
    static String decode(String s){
        switch(s){
            case "0001101": return "0";
            case "0011001": return "1";
            case "0010011": return "2";
            case "0111101": return "3";
            case "0100011": return "4";
            case "0110001": return "5";
            case "0101111": return "6";
            case "0111011": return "7";
            case "0110111": return "8";
            case "0001011": return "9";
            default: return "-";
        }
    }
    static int calc(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if((i+1)%2==0) c+=Integer.parseInt(""+s.charAt(i));
            else c+= 3*Integer.parseInt(""+s.charAt(i));
        }
        return c;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T;
            T=Integer.parseInt(br.readLine());
            

            for(int test_case = 1; test_case <= T; test_case++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                ArrayList<String> code = new ArrayList<String>();
                for(int i=0;i<N;i++){
                    String s = br.readLine();
                    if(s.contains("1")){
                        int idx = s.indexOf("1");
                        for(int j=1;j<=3;j++){
                            String k="";
                            if(idx-j>=0){
                                k = s.substring(idx-j,idx-j+56);
                                String r = "";
                                for(int t = 0;t<8;t++){
                                    r+=decode(k.substring(t*7,t*7+7));
                                }
                                if(!r.contains("-")){
                                    code.add(r);
                                    break;
                                }
                            }
                        }
                    }
                }
                 
                String k =code.get(0);
                if(k.contains("-")){
                    System.out.println("#"+test_case+" 0");
                }
                else{
                    if(calc(k)%10==0){
                        int cnt = 0;
                        for(int j=0;j<k.length();j++){
                            cnt+=Integer.parseInt(""+k.charAt(j));
                        }
                        System.out.println("#"+test_case+" "+cnt);
                    }
                    else System.out.println("#"+test_case+" 0");
                }

            }
            
    }
    catch(IOException e){
        e.printStackTrace();
    }
    }
}
