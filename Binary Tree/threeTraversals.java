import java.util.*;

class threeTraversals
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

    // static Node root = null;

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
            if(i >= inp.length)
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

    static void inOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
            
    }

    static void preOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
            
    }

    static void postOrderTraversal(Node root)
    {
        if(root == null)
        {
            return;
        }
        else
        {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
            
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        Node root = createTree(input);

        System.out.print("InOrder Traversal: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        postOrderTraversal(root);
        System.out.println();
        
        System.out.print("PreOrder Traversal: ");
        preOrderTraversal(root);
    }
}