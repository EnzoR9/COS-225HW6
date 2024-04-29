
public class MorseTree
{
    public TreeNode<String> root;

    // normal methods
    public MorseTree()
    {
        root = null;
    }

    public void treePopulate() 
    {
        root = new TreeNode<>("_");
        root.insertLeft(new TreeNode<String>("e"));
        root.insertRight(new TreeNode<String>("t"));
        root.getLeft().insertLeft(new TreeNode<String>("i"));
        root.getLeft().insertRight(new TreeNode<String>("a"));
        root.getRight().insertLeft(new TreeNode<String>("n"));
        root.getRight().insertRight(new TreeNode<String>("m"));
        
        root.getLeft().getLeft().insertLeft(new TreeNode<String>("s"));
        root.getLeft().getLeft().insertRight(new TreeNode<String>("u"));
        root.getLeft().getRight().insertLeft(new TreeNode<String>("r"));
        root.getLeft().getRight().insertRight(new TreeNode<String>("w"));
        root.getRight().getLeft().insertLeft(new TreeNode<String>("d"));
        root.getRight().getLeft().insertRight(new TreeNode<String>("k"));
        root.getRight().getRight().insertLeft(new TreeNode<String>("g"));
        root.getRight().getRight().insertRight(new TreeNode<String>("o"));

        root.getLeft().getLeft().getLeft().insertLeft(new TreeNode<String>("h"));
        root.getLeft().getLeft().getLeft().insertRight(new TreeNode<String>("v"));
        root.getLeft().getLeft().getRight().insertLeft(new TreeNode<String>("f"));
        root.getLeft().getLeft().getRight().insertRight(new TreeNode<String>("l"));
        root.getLeft().getRight().getLeft().insertLeft(new TreeNode<String>("p"));
        root.getLeft().getRight().getLeft().insertRight(new TreeNode<String>("j"));
        root.getLeft().getRight().getRight().insertLeft(new TreeNode<String>("b"));
        root.getLeft().getRight().getRight().insertRight(new TreeNode<String>("x"));
        root.getRight().getLeft().getLeft().insertLeft(new TreeNode<String>("c"));
        root.getRight().getLeft().getLeft().insertRight(new TreeNode<String>("y"));
        root.getRight().getLeft().getRight().insertLeft(new TreeNode<String>("z"));
        root.getRight().getLeft().getRight().insertRight(new TreeNode<String>("q"));
    }
    
    public String preOrderMorse()
    {
        return root.preorder();
    }
    
    public String postOrderMorse()
    {
        return root.postorder();
    }

    public String englishToMorse(String text) 
    {
        StringBuilder morse = new StringBuilder();
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) 
        {
            for (int i = 0; i < word.length(); i++) 
            {
                char c = word.charAt(i);
                if (Character.isLetter(c)) 
                {
                    String letter = String.valueOf(c);
                    String path = findNode(root, letter, "");
                    morse.append(path);
                    if (i < word.length()) 
                    {
                        morse.append("|");
                    }
                }
            }
            
        }
        return morse.toString().trim();
    }

    public String morseToEnglish(String morse)
    {
        StringBuilder sb = new StringBuilder();
        String[] codes = morse.split("\\|");
        for (String code : codes)
        {
            String english = getEnglish(code);
            if (english != null) 
            {
                sb.append(english);
            }
        }
        return sb.toString();
    }


    // helper methods
    public String findNode(TreeNode<String> node, String letter, String path)
    {
       if (node == null)
       {
            return "";
       }
       else if(node.getElement().equals(letter))
       {
            return path;
       }
       else
        {
            return "" + findNode(node.getLeft(), letter, path + "o") + findNode(node.getRight(), letter, path + "-");
        }
    }
    
    public String getMorseCode(TreeNode<String> node)
    {
        if (node == null)
        {
            return "";
        }
        StringBuilder code = new StringBuilder();
        Traverse(node, code);
        return code.toString();
    }

    public void Traverse(TreeNode<String> node, StringBuilder code)
    {
        if (node.getLeft() != null)
        {
            //code.append("o");
            Traverse(node.getLeft(), code);
        }
        if (node.getRight() != null)
        {
            //code.append("-");
            Traverse(node.getRight(), code);
        }
    }

    public TreeNode<String> findNodeByCode(TreeNode<String> node, String code)
    {
        if(node == null || code.isEmpty())
        {
            return null;
            
        }
        if (code.length() == 1 && node.getElement() != "")
        {
            return node;
        }
       
        char c = code.charAt(0);
        String codeRemaining = code.substring(1);

        if (c == 'o')
        {
            return findNodeByCode(node.getLeft(), codeRemaining);
        }
        else if ( c == '-')
        {
            return findNodeByCode(node.getRight(), codeRemaining);
        }

        return null;
    }

    public String getEnglish(String code) {
        TreeNode<String> currentNode = root;
        for (char symbol : code.toCharArray()) {
            if (symbol == 'o') {
                currentNode = currentNode.getLeft();
            } else if (symbol == '-') {
                currentNode = currentNode.getRight();
            }
            
            if (currentNode == null) {
                return null;
            }
        }
        
        return currentNode.getElement();
    }
}