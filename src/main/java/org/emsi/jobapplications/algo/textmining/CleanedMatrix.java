package org.emsi.jobapplications.algo.textmining;



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CleanedMatrix {

    private ArrayList<String> stopwords,Symboles,List;
    double[][] Data;

    public CleanedMatrix(ArrayList<String> Discriptions) {
        Start(Discriptions);
        printMatrice(".\\target\\classes\\static\\algoScripts\\FrequencyMatrix.csv");
    }

    public ArrayList<String> getList() {
        return List;
    }

    public double[][] getData() {
        return Data;
    }

    private ArrayList<String> Load_Words_From_File(String File_name)
    {  ArrayList<String> Words=new ArrayList();
        try {

            BufferedReader br = new BufferedReader(new FileReader(File_name));
            String x;
            while ( (x = br.readLine()) != null )
                Words.add(x);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return Words;
    }

    private void Start(ArrayList<String> Discriptions)
    {
        //Load Stopwords From File
        stopwords=Load_Words_From_File(".\\target\\classes\\static\\algoScripts\\stopwords.txt");
        //Load Symboles From File
        Symboles=Load_Words_From_File(".\\target\\classes\\static\\algoScripts\\symboles.txt");
//Store All the words of every Discription
        ArrayList<ArrayList<String>> List_Of_Words=new ArrayList();
        HashSet<String> Distinct=new HashSet();
        for (String Discription:Discriptions)
        {
            // Split_Words
            ArrayList<String> Local_List=Special_Split(Discription);
            List_Of_Words.add(Local_List);
            Distinct.addAll(Local_List);
        }
        List=new ArrayList<>(Distinct);
        Data=Convert_from_ARRAYLIST_to_ARRAY(Load_Matrice(List,List_Of_Words));
    }
    private ArrayList<String> Special_Split(String Discription)
    {
        //transform text into lowerCase
     //   String Siscription_Lower_Case =Discription.toLowerCase();
        //Remove all Symboles { & | , ; : ...)
        Symboles.forEach(S->{
            Discription.replaceAll(S, " ");});
        //Split The text into Words
        StringTokenizer tokens=new StringTokenizer(Discription);
        //Load Words into ArrayList
        ArrayList<String> Results= new ArrayList();
        while(tokens.hasMoreTokens())
        {
            Results.add(tokens.nextToken().toLowerCase().replaceAll("•","").replaceAll("\\d","").replaceAll("/","").replaceAll("\'", ""));
        }
        Results.removeAll(stopwords);
        return Results;
    }

    private ArrayList<ArrayList<Double>> Load_Matrice(ArrayList<String> Word_per_row,ArrayList<ArrayList<String>> Words_per_column)
    {
        ArrayList<ArrayList<Double>> Results=new ArrayList();
        for(String Word:Word_per_row)
        {
            ArrayList<Double> tempo=new ArrayList<>();
            for (ArrayList<String> Splited_Words_of_Discription:Words_per_column)
            {
                tempo.add(((Integer) Collections.frequency(Splited_Words_of_Discription,Word)).doubleValue());
            }
            Results.add(tempo);
        }
        return Results;
    }
    private double[][] Convert_from_ARRAYLIST_to_ARRAY(ArrayList<ArrayList<Double>> List)
    {
        double[][] LocalArray=new double[List.size()][List.get(0).size()];
        for (int i=0;i<List.size();i++)
        {
            for (int j=0;j<List.get(i).size();j++)
            {
                LocalArray[i][j]=List.get(i).get(j);
            }
        }
        return LocalArray;
    }
    private   void printMatrice(String File_name)
    {

        try {
            PrintWriter pw = new PrintWriter(new File(File_name));
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<Data.length;i++)
            {
                for (int j=0;j<Data[0].length;j++)
                {
                    sb.append(Data[i][j]+";");
                }
                sb.setLength(sb.length()-1);
                sb.append("\n");
            }
            pw.write(sb.toString());
            pw.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }








}
