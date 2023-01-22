package Four_in_a_row;

public abstract class Game{
	
	public abstract void play(Participant p);
	
    public abstract void insert(Participant p);

    public abstract Participant checkWin();

    public abstract void showBoard();
}