package classes;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class XOButton extends JButton {	
	Grid g;
	static int id = 0;
	int buttonId;
	int row = 0;
	int column = 0;
	
	public XOButton(Grid grid, int row, int column){
		g = grid;
		buttonId += id++;
		this.row =row;
		this.column = column;
		setFont(new Font("Arial", Font.PLAIN, 60));
		this.buildButton();
	}
	
	public void buildButton(){
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isEnabled()){
					setText(g.currentPlayer.getToken());
					setEnabled(false);

					if(g.isHorizontalWin()||g.isVerticalWin()||g.isDiagonalWin()){
						g.winningMove(g.currentPlayer.getToken());
					}

					if(g.currentPlayer.equals(g.player1)){
						g.currentPlayer = g.player2;
					}else{
						g.currentPlayer = g.player1;
					}
				}
			}
		});
	}
	
}
