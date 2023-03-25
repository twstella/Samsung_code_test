//13565
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;


public class Soak {
    static int N,M;
    static int[][] visited;
    static int[][] que;
    static int[][] map;
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    static boolean valid(int r,int c){
        if(r<0||r>=N||c<0||c>=M) return false;
        return true;
    }
    static String check(){
        for(int i=0;i<N;i++){
            if(visited[0][i]==0&&map[0][i]==0){
                if(bfs(0,i)==true) return "YES";
            }
        }
        return "NO";
    }
    static boolean bfs(int r,int c){
        int frnt=0;
        int rr=0;
        que = new int[2000000][2];
        que[rr][0]=r;
        que[rr++][1]=c;
        visited[r][c]=1;
        while(frnt!=rr){
            int er=que[frnt][0];
            int ec =que[frnt++][1];
            //System.out.println(e.r+","+e.c);
            if(er==N-1) return true;
            for(int i=0;i<4;i++){
                int nr = er+dir[i][0];
                int nc = ec+dir[i][1];
                if(valid(nr,nc)==false) continue;
                if(visited[nr][nc]==0&&map[nr][nc]==0){
                    visited[nr][nc]=1;
                    que[rr][0]=nr;
                    que[rr++][1]=nc;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            visited=new int[N][M];
            map =new int[N][M];
            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = s.charAt(j)-'0';
                }
            }
            System.out.println(check());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
