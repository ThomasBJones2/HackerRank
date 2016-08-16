public class Solution {
    Boolean[] dynamicMem;
    int maxLen;
    
    int maxLength(Set<String> wordDict){
        int out = 0;
        for(String s : wordDict){
            if(out < s.length()) out = s.length();
        }
        return out;
    }
    
    boolean check (String s, Set<String> wordDict, int index){
        for(int i = Math.max(0,index - maxLen); i < index; i ++){

            if(dynamicMem[i] && wordDict.contains(s.substring(i, index))){
                return true;
            }
        }
        return false;
    }
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        maxLen = maxLength(wordDict);
        dynamicMem = new Boolean[s.length() + 1];
        dynamicMem[0] = true;
        for(int i = 1; i <= s.length(); i ++){
            dynamicMem[i] = false;
        }

        for(int i = 0; i <= s.length(); i ++){
            if(check(s, wordDict, i)){
                dynamicMem[i] = check(s,wordDict, i);
            }
        }
        return dynamicMem[s.length()];
    }
}
