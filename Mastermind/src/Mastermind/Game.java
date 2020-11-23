package Mastermind;

public class Game {

    final int MAX_ATTEMPS = 10;
    final int WINS = 4;
    private ProposedCombination[] proposedCombinations;
    private SecretCombination secretCombination;
    public int[][] results;

    public Game() {
        proposedCombinations = new ProposedCombination[MAX_ATTEMPS];
        results = new int[MAX_ATTEMPS][];
        secretCombination = new SecretCombination();
    }

	public void play() {
        Console console = new Console();
        console.out("----- MASTERMIND ----- \n");
        int i = 0;
        do {
            console.out(i + " attempt(s): \n xxxx \n");
            showPreviousAttempts(i);
            proposedCombinations[i] = new ProposedCombination();
            results[i] = secretCombination.isEqual(proposedCombinations[i].getProposedCombination().show());
            i++;
            if(results[i-1][0] == WINS){
                break;
            }
        } while (i < proposedCombinations.length);
        console.out(finalResult(i-1));
    }
    
    private void showPreviousAttempts(int previous) {
        Console console = new Console();
        for (int j = 0; j < previous; j++) {
            console.out(getAttempt(j));
        }
    }

	public String getAttempt(int j) {
		return proposedCombinations[j].show() + " --> "+ results[j][0] + " blacks and " + results[j][1] + " whites \n";
	}

    private String finalResult(int i) {
        if(results[i][0] == 4) return "You've won!!! ;-) \n";
        return "You've lost!!! :-( \n";
    }
}
