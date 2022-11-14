package application;

public abstract class Question extends Case
{
    int x;
    
    abstract public int[] action(int y);
}