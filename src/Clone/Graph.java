package Clone;


public class Graph {

    //No of vertices;
    int V;
    Node[] nodes;

    public Graph(int V){
        this.V = V;
        nodes = new Node[V];

       for(int i = 0;i<V;i++){
           nodes[i].value = i;
       }
    }

    public void addEdge(int start,int end){
        nodes[start].children.add(end);
    }

    public Node clone(Node root){
        Node newNode = new Node(root.value);
        for(Integer integer : root.children){
            newNode.children.add(integer);
        }


        return null;

    }
}

