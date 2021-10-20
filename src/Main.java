import java.util.*;

public class Main {

    // programmers level 2 - 멀쩡한 사각형
    // 코드는 매우 간단하지만 공식을 구하는 게 어려웠다.
    // w와 h가 주어질 때 대각선으로 관통하는 직선을 그어서 멀쩡한 사각형을 구하는 문제였다.
    // 최대공약수를 활용해야 하는 건 알았는데 모든 상황에서 활용될 수 있는 공식을 구하기
    // 어려워서 뭔가 조금씩 오류가 나서 풀이법을 조금 찾아보고 해결했다.
    // (전체 크기) - (한 패턴 직사각형 당 사용하지 못하는 정사각형 크기 * 반복횟수)
    // 패턴 직사각형은 가로로 2 세로로 3인 직사각형을 의미하는데 이렇게 반복되는
    // 최소 크기를 고려하는 식으로 생각했어야 하는 것 같다.

    public static void main(String[] args) {

        int w = 8;
        int h = 12;

        int gcd = gcd(w,h); // 최대공약수

        System.out.println(((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd));

    }

    public static int gcd(int w, int h){
        int small = Math.min(w,h);
        while(true) {
            if (w % small == 0 && h % small == 0) {
                return small;
            }
            small -= 1;
        }
    }

}