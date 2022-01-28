import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java baekjoon 나이순 정렬 & 단어 정렬
    // 나이순 정렬(주석처리된 코드 부분)
    // 나이와 이름을 기준으로 정렬해야 하기 때문에 person class를 만들어서 나이와 이름을 저장하고
    // new 객체를 사용해 메모리를 할당한 다음에 나이로 정렬하여 출력한다.

    // 단어 정렬
    // 주어지는 단어를 arraylist에 집어넣은 다음에 길이가 같다면 사전순으로 정렬해야 하기 때문에
    // 길이가 같은지 확인하고 o1.compareTo(o2)를 활용하여 사전순 정렬하고
    // else로 길이 순으로 정렬한다.

    /*
    public static class Person{
        int age;
        String name;

        public Person(int age,String name){
            this.age = age;
            this.name = name;
        }
    }
     */

   public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       ArrayList<String> list = new ArrayList<>();
       Set<String> set = new HashSet<>();

       for(int i=0;i<N;i++){
           String str = br.readLine();
           if(set.add(str)){
               list.add(str);
           }
       }

       Collections.sort(list, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               if(o1.length() == o2.length()){
                   return o1.compareTo(o2);
               }
               else return o1.length() - o2.length();
           }
       });


       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i));
       }
       /*
       Person[] people = new Person[N];

       for(int i=0;i<N;i++){
           String str = br.readLine();

           people[i] = new Person(0,"");

           StringTokenizer stk = new StringTokenizer(str," ");
           int age = Integer.parseInt(stk.nextToken());
           String name = stk.nextToken();

           people[i].age = age;
           people[i].name = name;
       }

       Arrays.sort(people, new Comparator<Person>() {
           @Override
           public int compare(Person o1, Person o2) {
               return o1.age - o2.age;
           }
       });

       for(int i=0;i<N;i++){
           System.out.println(people[i].age + " " + people[i].name);
       }

        */









    }
}