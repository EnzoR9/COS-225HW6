public class MorseTester
{
    public static void main(String[] args) 
    {
        // new tree
        MorseTree tree = new MorseTree();

        // fill the tree
        tree.treePopulate();
        
        // Produce preorder of the tree
        System.out.println("Preorder tree contents: ");
        System.out.println(tree.root.preorder());

        // Produce postorder of the tree 
        System.out.println("Postorder tree contents: ");
        System.out.println(tree.root.postorder());

        // Define a string of English text, and translate it to Morse code using MorseTree
        String englishText = "The quick brown fox jumps over the lazy dog";
        String morseText = tree.englishToMorse(englishText);
        System.out.println("Morse code: " + morseText);

        // Using the same string as above, translate it back into english text
        String translatedEnglish = tree.morseToEnglish(morseText);
        System.out.println("Translated English text: " + translatedEnglish);

        //debug
        //tree.printMorseTree();
        
    }
}
