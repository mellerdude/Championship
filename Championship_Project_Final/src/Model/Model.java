
package Model;

import View.View;

public class Model {
	private int numberOfTimes = 0;
	private Sport tennis;
	private Sport basketball;
	private Sport soccer;
	private int p1Index;
	private int p2Index;
	private String phase;

	public Model() {
		tennis = new Sport("Tennis");
		basketball = new Sport("Basketball");
		soccer = new Sport("Soccer");
	}

	public Sport getRightSport(String sport) {
		if (sport == "Tennis")
			return tennis;
		else if (sport == "Basketball")
			return basketball;
		else
			return soccer;
	}
	
	public boolean findWinner(View theView) {
		int p1Wins = 0;
		int p2Wins = 0;

		String sport = theView.getSport();
		int n = theView.getPressedButtonNum();
		if (n >= 1 && n <= 4) {
			phase = "Top8";
			if (n == 1) {
				p1Index = 0;
				p2Index = 1;
			} else if (n == 2) {
				p1Index = 2;
				p2Index = 3;
			} else if (n == 3) {
				p1Index = 4;
				p2Index = 5;
			} else {
				p1Index = 6;
				p2Index = 7;
			}
		} else if (n >= 5 && n <= 6) {
			phase = "Top4";
			if (n == 5) {
				p1Index = 0;
				p2Index = 1;
			} else {
				p1Index = 2;
				p2Index = 3;
			}
		} else {
			phase = "Finals";
			p1Index = 0;
			p2Index = 1;
		}
		if (sport.equalsIgnoreCase("Tennis")) {
			if (theView.getPlayer1match1() > theView.getPlayer2match1())
				p1Wins++;
			else if (theView.getPlayer1match1() < theView.getPlayer2match1())
				p2Wins++;
			if (theView.getPlayer1match2() > theView.getPlayer2match2())
				p1Wins++;
			else if (theView.getPlayer1match2() < theView.getPlayer2match2())
				p2Wins++;
			if (theView.getPlayer1match3() > theView.getPlayer2match3())
				p1Wins++;
			else if (theView.getPlayer1match3() < theView.getPlayer2match3())
				p2Wins++;
			if (theView.isVisible()) {
				if (theView.getPlayer1match4() > theView.getPlayer2match4())
					p1Wins++;
				else if (theView.getPlayer1match4() < theView.getPlayer2match4())
					p2Wins++;
				if (theView.getPlayer1match5() > theView.getPlayer2match5())
					p1Wins++;
				else if (theView.getPlayer1match5() < theView.getPlayer2match5())
					p2Wins++;
				theView.setVisible(false);
			}
			if (p1Wins == 3 && p2Wins == 0) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p1Index), p1Index);
				return true;
			} else if (p2Wins == 3 && p1Wins == 0) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p2Index), p2Index);
				return true;
			} else if (p1Wins == 4 && p2Wins == 1) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p1Index), p1Index);
				return true;
			} else if (p2Wins == 4 && p1Wins == 1) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p2Index), p2Index);
				return true;
			} else if (p1Wins == 3 && p2Wins == 2) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p1Index), p1Index);
				return true;
			} else if (p1Wins == 2 && p2Wins == 3) {
				getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p2Index), p2Index);
				return true;
			} else if (p1Wins == p2Wins) {
				if ((int) ((Math.random() * 2) + 1) == 1) {
					getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p1Index),
							p1Index);
					return true;
				} else {
					getRightSport(theView.getSport()).setListOfWinners(phase, tennis.getList(phase).get(p2Index),
							p2Index);
					return true;
				}
			} else {
				numberOfTimes++;
				return false;
			}
		} else if (sport.equalsIgnoreCase("Basketball")) {
			if (theView.getPlayer1match1() > theView.getPlayer2match1())
				p1Wins++;
			else if (theView.getPlayer1match1() < theView.getPlayer2match1())
				p2Wins++;
			if (theView.getPlayer1match2() > theView.getPlayer2match2())
				p1Wins++;
			else if (theView.getPlayer1match2() < theView.getPlayer2match2())
				p2Wins++;
			if (theView.getPlayer1match3() > theView.getPlayer2match3())
				p1Wins++;
			else if (theView.getPlayer1match3() < theView.getPlayer2match3())
				p2Wins++;
			if (theView.getPlayer1match4() > theView.getPlayer2match4())
				p1Wins++;
			else if (theView.getPlayer1match4() < theView.getPlayer2match4())
				p2Wins++;
			if (p1Wins > p2Wins) {
				getRightSport(theView.getSport()).setListOfWinners(phase, basketball.getList(phase).get(p1Index),
						p1Index);
				return true;
			} else if (p1Wins == p2Wins) {
				if ((int) ((Math.random() * 2) + 1) == 1) {
					getRightSport(theView.getSport()).setListOfWinners(phase, basketball.getList(phase).get(p1Index),
							p1Index);
					return true;
				} else {
					getRightSport(theView.getSport()).setListOfWinners(phase, basketball.getList(phase).get(p2Index),
							p2Index);
					return true;
				}

			} else {
				getRightSport(theView.getSport()).setListOfWinners(phase, basketball.getList(phase).get(p2Index),
						p2Index);
				return true;
			}
		} else {
			if (theView.getPlayer1match1() > theView.getPlayer2match1())
				p1Wins++;
			else if (theView.getPlayer1match1() < theView.getPlayer2match1())
				p2Wins++;
			if (theView.getPlayer1match2() > theView.getPlayer2match2())
				p1Wins++;
			else if (theView.getPlayer1match2() < theView.getPlayer2match2())
				p2Wins++;
			if (theView.isVisible()) {
				if (theView.getPlayer1match3() > theView.getPlayer2match3())
					p1Wins++;
				else if (theView.getPlayer1match3() < theView.getPlayer2match3())
					p2Wins++;
				theView.setVisible(false);
			}
			if (getNumberOfTimes() == 2) {
				if (theView.getPlayer1match4() > theView.getPlayer2match4())
					p1Wins++;
				else if (theView.getPlayer1match4() < theView.getPlayer2match4())
					p2Wins++;
			}
			if (p1Wins > p2Wins) {
				getRightSport(theView.getSport()).setListOfWinners(phase, soccer.getList(phase).get(p1Index), p1Index);
				return true;
			} else if (p2Wins > p1Wins) {
				getRightSport(theView.getSport()).setListOfWinners(phase, soccer.getList(phase).get(p2Index), p2Index);
				return true;
			} else {
				numberOfTimes++;
				return false;
			}
		}
	}
	public int getP1Index() {
		return p1Index;
	}

	public int getP2Index() {
		return p2Index;
	}

	public int getNumberOfTimes() {
		return numberOfTimes;
	}

	public void setNumberOfTimes(int numberOfTimes) {
		this.numberOfTimes = numberOfTimes;
	}

	public String getPhase() {
		return phase;
	}
}
