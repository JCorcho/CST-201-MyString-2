/*
 *@Author Jacob Corcho
 *@Version 1/19/2020
 *
 * The purpose of this class is to take a given string object and print it out in an ASCII text art box
 * currently three types are available STAR, LINE, and DOT but this could easily be expanded upon.
 *
 */

package com.Smotteh;

public class BoxMaker {

    public enum boxTypes { //enum to contain different box type values.
        STAR, LINE, DOT, DOUBLE_LINE
    }

    public static void printInBox(String text, boxTypes type) {
        /*
         ****************
         *     NOTE     *
         ****************
         * Strings are used for both boxFiller variables to promote
         * better art, by adding new box types that use more than one character
         * such as a vertical line of "-=-=-=-=-=-=-=-=-=-"
         *
         */

        String boxFillerHorziontal = null; //String to hold character for horizontal box art
        String boxFillerVertical = null; //String to hold vertical box art
        Boolean isDouble = false;


        //Switch statement for each value in enum boxTypes
        switch (type)
        {
            case STAR: //runs if type "STAR"
                boxFillerHorziontal = "*";
                boxFillerVertical = "*";
                break;
            case LINE: //runs if type "LINE"
                boxFillerHorziontal = "-";
                boxFillerVertical = "|";
                break;
            case DOT: //runs if type "DOT"
                boxFillerHorziontal = ".";
                boxFillerVertical = ".";
                break;
            case DOUBLE_LINE: //runs if type "DOUBLE_LINE"
                boxFillerHorziontal = "-=";
                boxFillerVertical = "|";
                isDouble = true; //sets to isDouble because this type uses two characters so we break the string in half later.
                break;
            default: //default, no type set so we use the number symbol.
                boxFillerHorziontal = "#";
                boxFillerVertical = "#";
                break;
        } //end of switch statement.

        String boxLength = ""; //create and initialize boxLength String.
        String blankSpace = ""; //create and initialize blankSpace string. This holds the amount of blank spaces between one vertical end and the other.

        for (int i = 0; i < text.length(); i++) {
            boxLength += boxFillerHorziontal; // add the correct String to the boxLength string (this happens each loop so we do not set it, but add with +=).
            blankSpace += " "; //add a space to the string each loop.
        }//end for loop.

        int mid = boxLength.length() / 2; //this holds the index of the middle of the boxLength string.

        if (isDouble) { //if the type isDouble meaning it has two characters we cut it in half.
            boxLength = boxLength.substring(0, mid); //cut the string in half.
            boxLength += boxFillerHorziontal + boxFillerHorziontal; //add two additional horizontal box fillers for proper spacing.
        } else {
            boxLength += boxFillerHorziontal + boxFillerHorziontal + boxFillerHorziontal + boxFillerHorziontal; //add four additional horizontal box fillers for proper spacing.
        } //end if else statement.

        blankSpace += "  "; //add blank spaces for proper spacing.


        //prints out the box with the correct String variables based on the conditions set from the type argument passed to the method.
        System.out.println(boxLength);
        System.out.println(boxFillerVertical + blankSpace + boxFillerVertical);
        System.out.print(boxFillerVertical + " ");
        System.out.print(text);
        System.out.println(" " + boxFillerVertical);
        System.out.println(boxFillerVertical + blankSpace + boxFillerVertical);
        System.out.println(boxLength);
        //box is finished printing.

    }//end PrintInBox method.

}//end BoxMaker class.


