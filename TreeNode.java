// TODO:
// inorder
// cheap insert, remove?


public class TreeNode<T>
{
    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    // constructors
    public TreeNode(T newElement)
    {
        this.element = newElement;
    }

    // getters
    public T getElement()
    {
        return element;
    }

    public TreeNode<T> getLeft()
    {
        return left;
    }

    public TreeNode<T> getRight()
    {
        return right;
    }

    // setters
    public void setLeft(TreeNode<T> newNode)
    {
        left = newNode;
    }

    public void setRight(TreeNode<T> newNode)
    {
        right = newNode;
    }

    // other methods
    public String preorder()
    {
        if (this.left == null && this.right == null)
        {
            return this.getElement().toString(); //Self
        }
        else if (this.left == null && this.right != null)
        {
            return this.getElement().toString() + " "   // Self
            + this.getRight().preorder();       // Right
        }
        else if (this.left != null && this.right == null)
        {
            return this.getElement().toString() + " "   // Self
            + this.getLeft().preorder();     // Left
        }
        else
        {
            return this.getElement().toString() + " "   // Self
            + this.getLeft().preorder() + " "     // Left
            + this.getRight().preorder();       // Right
        }
       
        
    }

    public String postorder()   // O(n)
    {
        if (this.left == null && this.right == null)
        {
            return this.getElement().toString(); // Self
        }
        else if (this.left == null && this.right != null)
        {
            return this.getRight().postorder() + " "   // Right
            + this.getElement().toString();       // Self
        }
        else if (this.left != null && this.right == null)
        {
            return this.getLeft().postorder() + " "   // Left
            + this.getElement().toString();      // Self
        }
        else
        {
            return this.getLeft().postorder() + " "   // Self
            + this.getRight().postorder() + " "     // Left
            + this.getElement().toString();       // Right
        }
       
        
    }

    public int size() // O(n)
    {
        if (this.left == null && this.right == null)
        {
            return 1; // no decendents
        }
        else if (this.left == null && this.right != null)
        {
            return 1 + this.getRight().size(); // root plus size of right decendents
        }
        else if (this.left != null && this.right == null)
        {
            return 1 + this.getLeft().size(); // root plus size of left decendents
        }
        else
        {
            return 1 + this.getLeft().size() + this.getRight().size(); // root plus size of left decendents plus size of right decendents 
        }
    }

    public String inorder()
    {
        return "";
    }

    public void insertLeft(TreeNode<T> newNode) //O(1)
    {
        this.setLeft(newNode);
    }
    public void insertRight(TreeNode<T> newNode) //O(1)
    {
        this.setRight(newNode);
    }

    public void insert(TreeNode<T> newNode)
    {
        //TODO (height has yet to be made, will fix in class)
        /*
        if (this.getLeft().height() <= this.getRight().height())
        {
            this.getLeft().insert(element);
        }
        else if (this.getLeft().height() > this.getRight().height())
        {
            this.getRight().insert(element);
        }
        */
    }

    public void remove()
    {

    }

    // toString
    public String toString()
    {
        return element.toString();
    }
}
