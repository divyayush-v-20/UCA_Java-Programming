import java.util.*;
public class DirectedGraph{
    //implementation
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    
    public void addEdge(int u, int v){
        if(!adj.containsKey(u)){
            adj.put(u, new ArrayList<>());
        }
        adj.get(u).add(v);
        if(!adj.containsKey(v)){
            adj.put(v, new ArrayList<>());
        }
    }

    private void DFS(int node, HashMap<Integer, Boolean> vis){
        vis.put(node, true);
        System.out.print(node + " ");
        for(int child : adj.get(node)){
            if(!vis.containsKey(child)){
                DFS(child, vis);
            }
        }
    }

    private void BFS(int node, HashMap<Integer, Boolean> vis){
        vis.put(node, true);
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int child : adj.get(cur)){
                if(!vis.containsKey(child)){
                    q.offer(child);
                    vis.put(child, true);
                }
            }
        }
    }

    public void DFS(){
        System.out.println("depth first search: ");
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for(var li : adj.entrySet()){
            Integer node = li.getKey();
            if(!vis.containsKey(node)){
                DFS(node, vis);
            }
        }
        System.out.println();
    }

    public void BFS(){
        System.out.println("breadth first search: ");
        HashMap<Integer, Boolean> vis = new HashMap<>();
        for(var li : adj.entrySet()){
            Integer node = li.getKey();
            if(!vis.containsKey(node)){
                BFS(node, vis);
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        DirectedGraph g = new DirectedGraph();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);

        g.BFS();
        g.DFS();
    }

}