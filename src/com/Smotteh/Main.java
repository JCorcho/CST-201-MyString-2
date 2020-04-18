/*
 * @Author Jacob Corcho
 * @Version 04/11/2020
 * @Class CST-201
 *
 * The purpose of this class is to be the driver class for the 'MyString' project in the CST-201 class.
 * Within this driver class we will test each method that is accessible publicly from the MyString class. The only
 * private method "ensureCapacity" is used in the background to create a new array with a doubled size and reset the pointer
 * to the new array.
 */

package com.Smotteh;

public class Main {

    public static void main(String[] args)
    {
        MyString chocolate = new MyString("Chocolate");
        MyString strwBrry = new MyString("Strawberry");
        MyString vnlla = new MyString("Vanilla");

        //TESTING THE MyString.length() method
        BoxMaker.printInBox("TESTING THE MyString.length() method", BoxMaker.boxTypes.DOT);
        System.out.println(chocolate.toString() + " has a length of " + chocolate.length() + ".");

        //TESTING THE MyString.toString() method
        BoxMaker.printInBox("TESTING THE MyString.toString() method", BoxMaker.boxTypes.DOT);
        System.out.println(chocolate.toString());

        //TESTING THE MyString.concat() method
        BoxMaker.printInBox("TESTING THE MyString.concat() method", BoxMaker.boxTypes.DOT);

        MyString chcltSmoothie = chocolate.concat(new MyString(" Smoothie"));
        System.out.println(chcltSmoothie.toString());

        //TESTING THE MyString.equals() method
        BoxMaker.printInBox("TESTING THE MyString.equals() method", BoxMaker.boxTypes.DOT);
        if(!chocolate.equals(strwBrry))
            System.out.println(chocolate.toString() + " does not equal " + strwBrry.toString());

        if(chocolate.equals(chocolate))
            System.out.println(chocolate.toString() + " is equal to " + chocolate.toString());

        //TESTING THE MyString.compareTo() method
        BoxMaker.printInBox("TESTING THE MyString.compareTo() method", BoxMaker.boxTypes.DOT);
        System.out.println(strwBrry.compareTo(strwBrry));
        System.out.println(strwBrry.toUpper().compareTo(strwBrry.toLower()));
        System.out.println(chcltSmoothie.compareTo(strwBrry));
        System.out.print(chocolate.compareTo(vnlla));
        System.out.println();

        //TESTING THE MyString.toUpper() and MyString.toLower() methods
        BoxMaker.printInBox("TESTING THE MyString.toUpper() and MyString.toLower() methods", BoxMaker.boxTypes.DOT);
        System.out.println(chcltSmoothie.toUpper().toString());
        System.out.println(chcltSmoothie.toLower().toString());


        //TESTING THE MyString.equalsIgnoreCase() method
        BoxMaker.printInBox("TESTING THE MyString.equalsIgnoreCase() method", BoxMaker.boxTypes.DOT);
        if(chocolate.toUpper().equalsIgnoreCase(chocolate.toLower()))
            System.out.println(chocolate.toUpper().toString() + " does equal " + chocolate.toLower().toString());

        if(!chocolate.equals(vnlla))
            System.out.println(chocolate.toUpper().toString() + " does not equal " + vnlla.toLower().toString());

        //TESTING THE MyString.get() method
        BoxMaker.printInBox("//TESTING THE MyString.get() method", BoxMaker.boxTypes.DOT);
        System.out.println("Index 0,2,5 of Chocolate: " + chocolate.get(0) + chocolate.get(2) + chocolate.get(5));

             //TESTING THE EXCEPTION OF THE ABOVE METHOD
             // System.out.println("Index of 5000" + chocolate.get(5000)); // <--  REMOVE COMMENTS TO SEE TEST

        //TESTING THE MyString.indexOf method
        BoxMaker.printInBox("TESTING THE MyString.indexOf method", BoxMaker.boxTypes.DOT);
        System.out.println("First index of 'late' in " + chcltSmoothie.toString() + ": " + chcltSmoothie.indexOf(new MyString("late")));
        System.out.println("Last index of 'o' in " + chcltSmoothie.toString() + ": " + chcltSmoothie.lastIndexOf(new MyString("o")));

        //TESTING THE MyString.substring(int) and MyString.substring(int n, int m)
        BoxMaker.printInBox("TESTING THE MyString.substring(int) and MyString.substring(int n, int m)", BoxMaker.boxTypes.DOT);
        System.out.println("Chocolate starting index of 4: " + chocolate.substring(4));

        System.out.println("Chocolate starting index of 4, ending of 6: " + chocolate.substring(4, 6));

    }
}
