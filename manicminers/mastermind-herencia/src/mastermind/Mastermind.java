package mastermind;

class Mastermind {
	
	private Game game;
	
	public Mastermind() {
		
	}
	
	private void play() {
		 do {
			 this.game = new Game();
			 this.game.play();
		 }
		 while(this.game.resume());
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}
}
