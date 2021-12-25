import java.util.*;

public class Main {

    // B 사 코딩테스트 6번 문제
    // 월요일과 금요일의 정해진 출퇴근 시간이 주어지면 여행지와 해당 여행지를 갈때 소모되는 휴가시간을
    // 최대로 사용할 수 있는 경로를 구하라.
    // 여행지별로 사용되는 휴가 시간을 map으로 넣어서 비교했다.
    // 그 후에 사용되는 휴가 시간을 정렬하여 가장 휴가 시간을 잘 활용할 수 있는 여행지를 골라서
    // 정답으로 선정한다.
    // 이때 am과 pm으로 시간이 나누어지기 때문에 각각 am과 pm일 때를 구분하고
    // string으로 주어지는 시간을 계산하여 int로 비교했다.
    // 문제 자체를 해결하는 데는 큰 어려움은 없었다고 생각한다.
    // 근데 문제에서의 조건을 조금 놓친 건 아닐까 싶은 생각도 있다.
    // 휴가 시간을 잘 활용하는 마지막 경로를 찾아야 하고 월요일 오전과 금요일 오후를 따로
    // 계산해서 시간을 계산하는 방식이 조금 번거로웠다.

    public static void main(String[] args) {

        String[][] plans = {{"홍콩","06:45 am"},{"일본","10:10 pm"}};
        int time = 75;


        HashMap<String, Double> map = new HashMap<>(); // 도시=키 / 도시로 출발할 때 사용하는 휴가시간을 value

        for(int i=0;i<plans.length;i++){
            int startTime = 0; // 출발 시간에 관한 변수
            map.put(plans[i][0],0.0); // 해시에 도시명을 키로 해서 저장
            if(plans[i][1].contains("P")) { // 출발 시간이 PM이면
                startTime = Integer.parseInt(plans[i][1].substring(0, plans[i][1].indexOf("P")));
                // P 이전의 숫자(시간) 을 startTime 변수에 지정
                if(startTime < 6){ // 만약 6시 이전에 출발하면 휴가 시간을 사용하는 것이니까 map 갱신
                    map.put(plans[i][0],map.get(plans[i][0])+(double)6-startTime);
                }
            }
            else{ // 출발 시간이 AM이면
                startTime = Integer.parseInt(plans[i][1].substring(0, plans[i][1].indexOf("A")));
                if(startTime > 9.5){ // 9시 반 넘어서 출발하면 12 ~ 6시까지의 6시간과 (12-startTime) 오전 빼는 시간을 더해야 한다.
                    map.put(plans[i][0],map.get(plans[i][0])+(double)6+12-startTime);
                }
                else{ // 9시 이전에 출발하는 거면 금요일을 통째로 안 가니까 8.5시간을 더한다.
                    map.put(plans[i][0],map.get(plans[i][0])+(double)8.5);
                }
            }

            int arriveTime = 0; // 도착시간에 대한 변수
            if(plans[i][2].contains("P")) { // 월요일 오후에 도착하면
                arriveTime = Integer.parseInt(plans[i][2].substring(0, plans[i][2].indexOf("P")));
                if( arriveTime < 6 && arriveTime > 1){ // 월요일은 1시 출근이므로 1시에서 넘은 만큼 휴가 시간 사용
                    map.put(plans[i][0],map.get(plans[i][0])+(double)arriveTime-1);
                }
                else if(arriveTime >= 6){ // 만약 퇴근 시간을 지나서 왔다면 월요일 근무시간인 5시간 제외
                    map.put(plans[i][0],map.get(plans[i][0])+(double)arriveTime-5);
                }
            }
            // 월요일 오전에 도착하면 휴가 시간을 제외하지 않으니까 else문은 필요 없다.
        }

        String answer = "";
        ArrayList<Double> list = new ArrayList<>();
        for(String str : map.keySet()){
            if(map.get(str) <= time) { // 휴가 시간 내의 휴가지를 모두 선택
                list.add(map.get(str));
            }
        }
        Collections.sort(list,Collections.reverseOrder()); // 정렬
        for(String str : map.keySet()){
            if(map.get(str) == list.get(0)){ // 휴가 시간을 가장 잘 활용하는 여행지 선택(올해의 마지막 여행이므로)
                answer = str;
            }
        }
//        return answer;


    }
}
