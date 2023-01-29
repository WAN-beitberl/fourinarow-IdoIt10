package somethingInASomething1;

public class Participant{
    private String name;
    private int score;
    private char shape;
    
    public Participant(String name, int score, char shape){
        this.name = name;
        this.score = score;
        this.shape = shape;
    }
    
    public char getShape(){
        return this.shape;
    }
}