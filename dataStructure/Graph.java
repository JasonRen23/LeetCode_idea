package LeetCode_idea.dataStructure;

public class Graph {
    int V, E;
    Edge edge[];

    class Edge{
        int src, dest;
    };

    Graph(int v, int e){
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i = 0; i < e; ++i){
            edge[i] = new Edge();
        }
    }

    // find root and make root as parent of i (path compression)
    int find(int parent[], int i){
        if(parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }


    void Union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset= find(parent, y);
        parent[xset] = yset;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void UnionByRank(int parent[], int rank[], int x, int y){
        int rootx = find(parent, x);
        int rooty = find(parent, y);
        if(rootx != rooty){
            if(rank[rootx] > rank[rooty]){
                parent[rooty] = rootx;
            }else if(rank[rootx] < rank[rooty]){
                parent[rootx] = rooty;
            }else{
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }

        }
    }

    int isCycle(Graph graph){
        int parent[] = new int[graph.V];
        int rank[] = new int[graph.V];

        for(int i = 0; i < parent.length; ++i){
            parent[i] = -1;
            rank[i] = 0;
        }

        for(int i = 0; i < graph.E; ++i){
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);

            if(x == y){
                return 1;
            }

            graph.UnionByRank(parent, rank, x, y);
        }
        return 0;
    }

    //Driver Method
    public static void main(String[] args) {
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;


        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if(graph.isCycle(graph) == 1){
            System.out.println("graph contains cycle");
        }else{
            System.out.println("graph doesn't contain cycle");
        }



    }
}
