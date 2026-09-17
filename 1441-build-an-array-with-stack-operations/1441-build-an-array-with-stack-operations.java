class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int j=0;

        for(int i=1;i<=n;i++){

          if(j==target.length){
            break;
          }

            s.push(i);
            list.add("Push");


            if(s.peek()== target[j] && j<target.length){
                j++;
            }
            else{
                s.pop();
                list.add("Pop");
            }

        }

        return list;
        
    }
}