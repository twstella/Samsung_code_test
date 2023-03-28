//9935
import java.util.Scanner;


public class Explosion {
    static String str,exp;
    static boolean match(char[] s,int p){
        int ll = exp.length();
        int strt = p-ll+1;
        if(strt<0) return false;
        for(int i=0;i<ll-1;i++){
            if(exp.charAt(i)!=s[strt+i]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        exp = sc.next();
        sc.close();
        char[] st = new char[str.length()+1];
        int p =0;
        int len = str.length();
        int end = exp.charAt(exp.length()-1);
        for(int i=0;i<len;i++){
            if(str.charAt(i)!=end) st[p++]=str.charAt(i);
            else if (match(st,p)==false) st[p++]=str.charAt(i);
            else p = p-exp.length()+1;
        }
        st[p]=0;
        if(p==0) System.out.println("FRULA");
        else{
            StringBuilder rslt = new StringBuilder();
            for(int i=0;i<p;i++){
                rslt.append(st[i]);
            }
            System.out.println(rslt.toString());
        }
        
    }
    
}
