package Mastermind;

import java.util.Random;

public class SecretCombination extends Combination {
    public SecretCombination(){
        code = setRandomCombination();
    }

    private String setRandomCombination() {
        Random random = new Random();
        String value = "";
        for (int i = 0; i < MAX_COLORS; i++) {
            int a;
            do {
                a = random.nextInt(Color.values().length);
            } while (isContain(a, value.toCharArray()));
            value += Color.valueOf(a);
        }
        return value;
    }

    private boolean isContain(int value, char[] values){
        for (int i = 0; i < values.length; i++) {
            if(Color.valueOf(value) == values[i]) return true;
        }
        return false;
    }

	public int[] isEqual(String proposedCombination) {
        int[] result = new int[2];
        int blacks = 0;
        for (int i = 0; i < code.toCharArray().length; i++) {
            if(proposedCombination.toCharArray()[i] == code.toCharArray()[i]) blacks++;
        }
        int whites = -blacks;
        for (char j : proposedCombination.toCharArray()) {
            for (char i : code.toCharArray()) {
                if(j == i) whites++;
            }
        }
        result[0]= blacks;
        result[1]= whites;
        return result;
	}
    
    @Override
    public String show() {
        return "xxxx";
    }
    
}
