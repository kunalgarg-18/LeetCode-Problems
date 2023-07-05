// 572. Subtree of Another Tree
class Solution {

    private void serialize(TreeNode root, StringBuilder sb){
        if(root == null) {
            sb.append("#");
            return;
        }
        sb.append("*");
        sb.append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    private boolean kmp(String needle, String haystack){
        int m = needle.length();
        int n = haystack.length();

        if(n < m) return false;

        int[] lps = new int[m];
        int prev = 0;
        int i = 1;
        while(i < m){
            if(needle.charAt(i) == needle.charAt(prev)){
                prev ++;
                lps[i] = prev;
                i++;
            }
            else{
                if(prev == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                    prev = lps[prev - 1];
                }
            }
        }
        int haystackPointer = 0;
        int needlePointer = 0;

        while(haystackPointer < n){
            if(haystack.charAt(haystackPointer) == needle.charAt(needlePointer)){
                needlePointer++;
                haystackPointer++;

                if(needlePointer == m) return true;
            }
            else{
                    if(needlePointer == 0) haystackPointer++;
                    else needlePointer = lps[needlePointer - 1];
                }
            }
            return false;
        }
    

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        StringBuilder rootList = new StringBuilder();
        serialize(root, rootList);
        String r = rootList.toString();

        StringBuilder subrootList = new StringBuilder();
        serialize(subRoot, subrootList);
        String s = subrootList.toString();

        return kmp(s, r);        
    }
}
