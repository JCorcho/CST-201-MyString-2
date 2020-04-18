/*
 * @Author Jacob Corcho
 * @Version 04/11/2020
 * @Class CST-201
 *
 * The purpose of this class is to serve as my own version of the String class by Java called MyString for the first
 * project in the CST-201 class. Methods to interact with the MyString object are public as well as ensureCapacity being
 * private as it does not need outside interaction.
 */

package com.Smotteh;

import java.util.Arrays;

public class MyString {
    char[] charArr; //stores each character of the MyString in a charArray.
    int curr_length; //stores the length of the MyString.


    //START METHODS

    //returns the length of the current MyString held within the curr_length int.
    public int length() { //O(1)
        return curr_length;
    }

    //the following method checks if the array has enough capacity,if not we double it in size by making a new array double the size.
    private void ensureCapacity() { // ~O(nlog) or O(n)if the array length == curr_length else its O(n)

        if(charArr == null)
            charArr = new char[1];

        if(charArr.length == curr_length) {
            //doubles the size of the array
            char[] tempCharArr = new char[charArr.length * 2];

            //copies all the elements to the new array
            System.arraycopy(charArr, 0, tempCharArr, 0, curr_length);

            charArr = tempCharArr; //the pointer for charArr now points to tempCharArr
        }

    }

    //the following method converts the MyString to a String object and returns it.
    public String toString() { //O(n)

        StringBuilder returnStr = new StringBuilder(curr_length); //create a new StringBuilder object with the curr_length variable.

        for (int i = 0; i < curr_length; i++) { //loops through each index of the charArr and adds it to the StringBuilder
            returnStr.append(charArr[i]); //appends the StringBuilder with the index i of the charArr from this instance of the object.
        }

        return returnStr.toString(); //returns the returnStr String Builder parsed to a string.
    }

    //the following method is a concat method which essentially just adds the two MyString arguments together to one MyString object.
    public MyString concat(MyString myStr) { //O(n)
        MyString tempMyStr = new MyString(this); //copy the MyString to new temp MyString;
        for (int i = 0; i < myStr.curr_length; i++) { //loops through each index of the charArr in the MyString object.
            tempMyStr.addChar(myStr.charArr[i]); //adds the char at index i to the myStr charArr
        }

        return tempMyStr; //returns the tempMyStr object.
    }

    //the following method adds a character to the charArray, it wasn't in the assignment but makes things easier.
    private void addChar(char c) { //O(1)
        ensureCapacity(); //calls the ensureCapacity method to ensure the array has enough capacity, doubles array if not.
        charArr[curr_length++] = c; //adds a character at the index of (cur_length + 1) and adds one to the curr_length.
    }

    //the following method checks if the two MyString arguments are equal in all parameters.
    public boolean equals (MyString myStr) { //O(n)
        return Arrays.equals(charArr, myStr.charArr) && curr_length == myStr.curr_length;
    }

    //the following method checks if the MyString argument is equal in all parameters regardless of case of the charArr object within the MyString object.
    public boolean equalsIgnoreCase (MyString myStr) {//O(n)

        MyString tempStrA = toLower(); //temp MyString for comparison converted to lowercase.
        MyString tempStrB = toLower(); //temp MyString for comparison converted to lowercase.

        //returns true or false depending on comparison.
        return Arrays.equals(tempStrB.charArr, tempStrA.charArr) && curr_length == myStr.curr_length; //compares the two charArr's(char arrays) using the Array.equals method.
    }

    //the following method compares the argument against this instance of a MyString object.
    public int compareTo(MyString myStr) {//O(n)
        //returns 0 in the case they are equal ( using MyString.equalsIgnoreCase() ).
        if(myStr.equalsIgnoreCase(this)) {
            return 0;
        }

        int minDistance = Math.min(toLower().length(), myStr.toLower().length()); //finds minimum distance between the two strings.

        for(int i = 0; i < minDistance; i++) { //loops through each index of the charArr object from 0 until the minDistance.
            if (toLower().charArr[i] == myStr.toLower().charArr[i]) //if the char arrays are equal then we call continue;
                continue;

            //returns based on the value of the chars by the ascii table.
            return toLower().length() < myStr.toLower().length() ? 1 : -1;
        }

        //returns if this instance of MyString.length() is less than the arguments length
        return this.length() < myStr.length() ? 1 : -1;
    }

