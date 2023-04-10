import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BinarySearchTree {
    private Node root;

    public void insertNode(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node cur = root;

            while (true) {
                if (data < cur.data) {
                    if (cur.left == null) {
                        cur.left = newNode;
                        break;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = newNode;
                        break;
                    }
                    cur = cur.right;
                }
            }
        }
    }


    public String getJSONRepresentation() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(this.root);
    }


    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
