package Mastermind;

public abstract class Combination {
    protected final int MAX_COLORS = 4;
    protected String code;
    protected char[] charCode = new char[MAX_COLORS];
    //protected char[] colors = {'r','y','b','g','p','o'};
    //protected Color colors;

	public abstract String show();
}
