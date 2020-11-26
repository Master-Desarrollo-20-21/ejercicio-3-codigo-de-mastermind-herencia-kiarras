package mastermind;

class Result {
	
	Combination proposedCombination;
	Combination secretCombination;
	int whites = 0;
	int blacks = 0;
	
	public Result (Combination proposedCombination,  Combination secretCombination) {
		this.proposedCombination = proposedCombination;
		this.secretCombination = secretCombination;
		this.check();
	}
	
	protected void check() {
		String[] proposedColors = this.proposedCombination.getColors();
		String[] secretColors = this.secretCombination.getColors();

		for(int i = 0; i < proposedColors.length; i++) {
			for(int j = 0; j < secretColors.length; j++) {
				if(proposedColors[i].equals(secretColors[j])) {
					if(i == j) {
						this.blacks++;
					}
					else{
						this.whites++;
					}
				}
			}
		}
	}
		
	public boolean isWinner() {
		return this.blacks == this.proposedCombination.length();
	}
	
	public String toString() {
		return String.join("", this.proposedCombination.getColors()) + 
				" --> " + 
				this.blacks + " blacks and " + 
				this.whites + " whites.";		
	}
}
