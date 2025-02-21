//import java.util.*;
//
//class Meeting {
//    int start;
//    int end;
//
//    public Meeting() {
//    }
//
//    public Meeting(int start, int end) {
//        this.start = start;
//        this.end = end;
//    }
//
//    @Override
//    public String toString() {
//        return "Meeting{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
//}
//
//// 회의실 배정
//public class BOJ1931 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Meeting> arrStart = new ArrayList<>();
//        List<Meeting> arrEnd = new ArrayList<>();
//        int n = Integer.parseInt(sc.nextLine());
//        for (int i = 0; i < n; i++) {
//            String[] input = sc.nextLine().split(" ");
//            int a = Integer.parseInt(input[0]);
//            int b = Integer.parseInt(input[1]);
//            Meeting meeting = new Meeting(a, b);
//            arrStart.add(meeting);
//            arrEnd.add(meeting);
//        }
//
//        arrStart.sort(Comparator.comparingInt(meeting -> meeting.start));
//        arrEnd.sort(Comparator.comparingInt(meeting -> meeting.end));
//
//        for (Meeting meeting : arrStart) {
//            System.out.println(meeting);
//        }
//
//        int time = arrStart.getFirst().start;
//        int roomCnt = 0;
//        int index = 1;
//        while (!arrStart.isEmpty()) {
//            int nextTime = arrStart.get(index).start;
//            if (nextTime > time) {
//                roomCnt++;
//            } else if (nextTime == time) {
//
//            }
//        }
//
//
//
//
//
//
//    }
//}
