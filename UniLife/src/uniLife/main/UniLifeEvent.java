package uniLife.main;

import java.util.ArrayList;

public class UniLifeEvent {
	
	private ArrayList<String> options;
	private String optionText;
	private String eventText;
	private String name;
	
	
	public UniLifeEvent (String name, String eventText, String optionText, ArrayList<String> options){
		
		this.name = name;
		this.eventText = eventText;
		this.optionText = optionText;
		this.options = options;
		
	}
	
	public void setEventText (String t){
		eventText = t;
	}
	
	public String getEventText (){
		return eventText;
	}
	
	public void setOptionText (String t){
		optionText = t;
	}
	
	public String getOptionText(){
		return optionText;
	}
	
	public void setName (String n){
		name = n;
	}
	
	public String getName (){
		return name;
	}
	
	public ArrayList<String> getOptions(){
		return options;
	}

}
