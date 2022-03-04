import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        // 내일있을 software Maestro 코딩테스트를 대비해서 외부 IDE가 아닌
        // 코딩테스트 사이트 내에서 환경설정을 위해 문제를 해결해 보려고 했다.
        // 자동완성이나 자동 import 때문에 별로 보지 않던 부분을 다시 볼 수 있었다.
        // 나는 Scanner보다 BufferedReader를 좋아해서 BufferedReader를 사용하려는 데
        // BufferedReader는 java.util이 아닌 java.io를 사용해야 하고 IOException을 thorw 해줘야 하는 등
        // 자동완성이 아니라 스스로 구현해야 할 때 이것저것 체크해야 할 부분이 꽤 있었다.
//
//        import java.util.Scanner;
//        import java.io.*;
//
//        class Main {
//            public static void main(String args[]) throws IOException {
//                // String x;
//                // Scanner sc = new Scanner(System.in);
//
//                // x = sc.nextInt();
//                // System.out.println(x);
//
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//                String str = br.readLine();
//
//                int bomb = 0;
//                int razor = 0;
//                boolean flag = true;
//                for(int i=0;i<str.length();i++){
//                    if(str.charAt(i)== '('){
//                        bomb++;
//                    }
//                    else{
//                        razor++;
//                    }
//                }
//
//                if(bomb != razor) flag = false;
//
//                if(!flag) System.out.println("NO");
//                else System.out.println("YES");
//            }
//        }

//        insert into customer values (1,'Elice','2010-01-15',100);
//        insert into customer values (2,'Cheshire','2005-03-10',100);
//        insert into customer values (3,'Dodo','2010-04-30',100);
//
//        select * from customer;

        // animal_outs 테이블에 있는데 animal_ins 테이블에 없는 자료를 찾아서 출력하는 문제
        // join을 쓰는 건데 from 1번테이블 left outer join 2번테이블 이렇게 있을 때 1번 테이블을 기준으로 on 뒤의 컬럼으로
        // join을 실행하는 모습을 보인다.
        // join을 사용할 때 있지 않은 부분에 대해서 null을 반환하는 데 이를 사용해서 한쪽 테이블에 존재하지 않는다는 기준을 체크한다.
//        SELECT a.animal_id, a.name from animal_outs as a left outer join animal_ins as b
//        on a.animal_id = b.animal_id where b.animal_id is null order by a.animal_id;

    }
}
