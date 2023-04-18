import java.io.*;

public class 회문 {
    private static String[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            s = br.readLine().split("");
            int answer = checkPalindrome(0, s.length - 1, true);
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    private static int checkPalindrome(int startIdx, int endIdx, boolean isMainString) {
        int answer = isMainString? 0 : 1;
        int len = ((endIdx - startIdx + 1) / 2) + startIdx;
        int frontIdx = startIdx;
        int rearIdx = endIdx;

        while (frontIdx < len) {
            if(!s[frontIdx].equals(s[rearIdx])){
                boolean increaseFrontIdx = s[frontIdx + 1].equals(s[rearIdx]);
                boolean decreaseRearIdx = s[frontIdx].equals(s[rearIdx - 1]);

                answer = 2;

                if(isMainString && (increaseFrontIdx || decreaseRearIdx)) {
                    if(increaseFrontIdx) {
                        answer = checkPalindrome(frontIdx + 1, rearIdx, false);
                    }
                    if(answer == 2 && decreaseRearIdx){
                        answer = checkPalindrome(frontIdx, rearIdx - 1, false);
                    }
                }
                break;
            }
            frontIdx++;
            rearIdx--;
        }
        return answer;
    }
}