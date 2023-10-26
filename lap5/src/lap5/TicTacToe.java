package lap5;

public class TicTacToe {
	 private static final char EMPTY = ' ';
	    private char[][] board;
	    
	    
	    public TicTacToe() {
	        board = new char[3][3];
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = EMPTY;
	            }
	        }
	    }
	    
	   
	    public boolean checkRows() {
	        for (int row = 0; row < 3; row++) {
	            if (board[row][0] != EMPTY && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    
	    public boolean checkColumns() {
	        for (int col = 0; col < 3; col++) {
	            if (board[0][col] != EMPTY && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	 
	    public boolean checkDiagonals() {
	        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
	            return true; 
	        }
	        
	        if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
	            return true;
	        }
	        
	        return false;
	    }
	    public static void main(String[] args) {
	        TicTacToe game = new TicTacToe();
	        
	        game.board[0][0] = 'X';
	        game.board[1][0] = 'O';
	        game.board[0][1] = 'X';
	        game.board[0][2] = 'O';
	        game.board[1][1] = 'X';
	        game.board[2][0] = 'O';
	        
	        boolean win1 = game.checkRows();
	        boolean win2 = game.checkColumns();
	        boolean win3 = game.checkDiagonals();
	        
	        if (win1) {
	            System.out.println("Player wins via rows!");
	        } else if (win2) {
	            System.out.println("Player wins via columns!");
	        } else if (win3) {
	            System.out.println("Player wins via diagonals!");
	        } else {
	            System.out.println("No winner yet.");
	        }
	    }
	}

