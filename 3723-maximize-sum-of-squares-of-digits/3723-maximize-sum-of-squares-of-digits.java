class Solution {
    public String maxSumOfSquares(int num, int sum) {

        int digits = (int)Math.log10(sum)+1;

        if(num<digits || sum > 9*num){
            return "";
        }


        int arr[] = new int[num];
        int i=0;

        while(sum !=0 && i<num){
            if(sum >=9){
              arr[i] = 9;
              sum = sum-9;
              i++;
            }
            else{
                arr[i] = sum;
                sum =0;
                i++;
            }
        }

     StringBuilder sb = new StringBuilder();

     for(int j=0;j<arr.length;j++){
        sb.append(arr[j]);
     }

     return sb.toString();
        
    }
}