public class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                vowels.append(s.charAt(i));
            }
        }
        String revVowel = vowels.reverse().toString();
        int j = 0;
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < s.length(); i ++){
            if(isVowel(s.charAt(i))){
                out.append(revVowel.charAt(j));
                j ++;
            }
            else{
                out.append(s.charAt(i));
            }
        }
        return out.toString();
    }
    
    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
