package Mastermind;

public class Attempt {
    
    private ProposedCombination proposedCombination;
    public int[] result;

    public Attempt(){
        result = new int[2];
        proposedCombination = new ProposedCombination();
    }

    public ProposedCombination getProposedCombination() {
		return proposedCombination;
	}

	public String getAttempt() {
		return proposedCombination.show() + " --> "+ result[0] + " blacks and " + result[1] + " whites \n";
	}

}
