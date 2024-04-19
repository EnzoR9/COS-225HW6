import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseTree
{
    public TreeNode<String> root;

    public MorseTree()
    {
        root = null;
    }

    // make tree from file (somewhat done)
    public void treePopulate() // add: (String fileName) if you wanna switch back to file IO method 
    {
        root = new TreeNode<>("");

        codeInsert(root, "e", "o"); 
        codeInsert(root, "t", "-");
        codeInsert(root, "i", "o o");
        codeInsert(root, "a", "o -");
        codeInsert(root, "n", "- o");
        codeInsert(root, "m", "- -");
        codeInsert(root, "s", "o o o");
        codeInsert(root, "u", "o o -");
        codeInsert(root, "r", "o - o");
        codeInsert(root, "w", "o - -");
        codeInsert(root, "d", "- o o");
        codeInsert(root, "k", "- o -");
        codeInsert(root, "g", "- - o");
        codeInsert(root, "h", "o o o o");
        codeInsert(root, "v", "o o o -");
        codeInsert(root, "f", "o o - o");
        codeInsert(root, "l", "o - o o");
        codeInsert(root, "p", "o - - o");
        codeInsert(root, "j", "o - - -");
        codeInsert(root, "b", "- o o o");
        codeInsert(root, "x", "- o o -");
        codeInsert(root, "c", "- o - o");
        codeInsert(root, "y", "- o - -");
        codeInsert(root, "z", "- - o o");
        codeInsert(root, "q", "- - o -");


        // file IO method (wasnt really vibin with this, may come back to it later)
        /*
        try 
        {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            root = new TreeNode<>("");

            while (scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] parts = line.split(" ");
                String letter = parts[0];
                String code = parts[1];

                codeInsert(root, letter, code, 0);
            }
            scan.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + fileName);
        }
        */
    }

    public void codeInsert(TreeNode<String> node, String letter, String code)
    {
       for (int i = 0; i < code.length(); i++)
       {
            char c = code.charAt(i);
            if (c == 'o')
            {
                node.insertLeft(new TreeNode<>("")); // fucking up the print order/format
                node = node.getLeft();
            }
            else if (c == '-')
            {
                node.insertRight(new TreeNode<>("")); // also fucking up the print order/format
                node = node.getRight();
            }
       }
       node.insert(new TreeNode<>(letter));
    }
    
    public String preOrderMorse()
    {
        return root.preorder();
    }
    
    public String postOrderMorse()
    {
        return root.postorder();
    }
    // unfinished
    public String englishToMorse(String text)
    {
       return "";
    }
}