import java.util.*;

class leftView {

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

    static ArrayList<Integer> viewLeft(Node root) {
        ArrayList<Integer> AL = new ArrayList<>();

        if (root == null) {
            return AL;
        }

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int N = Q.size();
            for (int i = 0; i < N; i++) {
                Node temp = Q.poll();
                if (i == 0)
                    AL.add(temp.data);
                if (temp.left != null)
                    Q.add(temp.left);
                if (temp.right != null)
                    Q.add(temp.right);
            }
        }

        return AL;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        Node root = createTree(input);

        ArrayList<Integer> LV = viewLeft(root);
        System.out.print("Left View of the tree : ");

        for (int i : LV) {
            System.out.print(i + " ");
        }
    }
}