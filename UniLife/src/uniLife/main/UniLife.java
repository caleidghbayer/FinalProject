package uniLife.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import uniLife.gui.UniLifeGui;

public class UniLife {
	
	private ArrayList<UniLifeEvent> eventList;
	private Properties loadProperties;
	
	public static void main (String args[]){
		
		UniLife game = new UniLife();
		
		game.loadFiles();
		
		
		UniLifeGui window = new UniLifeGui(game, game.eventList.get(0));	
		window.setVisible(true);
		
	}
	
	private void loadFiles (){
		
		try{
			loadProperties = new Properties ();
			FileInputStream loadPropertiesIn = new FileInputStream("loadProperties.properties");
			
			loadProperties.load(loadPropertiesIn);
			loadPropertiesIn.close();
			
		}catch (IOException e){
			System.out.println("Something went wrong trying to load properties file!");
		}
		
		eventList = Utilities.loadEvents((String) loadProperties.getProperty("initialEvent"),
				(String) loadProperties.getProperty("folder"));
		
		
	}
	
	public ArrayList<UniLifeEvent> getEventList(){
		return eventList;
	}

}
