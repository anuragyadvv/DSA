class Solution {
    public int sumSubarrayMins(int[] arr) {

        // Brute force 
        // long sum = 0;
        // int n = arr.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //        int min =  Integer.MAX_VALUE;
        //        for(int k=i;k<=j;k++){
        //         min = Math.min(min,arr[k]);
        //        }

        //        sum =( sum+ min) % 1000000007;
        //     }
        // }

        // return (int) sum;

        // M-2  using montonic stack concept (next smaller left and next smaller right )
        int n = arr.length;
        int NSL[] = getNSL(arr,n);
        int NSR[] = getNSR(arr,n);

        long sum =0;
        int M = 1000000007;

        for(int i=0;i<n;i++){
            long d1 = i- NSL[i];
            long d2 = NSR[i]-i;

            long totalWaysForIMin = d1*d2;
            long sumIInTotalWays = arr[i]*totalWaysForIMin;
            sum = (sum+sumIInTotalWays) %M;
        }

        return (int)sum;
        
    }

    public int [] getNSL(int arr[],int n){
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();
        result[0] = -1;
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            result[i] = s.isEmpty()? -1 : s.peek();
            s.push(i);
        }  
        return result;
    }

    public int [] getNSR(int arr[], int n){
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();
        result[n-1] = n;
        s.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>arr[i]){
                s.pop();
            }

             result[i] = s.isEmpty()? n : s.peek();
            s.push(i);
        }

        return result;

    }
}