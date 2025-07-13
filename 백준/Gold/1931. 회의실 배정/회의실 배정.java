import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 회의실 개수 N
        // 회의 (시작시간, 끝나는 시간)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        int currentTime = 0;
        int meetingCnt = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);

        for(Meeting meeting : meetings) {
            if(meeting.startTime >= currentTime) {
                currentTime = meeting.endTime;
                meetingCnt++;
            }
        }

        System.out.println(meetingCnt);
    }
}

class Meeting implements Comparable<Meeting>{
    int startTime; // 시작시간
    int endTime; // 끝나는 시간

    public Meeting(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting m){
        if(this.endTime == m.endTime) { // 끝나는 시간이 같다면
            return Integer.compare(this.startTime, m.startTime); // 시작 시간이 빠른 순
        }
        return Integer.compare(this.endTime, m.endTime); // 끝나는 시간 오름차순
    }
}