package Mastermind;

public class ProposedCombination extends Combination{

    final String PROPOSE = "Propose a combination: ";
    final String WRONG_LENGTH = "Wrong proposed combination length \n";
    final String WRONG_COLORS = "Wrong colors, they must be: rbygop \n";
    public ProposedCombination() {
        code = getValidCombination();
    }

    private String getValidCombination() {
        String value = inProposedCombination("");
        while (value.length() != 4) {
            value = inProposedCombination(WRONG_LENGTH);
        } 
        while (!isColorsOK(value)) {
            value = inProposedCombination(WRONG_COLORS);
        }
        return value;
    }

    private String inProposedCombination(String alert) {
        Console console = new Console();
        console.out(alert);
        console.out(PROPOSE);
        return console.inString();
    }

    private boolean isColorsOK(String value) {
        for (char c : value.toCharArray()) {
                if(Color.valueOf(c) == null) return false;
            }
        return true;
    }

    public ProposedCombination getProposedCombination() {
		return this;
	}

    @Override
    public String show() {
        return code;
    }
}
