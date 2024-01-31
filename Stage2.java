import java.util.*;
import java.util.stream.Stream;

public class Stage2 {
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
        System.out.println("Enter the number of search queries:");
        int m = sc.nextInt();
        sc.nextLine();
        while(m!=0){
            List<String>ans = new ArrayList<>();
            System.out.println("Enter data to search people:");
            String k = sc.nextLine();
            for(String ele:arr){
                String low = ele.toLowerCase();
                String kLow = k.toLowerCase();
                int len = kLow.length();
                for(int i=0;i<low.length()-len;i++){
                    if(low.substring(i,i+len).equals(kLow)){
                        ans.add(ele);
                        break;
                    }
                }

            }
            if(ans.size()==0){
                System.out.println("No matching people found.");
            }
            else{
                System.out.println("Found people:");
                ans.forEach(System.out::println);
            }
            m--;
            ans.clear();
        }





    }
}
