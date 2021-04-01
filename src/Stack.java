public class Stack {
    private char[] stack;
    private int maxSize;
    private int top;

    public Stack (int length) {
        maxSize = length;
        stack = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stack[++top] = value;
    }

    public char pop(){
        return stack[top--];
    }

    public char peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public char peekN(int n) {
        return stack[n];
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void displayStack(String s)
    {
        System.out.print(s);
        for(int j = 0; j < size(); j++) {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }

}
