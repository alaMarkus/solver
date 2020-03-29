import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;

public class Search{
    String word;
    ArrayList<String> found;
    Search(){
        found = new ArrayList<String>();
        try{
            word = Files.readString(Paths.get("sanalista.txt"));
        }catch(Exception e){

        }
    }
    public Boolean find(String toSearch){
        if(word.contains("<s>"+toSearch)){
            if (word.contains("<s>"+toSearch+"</s>")){
                //System.out.println("found word: "+toSearch);
                if(found.contains(toSearch)==false){
                    System.out.println("found word: "+toSearch);
                    found.add(toSearch);
                    }
                }
            return true;
        }else{
            return false;
        }
    }
    public void printFoundWords(){
        for(int i =0; i<found.size();i++){
            System.out.println(found.get(i));
        }
    }
    public void sortStringListByLength() {
        System.out.println("-- sorting list of string --");
        Collections.sort(found, Comparator.comparing(String::length));
        found.forEach(System.out::println);
    }
}