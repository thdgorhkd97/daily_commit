import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // L사 코딩테스트 1번 문제
    // 1번문제면 가장 쉬운 문제였을 텐데 예상보다 시간을 많이 썼던 문제라서 다시 한 번 체크해보려 한다.
    // 문제 자체는 심플했다. 주어진 로그 문자열에 대해서 조건에 맞는 입력인지 파악해서 알맞지 않은 로그의 수를 반환한다.
    // 조건은 여러가지가 있다.
    // 1. 특정 이름을 포함하지 않는경우
    // 2. 공백으로 시작하는 경우
    // 3. 로그의 길이가 100을 넘는 경우
    // 4. 특정 이름에 대한 내용에 공백이 있는 경우(indexOf를 활용한 위치를 기준으로 substring으로 잘라서 구별했다)
    // 5. 특수문자나 숫자를 포함하는 경우
    // 이렇게 5가지 조건을 봐야 하는데 4번에서 substring으로 자르는 건 그리 어렵지 않았는데 5번에서 처음엔 정규표현식을
    // 잘못 표현해서 특수문자나 숫자를 포함하지 않을 때를 체크한 것 같다.

    public static void main(String[] args) throws IOException {


        String[] logs = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};

        int answer = 0;

        String teamName = "";
        String applicationName = "";
        String errorLevel = "";
        String Message = "";

        for(String str : logs){
            System.out.print(str + " ");

            if(!(str.contains("team_name") && str.contains("application_name") && str.contains("error_level") && str.contains("message")) || (str.charAt(0)==' ') || (str.length() >= 100)){
                System.out.println(" 4가지 중 하나가 없다");
                answer++;
            }

            else {
                //System.out.println(str +  " "+str.indexOf("team_name") + " " + str.indexOf("application_name") + " " +str.indexOf("error_level") + " "+str.indexOf("message") + " ");

                teamName = str.substring(12,str.indexOf("application_name")-1);
                applicationName = str.substring(str.indexOf("application_name")+19,str.indexOf("error_level")-1);
                errorLevel = str.substring(str.indexOf("error_level")+14,str.indexOf("message")-1);
                Message = str.substring(str.indexOf("message")+10);

                // System.out.println("teamName = " + teamName + " applicationName = " + applicationName + " errorLevel = " + errorLevel + " Message = " + Message);

                if(teamName.contains(" ") || applicationName.contains(" ") || errorLevel.contains(" ") || Message.contains(" ")){
                    answer++;
                    System.out.println(" 자른거에 공백을 포함합니다");

                }else{
                    teamName = teamName.replaceAll("[^a-zA-Z]","&");
                    applicationName = applicationName.replaceAll("[^a-zA-Z]","&");
                    errorLevel = errorLevel.replaceAll("[^a-zA-Z]","&");
                    Message = Message.replaceAll("[^a-zA-Z]","&");


                    if(teamName.contains("&") || applicationName.contains("&") || errorLevel.contains("&") || Message.contains("&")){
                        answer++;
                        System.out.println(" 특수문자나 숫자가 포함되네요 ");

                    }
                }

            }
        }

        System.out.println(answer);




    }
}
