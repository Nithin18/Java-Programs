import java.util.*;

class heightTree
{
    static class Node{
        int data;
        Node left,right;
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static Node createTree(String input)
    {
        String[] inp = input.split(" ");
        Node root = new Node(Integer.parseInt(inp[0]));
        
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);

        int i=1;
        while(Q.size()>0 && i<inp.length)
        {
            Node currNode = Q.peek();
            Q.remove();

            String currVal = inp[i];
            if(!currVal.equals("N"))
            {
                currNode.left = new Node(Integer.parseInt(currVal));
                Q.add(currNode.left);
            }

            i++;
            if(i>=inp.length)
                break;
            
            currVal = inp[i];
            if(!currVal.equals("N"))
            {
                currNode.right = new Node(Integer.parseInt(currVal));
                Q.add(currNode.right);
            }

            i++;

        }

        return root;
    }

    static int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        
        return 1+Math.max(height(root.left), height(root.right));

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Node root = createTree(input);
        System.out.println("Height of the tree: "+ height(root));
    }
}