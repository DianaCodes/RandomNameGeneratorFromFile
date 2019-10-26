/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diana Arita
 */

import java.util.*;
import java.io.*;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class RandomNameGenerator {
    public static void main(String[] args){
        //create readable file for first name
        String firstNamesContent = new String();
        File firstNamesFile = new File("C:\\Users\\SDEMO2\\Documents\\NetBeansProjects\\RandomNameGenerator\\src\\main\\java\\firstNames.txt");
        LinkedList<String> firstNames = new LinkedList<String>();
        
        //add file contents to linked list
        try {
            Scanner sc = new Scanner(new FileInputStream(firstNamesFile));
            while(sc.hasNextLine()) {
                firstNamesContent = sc.nextLine();
                firstNames.add(firstNamesContent);
            }
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated Safely...");
        }
        
        //add random items from linked list to random list
        LinkedList<String> firstNamesRandom = new LinkedList<String>();
        
        Random rand = new Random(); 
        
        for(int i=0;i<20;i++){
            firstNamesRandom.add(firstNames.get(rand.nextInt(firstNames.size())));
        }
        
        //create readable file for last name
        String lastNamesContent = new String();
        File lastNamesFile = new File("C:\\Users\\SDEMO2\\Documents\\NetBeansProjects\\RandomNameGenerator\\src\\main\\java\\lastNames.txt");
        LinkedList<String> lastNames = new LinkedList<String>();
        
        //add file contents to linked list
        try {
            Scanner sc = new Scanner(new FileInputStream(lastNamesFile));
            while(sc.hasNextLine()) {
                lastNamesContent = sc.nextLine();
                lastNames.add(lastNamesContent);
            }
            sc.close();
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("\nProgram terminated Safely...");
        }
        
        //add random items from linked list to new list
        LinkedList<String> lastNamesRandom = new LinkedList<String>();
        
        for(int i=0;i<20;i++){
            lastNamesRandom.add(lastNames.get(rand.nextInt(lastNames.size())));
        }
        
        //add first name value as key and last name value as value in multivalue map
        MultiValuedMap<String, String> namesMap = new ArrayListValuedHashMap<>();
        for(int i=0;i<20;i++){
            namesMap.put(firstNamesRandom.get(i), lastNamesRandom.get(i));
        }
        
        //add last name list to new list and sort new list
        LinkedList<String>  sortedRandomLastNames = new LinkedList<>();
        sortedRandomLastNames.addAll(lastNamesRandom);
        Collections.sort(sortedRandomLastNames);
        
        //Display to user
        System.out.println("Submitted be: Diana Arita - aritad@csp.edu");
        
        System.out.println();
        
        //Display the unsorted 
        System.out.println("Generated Names:");
        
        iterate(namesMap);
        
        System.out.println();
        
        //sort by first name/key
        System.out.println("Sorted by First Name:");

        //add namesMap keys to set to remove duplicates
        Set<String> keySet = new HashSet(namesMap.keys());
        
        List<String> keyList = new ArrayList<>();
        
        //add the set elements to the arraylist
        for(String key : keySet){
            keyList.add(key);
        }
        
        //sort the list
        Collections.sort(keyList);
        
        //iterate through each key and display the correct value with the key
        for(String key : keyList) {
            //display sorted by first name list
            getValueFromKey(namesMap,key);
        }
        
        System.out.println();
        
        //sort by last name/value
        System.out.println("Sorted by Last Name:");
        
        //add namesMap values to set to remove duplicates
        Set<String> valueSet = new HashSet(namesMap.values());
        
        List<String> valueList = new ArrayList<>();
        
        //add the set elements to the arraylist
        for(String val : valueSet){
            valueList.add(val);
        }
        
        //sort the list
        Collections.sort(valueList);
        
        //iterate through each value and display the correct key with the value
        for(String val : valueList) {
            //display sorted by last name list
            getKeyFromValue(namesMap,val);
        }
        
        System.out.println();
        
        //Display the map as 
        System.out.println("Combine all names by First Name:");
        
        //last names are grouped by first name already
        Object[] groupedKeys = namesMap.keySet().toArray();
        for(Object key1 : groupedKeys) {
            System.out.println(key1 + " " + namesMap.get((String) key1));
        }
        
    }
    
    public static<K,V> void iterate(MultiValuedMap<K,V> multiValuedMap)
    {
        int count = 1;
        
	for (Map.Entry<K,V> entry: multiValuedMap.entries()) {
		System.out.println(count + ". " + entry.getKey() + " " + entry.getValue());
                count++;
        }
    }
    
    public static<K,V> void getValueFromKey(MultiValuedMap<K,V> multiValuedMap, String key){
        //get value from key
        //for each key in the map, if the value equals parameter value then add it to the list
        for (Map.Entry<K,V> entry: multiValuedMap.entries()) {   
            if((entry.getKey()).equals(key)){
                System.out.println(key + " " + entry.getValue().toString());
            }
        }
    }
    
    public static<K,V> void getKeyFromValue(MultiValuedMap<K,V> multiValuedMap, String value){
        //get key from value
        //for each key in the map, if the value equals parameter value then add it to the list
        for (Map.Entry<K,V> entry: multiValuedMap.entries()) {   
            if((entry.getValue()).equals(value)){
                System.out.println(entry.getKey().toString() + " " + value);
            }
        }
    }
}