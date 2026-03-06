import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static double[] studentScore;
    static Double[] studentRankingBoard;
    static String[] credit = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static double calculateScore(int middle, int last, int assign) {
        return middle * 0.35 + last * 0.45 + assign * 0.2;
    }

    public static String findStudentScore(double score) {
        int rank = 0;
        for (int i = 0; i < studentRankingBoard.length; i++) {
            if (studentRankingBoard[i] == score) {
                rank = i;
                break;
            }
        }
        int standard = (studentRankingBoard.length) / 10;
        return credit[rank / standard];
    }

    // 오름차순으로 가는거지 -> 비율을 따졌을때 0~3 까지가 A+거니까
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int studentNumber = Integer.parseInt(st.nextToken());
            studentScore = new double[n];
            studentRankingBoard = new Double[n];

            double selectedScore = 0;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int middle = Integer.parseInt(st.nextToken());
                int last = Integer.parseInt(st.nextToken());
                int assign = Integer.parseInt(st.nextToken());
                studentScore[j] = calculateScore(middle, last, assign);
                studentRankingBoard[j] = calculateScore(middle, last, assign);

                if (studentNumber-1 == j) selectedScore = studentScore[j];
            }

            Arrays.sort(studentRankingBoard, Collections.reverseOrder());

            String studentCredit = findStudentScore(selectedScore);

            sb.append("#" + tc + " " + studentCredit + "\n");
        }
        System.out.println(sb);
    }
}