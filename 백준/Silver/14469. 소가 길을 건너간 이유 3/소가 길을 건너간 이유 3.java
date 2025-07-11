import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cowCnt = Integer.parseInt(st.nextToken()); // 소의 수

        Cow[] cows = new Cow[cowCnt]; // 도착 시간, 검문 시간

        // 입력받기.
        for(int i = 0; i < cowCnt; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(allEntryTime(cows));
    }

    static public int allEntryTime(Cow[] cows){
        int result = 0;

        // 도착 시간별로 정렬 (먼저 온 소 부터 들어간다.)
        PriorityQueue<Cow> pq = new PriorityQueue<>(
                (c1, c2) -> Integer.compare(c1.arriveTime, c2.arriveTime)
        );

        for (Cow cow : cows) {
            pq.offer(cow);
        }

        while(!pq.isEmpty()){
            Cow cow = pq.poll();
            result = result < cow.arriveTime ? cow.arriveTime + cow.testTime: result + cow.testTime;
        }

        return result;
    }
}

class Cow implements Comparable<Cow> {
    int arriveTime;
    int testTime;

    public Cow(int arriveTime, int testTime){
        this.arriveTime = arriveTime;
        this.testTime = testTime;
    }

    @Override
    public int compareTo(Cow c){
        return Integer.compare(this.arriveTime, c.arriveTime);
    }
}
