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
            return this.getElement().toString()
            
            + this.getRight().preorder()
            + " ";   
        }
        else if (this.left != null && this.right == null)
        {
            return this.getElement().toString()  
            + " "
            + this.getLeft().preorder()
            + " "; 
        }
        else
        {
            return this.getElement().toString() 
            + " "  
            + this.getLeft().preorder()
            
            + this.getRight().preorder()      
            + " ";
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
            return this.getRight().postorder()  // Right
            + this.getElement().toString();       // Self
        }
        else if (this.left != null && this.right == null)
        {
            return this.getLeft().postorder()  // Left
            + this.getElement().toString();      // Self
        }
        else
        {
            return this.getLeft().postorder()  // Self
            + this.getRight().postorder()     // Left
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
        if (left == null)
        {
            this.setLeft(newNode);
        }
    }

    public void insertRight(TreeNode<T> newNode) //O(1)
    {
        if (right == null)
        {
            this.setRight(newNode);
        }
       
    }

    public boolean isIn(T target) //O(n)
    {
        if (this.getElement().equals(target)) 
        {
            return true;
        }
        else if (this.left != null && this.right == null) // right is null
        {
            return false || this.left.isIn(target);
        }
        else if (this.left == null && this.right != null) // left is null
        {
            return false || this.right.isIn(target);
        }
        else if (this.left == null && this.right == null) // both is null
        {
            return false;
        }
        else    // return false or look in left or right decendents for the target using recursion
        {
            return false || this.left.isIn(target) || this.right.isIn(target);
        }
        
    }

    public int height() //O(n) 
    {
        if (this.left == null && this.right == null) // no height
        {
            return 0;
        }
        else if (this.left != null && this.right == null)
        {
            return 1 + this.left.height(); // right height is -1 so its not included
        }
        else if (this.left == null && this.right != null)
        {
            return 1 + this.right.height(); // left height is -1 so its not included
        }
        else // "one plus the maximum of the height of the two decendents"
        {
            return 1 + Math.max(this.left.height(), this.right.height());
        }
    }

    public void insert(TreeNode<T> newNode) // O(n log n) "nlogn algorithm 
    {
        
        if (this.left == null && this.right == null)
        {
            this.insertLeft(newNode); // inserts in left decendent first if both are empty 
        }
        else if (this.left == null && this.right != null)
        {
            this.insertLeft(newNode);
        }
        else if (this.left != null && this.right == null)
        {
            this.insertRight(newNode);
        }
        else // both are not null // inserting recursivley
        {
            if (this.left.height() > this.right.height())
            {
                this.right.insert(newNode);
            }
            else // this.left.height() <= this.right.height()
            {
                this.left.insert(newNode);
            }
        }
    }

    // toString
    public String toString()
    {
        return element.toString();
    }
}
