import java.util.*;

class checkChildValue {

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

    static int checkSum(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        int Left = node.left!=null ? node.left.data : 0;
        int Right = node.right!=null ? node.right.data : 0;

        if((Left+Right) != node.data)
        {
            return 0;
        }

        checkSum(node.left);
        checkSum(node.right);

        return 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        Node root = createTree(input);
        System.out.println(checkSum(root));
    }
}