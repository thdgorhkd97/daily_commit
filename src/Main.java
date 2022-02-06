import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 1010 다리 놓기
    //

//    재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다.
//        (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
//    재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
//    다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.

    // 처음에 주어진 예시를 보면서 규칙을 생각해보니까 조합과 식이 똑같다는 생각이 들었다.
    // 그래서 조합의 공식인 n! / r!(n-r)! 을 계산하려고 했는데
    // 처음에 그냥 int로 했더니 29!은 범위를 넘었고 Long으로 했는데도 범위를 넘어섰다.
    // double로 처리하였고 Long이 범위가 넘은 것은 29! 계산하는 부분에서 터진 것 같아서 아예 29! * 16! (13,29 예시에서)
    // 부분을 아예 함수에서 처리하고서 return 하는 식으로 코드를 수정했다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<Double> list = new ArrayList<>();

        for(int i=0;i<T;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            double west = Integer.parseInt(stk.nextToken());
            double east = Integer.parseInt(stk.nextToken());


            System.out.printf("%.0f\n",howManySite(west,east,list));
        }

    }

    public static double howManySite(double west, double east, ArrayList<Double> list){
        double many = 0;

        many = Combination(west,east);

        return many;
    }

    public static double Combination(double west,double east){
        double number1 = 1;
        double number2 = 1;

        for(double i=east;i>east-west;i--){
            number1 *= i;
        }

        for(double i=west;i>=1;i--){
            number2 *= i;
        }

        return number1 / number2;
    }
}