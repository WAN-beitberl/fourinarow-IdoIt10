package Four_in_a_row;

import java.util.Scanner;

public class Four_In_A_Row extends Game{
    private Participant parti1;
    private Participant parti2;
	private Board board;
	
	public Four_In_A_Row(Participant p1, Participant p2){
		this.parti1 = p1;
		this.parti2 = p2;
		this.board = new Board(6, 7);
	}
	
	public void play(Participant p){
		showBoard();
		insert(p);
		if (checkWin() == null)
		{
			if (p == parti1)
				play(parti2);
			else
				play(parti1);
		}
		else
			System.out.println("Congruts " + checkWin() + "! You are the champion (my friend)");
    }
	
    public void insert(Participant p){
		boolean flag = false;
		
		Scanner console = new Scanner(System.in);  
		int index = console.nextInt();  
		
		for (int j = 0; j < board.GetnumOfRows(); j++){
			if (board.valInPLace(index, j) != parti1.getShape() && board.valInPLace(index, j) != parti2.getShape()){
				board.putInPLace(index, j, p.getShape());
				flag = true;
				break;
			}
		}
		
		if (!flag){
			System.out.println("No place, try different place to put it in ;) #IHopeThatsWhatSheSaid");
			insert(p);
		}
    }

    public Participant checkWin(){
		
		// check for horizontal wins
		for (int i = 0; i < board.GetnumOfRows(); i++) {
			for (int j = 0; j < board.GetnumOfCols()-3; j++) {
				if (board.valInPLace(i, j) == board.valInPLace(i, j+1) && board.valInPLace(i, j+1) == board.valInPLace(i, j+2) && board.valInPLace(i, j+2) == board.valInPLace(i, j+3)) {
					if (board.valInPLace(i, j) == parti1.getShape())
						return parti1;
					else
						return parti2;
				}
			}
		}

		// check for vertical wins
		for (int i = 0; i < board.GetnumOfRows()-3; i++) {
			for (int j = 0; j < board.GetnumOfCols(); j++) {
				if (board.valInPLace(i, j) == board.valInPLace(i+1, j) && board.valInPLace(i+1, j) == board.valInPLace(i+2, j) && board.valInPLace(i+2, j) == board.valInPLace(i+3, j)) {
					if (board.valInPLace(i, j) == parti1.getShape())
						return parti1;
					else
						return parti2;
				}
			}
		}

		// check for diagonal wins (top-left to bottom-right)
		for (int i = 0; i < board.GetnumOfRows()-3; i++) {
			for (int j = 0; j < board.GetnumOfCols()-3; j++) {
				if (board.valInPLace(i, j) == board.valInPLace(i+1, j+1) && board.valInPLace(i+1, j+1) == board.valInPLace(i+2, j+2) && board.valInPLace(i+2, j+2) == board.valInPLace(i+3, j+3)) {
					if (board.valInPLace(i, j) == parti1.getShape())
						return parti1;
					else
						return parti2;
				}
			}
		}

		// check for diagonal wins (bottom-left to top-right)
		for (int i = 3; i < board.GetnumOfRows(); i++) {
			for (int j = 0; j < board.GetnumOfCols()-3; j++) {
				if (board.valInPLace(i, j) == board.valInPLace(i-1, j+1) && board.valInPLace(i-1, j+1) == board.valInPLace(i-2, j+2) && board.valInPLace(i-2, j+2) == board.valInPLace(i-3, j+3)) {
					if (board.valInPLace(i, j) == parti1.getShape())
						return parti1;
					else
						return parti2;
				}
			}
		}

		return null;
    }

    public void showBoard(){
		board.print();
    }
}