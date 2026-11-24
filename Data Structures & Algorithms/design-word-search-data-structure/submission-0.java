public class Node {
    Node[] childs;
    boolean word;

    public Node() {
        childs = new Node[26];
        word = false;
    }
}


class WordDictionary {

    public Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for(char ch : word.toCharArray()) {
            if(curr.childs[ch-'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
    private boolean search(String word, int i, Node curr) {
        if(curr == null) return false;

        if(i == word.length()) return curr.word;

        char ch = word.charAt(i);

        if(ch == '.') {
            for(Node child : curr.childs) {
                if(search(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        }
        return search(word, i + 1, curr.childs[ch - 'a']);
    }
}
