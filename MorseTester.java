public class MorseTester
{
    public static void main(String[] args) 
    {
        // instantiate a MorseTree (no params for now)
        MorseTree tree = new MorseTree();
        // fill the MorseTree
        tree.treePopulate();
        // Produce preorder of the tree
        System.out.println("Preorder tree contents: ");
        System.out.println(tree.root.preorder());
        // Produce postorder of the tree 
        System.out.println("Postorder tree contents: ");
        System.out.println(tree.root.postorder());
        // Define a string of English text, and translate it to Morse code using MorseTree
        // Using the same string as above, translate it back into english text
    }
}
