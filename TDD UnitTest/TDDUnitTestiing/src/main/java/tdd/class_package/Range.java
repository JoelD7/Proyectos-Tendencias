package tdd.class_package;

import java.util.ArrayList;
import java.util.List;

public class Range {

    private String param;
    private char firstDelim;
    private char lastDelim;
    private List<Integer> range;
    private int first;
    private int last;

    Range(String string) throws InvalidRange {
        //(1,3)
        this.param = string;
        range = new ArrayList<>();

        char[] arr = param.toCharArray();
        firstDelim = arr[0];
        lastDelim = arr[arr.length - 1];

        if (firstDelim != '[' && firstDelim != '(') {
            throw new InvalidRange("Invalid Range");
        }
        if (lastDelim != ']' && lastDelim != ')') {
            throw new InvalidRange("Invalid Range");
        }

        String[] numbers = param.substring(1, param.length() - 1).split(",");
        first = Integer.parseInt(numbers[0]);
        if (firstDelim == '(') {
            first++;
        }
        last = Integer.parseInt(numbers[1]);
        if (lastDelim == ')') {
            last--;
        }

        for (int i = first; i <= last; i++) {
            range.add(i);
        }

    }

    public boolean contains(int first, int second) {
        return range.contains(first) || range.contains(second);
    }

    @Override
    public String toString() {
        return param;
    }

}
