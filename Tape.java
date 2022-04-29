import java.util.ArrayList;

public class Tape {
    
    public ArrayList<String> input = new ArrayList<String>();
    public int pos = 0; 

    public Tape(String in, int pos){
        this.pos = pos;
        input.add("0"); //String 0 represents null when after hashtags
        this.pos += 1;
        for(int i = 0; i < in.length(); i++){
            input.add(in.substring(i, i+1));           
        }
        input.add("0");
    } 

    public String read(){
        return input.get(pos);
    }

    public void write(String value){
        input.set(pos, value);
    }

    public void left(){
        if(pos > 1){
            pos--;
        }
        else{
            input.add(0, "0"); //pos should still be 0
        }
    }
    public void right(){
        if(pos < input.size() - 1)
            pos++;
        else{
            input.add("0");
            pos++;
        }
    }

}