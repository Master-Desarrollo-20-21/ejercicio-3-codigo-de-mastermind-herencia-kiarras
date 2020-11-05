package Mastermind;

public class Game {

    final int MAXATTEMPS = 10;
    final int WINS = 4;
    private Attempt[] attempts;
    private SecretCombination secretCombination;

    public Game() {
        attempts = new Attempt[MAXATTEMPS];
        secretCombination = new SecretCombination();
    }

	public void play() {
        Console console = new Console();
        console.out("----- MASTERMIND ----- \n");
        int i = 0;
        do {
            console.out(i + " attempt(s): \n xxxx \n");
            showPreviousAttempts(i);
            attempts[i] = new Attempt();
            attempts[i].result = secretCombination.isEqual(attempts[i].getProposedCombination().Show());
            i++;
            if(attempts[i-1].result[0] == WINS){
                break;
            }
        } while (i < attempts.length);
        console.out(finalResult(i-1));
	}

    private String finalResult(int i) {
        if(attempts[i].result[0] == 4) return "You've won!!! ;-) \n";
        return "You've lost!!! :-( \n";
    }

    private void showPreviousAttempts(int previous) {
        Console console = new Console();
        for (int j = 0; j < previous; j++) {
            console.out(attempts[j].getAttempt());
        }

    }

}
