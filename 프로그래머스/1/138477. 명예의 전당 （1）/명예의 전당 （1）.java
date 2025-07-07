import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int answer[] = new int[score.length];

        PriorityQueue<Integer> rank = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> lowestRank = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++){
            rank.offer(score[i]);

            lowestRank.offer(score[i]);
            
            if(lowestRank.size() > k){
                lowestRank.poll();
            }

            answer[i] = lowestRank.peek();
        }
        
        return answer;
    }
}