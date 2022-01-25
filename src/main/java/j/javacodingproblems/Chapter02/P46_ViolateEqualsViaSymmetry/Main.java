package j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry;

import j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.bad.JumpJet;
import j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.bad.Vehicle;

public class Main {

    public static void main(String[] args) {

        // bad
        Vehicle vBad = new Vehicle("air", 1967);
        JumpJet jjBad = new JumpJet("air", 1967, "Harrier");

        System.out.println("jjBad equal vBad: " + jjBad.equals(vBad));
        System.out.println("vBad equal jjBad: " + vBad.equals(jjBad));

        System.out.println();

        // good
        j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.good.Vehicle vGood =
                new j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.good.Vehicle("air", 1967);
        j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.good.JumpJet jjGood =
                new j.javacodingproblems.Chapter02.P46_ViolateEqualsViaSymmetry.good.JumpJet("air", 1967, "Harrier");

        System.out.println("jjGood equal vGood: " + jjGood.equals(vGood));
        System.out.println("vGood equal jjGood: " + vGood.equals(jjGood));
    }

}
