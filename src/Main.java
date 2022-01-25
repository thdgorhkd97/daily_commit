import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1436 영화감독 숌숌

//    종말의 숫자란 어떤 수에 6이 적어도 3개이상 연속으로 들어가는 수를 말한다.
//    제일 작은 종말의 숫자는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 과 같다.
//
//    따라서, 숌은 첫 번째 영화의 제목은 세상의 종말 666, 두 번째 영화의 제목은 세상의 종말 1666 이렇게 이름을 지을 것이다.
//    일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 숫자) 와 같다.
//
//    숌이 만든 N번째 영화의 제목에 들어간 숫자를 출력하는 프로그램을 작성하시오.

    // 666이 들어가는지를 문자열로 바꾸고 contains로 확인한다.
    // 그 666이 들어가는 숫자가 몇 번째 숫자인지 확인하고 그 숫자의 순서가 알고자 하는 순서와 같다면
    // 그 숫자를 출력한다. (근데 이 방법은 소위 말해 노가다 방법이기 때문에 조금 효율적인 방법이 뭐가 있을까 찾아보았다)

    // 인터넷의 가장 일반적인 방법으로는 자릿수를 나눠서 계산하는 방식이다
    // 예를 들어 맨 앞자리가 몇 인지를 확인하고 순서를 계산한다. 다만 이때 맨 앞자리가 6이라면
    // 666으로 시작하는 경우가 있기 때문에 0~9까지를 카운트한다.
    // 이런 방식인건데 이 방법도 개발자가 가능한 케이스를 모두 계산해서 앞자리의 숫자에 따라
    // 가능한 케이스를 모두 계산해서 프로그래밍해야 하기 때문에 더 나은 방법이 확실한가는 솔직히 잘 모르겠다..

   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        while(true){
            if(String.valueOf(num).contains("666")){
                if(N == idx){ // 이 조건을 if로 확인하지 말고 while문의 조건으로 빼자
                    break;
                }
                idx++;
            }
            num++;
        }*/

        int num = 666;
        int idx = 1;
        while(idx != N){

            num++;
            if(String.valueOf(num).contains("666")){

                idx++;
            }

        }

        System.out.println(num);

    }

}