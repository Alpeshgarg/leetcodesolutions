class Solution {
    private int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return helper(0, traversal);
    }

    TreeNode helper(int level, String traversal){
        int numDashes = countDashes(traversal);
        if(level != numDashes){
            index -= numDashes;
            return null;
        }

        TreeNode node = new TreeNode(getNodeValue(traversal));
        node.left = helper(level +1, traversal);
        node.right = helper(level +1, traversal);
        return node;
        
    }

    private int countDashes(String traversal) {
        int count = 0;
        while (index < traversal.length() && traversal.charAt(index) == '-') {
            count++;
            index++;
        }
        return count;
    }

    private int getNodeValue(String traversal) {
        int num = 0;
        while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
            num = num * 10 + (traversal.charAt(index) - '0');
            index++;
        }
        return num;
    }
}