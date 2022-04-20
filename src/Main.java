import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 메뉴 리뉴얼
    // int[] course에 해당하는 길이만큼 순열을 구해서
    // 순열로 구해진 문자열을 orders에 포함되는지를 구했는데
    // 문제가 원하는 조건과 다른 것인지 해답이 되지 않는다.
    // 가능한 모든 조합을 구하는 것이라면 내가 한 방식이 맞을 텐데 아마 고객이 원하는
    // 조건에 대해서 따로 생각해야 하는 게 있는 것 같다..

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};

        Arrays.sort(orders,(Comparator.comparingInt(String::length)) );

        Set<String> set = new HashSet<>();
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i=0;i<orders.length;i++){
            for(int j=0;j<orders[i].length();j++){
                if(set.add(String.valueOf(orders[i].charAt(j)))){
                    arrayList.add(String.valueOf(orders[i].charAt(j)));
                }
            }
        }

        Collections.sort(arrayList);
        String[] str = new String[arrayList.size()];
        for(int i=0;i< arrayList.size();i++){
            str[i] = arrayList.get(i);
        }

        ArrayList<String> answer = new ArrayList<>();

        for(int i=0;i<course.length;i++){
            int r = course[i];
            String[] result = new String[r];
            int depth = 0;
            int startIdx = 0;
            combination(str,result,depth,r,startIdx);

            for(int j=0;j<list.size();j++){
                String string = list.get(j);
                int cnt = 0;

                for(int a=0;a<orders.length;a++){
                    boolean contain = true;

                    for(int b=0;b<string.length();b++){
                        if(!orders[a].contains(String.valueOf(string.charAt(b)))){
                            contain = false;
                            break;
                        }
                    }

                    if(contain) cnt++;
                }

                if(cnt >= 2) answer.add(string);
            }
            list.clear();
        }

        String[] ans = new String[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i] = answer.get(i);
        }

    }
    private static void combination(String[] str,String[] result,int depth,int r,int startIdx){
        if(depth == r){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i< result.length;i++){
//                System.out.print(result[i] + " ");
                sb.append(result[i]);
            }
//            System.out.println();
            list.add(sb.toString());
            return ;
        }

        for(int i=startIdx;i<str.length;i++){
           result[depth] = str[i];
           combination(str,result,depth+1,r,i+1);
        }
    }
}