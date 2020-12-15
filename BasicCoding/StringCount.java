//$Id$
package com.learn;

import java.util.*;

/**
 * Question
 * ========
 * 
 * You are given a string which comprises of lower case alphabets (a-z), upper case alphabets (A-Z), numbers, (0-9) and special characters like !,-.; etc.

You are supposed to find out which character occurs the maximum number of times and the number of its occurrence, in the given string. If two characters occur equal number of times, you have to output the character with the lower ASCII value.

For example, if your string was: aaaaAAAA, your output would be: A 4, because A has lower ASCII value than a.

Input format:
The input will contain a string.

Output format:
You've to output two things which will be separated by a space:
i) The character which occurs the maximum number of times.
ii) The number of its occurrence.

Constraints:
The maximum length of the string can be 1000.

SAMPLE INPUT 
Pulkit is a dog!!!!!!!!!!!!
SAMPLE OUTPUT 
! 12
 */

class StringCount {

    static final int ASCII_CHARACTER = 256;
    public static void main(String args[] ) throws Exception {
        
        String sample_input=null;
        Scanner in = new Scanner(System.in);

        sample_input = in.nextLine();
        int count_characters[] = new int[ASCII_CHARACTER];

        for(int i = 0; i < sample_input.length(); i++){
            count_characters[sample_input.charAt(i)]++;
        }

        int max = -1;
        char final_character = ' ';

        for(int i = 0; i < count_characters.length; i++){
            if(max < count_characters[i]){
                max = count_characters[i];
                final_character=sample_input.charAt(i);
            }
        }

        System.out.println(final_character + " " + max);

        

    }
}
