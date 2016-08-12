public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int right = matrix.length - 1;
        int left = 0;
        int top = matrix[0].length - 1;
        int bottom = 0;
        
        return matSearchRec(matrix, target, left, right, bottom, top);
        
        
    }
    
    
    boolean matSearchRec(final int[][] matrix, final int target, int left, int right, int bottom, int top){
        if(left > right || bottom > top) {
            return false;
        }
        
        int l = left;
        int r = right;
        int t = top;
        int b = bottom;
        
        while(l <= r && b <= t){
            int midX = (l + r)/2;
            int midY = (t + b)/2;
            int locVal = matrix[midX][midY];
            if (target < locVal){
                r = midX - 1;
                t = midY - 1;
            } else if(target > locVal){
                l = midX + 1;
                b = midY + 1;
            }
            else return true;
            
        }
        
        return matSearchRec(matrix, target, left, r, b, top)
            || matSearchRec(matrix, target, l, right, bottom, t);

    }
    
    
}
