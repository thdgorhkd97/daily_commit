package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

public class Main {

    // java programmers level 2 숫자 블록
    // 문제에서 조건을 찾아내서 최대값에 대한 부분도 체크했고 road를 기반으로
    // 크기에 대한 부분도 begin과 end에 대한 걸로 잘 해서
    // 시간을 최대한 줄인 것 같은데 시간초과가 발생한다...
    // 정확성은 모두 맞기에 효율성만 신경 쓰면 되는데
    // 크기를 처음에는 전체로 했다가 문제의 최대값을 파악해서 최대값을 줄이고
    // 그 후에는 answer를 그냥 크게 하는 것이 아니라 구해야 하는 구간이 end - begin + 1 이기 때문에
    // answer의 크기를 줄이고 하는 식으로 메모리와 시간을 생각했는데 어느 부분이 부족한 것인지...

    public static void main(String[] args) throws IOException {

        long begin = 1;
        long end = 10;

        int b = (int) begin;
        int e = (int) end;

        int[] road = new int[(int) (e+1)];

        for(int i=1;i<=e;i++){

            int idx = 2;
            while(idx * i <= e){
                road[ (idx * i)] = i;
                idx++;
            }
        }

        int[] answer = new int[ (e-b+1)];

        int idx = 0;
        for(int i=b;i<=e;i++){
            answer[idx++] = road[i];
        }

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] + " ");
        }



    }
}