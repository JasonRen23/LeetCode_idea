package LeetCode_idea.dataStructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        Matcher matcher = Pattern.compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)").matcher(formula);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
