import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // w 사 3번 코딩테스트 문제
    // 각 메뉴별로 들어가는 재료값과 메뉴의 가격을 비교하여 총 이익을 구하는 문제
    // 메뉴에 들어가는 재료를 charAt 으로 구해서 각 재료값을 모두 구하고 이를 메뉴값과 비교한다.
    // hash를 활용하여 메뉴별 이익금을 구하고
    // 마지막에 합한다.
    // 조금 노가다 성으로 푼 것 같은데 각 메뉴명만 보고 들어가는 재료를 구할 수 없기 때문에
    // 괜찮은 방법이라고 생각한다.

    public static void main(String[] args) {

        int answer = 0;

        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
        String[] menu = {
                "PIZZA arraak 145",
                "HAMBURGER tkar 180",
                "BREAD kkk 30",
                "ICECREAM rar 50",
                "SHAVEDICE rar 45",
                "JUICE rra 55",
                "WATER a 20"};

        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        HashMap<Character, Integer> jaeryo = new HashMap<>();

        String[] material = new String[2];
        for(int i=0;i<ings.length;i++){
            material = ings[i].split(" ");
            jaeryo.put(material[0].charAt(0),Integer.parseInt(material[1]));
        }

        HashMap<String, Integer> menuProfit = new HashMap<>();

        int profit = 0;
        String[] menuInfo = new String[3];
        for(int i=0; i< menu.length;i++){
            menuInfo = menu[i].split(" ");

            int materialValue = 0;
            String str = menuInfo[1];
            for(int j=0;j<str.length();j++){
                materialValue += jaeryo.get(str.charAt(j));
            }

            profit = Integer.parseInt(menuInfo[2]) - materialValue;
            menuProfit.put(menuInfo[0],profit);
        }

        String[] selling = new String[2];
        for(int i=0;i<sell.length;i++){
            selling = sell[i].split(" ");

            answer += Integer.parseInt(selling[1]) * menuProfit.get(selling[0]);
        }

        System.out.println(answer);

    }
}