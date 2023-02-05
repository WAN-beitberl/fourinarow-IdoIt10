package somethingInASomething1;

public class Board{
    private int numOfRows;
    private int numOfCols;
    private char[][] arr;
    
    public Board(int numOfRows, int numOfCols){
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        this.arr = new char[numOfRows][numOfCols];
    }
    
    public void print(){
        for (int i = 0; i < this.numOfRows; i++){
            for (int j = 0; j < this.numOfCols; j++){
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public int GetnumOfRows(){
        return this.numOfRows;
    }
    
    public int GetnumOfCols(){
        return this.numOfCols;
    }
    
    public char[][] GetBoard(){
        return this.arr;
    }
    
    public int valInPLace(int row, int col){
        return arr[row][col];
    }
    
    public void putInPLace(int row, int col, char val){
        arr[row][col] = val;
    }
}
