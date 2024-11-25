package number2;

import java.util.Random;
import java.util.Scanner;

class tictactoe{
	
	 static char[][]board;
	
	
	public tictactoe() {
		
		  board =new char[3][3];
		 initboard();
	}
	
	void initboard() {
		
		for(int i = 0; i<board.length; i++) {
			
			for (int j = 0; j< board[i].length; j++){
				
				board[i][j] = ' ';
			}
		}
	}
	
	static void disboard() {
		System.out.println("------------");
		
      for(int i = 0; i<board.length; i++) {
    	  System.out.print("| ");
			
			for (int j = 0; j< board[i].length; j++){
				
				System.out.print(board[i][j]  +" | ");
				
			}
			System.out.println();
			System.out.println("-------------");
		}
      
	}
	
	static void placeMark(int row, int col, char mark) {
		
		if(row>=0&& row<=2 && col >=0 && col <= 2) {
			
			board[row][col]=mark;
		}
		
		else {
			System.out.println("invalid position");
		}
	}
	
	static boolean checkColwin() {
		
		for(int j= 0; j<=2; j++) {
			
			if( board[0][j]!= ' ' && board[0][j]==board[1][j] &&board[1][j]==board[2][j] ) {
				return true;
			}
		}return false;
	}
	
	
	
 static boolean checkRowwin() {
		
		for(int i= 0; i<=2; i++) {
			
			if( board[i][0]!= ' ' && board[i][0]==board[i][1] &&board[i][1]==board[i][2] ) {
				return true;
			}
		}return false;
	}

 static boolean checkDigwin() {
	
	
		
		if( board[0][0]!= ' ' && board[0][0]==board[1][1] &&board[1][1]==board[2][2] ||
				board[0][2]!= ' ' && board[0][2]==board[1][1] &&board[1][1]==board[2][0] ) {
			return true;
		}
		else {
			return false;
		}
	
}

 static boolean checkDraw() {
	for(int i = 0 ; i<=2; i++) {
		for(int j = 0; j<=2; j++) {
			if(board[i][j]==' ')
			{
				return false;
			}
		}
	}
	return true;
 }
	
}


 abstract class Player{
	
	String name;
	char mark;
	abstract void makeMove();
	
boolean isvalidMove(int row, int col) {
		
		if(row>=0&& row<=2 && col >=0 && col <= 2) {
			
			if(tictactoe.board[row][col] == ' ') {
				return true;
			}
			
		}
		return false;
		
	}
	
}


class Humanplayer extends Player{
	
	
	
	public Humanplayer(String name, char mark) {
		
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		int row;
		int col;
		Scanner sc = new Scanner (System.in);
		
		do {
			
			System.out.println("Enter the row and col");
			row = sc.nextInt();
			col = sc.nextInt();
		}
		
		while(!isvalidMove(row,col));
	
			tictactoe.placeMark(row, col, mark);	
		
	}
	
}

class Ai extends Player{
	
	
	
	
	
	public Ai (String name, char mark) {
		
		this.name = name;
		this.mark = mark;
	}
	
	void makeMove() {
		int row;
		int col;
		Random R = new Random();
		System.out.println("Enter the row and col");
		
		do {
			
			
			row = R.nextInt(3);
			col = R.nextInt(3);
		}
		
		while(!isvalidMove(row,col));
	
			tictactoe.placeMark(row, col, mark);	
		
	}
	
}
	






public class game {
	public static void main(String[] args) {
		tictactoe t = new tictactoe();
		Humanplayer p1 = new Humanplayer("sk", 'x');
//		Humanplayer p2 = new Humanplayer("ssk", '0');
		Ai  p2 = new Ai("Bob", 'o');
		
		Player cp;
		
		cp = p1;
		while(true) {
		System.out.println(cp.name + "Turn");
		cp.makeMove();
		tictactoe.disboard();
		
		
			if(tictactoe.checkColwin()||tictactoe.checkDigwin()||tictactoe.checkRowwin()) 
			{
				System.out.println(cp.name + " Has won");
				break;	
			}
			else if(tictactoe.checkDraw()) {
				System.out.println("Game draw");
				break;
			}
			
			else {
				if(cp ==p1) 
				{
					cp=p2;
				}
				
				else {
					cp = p1;
				}
					
			}
		}
	}

}
