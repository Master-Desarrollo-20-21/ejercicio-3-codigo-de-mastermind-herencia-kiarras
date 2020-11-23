package Mastermind;

public class Mastermind {
    private Game game;
    public Mastermind(){
        this.game = new Game();
    }

    public void start() {
        do {
            this.game.play();
        } while (isResumed());
    }
    
    private boolean isResumed() {
        Console console = new Console();
        console.out("Resume? (y/n):");
        if(console.inChar() == 'y'){
            this.game = new Game();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
            new Mastermind().start();
    }
}
