public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer> base = new ArrayList<>();
        return csHelper(k, n, 1, base); 
        
    }
    
    int sumAll(List<Integer> in1, int in){
        int out = 0;
        for(int i : in1){
            out += i;
        }
        return out + in;
    }
    
    List<List<Integer>> csHelper(int k, int n, int next, List<Integer> base){
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        if(next > 9 || sumAll(base, next) > n) {
            return out;
        }
        else if(sumAll(base, next) == n) {
            if(k == 1){
                base.add(next);
                out.add(base);
            }
            return out;
        }
        else {
            ArrayList<Integer> base1 = new ArrayList<>(base);
            base1.add(next);
            List<List<Integer>> out1 = csHelper(k-1, n, next + 1, base1);
            ArrayList<Integer> base2 = new ArrayList<>(base);
            List<List<Integer>> out2 = csHelper(k, n, next + 1, base2);
            out1.addAll(out2);
            return out1;
        }
            
            
    }
}
