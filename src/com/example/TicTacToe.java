package com.example;

import java.util.Scanner;

public class TicTacToe {
	public static char[] board = new char[10];
	public static char playerOption;
	public static char computerOption;
	static Scanner sc = new Scanner(System.in);

	public static void createBoard() {
		for (int i = 1; i < 10; i++)
			board[i] = ' ';
	}

	public static void chooseOption() {
		System.out.println("To Choose X Press 1" + "\n" + "To Choose O Press 2");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Congratulations!! You have Chosen X \n" + "Let's Begin");
			playerOption = 'X';
			break;
		case 2:
			System.out.println("Congratulations!! You have Chosen O \n" + "Let's Begin");
			playerOption = 'O';
			break;
		default:
			System.out.println("Wrong Option, Try again");
			chooseOption();
		}
		computerOption = (playerOption == 'X') ? 'O' : 'X';
	}

	public static void showBoard() {
		for (int i = 1; i < 10; i = i + 3) {
			System.out.println("[" + board[i] + "] [" + board[i + 1] + "] [" + board[i + 2] + "]");
		}
	}

	public static boolean toss() {
		System.out.println("To Choose Heads Press 1" + "\n" + "To Choose Tails Press 2");
		int tossP = sc.nextInt();
		int tempToss = 0;
		switch (tossP) {
		case 1:
			System.out.println("You have Heads ");
			tempToss = 1;
			break;
		case 2:
			System.out.println("You have tails ");
			tempToss = 1;
			break;
		default:
			System.out.println("Wrong Option, Try again");
			tempToss = 1;
			toss();
			tempToss = 0;
			break;
		}
		if (tempToss == 1) {
			int option = (int) (Math.random() * 2);
			if (option == 0) {
				System.out.println("You can play first You won the toss ");
				return true;
			} else {
				System.out.println("You can't play first you have lost the toss");
				return false;
			}
		}
		return false;
	}

	public static void move(char whoMoves) {
		System.out.println("Select position from 1-9 to make your move");
		showBoard();
		int option = sc.nextInt();
		if (board[option] == ' ') {
			System.out.println("Position Available ");
			board[option] = whoMoves;
			showBoard();
		} else {
			System.out.println("Position Unavailable, Try again from available positions \n");
			move(whoMoves);
			showBoard();
		}
	}

	public static boolean winCondition() {
		if ((board[1] == board[2] && board[1] == board[3] && board[1] != ' ')
				|| (board[4] == board[5] && board[4] == board[6] && board[4] != ' ')
				|| (board[7] == board[8] && board[7] == board[9] && board[7] != ' ')
				|| (board[1] == board[4] && board[1] == board[7] && board[1] != ' ')
				|| (board[2] == board[5] && board[2] == board[8] && board[2] != ' ')
				|| (board[3] == board[6] && board[3] == board[9] && board[3] != ' ')
				|| (board[1] == board[5] && board[1] == board[9] && board[1] != ' ')
				|| (board[3] == board[5] && board[3] == board[7] && board[3] != ' ')) {
			return true;
		}
		return false;
	}

	public static void computerMove() {
		boolean moved = false;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				board[i] = computerOption;
				if (!winCondition()) {
					board[i] = ' ';
				} else {
					moved = true;
					break;
				}
			}
		}
		if (!moved)
			moved = blockOpponent();
		if (!moved)
			moved = takeCorner();
		if (!moved)
			moved = takeCentreOrSide();
	}

	public static boolean blockOpponent() {
		boolean ifMoved = false;
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ') {
				board[i] = playerOption;
				if (!winCondition()) {
					board[i] = ' ';
				} else {
					board[i] = computerOption;
					ifMoved = true;
					showBoard();
					break;
				}
			}
		}
		return ifMoved;
	}

	public static boolean takeCorner() {
		boolean ifMoved = false;
		int[] corners = { 1, 3, 7, 9 };
		for (int i = 0; i < corners.length; i++) {
			int corner = corners[i];
			if (board[corner] == ' ') {
				board[corner] = computerOption;
				ifMoved = true;
				showBoard();
				break;
			}
		}
		return ifMoved;
	}

	public static boolean takeCentreOrSide() {
		boolean ifMoved = false;
		int[] moves = { 5, 2, 4, 6, 8 };
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i];
			if (board[move] == ' ') {
				board[move] = computerOption;
				ifMoved = true;
				showBoard();
				break;
			}
		}
		return ifMoved;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");
		createBoard();
		chooseOption();
		showBoard();
		boolean winState = false;
		boolean toss = toss();
		for (int i = 1; i < 10; i++) {
			if (toss) {
				System.out.println("Player's Move");
				move(playerOption);
				winState = winCondition();
				if (winState) {
					System.out.println("Congratulations!! You Win");
					break;
				}
				toss = false;
			} else {
				System.out.println("Computer's Move");
				computerMove();
				winState = winCondition();
				if (winState) {
					System.out.println("Sorry!! Computer Wins");
					break;
				}
				toss = true;
			}
		}
		if (!winState) {
			System.out.println("It's a tie");
		}
	}
}
