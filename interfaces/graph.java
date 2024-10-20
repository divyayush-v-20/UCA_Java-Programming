import java.util.*;
interface UAG{
    void addEdge(int u, int v);
    void bfs(int startNode);
    // void dfs(int startNode);
}
class G1 implements UAG{
    HashMap<Integer, List<Integer>> adj;
    int V;
    public G1(int N){
        adj = new HashMap<>();
        V = N;
    }
    public void addEdge(int u, int v){
        adj.putIfAbsent(u, new LinkedList<>());
        adj.putIfAbsent(v, new LinkedList<>());

        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public void bfsHelper(int startNode, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        vis[startNode] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int nxt : adj.get(cur)){
                if(vis[nxt] != 1){
                    q.offer(nxt);
                    vis[nxt] = 1;
                }
            }

            System.out.print(cur + " ");
        }
    }
    public void bfs(int startNode){
        int[] vis = new int[V + 1];
        for(int i = 0; i < V; i++){
            if(vis[i] != 1){
                bfsHelper(i, vis);
            }
        }
    }
}
public class graph{
    public static void main(String[] args){
        G1 g = new G1(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);
        g.addEdge(1, 3);

        g.bfs(0);
    }
}