package mastermind;

class Game {

	final int MAX_ATTEMPS = 10;
	int attempsCounter = 0;
	private Console console;
	Combination secretCombination;
	Result[] results = new Result[MAX_ATTEMPS];

	Game() {
		this.console = new Console();
	}
	
	public void start() {
		this.attempsCounter = 0;
		this.results = new Result[MAX_ATTEMPS];
		this.secretCombination = new Combination();
		this.secretCombination.setRandomValue();
		this.console.out("\n---- MASTERMIND -----\n");
	}
	
	public void play() {
		this.start();
		do {
			Combination proposedCombination = new Combination();
			proposedCombination.readValue();
			this.results[this.attempsCounter] = new Result(proposedCombination, this.secretCombination);
			this.attempsCounter++;
			this.console.out(this.toString());

		} while (!this.isEndOfGame());
	}
	
	private boolean isEndOfGame() {
		return this.attempsCounter == MAX_ATTEMPS || this.getLastResult().isWinner();
	}
	
	private Result getLastResult() {
		return this.results[this.attempsCounter - 1];
	}

	public boolean resume() {
		String answer;
		do {
			answer = this.console.in("RESUME? (y/n): ");
		} while (!answer.equals("y") && !answer.equals("n"));
		return answer.equals("y");
	}
	
	public String toString() {
		String rs = "\n" + this.attempsCounter + " attempt(s):\n";
		
		for (int i = 0; i < this.attempsCounter; i++) {
			rs += results[i].toString() + "\n";
		}
		
		if(this.isEndOfGame()) {
			if (this.getLastResult().isWinner()) {
				rs += "You've won!!! ;-)\n";
			} else {
				rs += "You've lost!!! :-(\n";
				rs += "Secret was: " + this.secretCombination.getValue() + "\n";
			}
		}
		
		return rs;
	}
}
