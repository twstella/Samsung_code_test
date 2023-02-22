package samsung_expert;
import java.util.Scanner;
import java.util.StringTokenizer;
public class CodeScan {
    static int[][] hex = {{0,0,0,0},
                          {0,0,0,1},
                          {0,0,1,0},
                          {0,0,1,1},
                          {0,1,0,0},
                          {0,1,0,1},
                          {0,1,1,0},
                          {0,1,1,1},
                          {1,0,0,0},
                          {1,0,0,1},
                          {1,0,1,0},
                          {1,0,1,1},
                          {1,1,0,0},
                          {1,1,0,1},
                          {1,1,1,0},
                          {1,1,1,1}};
    static int[][][] cdTN = new int[5][5][5];
    static int[][] map;
    static int N,M;
    static void makeMap(String[] t,int r){
        for(int i=0;i<M;i++){
            int n = hexToDex(t[i].charAt(0));
            for(int j=0;j<4;j++){
                map[r][i*4+j] = hex[n][j];
            }
        }
    }
    static int isValid(int r){
        int[] cd = new int[8];
        int len =7;
        int res = 0;
        for(int j=M*4-1;j>=0;j--){
            int[] part = {0,0,0};
            if(map[r][j]==1&&map[r-1][j]==0){
                while(map[r][j]==1){part[2]++;j--;}
                while(map[r][j]==0){part[1]++;j--;}
                while(map[r][j]==1){part[0]++;j--;}
                j++;
                int min = Math.min(part[0],Math.min(part[1],part[2]));
                for(int k = 0;k<3;k++){
                    part[k]/=min;
                }
                cd[len--] = cdTN[part[0]][part[1]][part[2]];
                if(len==-1){
                    int sum = 0;
                    int total =0;
                    for(int i=0;i<8;i++){
                        sum+=cd[i];
                        if(i%2==0) total+= 3*cd[i];
                        else total+=cd[i];
                    }
                    if(total%10==0) res+=sum;
                    len = 7;
                }
            }
        }
        return res;
    }
    static int hexToDex(char c){
        if(c>='0'&&c<='9') return c-'0';
        return c -'A'+10;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++)
                    cdTN[i][j][k] = -1;
            }
        }
        cdTN[2][1][1] = 0;
        cdTN[2][2][1] = 1;
        cdTN[1][2][2] = 2;
        cdTN[4][1][1] = 3;
        cdTN[1][3][2] = 4;
        cdTN[2][3][1] = 5;
        cdTN[1][1][4] = 6;
        cdTN[3][1][2] = 7;
        cdTN[2][1][3] = 8;
        cdTN[1][1][2] = 9;
        for(int test_case=1;test_case<=T;test_case++){
            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[N][M*4];
            int ans = 0;
            String code ="";
            for(int i=0;i<N;i++){
                String s = sc.next();
                if(i==0||s.equals(code)){
                    code = s;
                    continue;
                }
                makeMap(code.split(""), i-1);
                makeMap(s.split(""), i);
                ans+=isValid(i);
                code = s;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}
