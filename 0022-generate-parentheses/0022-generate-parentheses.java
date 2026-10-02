
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        // Start backtracking with 0 open brackets, 0 close brackets, and an empty string
        solve(0, 0, "", n, res);

        return res;
    }

    public void solve(int openP, int closeP, String s, int n, List<String> res) {

        // Base Case 1: If we have used more opening or closing brackets than allowed, stop
        if (openP > n || closeP > n) {
            return;
        }

        // Base Case 2: If the string has reached the required length (2 * n), 
        // we found a valid combination, so add it to our results list
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        // Choice 1: We can add an opening bracket '(' if we haven't reached the limit 'n'
        if (openP < n) {
            s += "(";                               // Choose
            solve(openP + 1, closeP, s, n, res);    // Explore
            s = s.substring(0, s.length() - 1);     // Un-choose (Backtrack)
        }

        // Choice 2: We can add a closing bracket ')' only if there are 
        // unclosed opening brackets available (closeP < openP)
        if (closeP < openP) {
            s += ")";                               // Choose
            solve(openP, closeP + 1, s, n, res);    // Explore
            s = s.substring(0, s.length() - 1);     // Un-choose (Backtrack)
        }
    }
}