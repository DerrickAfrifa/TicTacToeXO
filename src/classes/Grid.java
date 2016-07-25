package classes;

import java.awt.GridLayout;

import javax.swing.*;

public class Grid {
	Player player1;
	Player player2;
	Player currentPlayer;

	int rows = 3;
	int columns = 3;
	JFrame frame;
	JPanel panel = new JPanel();
	JButton[][] buttonGrid = new XOButton[rows][columns];

	public Grid(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.currentPlayer = player1;

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
		for(int col=0; col<buttonGrid.length; col++){
			column = new JButton[rows];
			for (int row = 0; row < buttonGrid.length; row++) {
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

	public void winningMove(String token) {
		JOptionPane.showMessageDialog(frame, "(" + token + ") wins.");
		System.exit(0);
	}

}
