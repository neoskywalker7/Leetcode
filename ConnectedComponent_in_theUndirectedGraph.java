/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        int m = nodes.size();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        
       for (UndirectedGraphNode node : nodes){
            visited.put(node, false);
       }
        
        List<List<Integer>> result = new ArrayList<>();//这个的写法 我了个大曹
        
        for (UndirectedGraphNode node : nodes){
            if (visited.get(node) == false){
                bfs(node, visited, result);
            }
        }
        
        return result;
    }
    
    
    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result){// BFS+queue
        
        List<Integer>row = new ArrayList<>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();//这个的写法 是神马意思啊  左边是队列右边是linkedlist = =
        visited.put(node, true);
        queue.offer(node);
        
        while (!queue.isEmpty()){
            UndirectedGraphNode u = queue.poll();
            row.add(u.label);
            
            for (UndirectedGraphNode v : u.neighbors){
                if (visited.get(v) == false){
                    visited.put(v, true);
                    queue.offer(v);
                }
            }
        }
        
        Collections.sort(row);
        result.add(row);
        
    
    }
}
