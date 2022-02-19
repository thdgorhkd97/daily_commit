import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // devcourse 백엔드 코딩테스트 2번문제
    // push 되는 string의 share / comment 가 일치하게 되면
    // 인원수에 따라 push 되는 string을 따로 구분해야 하는데 이 부분을 어떻게 처리할까 고민하다가
    // 시간이 많이 소모 되었다 ㅠㅠㅠ
    // 그래서 결국 모든 push 되는 string을 저장해 두었다가 push 되는 조건이 일치하게 되면
    // push되는 string을 변경함으로써 조건을 맞추는 작업을 추가했다.

    public static void main(String[] args) throws IOException {

        String[] records = {
                "john share",
                "mary comment",
                "jay share",
                "check notification",
                "check notification",
                "sally comment",
                "james share",
                "check notification",
                "lee share",
                "laura share",
                "will share",
                "check notification",
                "alice comment",
                "check notification"};

        Stack<String> alarm = new Stack<>();
        Stack<String> savings = new Stack<>();

        for(int i=0;i< records.length;i++){
            String name = records[i].substring(0,records[i].indexOf(" "));
            String category = records[i].substring(records[i].indexOf(" ") + 1);

            if(alarm.isEmpty()){ // 스택이 비어있으면
                alarm.push(records[i]);
            }
            else if(records[i].equals("check notification")){ // 보관함으로 이동
                savings.push(alarm.pop());
            }
            else{
                String prev = alarm.peek();
                String prevName = prev.substring(0,prev.indexOf(" ")); // 이전 이름
                String prevCategory = prev.substring(prev.indexOf(" ") + 1); // 이전 comment ? share ?

                String together = "";
                if(prevCategory.equals(category)){
                    together = prevName + "&&" + name;
                    alarm.pop();
                    alarm.push(together+" "+prevCategory);
                }
                else{
                    alarm.push(records[i]);
                }
            }
        }


        String[] answer = new String[savings.size()];
        int idx = 0;
        for(String str : savings){

            String people = str.substring(0,str.indexOf(" ")); // 같은 카테고리를 가지는 사람을 && 으로 구분한 문자열
            String category = str.substring(str.indexOf(" ") + 1); // 어떤 카테고리?
            String[] person = people.split("&&"); // 같은 카테고리를 가지는 사람 수

            StringBuffer save = new StringBuffer();

            if(person.length == 1){ // 1명 일때
                save.append(person[0]);
            }
            else if(person.length == 2){ // 2명 일때
                String appned = person[0] + " and " + person[1];
                save.append(appned);
            }
            else{ // 3명 이상이면 맨 앞사람 + n 명
                String append = person[0] + " and " + String.valueOf(person.length-1) + " others";
                save.append(append);
            }

            if(category.equals("share")){
                save.append(" shared your post");
            }
            else if(category.equals("comment")){
                save.append(" commented on your post");
            }


            answer[idx++] = save.toString();
        }


        /*
        while(!savings.isEmpty()){
        System.out.println(savings.pop());
        }
        */

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }






    }
}