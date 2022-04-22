import java.util.ArrayList;

public class Tape {
    
    ArrayList<String> input = new ArrayList<String>();
    int pos = 0; 
    int count = 0;

    public Tape(String in, Object o, int pos){
        this.pos = pos;
        input.add(null);
        for(int i = 0; i < in.length(); i++){
            input.add(in.substring(i, i+1));           
        }
        input.add(null);
    }

    public String read(){
        return input.get(pos);
    }

    public void write(String value){
        if(value == "1"){
            count++;
        }
        input.set(pos, value);
    }

    public void left(){
        if(pos > 0){
            pos--;
        }
        else{
            input.add(0, null); //pos should still be 0
        }
    }
    public void right(){
        if(pos < input.size() - 1)
            pos++;
        else{
            input.add(null);
            pos++;
        }
    }

    public int oneCount(){
        return count;
    }
}