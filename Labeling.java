//2667
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
 
class House{
    int r;
    int c;
    House(int x,int y){
        r=x;
        c = y;
    }
}

public class Labeling {
    static int N;
    static int[][] visited;
    static ArrayList<House> que;
    static int[][] map;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static boolean valid(int r,int c){
        if(r<0||r>=N||c<0||c>=N) return false;
        return true;
    }
    static void check(){
        ArrayList<Integer> p = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==0&&map[i][j]==0){
                    int t =bfs(i,j);
                        p.add(t);
                }
            }
        }
        System.out.println(p.size());
        Collections.sort(p);
        for(int k:p){
            System.out.println(k);
        }
    }
    static int bfs(int r,int c){
        int cnt=0;
        que =new ArrayList<House>();
        que.add(new House(r,c));
        visited[r][c]=1;
        while(!que.isEmpty()){
            House e = que.remove(0);
            //System.out.println(e.r+","+e.c);
            //if(visited[e.r][e.c]!=0) continue;
            cnt++;
            for(int i=0;i<4;i++){
                int nr = e.r+dir[i][0];
                int nc = e.c+dir[i][1];
                if(valid(nr,nc)==false) continue;
                if(visited[nr][nc]==0&&map[nr][nc]==0){
                    visited[nr][nc]=1;
                    que.add(new House(nr,nc));
                    //cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            visited=new int[N][N];
            map =new int[N][N];
            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<N;j++){
                    map[i][j] = s.charAt(j)-'1';
                }
            }
            check();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
