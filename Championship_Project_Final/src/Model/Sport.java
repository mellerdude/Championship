package Model;

import java.util.ArrayList;

public class Sport {
	private ArrayList<String> listOfParticipant;
	private ArrayList<String> listOf4Best;
	private ArrayList<String> listOfFinals;
	private String winner;
	private String typeOfSport;
	
	public Sport(String type) {
		 listOfParticipant = new ArrayList<String>();
		 listOf4Best = new ArrayList<String>();
		 for (int i = 0; i < 4; i++) {
			 listOf4Best.add("");
		}
		 listOfFinals = new ArrayList<String>();
		 for (int i = 0; i < 2; i++) {
			listOfFinals.add("");
		}
		 winner = "";
		 typeOfSport = type;
	}
	

	public ArrayList<String> getListOfParti(){
		return listOfParticipant;
	}
	public ArrayList<String> getListOf4Best(){
		return listOf4Best;
	}
	public ArrayList<String> getListOfFinals(){
		return listOfFinals;
	}
	public ArrayList<String> getList(String phase) {	
		if (phase.equalsIgnoreCase("top8"))	
			return listOfParticipant;	
		else if (phase.equalsIgnoreCase("top4"))	
			return listOf4Best;	
		else	
			return listOfFinals;	
	}
	public String getWinner(){
		return winner;
	}
	public String getType() {
		return typeOfSport;
	}
	//set the winner name in the right list
	public void setListOfWinners(String phase, String winner, int index) {	
		if (phase.equalsIgnoreCase("Top8")) {	
			if (index == 0 || index == 1)	
				listOf4Best.set(0, winner);	
			else if (index == 2 || index == 3)	
				listOf4Best.set(1, winner);	
			else if (index == 4 || index == 5)	
				listOf4Best.set(2, winner);	
			else {	
				listOf4Best.set(3, winner);	
			}	
		} else if (phase.equalsIgnoreCase("Top4")) {	
			if (index == 0 || index == 1)	
				listOfFinals.set(0, winner);	
			else if (index == 2 || index == 3)	
				listOfFinals.set(1, winner);	
		} else {	
			this.winner = winner;	
		}	
	}
}
