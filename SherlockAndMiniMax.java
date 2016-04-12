import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i ++){
            array[i] = in.nextInt();
        }
        int P = in.nextInt();
        int Q = in.nextInt();

        Arrays.sort(array);
        
        int minDistP = -1;
        for(int i = 0; i < size; i ++){
            if(minDistP < 0 || minDistP > Math.abs(array[i] - P)){
                minDistP = Math.abs(array[i] - P);
            }
        }
        int minDistQ = -1;
        for(int i = 0; i < size; i ++){
            if(minDistQ < 0 || minDistQ > Math.abs(array[i] - Q)){
                minDistQ = Math.abs(array[i] - Q);
            }
        }
        int[] distNext = new int[size-1];
        for(int i = 0; i < size - 1; i ++){
            distNext[i] = -1;
            if(array[i] < P && array[i + 1] > P){
                if(array[i] + Math.abs(array[i + 1] - array[i])/2 >= P)
                    distNext[i] = Math.abs(array[i + 1] - array[i]);
            } else if(array[i] < Q && array[i + 1] > Q){
                if(array[i] + Math.abs(array[i + 1] - array[i])/2 <= Q)
                    distNext[i] = Math.abs(array[i + 1] - array[i]);
            } else { 
                if(array[i] > P && array[i + 1] < Q)
                    distNext[i] = Math.abs(array[i + 1] - array[i]);
            }
        }
        
        
        int maxIndex = -1;
        int maxDist = -1;
        for(int i = 0; i < distNext.length; i ++){
            if(maxDist < distNext[i]){
                maxDist = distNext[i];
                maxIndex = i;
            }
        }
        //System.out.println(minDistP + " " + minDistQ);
        if(minDistP >= minDistQ && minDistP >= maxDist/2){
            System.out.println(P);
        } else if(maxDist/2 >= minDistQ){
            System.out.println(array[maxIndex] + maxDist/2);
        } else {
            System.out.println(Q);
        }
    }
}
