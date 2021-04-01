import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
Условие:
Написать на Java программу распаковывания строки. На вход поступает строка вида число[строка],
  на выход - строка, содержащая повторяющиеся подстроки.

Пример:
Вход: 3[xyz]4[xy]z
Выход: xyzxyzxyzxyxyxyxyz

Ограничения:
- одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
- допустимые символы на вход: латинские буквы, числа и скобки []
- числа означают только число повторений
- скобки только для обозначения повторяющихся подстрок
- входная строка всегда валидна.

 */
public class Main {
    static ArrayList<String> valueIn = new ArrayList<>();
    static String[] symb;

    public static void main(String[] args) throws IOException {
        String input, output;
        while(true)
        {
            System.out.flush();
            input = getString();
            if( input.equals("") )
                break;

            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();

            ParsePost aParser = new ParsePost(output);
            output = aParser.doParse();
            System.out.println(output);
        }
    }

    public static String getString ()  {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (((int) ch >= 48 && (int) ch <= 57) || ((int) ch >= 65 && (int) ch <= 90) || ((int) ch >= 97 && (int) ch <= 122) || ch == '[' || ch == ']') {
            } else {
                System.out.println("Входная строка не соответствует параметрам. Ипользуйте символы '[', числа и буквы латинского алфавита.");
                str = "";
            }
        }

        ArrayList<Character> list;

        Converter convert = new Converter(str);
        list = convert.convertTo();
        String line = "";
        for (int i = 0; i < list.size(); i++) {
            line = line + list.get(i);
        }
        return line;
    }
}
