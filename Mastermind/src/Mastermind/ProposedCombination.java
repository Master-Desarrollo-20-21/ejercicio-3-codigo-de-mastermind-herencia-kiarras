package Mastermind;

public class ProposedCombination extends Combination{

    final String PROPOSE = "Propose a combination: ";
    final String WRONG_LENGTH = "Wrong proposed combination length \n";
    final String WRONG_COLORS = "Wrong colors, they must be: rbygop \n";
    public ProposedCombination() {
        code = isValid();
    }

    private String isValid() {
        Console console = new Console();
        String value = console.readString(PROPOSE);
        while (value.length() != 4) {
            console.out(WRONG_LENGTH);
            value = console.readString(PROPOSE);
        } 
        while (!isColorsOK(value)) {
            console.out(WRONG_COLORS);
            value = console.readString(PROPOSE);
        }
        return value;
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