    //the following method returns the char at the index passed.
    public char get(int index) {//O(1)
        try { //try catch for IndexOutOfBounds
            return charArr[index]; //tries to return the charArr index at index of the argument passed.
        }
        catch (IndexOutOfBoundsException E) { //throws index out of bounds exception.
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    //the following method makes each character in the charArr uppercase.
    public MyString toUpper() {//O(n)
        for(int i = 0; i < curr_length; i++) { //loops through each index of the char array and sets it to its uppercase counterpart.
            charArr[i] = Character.toUpperCase(charArr[i]);
        }

        return this;
    }

    //the following method makes each character in the charArr lowercase.
    public MyString toLower() {//O(n)
        for(int i = 0; i < curr_length; i++) { //loops through each index of the char array and set it to its lowercase counterpart.
            charArr[i] = Character.toLowerCase(charArr[i]);
        }

        return this;
    }

    public MyString substring(int index) {//O(n)
        try {
            MyString tempStr = new MyString();
            for(int i = index; i < curr_length; i++)
            {
               tempStr.addChar(charArr[i]);
            }

           return tempStr;
        } catch (IndexOutOfBoundsException E) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    public MyString substring(int n, int m) {//O(n)
        m++;
        try {
            MyString tempStr = new MyString();
            for(int i = n; i < m; i++)
            {
                tempStr.addChar(charArr[i]);
            }

            return tempStr;
        } catch (IndexOutOfBoundsException E) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    public int indexOf(MyString myStr) {//O(n^2) or O(n, m)
        try { //try catch statement for returning -1 upon exception

            //parent loop
            for(int i = 0; i < length() - myStr.length() + 1; i++) { //loops through each index of the myStr.length
                var check = true; //bool for checking where an equal comparison is found

                //child loop
                for(int x = 0; x < myStr.length(); x++) {
                    if(charArr[i + x] != myStr.charArr[x]) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    return i; //returns the index of where the check bool found an equal comparison.
                }
            }

            return - 1;

        } catch (Exception E) {
            return -1;
        }
    }

    public int lastIndexOf(MyString myStr) {//O(n^2) or O(n, m)
        try {
            for(int i = (length() - 1) - myStr.length() + 1; i >= 0; i--) { //loops through each index of the myStr.length
                var check = true; //bool for checking where an equal comparison is found

                for(int x = 0; x < myStr.length(); x++) {
                    if(charArr[i + x] != myStr.charArr[x]) {
                        check = false;
                        break;
                    }
                }
                if(check)
                    return i; //returns the index of where the check bool found an equal comparison
            }
            return - 1; //returns -1
        } catch (Exception E) { //returns -1 upon exception
            return  -1;
        }

    }



    //END METHODS

    //START CONSTRUCTORS

    //CUSTOM CONSTRUCTOR 1 | DEFAULT
    public MyString() {//O(1)
        charArr = null;
        curr_length = 0;

    }

    //CUSTOM CONSTRUCTOR 2 | TAKES String ARGUMENT
    public MyString(String str) {//O(n)
        charArr = new char[1];
        curr_length = 0;
        for(int i = 0; i < str.length(); i++) {
            addChar(str.charAt(i));
        }

    }

    //COPY CONSTRUCTOR | TAKES MyString ARGUMENT
    public MyString(MyString myStr) {//O(n)
        //sets curr_length to the arguments curr_length
        curr_length = myStr.curr_length;
        //initialize charArr to a new char array with the length of the charArr
        charArr = new char[myStr.charArr.length];

        //copies each index of charArr over at each index respectively.
        for(int i = 0; i < myStr.length(); i++) {
            charArr[i] = myStr.charArr[i];
        }
    }



    //END CONSTRUCTORS


}
