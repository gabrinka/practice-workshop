package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HashMap<String,String> phonetable = new HashMap<String, String>();
        phonetable.put("2","Kote");
        phonetable.put("4","Kote222");
        System.out.println(phonetable);



        Map<String,String> phonetable2 = new HashMap<>();
        phonetable2.put("Gabi","Marto");
        phonetable2.put("Mama","Tate");
        Set<Map.Entry<String,String>> entries = phonetable2.entrySet();
        phonetable2.putAll(phonetable);
        for(Map.Entry<String,String> entry : entries){
            System.out.println(entry.getKey() +" "+ entry.getValue());

        }
    }
}
