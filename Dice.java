//14499
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;;

public class Dice {
    static int N,M,R,C,K;
    static int[][] map;
    static int[] dice = {0,0,0,0,0,0};
    static void turn_east(){
        int tmp = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[2];
        dice[2] = dice[0];
        dice[0] = tmp;
    }
    static void turn_west(){
        int tmp = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[0];
        dice[0] = tmp;
    }
    static void turn_north(){
        int tmp= dice[4];
        dice[4] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[0];
        dice[0] = tmp;
    }
    static void turn_south(){
       int tmp = dice[1];
       dice[1] = dice[5];
       dice[5] = dice[4];
       dice[4] = dice[0];
       dice[0] = tmp;
    }
    static void print_dice(){
        System.out.println("  "+dice[1]);
        System.out.println(dice[3]+" "+dice[0]+" "+dice[2]);
        System.out.println("  "+dice[4]);
        System.out.println("  "+dice[5]);
        System.out.println("-----------------------------");
    }
    static int[][] go = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<K;i++){
                int d = Integer.parseInt(st.nextToken());
                //System.out.println("r:"+R+",c:"+C);
                if (d==1){
                    R += go[0][0];
                    C += go[0][1];
                    if(R<0||R>=N||C<0||C>=M){
                        C-=1;
                        continue;
                    }
                    turn_east();
                }
                else if(d==2){
                    R += go[2][0];
                    C += go[2][1];
                    if(R<0||R>=N||C<0||C>=M){
                        C+=1;
                        continue;
                    }
                    turn_west();
                }
                else if(d==3){
                    
                    R += go[3][0];
                    C += go[3][1];
                    if(R<0||R>=N||C<0||C>=M){
                        R+=1;
                        continue;
                    }
                    turn_north();
                }
                else if(d==4){
                    
                    R += go[1][0];
                    C += go[1][1];
                    if(R<0||R>=N||C<0||C>=M){
                        R-=1;
                        continue;
                    }
                    turn_south();
                }
                //System.out.println("turn:"+i);
                if(map[R][C]==0){
                    map[R][C] = dice[5];
                }
                else {
                    dice[5] = map[R][C];
                    map[R][C] = 0;
                }
                //print_dice();
                System.out.println(dice[0]);
            }
            

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
