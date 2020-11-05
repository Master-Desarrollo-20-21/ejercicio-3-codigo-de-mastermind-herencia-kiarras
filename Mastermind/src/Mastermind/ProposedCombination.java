package Mastermind;

public class ProposedCombination extends Combination{

    final String PROPOSE = "Propose a combination: ";
    final String WRONGLENGTH = "Wrong proposed combination length \n";
    final String WRONGCOLORS = "Wrong colors, they must be: rbygop \n";
    public ProposedCombination() {
        code = isValid();
    }

    @Override
    public String Show() {
        return code;
    }

    private String isValid() {
        Console console = new Console();
        String value = console.readString(PROPOSE);
        while (value.length() != 4) {
            console.out(WRONGLENGTH);
            value = console.readString(PROPOSE);
        } 
        while (!isColorsOK(value)) {
            console.out(WRONGCOLORS);
            value = console.readString(PROPOSE);
        }
        return value;
    }

    private boolean isColorsOK(String value) {
        boolean bol1 = false;
        for (char c : value.toCharArray()) {

            for (char d : colors) {
                if(c == d ) bol1 = true;
            }
            if(!bol1) return false;
        }
        return bol1;
    }

}
