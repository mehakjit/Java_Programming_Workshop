package com.example;

import java.util.Scanner;

public class TicTacToe {
	
	public static void createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++)
			board[i] = ' ';
	}
	public static char chooseOption() {
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1) 
			return 'X';
			else
				return 'Y';
		}
				
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		System.out.println("To Choose X Press 1"+ "\n" +
							"To Choose O Press 2");
		char playerOption = chooseOption();
		}
}
