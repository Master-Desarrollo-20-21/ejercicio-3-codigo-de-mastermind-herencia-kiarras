package Mastermind;

import java.util.Random;

public class SecretCombination extends Combination {
    public SecretCombination(){
        code = setRandomCombination();
    }

    private String setRandomCombination() {
        Random random = new Random();
        String value = "";
        for (int i = 0; i < MAXCOLORS; i++) {
            value += colors[random.nextInt(colors.length)];
        }
        return value;
    }

    @Override
    public String Show() {
        return "xxxx";
    }
    
	public int[] isEqual(String proposedCombination) {
        int[] result = new int[2];
        int blacks = 0;
        int whites = 0;
        for (int i = 0; i < code.toCharArray().length; i++) {
            if(proposedCombination.toCharArray()[i] == code.toCharArray()[i]) blacks++;
        }
        for (char j : proposedCombination.toCharArray()) {
            for (char i : code.toCharArray()) {
                if(j == i) whites++;
            }
        }
        result[0]= blacks;
        result[1]= whites;
        return result;
	}
    
}
