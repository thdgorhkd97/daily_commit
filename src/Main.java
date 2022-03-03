import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    // java 9095 1,2,3 더하기

    // dp가 아닌 완전 탐색 방법으로 해결하는 경우
    // 재귀를 통해서 특정 수가 되면 답에 +1 하고 특정 수를 넘어서면 해당 케이스를 종료한다.
    // 근데 이게 재귀를 통해서 할 때 재귀의 종료 조건을 어떻게 걸어야 하나 고민을 많이 했다.
    // 더해나가다가 타겟 넘버를 넘어서면 종료하면 되는 것이었고
    // 1,2,3을 차례로 계속 더해나가면서 재귀를 통해서 구현하면 되는 건데.. 재귀는 해도해도 참..

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());

            System.out.println(OneTwoThree(0,n));

        }

    }

    private static int OneTwoThree(int number, int n){
        if(number > n){
            return 0;
        }

        if(number == n){
            return 1;
        }

        int cnt = 0;
        for(int i=1;i<=3;i++){
            cnt += OneTwoThree(number + i,n);
        }

        return cnt;
    }
}


//    중복제거할 때 distinct 를 사용하는데
//    select distinct count(name) 이렇게 썼는데 괄호 안에 넣어 주어야 한다.
//    SELECT count(distinct name) from animal_ins;

//    group by 순서를 from 앞에 둬서 실패했었다.
//    문법은 얼추 아는 데 순서를 헷갈리거나 위치가 확실하지 않은 경우가 꽤 있다.
//    select animal_type, count(*)
//    from animal_ins group by animal_type order by animal_type;
//    < select -> from -> where -> group by -> having -> order by >