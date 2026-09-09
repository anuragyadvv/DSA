class Solution {
    public long countCommas(long n) {
        // Brute force 

        // long count = 0;

        // if (n < 1000) {
        //     return 0;
        // }

        // // 1,000 to 999,999 (1 comma each, total: 999,000 numbers)
        // if (n >= 1_000L && n < 1_000_000L) {
        //     count += (n - 1_000L + 1) * 1;
        // }

        // // 1,000,000 to 999,999,999 (2 commas each)
        // if (n >= 1_000_000L && n < 1_000_000_000L) {
        //     count += (999_999L - 1_000L + 1) * 1; // commas from full 10^3 tier
        //     count += (n - 1_000_000L + 1) * 2;
        // }

        // // 1,000,000,000 to 999,999,999,999 (3 commas each)
        // if (n >= 1_000_000_000L && n < 1_000_000_000_000L) {
        //     count += (999_999L - 1_000L + 1) * 1;
        //     count += (999_999_999L - 1_000_000L + 1) * 2;
        //     count += (n - 1_000_000_000L + 1) * 3;
        // }

        // // 1,000,000,000,000 to 999,999,999,999,999 (4 commas each)
        // if (n >= 1_000_000_000_000L && n < 1_000_000_000_000_000L) {
        //     count += (999_999L - 1_000L + 1) * 1;
        //     count += (999_999_999L - 1_000_000L + 1) * 2;
        //     count += (999_999_999_999L - 1_000_000_000L + 1) * 3;
        //     count += (n - 1_000_000_000_000L + 1) * 4;
        // }

        // // Exactly 10^15 (5 commas)
        // if (n == 1_000_000_000_000_000L) {
        //     count += (999_999L - 1_000L + 1) * 1;
        //     count += (999_999_999L - 1_000_000L + 1) * 2;
        //     count += (999_999_999_999L - 1_000_000_000L + 1) * 3;
        //     count += (999_999_999_999_999L - 1_000_000_000_000L + 1) * 4;
        //     count += 5;
        // }

        // return count;


        // Approach -2 
        long result =0;
        long start = 1000;

        while(start<=n){
            result += (n-start+1);
            start = start*1000;
        }

        return result;
    }
}