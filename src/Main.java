package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.IOException;
import java.util.*;

/*
2022 - 06 - 04 < 송해광 >
열심히 주석달고 최대한 메소드로 빼서 코드 자체를 직관적으로 이해할 수 있게 했습니다.
다만 이게 좋은가 싶은 부분이 꽤 있었습니다.
1. 처음에 season을 month에 의해 구별해야 했는데 이렇게 구한 season을 가지고 if-else로
   봄/여름 인지 가을/겨울인지 확인하는 식으로 했는데 이 방법과 아예 month를 받아서 GetSeason
   함수를 부르는 방법 중 어떤게 나을까요?

2. main의 for문을 돌면서 어느 날 어떤 과일이 나오는지 직관적으로 알기 위해 메소드로 따로 구현했는데
   이렇게 하니 메소드 내부의 로직이 겹치는 것 같은데 그냥 for문 자체에서 출력하는 게 나을지 여쭤보고 싶습니다.
 */

public class Main {

    public static void main(String[] args) throws IOException {

        int month = 3; // 디저트 구매요청 월
        int numOfSoldier = 70; // 군인 수

        String season = ""; // 계절 ( 봄/여름? or 가을/겨울? )
        season = GetSeason(month); // 월에 따른 계절 확인

        int[] howManyFruitRequire = new int[2]; // 군인 수에 따른 필요 과일 수
        howManyFruitRequire = calculateFruitCnt(season,numOfSoldier); // 계절과 군인 수에 따른 과일 필요 수량 계산

        System.out.println(month + "월 디저트 구매내역서 (총 " + numOfSoldier + "명)");

        int daysPerMonth = 30; // 월은 30일까지만 있는 것으로 가정
        for(int i=1;i<=daysPerMonth;i++){
            int endDays = i % 10; // 일의 일의 자리수 ( ex 10일 -> 0, 15일 -> 5)
            switch (endDays){
                case 1,5 : provideStrawberryOrApple(howManyFruitRequire[0],season,month,i); break;
                case 3,7 : provideWatermelonOrPear(howManyFruitRequire[1],season,month,i); break;
                default:
                    System.out.println(month +"월 " + i+"일 : -");
                    break;
            }
        }

    }

    private static void provideWatermelonOrPear(int numberOfFruit,String season,int month,int day) {
        if(season.equals("Spring/Summer")){
            System.out.println((month +"월 " + day+"일 : 수박 " + numberOfFruit +"개"));
        }
        else{
            System.out.println((month +"월 " + day+"일 : 배 " + numberOfFruit +"개"));
        }
    }

    private static void provideStrawberryOrApple(int numberOfFruit,String season,int month,int day) {
        if(season.equals("Spring/Summer")){
            System.out.println((month +"월 " + day+"일 : 딸기 " + numberOfFruit +"개"));
        }
        else{
            System.out.println((month +"월 " + day+"일 : 사과 " + numberOfFruit +"개"));
        }
    }

    private static int[] calculateFruitCnt(String season, int numOfSoldier) {
        int[] fruitCnt = new int[2]; // 반환할 변수( fruitCnt[0] = 딸기 or 사과의 개수, fruitCnt[1] = 수박 or 배의 개수)
        if(season.equals("Spring/Summer")){ // 봄/여름 계절이라면 딸기/수박
            fruitCnt[0] = 5 * numOfSoldier; // 딸기는 1명당 5개 제공
            fruitCnt[1] = (int) Math.ceil(numOfSoldier / 10.0); // 수박은 11명에게는 2개 제공해야 하므로 ceil로 올림처리하여 계산

        }
        else{ //season.equals("Fall/Winter") 가을/겨울 계절은 사과/배
            fruitCnt[0] = numOfSoldier; // 사과는 1명당 1개 제공
            fruitCnt[1] = numOfSoldier / 2; // 배는 2인에 하나 제공
        }
        return fruitCnt;
    }

    private static String GetSeason(int month) {
        if(3<=month && month <= 8){ // 3~8 월은 봄/여름
            return "Spring/Summer";
        }
        else return "Fall/Winter"; // 9~2월은 가을/겨울
    }

}