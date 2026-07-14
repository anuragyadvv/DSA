class Solution {
    // standard Approach(Pattern)- Use BFS  used in many question
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer>list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=8;i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            int num = q.remove();

            if(num>=low && num<= high){
                list.add(num);
            }

            if(num>high){
                break;
            }
           
            int lastDigit = num%10;
            if(lastDigit+1<=9){
                q.add((num*10)+(lastDigit+1));
            }
        }

        return list;
    }
}