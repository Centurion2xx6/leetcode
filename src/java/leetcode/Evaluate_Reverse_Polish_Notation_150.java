package main.leetcode;

import java.util.*;

/**
 * Created by Alex on 07.06.2017.
 */
public class Evaluate_Reverse_Polish_Notation_150 {
    public static void main(String[] args)
    {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));

        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public static int evalRPN(String[] tokens)
    {
        if (tokens == null || tokens.length == 0)
        {
            return 0;
        }
        else if (tokens.length == 1)
        {
            return Integer.valueOf(tokens[0]);
        }

        List<String> operators = new ArrayList<>();
        operators.add(PLUS);
        operators.add(MINUS);
        operators.add(MULTIPLY);
        operators.add(DIVIDE);

        List<String> processedItems = new LinkedList<>();
        Arrays.stream(tokens).forEach(s -> processedItems.add(s));

        Iterator<String> iter = processedItems.listIterator();

        while (processedItems.size() > 1)
        {
            iter.next();
            //switch ()
            iter.next();
        }

        return Integer.valueOf(processedItems.get(0));
    }

}
