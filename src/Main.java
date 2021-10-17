import java.util.*;

public class Main {

    // programmers level 2 - n^2 배열 자르기
    // 배열을 만드는 방식에서 문제처럼 i행 i열까지 비어있는 칸을 i로 채운다는 방식 말고
    // 행이나 열중에서 최대값+1이라는 방식으로 채우는 것이 좋다
    // 그 이유는 문제에서 주어지는 n의 형식이 int형이기 때문에
    // long으로 주어지는 left, right와 호환이 불가능해서 long형 list에
    // left ~ right 범위에 해당하면 행과 열만 알면 값을 넣을 수 있어야 하기 때문이다.

    // 메모리 이슈로 고생했던 문제다.
    // int로 주어지는 상수를 가지고 long 의 범위를 다뤄야 해서 고생을 많이 했는데
    // return 형을 List<Long>으로 바꾸고 문제에서 주어지는 조건에만 따르는 것이 아니라
    // 배열을 채우는 규칙을 다시 찾은 것( 행렬중에서 max값 + 1)
    // 행렬로 규칙을 찾았으니 행렬의 기준만을 가지고 값을 채운 것으로 해결할 수 있었다.

    public static void main(String[] args) {

        long left = 2;
        long right = 5;
        int n = 3;

        List<Long> list = new ArrayList<>();

        // 00=1   01=2  02=3
        // 10=2   11=2  12=3
        // 20=3   21=3  22=3 -> 행이나 열중에서 최대값 + 1 이다.

        for(long i=left; i<=right; i++){
            list.add(Math.max(i/n,i%n) + 1); // 여기를 i를 가지로 행 열을 표현할 수 있으면 해결 가능하다.
            // 행렬이 n X n 이기 때문에 행은 i/n으로 표현가능하고 열은 i%n이다.
            // 이때 배열의 인덱스는 0부터 시작하므로 +1을 해줘야 순서와 맞는다.
        }



        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }


    }
}