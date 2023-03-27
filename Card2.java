//2164
import java.util.Scanner;


public class Card2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q= new int[2*n+1];
        int frnt=0,bck = 0;
        for(int i=0;i<n;i++){
            q[bck++]=i+1;
        }
        while(bck-frnt>1){
            frnt++;
            int t = q[frnt++];
            q[bck++]=t;
        }
        System.out.println(q[frnt]);

        
    }
}