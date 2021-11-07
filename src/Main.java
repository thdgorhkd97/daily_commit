import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // B 사 코딩테스트 문제
    // 공부 시간이 시작, 끝, 시작, 끝... 이렇게 주어지면
    // 105분 이상 공부한 건 105분으로 5분 미만 공부한 건 무시하는 걸 포함하여 총 공부시간을 구하는 것이다.
    // 시간 형식이 string "hh:mm"으로 주어져서 substring을 이용해 : 위치에서 끊어서 시간과 분을 구해서 int형식으로 계산하였다.
    // 시간과 분에 따라서 내림이나 올림이 있을 수 있기에 시간에 60을 곱해 총 분으로 계산하였다.
    // 그렇게 하여 총 분을 더한다.(단 조건문에 의해서 if - else로 5분 미만과 105분 초과하는 경우를 고려한다.)
    // 문제는 해결하였는데 string -> int -> string 으로 형 변환을 많이 하였다.
    // 형 변환 과정을 최대한 줄이려고 하였는데 시간 계산이다 보니 int로 바꿔야 계산이 편해졌고 return 형이 string이라서 형 변환을 줄이기는 힘들었다.

    public static void main(String[] args) {

        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
        int len = log.length/2;

        String[] start = new String[len]; // 시작 시간 모음
        String[] end = new String[len]; // 끝 시간 모음

        int startIdx = 0;
        int endIdx=0;
        for(int i=0;i<log.length;i++){ // 시작 끝 시작 끝 ... 반복되므로 i가 짝수면 시작 홀수면 끝 시간
            if(i % 2 == 0){ // 시작 시간을 start 배열에
                start[startIdx++] = log[i];
            }
            else{ // 끝 시간을 end 배열에
                end[endIdx++] = log[i];
            }
        }

        int[] studyTime = new int[len]; // 공부시간만 계산하기(시작시간과 끝 시간을 가지고)
        for(int i=0;i< len; i++){
            int startTime = 60 * Integer.parseInt((start[i].substring(0,2))) + Integer.parseInt(start[i].substring(3)); // 시작시각을 시간에 60 곱해서 분으로만 표현
            int endTime = 60 * Integer.parseInt((end[i].substring(0,2))) + Integer.parseInt(end[i].substring(3)); // 끝시간을 시간에 60곱해서 분으로만 표현

            studyTime[i] = (endTime - startTime); // 공부한 시간을 분으로 표현
        }

        int studyTimeSum = 0; // 전체 공부한 시간을 표현한 변수
        for(int N : studyTime){
            if(N >= 105){ // 공부시간이 1시간 45분 이상이면 1시간 45분으로 설정
                studyTimeSum += 105;
            }
            else if(N < 5){ // 5분미만이면 제외
                continue;
            }
            else{
                studyTimeSum += N;
            }
        }

        int hour = studyTimeSum / 60; // 전체 공부 시간의 시간
        int minute = studyTimeSum % 60; // 전체 공부시간의 분

        String[] answer = new String[5];
        if(hour < 10){ // 공부시간이 한자리면 앞에 0을 추가
            answer[0] = "0";
        }
        else{ // 공부시간이 2자리이상이면 몫을 넣고
            answer[0] = String.valueOf(hour/10);
        }
        answer[1] = String.valueOf(hour % 10);
        answer[2] = ":";
        if(minute < 10){ // 공부한 시간의 분이 10미만이면 앞에 0넣고
            answer[3] = "0";
        }
        else{ // 공부한 시간의 분이 10이상이면 10의자리 계산
            answer[3] = String.valueOf(minute/10);
        }
        answer[4] = String.valueOf(minute % 10); // 공부한 시간의 분 1의 자리 계산

        StringBuffer sb = new StringBuffer(); // answer 배열 합쳐서 반환
        for(String str : answer){
            sb.append(str);
        }
        //return sb.toString();
        System.out.println(sb.toString());
    }
}