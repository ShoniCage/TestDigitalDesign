import java.util.ArrayList;

public class Converter {
    String line;
    ArrayList<Character> list = new ArrayList<>();
    public Converter (String str) {
        line = str;
    }

    public ArrayList<Character> convertTo () {
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            int y = -1;
            if (i >= 1)
                y = (int) line.charAt(i-1);
            list.add(ch);
            if (ch == '[') {
                list.add(list.size() - 1, '*');
            } else if ((( y >= 65 && y <= 90) || (y >= 97 && y <= 122)) && (((int) ch >= 48 && (int) ch <= 57)
                    || (((int) ch >= 65 && (int) ch <= 90) || ((int) ch >= 97 && (int) ch <= 122)))) {
                list.add(list.size() - 1, '+');
            } else if ((i > 0 && line.charAt(i-1) == ']') && (((int) ch >= 65 && (int) ch <= 90) || ((int) ch >= 97 && (int) ch <= 122))) {
                list.add(list.size() - 1, '+');
            }
        }
        return list;
    }
}
