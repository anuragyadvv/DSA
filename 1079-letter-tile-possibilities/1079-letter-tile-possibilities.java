class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        int n = tiles.length();
        StringBuilder sb = new StringBuilder();

        boolean used[] = new boolean[n + 1];

        solve(tiles, 0, set, sb, n, used);

        return set.size() - 1; // because we  added an empty string 

    }

    public void solve(String tiles, int i, Set<String>set, StringBuilder sb, int n, boolean used[]){

        set.add(sb.toString());

        for(int j=0;j<n;j++){

        if(used[j]==true) continue;
     

    //  do
        used[j] = true;
        sb.append(tiles.charAt(j));

        // explore 
        solve(tiles,j+1,set,sb,n,used);

        // undo 
        used[j] = false;
        sb.deleteCharAt(sb.length()-1);
        }




    }
}