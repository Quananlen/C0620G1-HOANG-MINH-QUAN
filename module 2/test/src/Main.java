import commons.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws Exception {
        final String REGEX = "abc$";
        String str = "aabc";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(str);
        boolean b = m.find();
        System.out.println(b);
    }

}
