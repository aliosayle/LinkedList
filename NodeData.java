package linkedlist;

public class NodeData {

   int value;
    
    public NodeData(int v) {
        value = v;
    }

    public int compareTo(NodeData nd) {
        if (value == nd.value)
            return 0;
        if (value < nd.value)
            return -1;
        return 1;    
    }
    
} // end class NodeData

