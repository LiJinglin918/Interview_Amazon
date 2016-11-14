public class Solution {
    public class TrieNode{
        public boolean end = false;
        public TrieNode[] child = new TrieNode[26];
        public TrieNode(){
        }
    }
    TrieNode root = new TrieNode();
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(board == null || board.length == 0 || board[0].length == 0){
            return new LinkedList<String>();
        }
        visited = new boolean[board.length][board[0].length];
        addToTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(root.child[board[i][j] - 'a'] != null){
                    search(board, i, j, root, "", res);
                }
            }
        }
        return new LinkedList<String>(res);
    }
    private void addToTrie(String[] words){
        for(String s : words){
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(node.child[c - 'a'] == null){
                    node.child[c - 'a'] = new TrieNode();
                }
                node = node.child[c - 'a'];
            }
            node.end = true;
        }
    }
    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> res){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] ){
            return;
        }
        if(node.child[board[i][j] - 'a'] == null){
            return;
        }
        visited[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if(node.end){
            res.add(word + board[i][j]);
        }
        search(board, i - 1, j, node, word + board[i][j], res);
        search(board, i + 1, j, node, word + board[i][j], res);
        search(board, i, j - 1, node, word + board[i][j], res);
        search(board, i, j + 1, node, word + board[i][j], res);
        visited[i][j] = false;
    }
}
