import java.util.Stack;

public class Solution {

    boolean adjacent(String s1, String s2){
        int diffCount = 0;
        for(int i = 0; i < s1.length(); i ++){
            if(s1.charAt(i) != s2.charAt(i)) {
                diffCount ++;
                if(diffCount > 1)
                    return false;
            }
        }
        return (diffCount == 1);
    }
    
    boolean stringAdjacent(String s, HashSet<String> backSet){
        for(String t : backSet){
            if(adjacent(s,t)){
                return true;
            }
        }
        return false;
    }
    
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> frontSet = new HashSet<String>();
        frontSet.add(beginWord);
        HashSet<String> backSet = new HashSet<String>();
        backSet.add(endWord);
        HashSet<String> leftSet = new HashSet<String>(wordList);
        leftSet.remove(beginWord);
        leftSet.remove(endWord);

        int curDist = 1;
        
        while(frontSet.size() > 0 && backSet.size() > 0){
            if(frontSet.size() > backSet.size()){
                HashSet<String> temp = frontSet;
                frontSet = backSet;
                backSet = temp;
            }

            
            HashSet<String> temp = new HashSet<>();
            for(String s : frontSet) {
                if(stringAdjacent(s, backSet)){
                    return curDist + 1;
                }
                
                Iterator<String> ls = leftSet.iterator();
                while(ls.hasNext()){
                    String t = ls.next();
                    if (adjacent(s,t)) {
                        temp.add(t);
                        ls.remove();
                    }
                }
            }
            
            frontSet = temp;

            curDist ++;
        }
        return 0;
    }
}
