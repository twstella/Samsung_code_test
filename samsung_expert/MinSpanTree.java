package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Edge{
    int n1,n2;
    double d;
    Edge(int r,int c,double k){
        n1=r;
        n2 = c;
        d = k;
    }
}
public class MinSpanTree {
    static int N;
    static int[] grp;
    static int cnt;
    static double E;
    static ArrayList<Edge> road;
    static double span(){
        double res = 0;
        for(int i=0;i<N-1;i++){
            Edge e = road.remove(0);
            //cycle check;
            if(grp[e.n1]!=-1&&grp[e.n1]==grp[e.n2]) {i--;continue;}
            else{
                if(grp[e.n1]!=-1){
                    //union
                    if(grp[e.n2]!=-1){
                        int g = grp[e.n2];
                        for(int j=0;j<N;j++){
                            if (grp[j]==g){
                                grp[j]=grp[e.n1];
                            }
                        }
                    }
                    else{
                        grp[e.n2] = grp[e.n1];
                    }
                }
                else{
                    if(grp[e.n2]!=-1){
                        grp[e.n1] = grp[e.n2];
                    }
                    else{//new group
                        grp[e.n1] = cnt;
                        grp[e.n2] = cnt;
                        cnt++;
                    }
                }
                //System.out.println("("+e.n1+","+e.n2+")");
                res+=E * Math.pow(e.d,2);
            }
        }
        return res;
    }

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test_case=1;test_case<=T;test_case++){
                N = Integer.parseInt(br.readLine());
                grp = new int[N];
                cnt = 0;
                int[] x = new int[N];
                int[] y = new int[N];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    x[i] = Integer.parseInt(st.nextToken());
                    grp[i] = -1;
                }
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    y[j] = Integer.parseInt(st.nextToken()); 
                }
                E = Double.parseDouble(br.readLine());
                road = new ArrayList<Edge>();
                for(int i=0;i<N;i++){
                    for(int j=i+1;j<N;j++){
                        double k = Math.sqrt(Math.pow(x[i]-x[j],2)+Math.pow(y[i]-y[j],2));
                        road.add(new Edge(i,j,k));
                    }
                }
                Comparator<Edge> comp = new Comparator<Edge>(){
                    public int compare(Edge a,Edge b){
                        if(a.d>b.d) return 1;
                        else if(a.d==b.d){
                            return a.n1-b.n1;
                        }
                        else return -1;
                    }
                };
                Collections.sort(road,comp);
                double res = span();
                System.out.println("#"+test_case+" "+Math.round(res));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
