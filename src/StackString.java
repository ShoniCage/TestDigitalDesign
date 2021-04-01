public class StackString {
    private String[] stack;
    private int maxSize;
    private int top;

    public StackString (int length) {
            maxSize = length;
            stack = new String[maxSize];
            top = -1;
        }

    public void push(String value) {
        stack[++top] = value;
    }

    public String pop(){
        return stack[top--];
    }

    public String peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public String peekN(int n) {
        return stack[n];
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void displayStack(String s) {
        System.out.print(s);
        for (int j = 0; j < size(); j++) {
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }
}

