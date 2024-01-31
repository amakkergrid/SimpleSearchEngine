
import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.exit;

public class Stage3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int n = sc.nextInt();
        sc.nextLine();
//        String[] li = s.split(" ");
//        Optional<Integer> op = Stream.iterate(0,idx->idx+1).limit(li.length).filter(idx->w.equals(li[idx])).findFirst();
//        op.ifPresentOrElse((idx->System.out.println(idx+1)),()->System.out.println("Not Found"));
//        boolean flag = false;
//        int i = 1;
//        for(String ele:li){
//            if(ele.equals(w)){
//                flag = true;
//                break;
//            }
//            i++;
//        }
//        if(flag)System.out.println(i);
//        else System.out.println("Not found");
        List<String>arr = new ArrayList<>();
        System.out.println("Enter all people:");
        while(n!=0){
            String s = sc.nextLine();
            arr.add(s);
            n--;
        }
        while(true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 0:
                    System.out.println("Bye");
                    exit(0);
                    break;
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    String k = sc.nextLine();
                    List<String>ans = new ArrayList<>();
                    for (String ele : arr) {
                        String low = ele.toLowerCase();
                        String kLow = k.toLowerCase();
                        int len = kLow.length();
                        for (int i = 0; i <= low.length() - len; i++) {
                            if (low.substring(i, i + len).equals(kLow)) {
                                ans.add(ele);
                                break;
                            }
                        }

                    }
                    ans.forEach(System.out::println);
                    ans.clear();
                    break;
                case 2:
                    System.out.println("=== List of people ===");
                    arr.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }

        }







    }
}
