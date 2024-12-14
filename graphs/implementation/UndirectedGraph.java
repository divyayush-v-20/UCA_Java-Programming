import java.util.*;
public class UndirectedGraph{
    //implementation
    HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
    int maxDegree;

    public void addEdge(int u, int v){
        if(!adj.containsKey(u)){
            adj.put(u, new ArrayList<Integer>());
        }
        if(!adj.containsKey(v)){
            adj.put(v, new ArrayList<Integer>());
        }
        adj.get(u).add(v);
        adj.get(v).add(u);
        maxDegree = Math.max(maxDegree, Math.max(adj.get(u).size(), adj.get(v).size()));
    }

    private void DFS(int node, int[] vis){
        vis[node] = 1;
        System.out.print(node + " ");
        for(int i : adj.get(node)){
            if(vis[i] == 0) {
                DFS(i, vis);
            }
        }
    }

    public void DFS(){
        int V = adj.size();
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        System.out.println("depth first search: ");
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                DFS(i, vis);
            }
        }
        System.out.println();
    }

    private void BFS(int cur, int[] vis){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(cur);
        vis[cur] = 1;

        System.out.println("breadth first search: ");
        
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");

            for(int i : adj.get(node)){
                if(vis[i] == 0){
                    q.offer(i);
                    vis[i] = 1;
                }
            }
        }
    }

    public void BFS(){
        int V = adj.size();
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                BFS(i, vis);
            }
        }
        System.out.println();
    }

    public Integer maxDegree(){
        return maxDegree;
    }

    public static void main(String[] args){
        UndirectedGraph g = new UndirectedGraph();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 4);
        g.addEdge(2, 3);
        g.addEdge(0, 5);

        g.DFS();
        g.BFS();

        System.out.print("maximum degree: " + g.maxDegree());
    }
}