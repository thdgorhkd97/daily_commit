import java.io.IOException;
import java.util.*;

public class Main {

    // programmers level 4 - 호텔 방 배정
//    1. 한 번에 한 명씩 신청한 순서대로 방을 배정합니다.
//    2. 고객은 투숙하기 원하는 방 번호를 제출합니다.
//    3. 고객이 원하는 방이 비어 있다면 즉시 배정합니다.
//    4. 고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다.
    // 효율성을 위해서 map을 활용해야 한다는 힌트를 얻었고 map에서 키값으로는 현재 방을
    // value값으로는 키에 해당하는 다음 비어있는 방을 넣어야 한다는 생각까지는 할 수 잇었다.
    // 그래서 구현을 하다 보니 처음으로 할당되는 경우 즉 키에 값이 존재하지 않는 경우에 대해서는
    // 구현할 수 있었다.( !map.containskey())를 활용하여
    // 근데 이미 있는 경우에 대해서 다음으로 비어있는 방의 번호를 map의 value로 집어넣는
    // 케이스를 구현하는 데서 꽤 애먹었다.
    // 처음에는 반복문을 구현해서 map의 키에 없는 값(비어있는 방)을 찾아야 하나 싶었는데
    // 그렇게 해도 효율성에서 완벽히 통과하지 못했다.
    // 결론적으로는 재귀적으로 구현해서 다음 비어있는 방을 찾아서 map의 value에 넣고
    // key 값에 따라서 찾는 것이 이상적이다.

    static Map<Long,Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        long k = 10;
        long[] room_number = {1,3,4,1,3,1};

        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = assignRoom(room_number[i]);
        }

//         return answer;

    }

    private static long assignRoom(long wantRoomNumber) {

        if(!map.containsKey(wantRoomNumber)){ // map에 할당되지 않은 방이라면
            // 처음으로 원하는 사람이라는 뜻이므로
            map.put(wantRoomNumber, wantRoomNumber+1); // +1(다음 방)을 해서 value에 넣고
            return wantRoomNumber; // 그대로 원하는 방을 할당한다.
        }

        // 이미 그 방에 사람이 있는 상태라면
        long nextRoom = assignRoom(map.get(wantRoomNumber));
        // 다음 비어있는 방을 할당한다.
        map.put(wantRoomNumber,nextRoom);
        return nextRoom;
    }
}
