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

    public boolean doesNotContain(int i, int i0) {
        return !range.contains(i) || !range.contains(i0);
    }

    public int[] getAllPoints() {
        int[] arr = new int[range.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = range.get(i);
        }
        return arr;
    }

    public boolean containsRange(String string) throws InvalidRange {
        Range other = new Range(string);
        return other.first >= this.first && other.last <= this.last;
    }

    public boolean doesNotContain(String string) throws InvalidRange {
        Range other = new Range(string);
        return other.first > this.last;
    }

    public int[] endpoints() {
        int[] arr = {this.first, this.last};
        return arr;
    }

    public boolean overlaps(String string) throws InvalidRange {
        Range other = new Range(string);
        for (int i : this.range) {
            if (other.range.contains(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesNotOverlaps(String string) throws InvalidRange {
        Range other = new Range(string);
        for (int i : this.range) {
            if (other.range.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(String string) throws InvalidRange {
        Range other = new Range(string);
        return other.first == this.first && other.last == this.last;
    }

    public boolean notEquals(String string) throws InvalidRange {
        return !equals(string);
    }

    @Override
    public String toString() {
        return param;
    }

}
