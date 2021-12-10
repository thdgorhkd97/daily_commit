import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 기지국 설치
    // 내가 한 방식과 일반적인 풀이 방식에 차이가 있어서 2가지 방법을 사용해 보았다.(나는 50% 정도 였고 풀이방식은 참고해서 다시 했다.)
    // 풀이 방식은 idx와 pos을 활용해서 모든 아파트를 지나치면 끝나는 방식을 활용하여 인덱스를 통해 종료조건을 걸었고
    // 나는 boolean[] 배열을 활용해서 모두 true로 바뀌었는지를 확인했다.(인덱스 활용 방식이 메모리, 시간 측에서 이득이다.)
    // 풀이방식과 나의 방식 중 가장 큰 차이점은 stations[] 배열에 미리 주어지는 설치 지점들을 별도의 변수를 활용해서
    // 특정 조건일 때만(설치된 기지국을 지나가야 할 때) 인덱스를 더해가는 식으로 처리한 것이다.
    // 즉, 전체 아파트를 순회하는 변수와 미리 설치된 기지국을 확인하는 변수를 따로 관리하는 것이 포인트였다.

    public static void main(String[] args) {

        int n = 16;
        int[] stations = {9};
        int w = 2;

        int answer = 0;
        int pos = 1;
        int idx = 0;


        while(pos <= n){

            if(idx < stations.length&&pos >= stations[idx] - w){
                pos = stations[idx] + w + 1;
                idx++;
            }
            else{
                answer++;
                pos += 2*w + 1;
            }
        }

        System.out.println(answer);

        /*
        boolean[] check = new boolean[n+1];

        for(int i=0;i<stations.length;i++){
            for(int j=stations[i]-w;j<=stations[i]+w;j++){
                check[i] = true;
            }
        }

        int pos = 1;

        while(pos < n+1){
            if(!check[pos]){
                for(int i=pos;i<pos+2*w;i++){
                    if(i > n){
                        break;
                    }
                    check[i] = true;
                }
                answer++;
                pos = pos + 2 * w + 1;
            }
            pos++;
        }

        System.out.println(answer);
        */



    }
}