import java.io.*;
import java.util.*;

class Solution {
    static class Process {
        int priority;
        int location;

        public Process(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        // 큐: 문서 순서 유지
        Queue<Process> q = new LinkedList<>();
        // 우선순위 큐: 가장 높은 우선순위 추적
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Process(priorities[i], i));
            pq.offer(priorities[i]);
        }

        int count = 0;

        while (!q.isEmpty()) {
            Process current = q.poll();

            if (current.priority < pq.peek()) {
                q.offer(current); // 우선순위가 낮으면 다시 뒤로
            } else {
                pq.poll(); // 출력됨
                count++;

                if (current.location == location) break;
            }
        }
        
        return count;
    }
}