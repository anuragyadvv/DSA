class Solution {
    public boolean canBeValid(String s, String locked) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (locked.charAt(i) == '0') {
                openClose.push(i);
            } else {  // locked[i] = 1

                if (s.charAt(i) == '(') {
                    open.push(i);
                } else if (s.charAt(i) == ')') { // closing bracket
                    if (!open.isEmpty()) {
                        open.pop();
                    } else if (!openClose.isEmpty()) {
                        openClose.pop();
                    } else {
                        return false; //  No open or unlocked character available to match this locked ')'
                    }
                } else {
                    return false; 
                }

            }
        }

        while (!open.isEmpty() && !openClose.isEmpty()) {
            if (open.peek() < openClose.peek()) {
                open.pop();
                openClose.pop();
            } else {
                return false;
            }
        }

        return open.isEmpty();
    }
}