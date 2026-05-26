class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean visited[] = new boolean[n];

        return solve(arr, start, n,visited);

    }

    public boolean solve(int arr[], int idx, int n, boolean visited[]) {

        if(idx<0 || idx>n || visited[idx]){
            return false;
        }
        if (arr[idx] == 0) {
            return true;
        }

    visited[idx]= true;

        if (idx + arr[idx] < n && solve(arr, idx + arr[idx], n, visited) == true) {
            return true;
        }

        if (idx - arr[idx] >= 0 && solve(arr, idx - arr[idx], n, visited) == true) {
            return true;
        }

        
        return false;
    }
}