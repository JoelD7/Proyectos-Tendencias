package mainpackage;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

    public static void main(String[] args) {
//        System.out.println(new Range("(2,9)"));
//        System.out.println(new Range("[12,32)"));
//        System.out.println(new Range("]3,2)"));
//        System.out.println(new Range("(1,9["));

//        System.out.println(new Range("[9,15]").contains(10, 15));
//        System.out.println(new Range("(1,3)").contains(5, 6));
//        System.out.println(new Range("[4,8)").contains(-3, 9));
//        System.out.println(new Range("(10,13]").contains(11, 12));
//        System.out.println(new Range("(3,18)").doesNotContain(-1, 0));
//        System.out.println(new Range("(1,2)").doesNotContain(0, 9));
//        System.out.println(new Range("[25,50]").doesNotContain(30, 31));
//        System.out.println(new Range("[10,21)").doesNotContain(16, 20));
//        System.out.println(Arrays.toString(new Range("[1,5)").getAllPoints()));
//        System.out.println(Arrays.toString(new Range("[12,20]").getAllPoints()));
//        System.out.println(Arrays.toString(new Range("(2,4)").getAllPoints()));
//        System.out.println(Arrays.toString(new Range("(3,8]").getAllPoints()));
//        System.out.println(new Range("[3,10]").containsRange("(5,8)"));
//        System.out.println(new Range("(10,19)").containsRange("[15,16]"));
//        System.out.println(new Range("[1,4)").containsRange("(7,13]"));
//        System.out.println(new Range("(20,29)").containsRange("(1,8)"));
//        System.out.println(new Range("(4,9)").doesNotContainRange("(12,20]"));
//        System.out.println(new Range("[3,14)").doesNotContainRange("[15,20]"));
//        System.out.println(new Range("(15,21)").doesNotContainRange("[16,19]"));
//        System.out.println(new Range("[4,20]").doesNotContainRange("(7,12]"));
//        System.out.println(Arrays.toString(new Range("(12,15)").endpoints()));
//        System.out.println(Arrays.toString(new Range("[5,19)").endpoints()));
//        System.out.println(Arrays.toString(new Range("[10,30]").endpoints()));
//        System.out.println(Arrays.toString(new Range("(4,10]").endpoints()));
//        System.out.println(new Range("[2,9)").overlapsRange("[3,7]"));
//        System.out.println(new Range("(5,18)").overlapsRange("(8,23]"));
//        System.out.println(new Range("[19,23)").overlapsRange("[1,2]"));
//        System.out.println(new Range("(4,11]").overlapsRange("(1,3]"));
//        System.out.println(new Range("[19,23)").doesNotOverlapsRange("[1,2]"));
//        System.out.println(new Range("[2,5]").doesNotOverlapsRange("(6,12]"));
//        System.out.println(new Range("(31,34)").doesNotOverlapsRange("[32,33]"));
//        System.out.println(new Range("[6,10)").doesNotOverlapsRange("[7,9)"));
//        System.out.println(new Range("(12,15)").equals("[13,14]"));
//        System.out.println(new Range("[1,4)").equals("(0,3)"));
//        System.out.println(new Range("(12,18]").equals("[12,18]"));
//        System.out.println(new Range("[15,19]").equals("(15,19)"));
        System.out.println(new Range("(12,18]").notEquals("[12,18]"));
        System.out.println(new Range("(8,11)").notEquals("[10,14]"));
        System.out.println(new Range("[1,10)").notEquals("[1,9]"));
        System.out.println(new Range("[10,21]").notEquals("(9,22)"));

    }
}
