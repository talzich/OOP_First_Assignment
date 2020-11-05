package ex0;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class implements the node_data interface and represents a single
 * node in an unweighted undirected graph.
 * Each node holds a list of its adjacent nodes.
 * @author tal.zichlinsky
 */
public class Node implements node_data {

    private static int serialNumber = 0;
    private int key =0;
    private HashMap<Integer, node_data> nei;
    private String info = "";
    private int tag = 0;


    /**
     * Gives new node it's unique key and initializes it's set of neighbours.
     */
    public Node(){
        key = serialNumber++;
        nei = new HashMap<>();
    }

//    /**
//     * Copy constructor
//     * @param other
//     */
//    public Node(Node other) {
//        this.key = other.key;
//        this.info = other.info;
//        this.tag = other.tag;
//    }

    /**
     * Implements node_data
     * @return This node's key
     */
    @Override
    public int getKey() {
        return this.key;
    }

    /**
     * Implements node_data
     * @return A collection representation of all nodes adjacent to this node
     */
    @Override
    public Collection<node_data> getNi() {
        return nei.values();
    }

    /**
     * Implements node_data
     * @param key
     * @return True iff a node with a key ,identical to the given parameter, is adjacent to this node.
     */
    @Override
    public boolean hasNi(int key) {
        //if(key > nei.size()) return false;
        return (nei.get(key) != null);
    }

    /**
     * Adds node t to this node's neighbours set.
     * @param t
     */
    @Override
    public void addNi(node_data t) {
        if (this == t || t == null) return;
        this.nei.put(t.getKey(), t);
    }

    /**
     * Removes node from this node's neighbours set.
     * @param node
     */
    @Override
    public void removeNode(node_data node) {
        if(node == null) return;
        this.nei.remove(node.getKey());
    }

    /**
     *
     * @return The info for this graph as provided in the setInfo method.
     */
    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        info = s;
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setTag(int t) {
        tag = t;
    }

    public String toString(){
        String data = "Key: " + key + "\nTag: " + tag + "\nInfo: " +info;
        return data;
    }



}