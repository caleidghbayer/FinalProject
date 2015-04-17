package uniLife.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.util.ArrayList;
import uniLife.main.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class UniLifeEventGui extends JPanel{
	
	private UniLife game;
	private UniLifeEvent data;
	private JLabel eventText;
	private ArrayList<JButton> buttonOptions = new ArrayList<JButton>();
	
	public UniLifeEventGui (UniLifeGui window, UniLife game, UniLifeEvent e){
		data = e;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100};
		gridBagLayout.rowHeights = new int[]{100,100,100};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		setLayout(gridBagLayout);
		
		eventText = new JLabel (e.getEventText());
		GridBagConstraints gbc_eventText = new GridBagConstraints();
		gbc_eventText.anchor = GridBagConstraints.NORTHWEST;
		gbc_eventText.gridx = 0;
		gbc_eventText.gridy = 0;
		this.add(eventText, gbc_eventText);
		
		for (int i = 0; i < e.getOptions().size(); i++){
			
				if (e.getOptions().get(i).equals("The End")){
					JButton endButton = new JButton ("The End");
					GridBagConstraints gbc_end = new GridBagConstraints();
					gbc_end.gridx = 0;
					gbc_end.gridy = i+1;
					gbc_end.fill = GridBagConstraints.BOTH;
					gbc_end.anchor = GridBagConstraints.LINE_START;
					this.add(endButton, gbc_end);
				}else{
					JButton newOption = new JButton (
							Utilities.resolveName(game,e.getOptions().get(i)).getOptionText());
					buttonOptions.add(newOption);
					GridBagConstraints gbc_newOption = new GridBagConstraints();
					gbc_newOption.gridx = 0;
					gbc_newOption.gridy = i+1;
					gbc_newOption.fill = GridBagConstraints.BOTH;
					gbc_newOption.anchor = GridBagConstraints.LINE_START;
					this.add(newOption, gbc_newOption);
					
					newOption.addActionListener(window);
				}
			
				
			
			
		}
		
	}
	
	

}
