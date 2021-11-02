import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // map에서 number에 해당하는 원소들을 지워가는 빙고 게임에서 몇 줄을 지우는지를 리턴하라.
    // 커뮤러닝에서 예시문제였는데 해결을 못해서 다시 해보기로 하였다.
    // 구현은 잘 했는데 효율성을 확인해 볼 수 없어서 효율성은 모르겠다.
    // 근데 코드를 리팩토링 하는 거에 대해 고민했는데
    // 아예 로직을 바꾸지 않는 한 내가 생각한 방법에서는 더 빠르게 할 수 있는 방법은 없는 것 같다.
    //

    public static void main(String[] args) {

        int[][] map = {{1,9,10,11},{2,8,16,12},{13,3,6,7},{14,4,5,15}};
        int[] number = {4,8,5,9,11,16,14,2,3,6,13,1};

        for(int n : number){
            for(int i=0;i<map.length;i++){
                for(int j=0;j< map.length;j++){
                    if(map[i][j] == n){
                        map[i][j] = 0;
                        break;
                    }
                }
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j< map.length;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("garo : " + garo(map));
        System.out.println("sero : " + sero(map));
        System.out.println("daegak : " + daegak(map));


   }

   public static int garo(int[][] map){
        int result = 0;
        boolean flag = false;
        for(int i=0;i<map.length;i++){
            flag = false;
            for(int j=0;j<map.length;j++){
                if(map[i][j] != 0){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        return result;
   }

   public static int sero(int[][] map){
        int result = 0;
        boolean flag = false;
        for(int i=0;i<map.length;i++){
            flag = false;
            for(int j=0;j<map.length;j++){
                if(map[j][i] != 0){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        return result;
   }

   public static int daegak(int[][] map){
        int result = 0;
        int i=0;
        int j=0;
        boolean flag = false;
        while(i <= map.length-1 && j<=map.length-1){
            if(map[i][j] != 0){
                flag = true;
                break;
            }
            i++;
            j++;
        }
        if(!flag) result++;

        flag=false;
        i=map.length-1; j=0;
        while(i >= 0 && j<=map.length-1){
            if(map[i][j] != 0){
                flag = true;
                break;
            }
            i--;
            j++;
        }
       if(!flag) result++;

       return result;
   }


}