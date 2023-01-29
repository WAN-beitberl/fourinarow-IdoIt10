package SomethingInASomething1;

import java.util.Scanner;
import java.util.Arrays;

public class SomethingInASomething extends Game{
    private Participant[] participants;
	private Board board;
	private int sequence;
	
	Scanner console = new Scanner(System.in);
	
	public static Participant[] addParticipant(Participant arr[], Participant p)
    {
		int i;
		int n = arr.length;
		
		Participant newarr[] = new Participant[n + 1];
		
		for (i = 0; i < n; i++)
			newarr[i] = arr[i];
   
		newarr[n] = p;
		arr = newarr;
    }
   
	public SomethingInASomething(){
		
		int i = 0;
		char stop = '';
		
		while (stop != 'X' || i < 2){
			i++;
			
			System.out.println("Enter name of participant " + i);
			String name = console.nextLine();
			
			System.out.println("Enter sign of participant " + i);
			char sign = console.nextLine();
			
			System.out.println("Enter name of participant " + i);
			int score = console.nextInt();
			
			Participant p = new Participant(name, score, sign);
			
			addParticipant(participants, Participant p);
			
			System.out.println("Enter X to stop adding players \nkeep in your mind there must be at least 2 players!");
			char stop = console.nextLine();
		}
		
		System.out.println("Enter size for sequence");
		
		this.sequence = console.nextInt();
		
		System.out.println("Enter size of row table");
		int row = console.nextInt();
		
		System.out.println("Enter size of column table");
		int col = console.nextInt();
		
		this.board = new Board(row, col);
	}
	
	public boolean isWin(){
		for (int i = 0; i < participants.length; i++){
			if (checkWin(board.GetBoard(), 0, 0, participants[i], sequence) == participants[i])
				return false;
		}
		return true;
	}
	
	public void play(Participant p){
		showBoard();
		insert(p);
		
		if (isWin())
		{
			for (int i = 0; i < participants.length; i++){
			if (participants[i] = p)
				play(participants[i + 1]);
		}
		}
		else{
			for (int i = 0; i < participants.length; i++){
			if (checkWin(board.GetBoard(), 0, 0, participants[i], sequence) == participants[i])
				System.out.println("Congruts " + participants[i] + "! You are the champion (my friend)");
			}
		}
    }
	
    public void insert(Participant p){
		boolean flag = false;
		
		
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
	
    public Participant checkWin(int[][] board, int row, int col, Participant player, int sequence){
		
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				count += checkWin(board, row + i, col + j, player);
				if (count == sequence) {
					return player;
				}
			}
		}
		
		return null;
    }

    public void showBoard(){
		board.print();
    }
}