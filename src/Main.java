import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // B사 코딩테스트
    // {1,1,1,0,0} -> {1,0,1,0,1}
    // {0,1,1,1,0,0,0,0,1} -> {0,1,0,1,0,1,0,0,1}
    // 1과 1사이에 0을 둬야 하고 1을 앞으로 당기지 않는다.

    // 금일 코딩테스트를 하면서 접했던 문제인데 확실치 않아 다시 풀어보았다.
    // 테스트 케이스는 모두 통과하는데 내가 해본 테스트는 모두 통과하는데
    // 수많은 테스트를 넣어본 게 아니라서 100퍼센트 완벽한지는 확실하지 않다
    // 코드 자체는 간단하지만 ArrayList를 활용하다가 index를 고치다가 등등
    // 시간을 상당히 많이 잡아먹었던 문제다.

    // programmers 사이트에서 진행하다 보니 오류가 났을 때 어디서 오류가 난 건지 확인이
    // 불가능했고 코드를 짤때 인덱스와 범위, loop에 대해서 유의하면서 지속해야겠다.

    public static void main(String[] args) {

        int[] arr = {0,1,1,1,0,0,0,0,1};

        int pos=0;
        for(int i=pos;i<arr.length-1;i++){
            if(arr[i] == 1 && arr[i+1] == 1){
                arr[i+1] = 0;
                pos = i+2;
                while(pos<arr.length && arr[pos] == 1){
                    pos++;
                }
                arr[pos] = 1;
                i = pos-2;
            }
            System.out.println(i);
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }


    }
}