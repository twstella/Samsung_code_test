package samsung_expert;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Box{
    int r,c;
    Box(int x,int y){
        r = x;
        c = y;
    }
}
public class Matrix {
    static int N ;
    static int[][] map;
    static ArrayList<Box> bx ;
    static void findMatrix(int r,int c){
        int w =0;
        int h = 0;
        for(int i=r;i<N;i++){
            if(map[i][c]==0){
                h = i-r;
                break;
            }
        }
        for(int j=c;j<N;j++){
            if(map[r][j]==0){
                w = j-c;
                break;
            }
        }
        bx.add(new Box(h,w));
        for(int i=r;i<r+h;i++){
            for(int j=c;j<c+w;j++){
                map[i][j] = 0;
            }
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test=1;test<=T;test++){
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                bx = new ArrayList<Box>();
                for(int i=0;i<N;i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=0;j<N;j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(map[i][j]!=0){
                            findMatrix(i, j);
                        }
                    }
                }
                Comparator<Box> comp = new Comparator<Box>(){
                    public int compare(Box b1,Box b2){
                        int r = b1.r*b1.c-b2.r*b2.c;
                        if(r == 0) return b1.r-b2.r;
                        else return r;
                    }
                };
                Collections.sort(bx,comp);
                String re = "";
                for(Box b:bx){
                    re+=" "+b.r+" "+b.c;
                }
                System.out.println("#"+test+" "+bx.size()+re);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
