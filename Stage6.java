import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.exit;

public class Stage6 {

    public static String readFile(String path) throws IOException{
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = args[1];
        String txt = readFile(fileName);
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
//        System.out.println("Enter all people:");
//        while(n!=0){
//            String s = sc.nextLine();
//            arr.add(s);
//            n--;
//        }
        String[] a = txt.split("\n");
        arr = Arrays.stream(a).toList();
        Map<String,ArrayList<Integer>>mp =new HashMap<>();
        for(int i=0;i<arr.size();i++){
            String s = arr.get(i);
            String[] words = s.split(" ");
            for(String p:words){
                p = p.toLowerCase();
                mp.putIfAbsent(p,new ArrayList<>());
                mp.get(p).add(i);
            }

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
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String stra = sc.nextLine();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String k = sc.nextLine();
                    String[] qWord = k.split(" ");
                    Set<Integer> s = new HashSet<>();
                    if(stra.equals("ANY") || stra.equals("NONE")){
                        Set<Integer> r = new HashSet<>();
                        for(var each:qWord){
                            each = each.toLowerCase();
                            if(mp.get(each)!=null){
                                r.addAll(mp.get(each));
                            }
                        }
                        if(stra.equals("NONE")){
                            for(int i = 0; i < arr.size(); i++){
                                if(!r.contains(i)){
                                    s.add(i);
                                }
                            }
                        }
                        else{
                            s = r;
                        }
                    }
                    else{
                        boolean first_move = true;
                        for(String w : qWord){
                            w = w.toLowerCase();
                            if(mp.get(w) == null) continue;
                            if(first_move){
                                first_move = false;
                                s.addAll(mp.get(w));
                            }
                            else{
                                Set<Integer> f = new HashSet<>();
                                for(int val : mp.get(w)){
                                    if(s.contains(val)){
                                        f.add(val);
                                    }
                                }
                                s = f;
                            }
                        }
                    }
                    if(!s.isEmpty()){
                        s.stream().map(arr::get).forEach(System.out::println);
                    }
                    else{
                        System.out.println("No matching people found.");
                    }

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
