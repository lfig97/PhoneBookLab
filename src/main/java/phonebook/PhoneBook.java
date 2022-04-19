package phonebook;

import java.sql.Array;
import java.util.*;

public class PhoneBook {
    private Map<String,List<String>> phoneEntry;

    public PhoneBook(Map<String, List<String>> phoneEntry) {
        this.phoneEntry = phoneEntry;
    }

    public PhoneBook(){
        LinkedHashMap<String,List<String>> phoneEntry = new LinkedHashMap<>();
        this.phoneEntry = phoneEntry;
    }

    public void add(String name, String phoneNumber){
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        phoneEntry.put(name,phoneNumbers);
    }

    public void addAll(String name,String[] phoneNumbers){
        phoneEntry.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name){
        phoneEntry.remove(name);
    }

    public boolean hasEntry(String name){
        boolean hasCheck = false;
        for(Map.Entry<String,List<String>> entry: phoneEntry.entrySet()){
            if(entry.getKey().contains(name)){
                hasCheck = true;
            }
            else{
                hasCheck = false;
            }
        }
        return hasCheck;
    }

    public boolean hasEntry(String name,String phoneNumber){
        boolean hasCheck = false;
        for(Map.Entry<String,List<String>> entry: getPhoneEntry().entrySet()){
            if(entry.getKey().contains(name) && entry.getValue().contains(phoneNumber)){
                hasCheck = true;
            }
            else{
                hasCheck = false;
            }
        }
        return hasCheck;
    }

    public List<String> lookup(String name){
        return phoneEntry.get(name);
    }

    public String reverseLookup(String phoneNumber){
        String name = "";
        for(Map.Entry<String,List<String>> entry: phoneEntry.entrySet()){
            for(String number: entry.getValue()){
                if(number.equals(phoneNumber)){
                    name = entry.getKey();
                }
            }
        }
        return name;
    }
    public List<String> getAllContactNames(){
        List<String> names = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: phoneEntry.entrySet()){
            names.add(entry.getKey());
        }
        return names;
    }

    public Map<String, List<String>> getPhoneEntry() {
        return phoneEntry;
    }
}
