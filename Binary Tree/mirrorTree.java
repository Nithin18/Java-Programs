import java.util.*;

class mirrorTree {

    static class Node {
        int data;
        Node left, right;

        Node(int D) {
            data = D;
            left = null;
            right = null;
        }
    }

    static Node createTree(String input) {
        String[] inp = input.split(" ");
        Node root = new Node(Integer.parseInt(inp[0]));

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int i = 1;

        while (Q.size() > 0 && i < inp.length) {
            Node curNode = Q.peek();
            Q.remove();

            String currVal = inp[i];

            if (!currVal.equals("N")) {
                curNode.left = new Node(Integer.parseInt(currVal));
                Q.add(curNode.left);
            }
            i++;

            if (i >= inp.length)
                break;

            currVal = inp[i];
            if (!currVal.equals("N")) {
                curNode.right = new Node(Integer.parseInt(currVal));
                Q.add(curNode.right);
            }

            i++;
        }

        return root;
    }

    static Node Mirror(Node node) {
        if (node == null) {
            return node;
        }

        Node left = Mirror(node.left);
        Node right = Mirror(node.right);

        node.left = right;
        node.right = left;

        return node;

    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        Node root = createTree(input);
        Mirror(root);
        inOrder(root);
    }
}