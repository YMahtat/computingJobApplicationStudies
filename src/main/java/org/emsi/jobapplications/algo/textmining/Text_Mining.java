package org.emsi.jobapplications.algo.textmining;

import java.util.ArrayList;

public class Text_Mining {
    private CleanedMatrix x;
    private ArrayList<ArrayList<Distance_per_word>> DPW;
    public Text_Mining(ArrayList<String> All_discription) {
       x=new CleanedMatrix(All_discription);
    }
    public void Call_Kmeans_algorithm(int ClusterNumbers)
    {
        System.out.println(x.getData()[0].length);
        Distance_per_word.Liste_of_words=x.getList();
        Kmeans K=new Kmeans(x.getData(),ClusterNumbers);

        K.calculateClusters();
       DPW= K.List_Of_Clusters;

    }
    public ArrayList<Distance_per_word> Distance_per_word_per_cluster(int i)
    {
        return DPW.get(i);
    }
	public ArrayList<ArrayList<Distance_per_word>> getDPW() {
		return DPW;
	}
	public void setDPW(ArrayList<ArrayList<Distance_per_word>> dPW) {
		DPW = dPW;
	}
    
    

}
