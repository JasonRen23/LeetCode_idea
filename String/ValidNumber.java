package LeetCode_idea.String;

public class ValidNumber {

    enum InputType{
    INVALID,
    SPACE,
    SIGN,
    DIGIT,
    DOT,
    EXPONET,
    NUM_INPUTS
    }
    public static boolean isNumber(String s) {
        int[][] transitionTable = new int[][]{
                {-1, 0, 3, 1, 2, -1},
                {-1, 8, -1, 1, 4, 5},
                {-1, -1, -1, 4, -1, -1},
                {-1, -1, -1, 1, 2, -1},
                {-1, 8, -1, 4, -1, 5},
                {-1, -1, 6, 7, -1, -1},
                {-1, -1, -1, 7, -1, -1},
                {-1, 8, -1, 7, -1, -1},
                {-1, 8, -1, -1, -1, -1}

        };


        int state = 0;

        for(int i = 0; i < s.length(); ++i){
            final char ch = s.charAt(i);
            InputType input = InputType.INVALID;

            if(Character.isSpaceChar(ch)){
                input = InputType.SPACE;
            }else if(ch == '+' || ch == '-'){
                input = InputType.SIGN;
            }else if(Character.isDigit(ch)){
                input = InputType.DIGIT;
            }else if(ch == '.'){
                input = InputType.DOT;
            }else if(ch == 'e' || ch == 'E'){
                input = InputType.EXPONET;
            }

            state = transitionTable[state][input.ordinal()];

            if(state == - 1) return false;
        }

        return state == 1 || state == 4 || state == 7 || state == 8;
    }

    public static boolean isNumber_1(String s){

        /**
         * isNumber(s)==true if and only if s=s1 or s1+'e'+s2, where s1, s2
         * are valid strings of a number without the char 'e', and s2 is an
         * integer.
         *
         * 'e' : valid_count=0~1; [boolean hasE]
         *
         * Valid chars in a string of a number without 'e':
         *
         * ' ' : valid_count=0~n; must appear at two ends
         *
         * '+/-' : valid_count=0~1; must be the first non-space valid char;
         * [boolean hasFirst]
         *
         * '.' : valid_count=0~1; cannot appear after 'e'; [boolean hasDot]
         *
         * '0~9' : valid_count=1~n; [boolean hasDigit]
         */
        s = s.trim();
        final int n = s.length();
        if(n == 0) return false;

        boolean hasE, hasFirst, hasDot, hasDigit;
        hasE = hasFirst = hasDot = hasDigit = false;

        char c;
        for(int i = 0; i < n; ++i){
            c = s.charAt(i);

            if(c >= '0' && c <= '9'){
                hasFirst = hasDigit = true;
                continue;
            }

            switch (c){
                case 'e':
                    if(hasE || !hasDigit)
                        return false;
                    hasE = true;

                    hasFirst = hasDigit = false;
                    hasDot = true;

                    continue;

                case '+':
                case '-':
                    if(hasFirst)
                        return false;
                    hasFirst = true;
                    continue;

                case '.':
                    if(hasDot)
                        return false;
                    hasFirst = hasDot = true;
                    continue;
                default:
                    return false;
            }
        }
        return hasDigit;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0"));    //true
        System.out.println(isNumber("0.1"));  //true
        System.out.println(isNumber("abc"));  //false
        System.out.println(isNumber("1 a"));  //false
        System.out.println(isNumber("2e10")); //true
        System.out.println(isNumber("0.1e10")); //true
        System.out.println(isNumber("0e")); //true

        System.out.println();

        System.out.println(isNumber_1("0"));    //true
        System.out.println(isNumber_1("0.1"));  //true
        System.out.println(isNumber_1("abc"));  //false
        System.out.println(isNumber_1("1 a"));  //false
        System.out.println(isNumber_1("2e10")); //true
        System.out.println(isNumber_1("0.1e10")); //true
    }
}
