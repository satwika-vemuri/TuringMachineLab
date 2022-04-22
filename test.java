import java.util.ArrayList;

public class test {

    public static void main(String[] args){
        ArrayList<String> x = new ArrayList<>();
        x.add("a");
        x.add("b");
        x.add(null);
        for(int i = 0; i < x.size(); i++){
            System.out.println(x.get(i));
        }
    }
    
}
