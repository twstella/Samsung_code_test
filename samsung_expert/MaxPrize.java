package samsung_expert;
import java.util.Scanner;
public class MaxPrize {
    static int[] quiz;
    static int max;
    static void dfs(int idx,int cnt,int l){
        if(cnt<=0){
            String s = "";
            for(int i:quiz){
                s+=i;
            }
            if(max<Integer.parseInt(s)) max = Integer.parseInt(s);
            return;
        }
        for(int i=idx;i<l-1;i++){
            for(int j=i+1;j<l;j++){
                int tmp = quiz[i];
                quiz[i] = quiz[j];
                quiz[j] = tmp;
                dfs(i,cnt-1,l);
                quiz[j] = quiz[i];
                quiz[i] = tmp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T;
		T=Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String s = sc.nextLine();
            String nums = s.split(" ")[0];
            int cnt = Integer.parseInt(s.split(" ")[1]);
            quiz = new int[nums.length()];
            max = Integer.MIN_VALUE;
            if(cnt>quiz.length) cnt = quiz.length;
            for(int i=0;i<quiz.length;i++){
                quiz[i] = nums.charAt(i)-'0';
            }
            dfs(0,cnt,quiz.length);
            System.out.println("#"+test_case+" "+max);
		}
    }
}
