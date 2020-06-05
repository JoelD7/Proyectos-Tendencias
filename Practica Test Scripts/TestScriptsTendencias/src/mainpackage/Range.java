package mainpackage;

import java.util.ArrayList;
import java.util.List;

public class Range {

    public List<Integer> range;
    public int first;
    public int last;
    public int originalFirst;
    public int originalLast;
    public String firstChar;
    public String lastChar;

    public Range(String range) {
        //(12,32]
        firstChar = range.substring(0, 1);
        lastChar = range.substring(range.length() - 1, range.length());
        try {
            if (!firstChar.equals("(") && !firstChar.equals("[")) {
                throw new InvalidRange("Invalid Range");
            }
            if (!lastChar.equals(")") && !lastChar.equals("]")) {
                throw new InvalidRange("Invalid Range");
            }

            String[] arr = range.substring(1, range.length() - 1).split(",");
            if (!isNumber(arr[0]) || !isNumber(arr[1])) {
                throw new InvalidRange("Invalid Range");
            }

            originalFirst = Integer.parseInt(arr[0]);
            if (firstChar.equals("(")) {
                first = Integer.parseInt(arr[0]) + 1;
            } else {
                first = Integer.parseInt(arr[0]);
            }

            originalLast = Integer.parseInt(arr[1]);
            if (lastChar.equals(")")) {
                last = Integer.parseInt(arr[1]) - 1;
            } else {
                last = Integer.parseInt(arr[1]);
            }
        } catch (InvalidRange e) {
            System.out.println(e);
        }

        this.range = new ArrayList<>();
        for (int i = first; i <= last; i++) {
            this.range.add(i);
        }
    }

    public boolean contains(int... vals) {
        for (int i : vals) {
            if (!this.range.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean doesNotContain(int... vals) {
        for (int i : vals) {
            if (!this.range.contains(i)) {
                return true;
            }
        }
        return false;
    }

    public int[] getAllPoints() {
        int[] arr = new int[this.range.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.range.get(i);
        }
        return arr;
    }

    public boolean containsRange(String r) {
        Range other = new Range(r);
        return other.first >= this.first && other.last <= this.last;
    }

    public boolean doesNotContainRange(String r) {
        Range other = new Range(r);
        if (other.first >= this.first && other.last <= this.last) {
            return false;
        } else {
            return true;
        }
    }

    public int[] endpoints() {
        int[] arr = new int[2];
        arr[0] = this.first;
        arr[1] = this.last;
        return arr;
    }

    public boolean overlapsRange(String r) {
        Range other = new Range(r);
        for (int i : other.range) {
            if (this.range.contains(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesNotOverlapsRange(String r) {
        Range other = new Range(r);
        for (int i : other.range) {
            if (this.range.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(String r) {
        Range other = new Range(r);
        return other.first == this.first && other.last == this.last;
    }

    public boolean notEquals(String r) {
        Range other = new Range(r);
        if (other.first == this.first && other.last == this.last) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return firstChar + originalFirst + ", " + originalLast + lastChar;
    }

}
