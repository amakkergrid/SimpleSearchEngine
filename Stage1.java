
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Stage1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] li = s.split(" ");
        String w = sc.next();
        Optional<Integer> op = Stream.iterate(0,idx->idx+1).limit(li.length).filter(idx->w.equals(li[idx])).findFirst();
        op.ifPresentOrElse((idx->System.out.println(idx+1)),()->System.out.println("Not Found"));
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

    }
}
