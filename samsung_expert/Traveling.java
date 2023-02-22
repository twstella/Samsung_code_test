package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Arrays;

class Pos{
    int x,y;
    Pos(int r,int c){
        x = r;
        y = c;
    }
}
public class Traveling {
    static int N;
    static Pos work;
    static Pos home;
    static Pos[] cli;
    static int[] visited;
    static int min;
    static int r,c;
    static void dfs(int idx,int cnt,int dis){
        if(idx<0||idx>=N){
            return;
        }
        //System.out.print(idx+"-");
        if(cnt==N-1){
            int rm = dis + Math.abs(cli[idx].x-home.x)+Math.abs(cli[idx].y-home.y);
            if(min>rm) {
                min = rm;
                r = cli[idx].x;
                c = cli[idx].y;
            }
            //System.out.println("dis:"+dis);
            return;
        }
        
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                visited[i] = 1;
                dfs(i,cnt+1,dis+Math.abs(cli[i].x-cli[idx].x)+Math.abs(cli[i].y-cli[idx].y));
                visited[i] = 0;
            }
        }

    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for(int test_case = 1;test_case<=T;test_case++){
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                cli = new Pos[N];
                min = Integer.MAX_VALUE;
                work = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                home = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                for(int i=0;i<N;i++){
                    cli[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                }
                Comparator<Pos> comp = new Comparator<Pos>(){
                    public int compare(Pos a,Pos b){
                        int ta = Math.abs(a.x-work.x) + Math.abs(a.y-work.y);
                        int tb = Math.abs(b.x-work.x)+Math.abs(b.y-work.y);
                        if (ta==tb){
                            int ha = Math.abs(a.x-home.x) + Math.abs(a.y-home.y);
                            int hb = Math.abs(b.x-home.x)+Math.abs(b.y-home.y);
                            return ha-hb;
                        }
                        return ta-tb;
                    }
                };
                Arrays.sort(cli,comp);
                visited = new int[N];
                r=-1;
                c=-1;

                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        visited[j]=0;
                    }
                    visited[i] =1;
                    dfs(i,0,Math.abs(work.x-cli[i].x)+Math.abs(work.y-cli[i].y));
                    //System.out.println("min:"+min);
                }
                System.out.println("#"+test_case+" "+min);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
