import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 특별 모의고사 2번
    // 10분 간격으로 오는 고객들 중 booked 에 있는 고객을 먼저 대한다.
    // 예약을 한 고객과 안 한 고객으로 hash를 만들어서 관리하고자 하였다.
    // 이때 시간을 10분씩 더하면서 확인한건데
    // 내 생각으로는 10분을 더한 시간까지 book 고객을 확인하고 다시 unbook 고객을 확인하면
    // book 고객이 먼저 들어가고 그 뒤에 unbook 고객이 들어간다고 생각했는데
    // 지금10 분내에 예약 고객과 예약 안 한 고객이 같이 있는 경우가 에러가 발생한다...


    public static void main(String[] args) {

        String[][] booked = {{"09:55", "hae"}, {"10:05", "jee"}};
        String[][] unbooked = {{"10:04", "hee"}, {"14:07", "eom"}};

        HashMap<String, Integer> book = new HashMap<>();
        HashMap<String, Integer> unbook = new HashMap<>();
        int startTime = 0;
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<booked.length;i++){
            book.put(booked[i][1],Integer.parseInt(booked[i][0].substring(0,2)) * 60 + Integer.parseInt(booked[i][0].substring(3)));
        }
        for(int i=0;i< unbooked.length;i++){
            unbook.put(unbooked[i][1],Integer.parseInt(unbooked[i][0].substring(0,2)) * 60 + Integer.parseInt(unbooked[i][0].substring(3)));
        }

        if(book.get(booked[0][1]) < unbook.get(unbooked[0][1])){ // 첫 손님이 booked의 첫 손님
            startTime = (book.get(booked[0][1]));
            list.add(booked[0][1]);
            book.remove(booked[0][1]);
        }
        else{
            startTime = (unbook.get(unbooked[0][1]));
            list.add(unbooked[0][1]);
            unbook.remove(unbooked[0][1]);
        }

        while(!book.isEmpty() && !unbook.isEmpty()){

            startTime += 10;

            for(String str : book.keySet()){
                if(book.get(str) <= startTime){
                    list.add(str);
                    book.remove(str);

                }
            }

            for(String str : unbook.keySet()){
                if(unbook.get(str) <= startTime){
                    list.add(str);
                    unbook.remove(str);
                }
            }

            if(book.isEmpty()){
                for(String str : unbook.keySet()){list.add(str);break;}
            }
            if(unbook.isEmpty()){
                for(String str : book.keySet()){list.add(str);break;}
            }

        }

        String[] answer =  new String[list.size()];
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            answer[i] = list.get(i);
        }

   }
}