import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MorseTree
{
    // Contains a TreeNode representing the root of the Tree containing letters
    public TreeNode<Character> root;
    // Contains a default constructor to make a NULL Tree
    public MorseTree()
    {
        root = null;
    }

    // make tree from file (unfinished asf)
    public void treePopulate(String filename)
    {
        try
        {
            File txtFile = new File(filename);
            Scanner scanner = new Scanner(txtFile);

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                char letter = parts[0].charAt(0);
                String morseCode = parts[1];

                // Insert the letter into the tree based on morse
                // NOTE: insert method is not done so this is doo doo rn
                // insert(letter, morseCode); //<---
            }
            scanner.close();
            
            
        } 
        catch (FileNotFoundException e)
        {
            System.err.println("File not found: " + e.getMessage());
        }
        

    }
    
    // Method that will return a String containing the Pre-order of the Tree
    public String preOrderMorse()
    {
        return "";
    }
    // Method that will return a String containing the Post-order of the Tree (ignoring case)
    public String postOrderMorse()
    {
        return "";
    }
    // Method that will translate an English string into is Morse code equivalent (ignoring spaces and case)
    public String englishToMorse()
    {
        return ""; 
    }
}