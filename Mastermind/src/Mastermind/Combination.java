package Mastermind;

public abstract class Combination {
    protected final int MAXCOLORS = 4;
    protected String code;
    protected char[] charCode = new char[MAXCOLORS];
    //protected char[] colors = {'r','y','b','g','p','o'};
    //protected Color colors;

	public abstract String show();
}
