package org.emsi.jobapplications.algo.textmining;

import java.util.ArrayList;

public class Distance_per_word implements Comparable<Distance_per_word>{
   private String key;
   private Double value;
   public static ArrayList<String> Liste_of_words;
    public Distance_per_word(int Mot,Double Distance)
    {
       key= Liste_of_words.get(Mot);
       value=Distance;
    }

   
    public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public static ArrayList<String> getListe_of_words() {
		return Liste_of_words;
	}


	public static void setListe_of_words(ArrayList<String> liste_of_words) {
		Liste_of_words = liste_of_words;
	}


	@Override
	public String toString() {
		return "{'key':'" + key + "', 'value':" + value + "]";
	}


	@Override
    public int compareTo(Distance_per_word obj) {
        if (value>obj.value)
        {
            return 1;
        }
        else if(value<obj.value)
        {
            return -1;
        }
        else {
            return 0;
        }
    }
}
