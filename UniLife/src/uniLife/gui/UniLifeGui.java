package uniLife.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniLife.main.UniLife;
import uniLife.main.UniLifeEvent;
import uniLife.main.Utilities;

public class UniLifeGui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private UniLife game;
	private UniLifeEventGui event;
	/**
	 * Create the frame.
	 */
	
	public UniLifeGui(UniLife game, UniLifeEvent init) {
		this.game = game;
		setTitle("UniLife ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		event = new UniLifeEventGui (this,game,init);
		this.add(event);
		this.pack();
		
	}
	
	public UniLife getGameInstance (){
		return game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String chosenOption = ((JButton) e.getSource()).getText();
		
		if (chosenOption.equals("The End")){
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}else{
			this.remove(event);

			event = new UniLifeEventGui (this, game, Utilities.resolveOptionText(game, chosenOption));
			this.add(event);
			
			this.revalidate();
			this.repaint();
		}
	}

}
