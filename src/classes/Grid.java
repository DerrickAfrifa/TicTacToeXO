package classes;

import java.awt.GridLayout;

import javax.swing.*;

public class Grid {
	Player player1;
	Player player2;
	Player currentPlayer=player1;

	int rows = 3;
	int columns = 3;
	JFrame frame;
	JPanel panel = new JPanel();
	JButton[][] buttonGrid = new XOButton[rows][columns];
	String[] stringGrid = new String[rows * columns];

	public Grid(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		createGrid();
	}

	public void createGrid() {
		frame = new JFrame("Tic Tac Toe");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);

		panel.setLayout(new GridLayout(3, 3));

		initialiseButtons();
		initialiseStringGrid();

		frame.add(panel);

	}

	public void initialiseButtons() {
		for (int row = 0; row < buttonGrid.length; row++) {
			for (int column = 0; column < buttonGrid[row].length; column++) {
				buttonGrid[row][column] = new XOButton(this, row, column);
				panel.add(buttonGrid[row][column]);
			}
		}
	}

	public boolean isWin(JButton[] line){
		String rowToken = null;
		boolean foundWin = true;
		for(JButton button: line){
			if(rowToken == null){
				rowToken = button.getText();
			}else if(button.getText().equals("")){
				return false;
			}else if(!(button.getText()).equals(rowToken)){
				return false;
			}
		}
		return foundWin;
	}

	public boolean isHorizontalWin(){
		boolean ishorizontalWin = false;
		for(int row=0; row<buttonGrid.length; row++){
			if(isWin(buttonGrid[row])){
				return true;
			}
		}
		return ishorizontalWin;
	}

	public boolean isVerticalWin(){
		boolean isVerticalWin = false;
		JButton[] column = null;
		for(int col=0; col<buttonGrid[col].length; col++){
			column = new JButton[rows];
			for (int row = 0; row < buttonGrid[row].length; row++) {
				column[row] = buttonGrid[row][col];
			}
			if(isWin(column)){
				return true;
			}
		}
		return isVerticalWin;
	}

	public boolean isDiagonalWin(){
		JButton[] diagonal = new JButton[columns];
		boolean isDiagonalWin = false;
		for(int row=0; row<buttonGrid.length; row++) {
			diagonal[row] = buttonGrid[row][row];
		}
		if(isWin(diagonal)){
			return true;
		}else{
			for (int row = 0; row < buttonGrid.length; row++) {
				diagonal[row] = buttonGrid[row][(buttonGrid.length-1)-row];
			}
			if(isWin(diagonal)) {
				return true;
			}
		}
		return isDiagonalWin;
	}

	public void initialiseStringGrid() {
		for (int i = 0; i < stringGrid.length; i++) {
			stringGrid[i] = "-1";
		}
	}

	public void updateStringGrid(int position, String token) {
		stringGrid[position] = token;
	}

	public void checkIfWinningMove(int position, String token) {
		switch (position) {
		case 0:

			// check horizontal
			if (stringGrid[1].equals(token) && stringGrid[2].equals(token)) {
				winningMove(token);
			}
			// check diagonal
			else if (stringGrid[4].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[3].equals(token) && stringGrid[3].equals(token)) {
				winningMove(token);
			}

			break;
		case 1:

			// check horizontal
			if (stringGrid[0].equals(token) && stringGrid[2].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[4].equals(token) && stringGrid[7].equals(token)) {
				winningMove(token);
			}

			break;
		case 2:

			// check horizontal
			if (stringGrid[1].equals(token) && stringGrid[0].equals(token)) {
				winningMove(token);
			}
			// check diagonal
			else if (stringGrid[4].equals(token) && stringGrid[6].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[5].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}

			break;
		case 3:
			// check horizontal
			if (stringGrid[4].equals(token) && stringGrid[5].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[0].equals(token) && stringGrid[6].equals(token)) {
				winningMove(token);
			}

			break;
		case 4:
			// check horizontal
			if (stringGrid[3].equals(token) && stringGrid[5].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[1].equals(token) && stringGrid[7].equals(token)) {
				winningMove(token);
			}
			// check diagonal 1
			if (stringGrid[0].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}
			// check diagonal 2
			else if (stringGrid[2].equals(token) && stringGrid[6].equals(token)) {
				winningMove(token);
			}
			break;
		case 5:
			// check horizontal
			if (stringGrid[4].equals(token) && stringGrid[3].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[2].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}	

			break;
		case 6:

			// check horizontal
			if (stringGrid[7].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}
			// check diagonal
			else if (stringGrid[4].equals(token) && stringGrid[2].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[3].equals(token) && stringGrid[0].equals(token)) {
				winningMove(token);
			}

			break;
		case 7:
			// check horizontal
			if (stringGrid[6].equals(token) && stringGrid[8].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[4].equals(token) && stringGrid[1].equals(token)) {
				winningMove(token);
			}
			break;
		case 8:

			// check horizontal
			if (stringGrid[7].equals(token) && stringGrid[6].equals(token)) {
				winningMove(token);
			}
			// check diagonal
			else if (stringGrid[4].equals(token) && stringGrid[0].equals(token)) {
				winningMove(token);
			}
			// check vertical
			else if (stringGrid[5].equals(token) && stringGrid[2].equals(token)) {
				winningMove(token);
			}

			break;

		}
	}

	public void winningMove(String token) {
		if(token.equals(player1.getToken()))
			JOptionPane.showMessageDialog(frame, "Player 1 wins " + "(" + player1.getToken() + ")");
		else
			JOptionPane.showMessageDialog(frame, "Player 2 wins " + "(" + player2.getToken() + ")");
		System.exit(0);
	}

}
