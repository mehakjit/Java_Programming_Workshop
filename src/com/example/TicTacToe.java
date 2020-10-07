package com.example;

import java.util.Scanner;

public class TicTacToe {
	public static char[] board = new char[10];
			
	public static void createBoard() {
		for (int i = 1; i < 10 ; i++)
			board[i] = ' ';
	}
	public static char chooseOption() {
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println("Congratulations!! You have Chosen X \n" +
								"Let's Begin");
			return 'X';
		}
		else {
			System.out.println("Congratulations!! You have Chosen Y \n"
								+ "Let's Begin");
				return 'Y';
			}
		}
		public static void showBoard() {
			for (int i=1; i<10 ;i = i+3) {
				System.out.println("[" + board[i] + "] [" + board[i+1] + "] [" + board[i+2] + "]" );
			}
			}
				
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		System.out.println("To Choose X Press 1"+ "\n" +
							"To Choose O Press 2");
		char playerOption = chooseOption();
		char computerOption = (playerOption == 'X') ? 'O' :'Y';
		showBoard();
		}
}
