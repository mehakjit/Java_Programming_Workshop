package com.example;

import java.util.Scanner;

public class TicTacToe {
	public static char[] board = new char[10];
	public static char playerOption;
	public static char computerOption;
	static Scanner sc = new Scanner(System.in);
	
	public static void createBoard() {
		for (int i = 1; i < 10 ; i++)
			board[i] = ' ';
	}
	
	public static void chooseOption() {
		System.out.println("To Choose X Press 1"+ "\n" +
				"To Choose O Press 2");
		int option = sc.nextInt();
		if(option == 1) {
			System.out.println("Congratulations!! You have Chosen X \n" +
								"Let's Begin");
			playerOption = 'X';
			computerOption = (playerOption == 'X') ? 'O' :'Y';
		}
		else {
			System.out.println("Congratulations!! You have Chosen Y \n"
								+ "Let's Begin");
				playerOption = 'O';
			}
				
		}
		public static void showBoard() {
			for (int i=1; i<10 ;i = i+3) {
				System.out.println("[" + board[i] + "] [" + board[i+1] + "] [" + board[i+2] + "]" );
			}
		}
		public static void move() {
			System.out.println("Select position from 1-9 to make your move");
			int option = sc.nextInt();
			if ( board[option] == ' ') {
				System.out.println("Position Available ");
				board[option] = playerOption;
			}
			else {
				System.out.println("Position Unavailable");
			}
			showBoard();
		}
				
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		chooseOption();
		showBoard();
		move();
		}
}
