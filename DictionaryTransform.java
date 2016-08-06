import java.util.Stack;

public class Solution {
    private class DistPair{
        String word;
        int distance;
        
        DistPair(String inWord, int inDist){
            word = inWord;
            distance = inDist;
        }
    }
    
    boolean adjacent(String s1, String s2){
        int diffCount = 0;
        for(int i = 0; i < s1.length(); i ++){
            if(s1.charAt(i) != s2.charAt(i))
                diffCount ++;
        }
        return (diffCount == 1);
    }
    
    int findLink(ArrayList<DistPair> frontQueue, ArrayList<DistPair> backQueue){
        int curDist = -1;
        for(DistPair s : frontQueue){
            for(DistPair t : backQueue){
                int distance = s.distance + t.distance + 1;
                if(s.word.equals(t.word) && (distance < curDist || curDist < 0)){
                    curDist = distance;
                }
            }
        }
        return curDist;
    }
    
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        HashSet<String> frontSet = new HashSet<>(wordList);
        HashSet<String> backSet = new HashSet<>(wordList);

        if(beginWord.equals(endWord)){
            return 1;
        }
        
        ArrayList<DistPair> frontQueue = new ArrayList<>();
        ArrayList<DistPair> backQueue = new ArrayList<>();

        DistPair start = new DistPair(beginWord, 0);
        DistPair end = new DistPair(endWord, 0);
        frontQueue.add(start);
        frontSet.remove(beginWord);
        backQueue.add(end);
        backSet.remove(endWord);        
        
        
        while(frontQueue.size() > 0 && backQueue.size() > 0){
            DistPair nextWord = frontQueue.get(0);
            System.out.println("f: " + nextWord.word + nextWord.distance);
            Iterator<String> iter = frontSet.iterator();
            while(iter.hasNext()){
                String s = iter.next();
                if(adjacent(s, nextWord.word)){
                    iter.remove();
                    frontQueue.add(new DistPair(s, nextWord.distance + 1));
                }
            }
            
            nextWord = backQueue.get(0);
            System.out.println("b: " + nextWord.word + nextWord.distance);
            iter = backSet.iterator();
            while(iter.hasNext()){
                String s = iter.next();
                if(adjacent(s, nextWord.word)){
                    iter.remove();
                    backQueue.add(new DistPair(s, nextWord.distance + 1));
                }
            }
            
            
            int linked = findLink(backQueue, frontQueue);
            if(linked > 0){
                return linked;
            }
            if(linked > 2){
                return linked - 1;
            }
            frontQueue.remove(0);
            backQueue.remove(0);
            
        }
        return 0;
    }
}
