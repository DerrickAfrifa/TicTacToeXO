package classes;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class XOButton extends JButton {	
	Grid g;
	int status = 0;
	static int clickCount=0;
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
				
				if(clickCount == 0){
					if(isEnabled()){
						setText(g.player1.getToken());
						setEnabled(false);
						g.updateStringGrid(buttonId, g.player1.getToken());
						g.checkIfWinningMove(buttonId, g.player1.getToken());
						clickCount++;
						clickCount %= 2;
					}
					//setEnabled(false);
					
				}else{
					if(isEnabled()){					
						setText(g.player2.getToken());
						setEnabled(false);
						g.updateStringGrid(buttonId, g.player2.getToken());
						g.checkIfWinningMove(buttonId, g.player2.getToken());
						clickCount++;
						clickCount %= 2;
					}
					//setEnabled(false);
				}
				
			}
		});
	}
	
}
