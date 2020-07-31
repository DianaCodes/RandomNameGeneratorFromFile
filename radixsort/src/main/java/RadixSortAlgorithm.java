/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diana Arita
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.*;

public class RadixSortAlgorithm {
    public static void main(String[] args) throws FileNotFoundException{
        String str = "dog cactus plum ant apple cat drum pumpkin burrow manatee bookcase woodpecker";
        
        //Load words in sentence into array
        String[] unsortedArray = str.split("\\s+");
        
        //Replace blanks with spaces in the words in unsorted Array
        for(int i=0;i < unsortedArray.length;i++) {
            unsortedArray[i] = unsortedArray[i].replaceAll("[^\\w]","");
        }
        
        //add unsortedArray elements to list
        List<String> list = new ArrayList<String>(Arrays.asList(unsortedArray));
        
        //Get length of longest word in sentence
        int len = getLongestWordLength(str);
        
        //Display outputs
        System.out.println("Submitted by Diana Arita - aritad@csp.edu");
        System.out.println("I certify that this is my own work");
        System.out.println();
        
        radixSort(list, len);
        System.out.println();
    }
    
    //Method that returns the longest word's length in a String
    public static int getLongestWordLength(String str) {
        int n = str.length();
        int res = 0;
        int temp = 0;
        
        for(int i=0;i < n;i++){
            //If the current char isn't at the end of the current word
            if(str.charAt(i) != ' ') {
                temp++;
            } else{ //If the end of the word is found
                res = Math.max(res,temp);
                temp = 0;
            }
        }
        
        //Do max one more time because the last word might not 
        //have any space after it
        return Math.max(res, temp);
    }
    
    //Method that prints list
    public static void printList(List<String> list){
        System.out.print("  ");
        for(int i = 0; i < list.size(); i++){
            if (i < list.size() - 1)
                System.out.print(list.get(i) + " ");
            else
                System.out.print(list.get(i));
        }
    }
    
    
    //Method that sorts a list by looping numLettersInLongestWord length
    //and puts a word from a list into a bucket based on the letters nth
    //place letter.
    public static void radixSort(List<String> list, int numLettersInLongestWord){
        //Initialize bucket list
        List<String>[] buckets = new List[27];
        
        int tracker = numLettersInLongestWord - 1;
        
        //Add a linked list in each bucket to store words from list
        for(int i = 0;i < buckets.length;i++){
            //I chose to use linked lists, because I'll beable to access
            //strings from any index and it keeps the order of elements inserted
            buckets[i] = new LinkedList();
        }
        
        //Instantiate variables that will keep track of word lengths
        int largestLength = -1;
        int secondLargestLength = 0;
        
        //Set largest and second largest length words from the list
        for (String s : list) {
            int length = s.length();
            if (length >= largestLength) {
                secondLargestLength = largestLength;
                largestLength = length;
            } else if (secondLargestLength < length) {
                secondLargestLength = length;
            }
        }

        //Check if there's an unusually large word in the list
        if (largestLength > numLettersInLongestWord) {
            throw new IllegalArgumentException("One of the strings is too long");
        }
        
        //Display list for the largest index
        System.out.println("Iterating on index: " + tracker);
        printList(list);

        //i will be equal to the secondLargestLength -1 
        //if seconLargestLength == largestLength
        //or it'll be equal to the secondLargestLength
        for (int i = secondLargestLength == largestLength ? secondLargestLength-1 : secondLargestLength; i >= 0; i--) {
            for (String word : list) {
                //index will equal 0 if the words length is <= 1
                //or it'll equal the char at i - 'a' - 1
                int index = (word.length() <= i) ? 0 : word.charAt(i) - ('a' - 1);
                
                //Add the word to its corresponding index
                buckets[index].add(word);
            } 

            //Clear the list so new values can be added
            list.clear();

            for (List<String> z: buckets) {
                if (z != null) {
                    //Add words in buckets to list
                    list.addAll(z);
                    
                    //Clear z list so new values can be added
                    z.clear();
                }
            }
            
            tracker--;
            
            System.out.println();
            System.out.println("Iterating on index: " + tracker);
            printList(list);
        }
    }
}