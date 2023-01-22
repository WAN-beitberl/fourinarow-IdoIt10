package Four_in_a_row;

public class Main {
    public static void main(String[] args) {
		Participant p1 = new Participant("Ido", 0, 'X');
		Participant p2 = new Participant("Yuval", 0, 'O');
		Four_In_A_Row game = new Four_In_A_Row(p1, p2);
		game.play(p1);
    }
}