package uniLife.main;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Utilities {

	public static ArrayList<UniLifeEvent> loadEvents(String filename, String folder){
		
		filename = folder + filename + ".txt";
		
		ArrayList<UniLifeEvent> result = new ArrayList<UniLifeEvent>();
		
		LinkedList<String> loadQueue = new LinkedList<String>();
		
		loadQueue.addFirst(filename);
		
		while (loadQueue.peekFirst() != null){
			
			try{
				
				ArrayList<String> optionsArrayList = new ArrayList<String>();
				
				File file = new File (loadQueue.getFirst());
				
				FileReader fReader = new FileReader (file);
				
				BufferedReader bReader = new BufferedReader (fReader);
				
				String name = bReader.readLine();
				
				String options = bReader.readLine();
				
				if (options.equals("~")){
					optionsArrayList.add("The End");
				}else{
					
					String[] optionsList = options.split(",");
					
					for (int i = 0; i < optionsList.length; i++){
						optionsArrayList.add(optionsList[i]);
						loadQueue.addLast(folder + optionsList[i] + ".txt");
					}
				}
				
				
				boolean eventText = false;
				boolean optionText = false;
				
				String eventTextString = "";
				String optionTextString = "";
				
				String line = bReader.readLine();
				
				while (line != null){
					
					if (line.charAt(0) == '*'){
						eventText = false;
						optionText = true;
						line = line.replace('*',' ');
						optionTextString += line;
					}
					
					
					if(line.charAt(0) == '#'){
						optionText = false;
						eventText = true;
						line = line.replace('#', ' ');
						eventTextString += line;
					}	
					
					line = bReader.readLine();
				}

				
				UniLifeEvent loadedEvent = new UniLifeEvent (name, eventTextString, optionTextString, optionsArrayList );
				
				result.add(loadedEvent);
				
				loadQueue.removeFirst();
				
			}catch (IOException e){
				System.out.println("Something went wrong reading an event file!");
			}
			
			
		}
		
		return result;
	}
	
	public static UniLifeEvent resolveName (UniLife game, String name){
		
		ArrayList<UniLifeEvent> list = game.getEventList();
		
		for (int i = 0; i < list.size(); i++){
			if (name.equals(list.get(i).getName())){
				return list.get(i);
			}
		}

		
		System.out.println("Event not found!");
		return null;
		
	}
	
	public static UniLifeEvent resolveOptionText (UniLife game, String optionText){
		
		ArrayList<UniLifeEvent> list = game.getEventList();
		
		for (int i = 0; i < list.size(); i++){
			if (optionText.equals(list.get(i).getOptionText())){
				return list.get(i);
			}
		}
		
		System.out.println("Event not found! Event did not match option text!");
		return null;
	}
}
