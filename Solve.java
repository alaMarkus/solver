import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;

public class Solve{
    public static void main(String[] args) {
        boolean run = true;
        while (run){
        Clock clock = Clock.systemDefaultZone();
        ArrayList<int[]> path = new ArrayList<int[]>();
        Next next = new Next();
        Search search = new Search();
        Values values = new Values();
        Scanner scanner = new Scanner(System.in);

        String input ="";
        while (input.length()!= 16){        //halt until user inputs 16 letters
            System.out.println("insert 16 letters");
            input = scanner.nextLine();
            if (input.contentEquals("exit")){
                run = false;
                System.exit(1);
                break;
            }
        }

        values.setGrid(input);

        String word = "";

        int[] current = new int[]{0,0};
        int[] start = new int[]{1,1};

        long startTime = clock.millis();

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                if (path.size()<2||path.isEmpty()){
                    path.clear();
            //        System.out.println("path cleared");
            //        System.out.println("start: "+i+","+j);
                    int[] adds = new int[]{i,j};
                    path.add(adds);
              //      System.out.println("added to path: "+adds[0]+","+adds[1]);
                    start[0] = i;
                    start[1] = j;

                    word = values.getLetter(start);
            //        System.out.println("starting letter: "+word);

                    current[0]=start[0]-1;
                    current[1]=start[1]-1;

            //        System.out.println("current: "+current[0]+","+current[1]);
                }

                while (current[0]<=start[0]+1){
                    if (exists(current, start)){
                        if(pathContains(path, current)==false){

            //                scanner.nextLine();
                            word = word+values.getLetter(current);
            //                System.out.println(word);

                            if(search.find(word)){
                                int[] toAdd = new int[]{current[0],current[1]};
                                path.add(toAdd);
            //                    System.out.println("path updated with: "+toAdd[0]+","+toAdd[1]);
                                start[0]=current[0];
                                start[1]=current[1];
            //                    System.out.println("updated start to: "+ start[0]+","+start[1]);
                                current[0]=start[0]-1;
                                current[1]=start[1]-1;
            //                    System.out.println("updated current to "+current[0]+","+current[1]);
                            }else{
                                word = removeLastLetter(word);                       
                            }
                        }
                    }
            //        printPath(path);
            //        System.out.println(word);
                    current = next.nextCurrent(current, start);
            //        System.out.println("next current: "+current[0]+","+current[1]);
                    if (current[0]>=start[0]+2){
            //            System.out.println("current x: "+current[0]+" start x+2: "+start[0]+"+"+2);
                        if (path.size()>1){
                            do{
                                if(path.size()>1){
                                    start[0]=path.get(path.size()-2)[0];
                                    start[1]=path.get(path.size()-2)[1];
            //                        System.out.println("updated start to: "+ start[0]+","+start[1]+" from path");

                                    current[0]=path.get(path.size()-1)[0];
                                    current[1]=path.get(path.size()-1)[1];
                                    current = next.nextCurrent(current, start);
            //                        System.out.println("updated current to: "+current[0]+","+current[1]+" from path");
                                    path.remove(path.size()-1);
                                    word = removeLastLetter(word);
            //                        System.out.println("removed last item from path");
                                }else{
                                    break;
                                }
                            }while(current[0] == start[0]+2 && current[1] == start[1]-1);
                        }
                    }
                }
            }
        }
        search.sortStringListByLength();
        long endTime = clock.millis();
        long duration = endTime-startTime;
        System.out.println("execution took "+duration/1000+" seconds");
    }
    }

    public static Boolean exists(int[] cpoint,int[] spoint){
        if (cpoint[0]<4 && cpoint[1] < 4 && cpoint[0] > -1 && cpoint[1] > -1){
            if(cpoint[0] == spoint[0] && cpoint[1] == spoint[1] ){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    
    public static boolean pathContains(ArrayList<int[]> path, int[] point){
        for (int[] i : path){
            if (i[0] == point[0] && i[1] == point[1]){
             //   System.out.println("point: "+point[0]+","+point[1]+" is already in path: "+i[0]+","+i[1]);
                return true;
            }
        }
        return false;
    }

    public static String removeLastLetter(String str) {
        if (str != null && str.length() > 0){
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void printPath(ArrayList<int[]> path){
        for(int[] i : path){
            System.out.println("path: "+i[0]+","+i[1]);
        }
    }
}