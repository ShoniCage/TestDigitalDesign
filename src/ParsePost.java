public class ParsePost {
    private StackString theStack;
    private String input;

    public ParsePost( String s) {
        input = s;
    }

    public String doParse() {
        theStack = new StackString (input.length());
        char ch;
        int j;
        String num1, num2, interAns = "";
         for (j = 0; j < input.length(); j++) {
             ch = input.charAt(j);
             if (((int) ch >= 65 && (int) ch <= 90) || ((int) ch >= 97 && (int) ch <= 122) || ((int) ch >= 48 && (int) ch <= 57)) {
                 theStack.push(Character.toString(ch));
             } else {
                 num2 = theStack.pop();
                 num1 = theStack.pop();

                 interAns = "";
                 switch(ch) {
                     case '+':
                         interAns = num1 + num2;
                         break;
                     case '*':
                         for (int i = 1; i <= (Integer.parseInt(num1)); i++) {
                             interAns = interAns + num2;
                         }
                         break;
                     default:
                         interAns = "";
                 }
                 theStack.push(interAns);
             }
         }
        interAns = theStack.pop();
        return interAns;
    }
}
