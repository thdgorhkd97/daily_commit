import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 3053 택시 기하학
    // 코드는 진짜 아무것도 아닌건데 택시 기하학이라는 개념을 이해하는데 시간이 걸렸다.

    // 택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
    // D(T1,T2) = |x1-x2| + |y1-y2|
    // 두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.

    // 문제에서 제시는 이렇게 되어 있는데 이를 활용해서 반지름이 주어졌을 때 원의 넓이를
    // 구하는 게 이해가 되지 않아서 따로 개념을 찾아보았다.
    // 우리가 일반적으로 아는 원의 넓이는 pi * R * R 이다.
    // 그런데 문제의 택시기하학(맨해튼 거리와 같은 말)에서 원의 넓이를 살펴보면
    // 택시 기하학에서 두점 사이의 거리를 구하는 방식은 일직선과 같은 개념이기 때문에
    // 반지름이 3이라고 한다면 (-3,0),(0,3),(3,0),(0,-3) 을 일직선으로 연결한
    // 마름모꼴의 도형이 나오게 된다.
    // 즉 택시 기하학에서의 원의 넓이는 R인 반지름이 나오면 2 * R * R이 된다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int R = Integer.parseInt(br.readLine());

        System.out.println(R * R * Math.PI);
        System.out.println(2 * R * R);

    }
}
       /*
       while(true){
           String str = br.readLine();
           StringTokenizer stk = new StringTokenizer(str," ");

           int[] tri = new int[3];
           int idx = 0;
           tri[idx++] = Integer.parseInt(stk.nextToken());
           tri[idx++] = Integer.parseInt(stk.nextToken());
           tri[idx++] = Integer.parseInt(stk.nextToken());

           if(tri[0]==0 && tri[1] == 0 && tri[2] == 0){
               break;
           }

           is90(tri);
       }


   }

   public static void is90(int[] arr){
       Arrays.sort(arr);

       if(Math.pow(arr[2],2) == Math.pow(arr[0],2) + Math.pow(arr[1],2)){
           System.out.println("right");
       }
       else System.out.println("wrong");
   }
}*/