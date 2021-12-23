import java.util.*;

public class Main {

    // programmers level 2 - 문자열 압축
    // 유튜브에 있는 문제 해결 풀이 영상을 보았다.
    // 설명도 있어서 코드는 이해했는데 나 혼자서는 못했을 것 같다.
    // 특정한 알고리즘이 쓰이지 않는 시뮬레이션 문제인데
    // 3중 for문이 활용된 데다가 for 문 내에서
    // 시작 조건이나 i++ 에 해당하는 부분을 없이 구현하고
    // pos += i 등으로 문자열의 특정 위치로 이동하거나 부분문자열을 확인하는등
    // 생각해야 할게 상당히 많은 문제였다.
    // 특정 알고리즘에 대한 공부가 아니라 기본적으로 문제를 푸는 사고력에 대해서
    // 훈련을 해야 한다고 느끼는 시간이다.

    public static void main(String[] args) {

        String s = "aabbaccc";

        int answer = s.length();

        for(int i=1; i < s.length()/2 ;i++){ // 절반이후로는 압축이 안 되므로
            int pos = 0;

            int len = s.length();

            for(; pos + i <= s.length() ;){
                String unit = s.substring(pos,pos + i);
                pos += i;

                int cnt = 0;
                for(; pos + i <= s.length();){
                    if(unit.equals(s.substring(pos,pos+i))){ // 그다음문자와 같은지
                        cnt++;
                        pos += i;
                    }else{ // 다음 문자가 다르다면
                        break;
                    }
                }

                if(cnt > 0){
                    len -= i * cnt; // i가 반복되는 문자의 개수

                    if( cnt < 9){ // 한자리숫자만큼 반복되면
                        len += 1;
                    }
                    else if(cnt < 99){ // 두자리숫자만큼 반복되면
                        len += 2;
                    }
                    else if(cnt < 999){ // 세자리숫자만큼 반복되면
                        len += 3;
                    }
                    else{ // 최대는 1000
                        len += 4;
                    }
                }

            }

            answer = Math.min(answer, len);
        }

//        return answer;

    }
}
