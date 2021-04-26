import java.util.*;

class findDiameter {

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

    static int Height(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        int leftHeight = Height(node.left);
        int rightHeight = Height(node.right);

        return (1+Math.max(leftHeight, rightHeight));
    }

    static int Diameter(Node node)
    {
        if(node == null)
        {
            return 0;
        }

        if(node.left == null &&  node.right == null)
        {
            return 1;
        }

        int leftHeight = Height(node.left);
        int rightHeight = Height(node.right);

        int leftDiameter = Diameter(node.left);
        int rightDiameter = Diameter(node.right);

        return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight+rightHeight+1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        Node root = createTree(input);
        System.out.println("Diameter of the tree : "+Diameter(root));
    }
}