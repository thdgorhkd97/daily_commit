import java.io.IOException;
import java.util.*;

public class Main {

    // programmers level 4 - 호텔 방 배정
    // 가장 먼저 드는 생각으로 코딩하면 런타임 에러가 발생한다.
    // 근데 문제를 해결하는 과정에서 한 가지 의문이 들었다. long[]으로 선언한 배열에
    // 인덱스를 (int)로 캐스팅해야만 해야 하는 게 왜 그럴까 싶었다.
    // 우선 자바의 배열의 최대 크기는 JVM에 따라 다를 수 있으며
    // 어플리케이션에 사용 가능한 메모리 양과 색인을 생성할 수 있는 최대요소라는 2가지 한계가 있다.
    // long 형으로 선언했다하더라도 배열의 색인으로는 int 를 받아야 한다.
    // 즉 for문에서 long 형으로 선언한 i를 색인에 넣으면 (int)로 cast 해줘야 한다.

    public static void main(String[] args) throws IOException {

        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        long[] answer = new long[room_number.length];

        boolean[] check = new boolean[room_number.length+1];

        /* 런타임 에러가 발생하는 코드
        for(long i=0;i< room_number.length; i++){
            if(!check[(int) room_number[(int) i]]){
                answer[(int) i] = room_number[(int) i];
                check[(int) room_number[(int) i]] = true;
            }
            else{
                long idx = room_number[(int) i] + 1;
                while(true){
                    if(!check[(int) idx]){
                        answer[(int) i] = idx;
                        check[(int) idx] = true;
                        break;
                    }
                    else idx++;

                }
            }

        }*/


    }
}
