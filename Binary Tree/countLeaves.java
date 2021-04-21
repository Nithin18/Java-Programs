import java.util.*;

class countLeaves
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

    static int countTheLeaves(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        else
        {
            return (countTheLeaves(root.left)+countTheLeaves(root.right));
        }
        

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Node root = createTree(input);
        System.out.println("No. of Leaves in the tree: "+ countTheLeaves(root));
    }
}