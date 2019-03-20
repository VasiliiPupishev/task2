import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class EntryPoint {
    static ArrayList<Integer> color = new ArrayList<Integer>();
    public static void main(String[] arg){
        int count = 0;
        String strf = "";
        String strf1 = "";
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\T_e_n_Jl_bl_u\\IdeaProjects\\task1\\in.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null){
                if (i == 0){
                    count = Integer.parseInt(strLine);
                } else if (i <= count){
                    g.add(new ArrayList<Integer>());
                    String temp = "";
                    for(int j = 0; j < strLine.length(); j++){
                        if (strLine.charAt(j) == ' ' && temp.length() > 0 && !temp.equals("0")){
                            g.get(i - 1).add(Integer.parseInt(temp) - 1);
                            temp = "";
                        }else{
                            temp += strLine.charAt(j);
                        }
                    }
                }
                i++;
            }
        }catch (IOException e){
            System.out.println("Ошибка чтения файла.");
        }
        for (int i = 0; i < count; i++){
            //System.out.print("Вершина ");
            //System.out.print(i + 1);
            //System.out.print(" смежна с ");
            //for (int j = 0; j < g.get(i).size(); j++){
                //System.out.print(g.get(i).get(j));
                //System.out.print(" ");
            //}
            //System.out.println();
        }
        for (int i = 0; i < count; i++){
            color.add(0);
        }
        Boolean ok = true;
        for (int i = 0; i < count; i++){
            if (color.get(i) == 0){
                color.set(i, 1);
                dfs(i, g);
            }
        }
        System.out.println("yes");
    }

    static void dfs(int start, ArrayList<ArrayList<Integer>> g){
        for (int u = 0; u < g.get(start).size(); u++) {
            if (color.get(g.get(start).get(u)) == 0) {
                color.set(g.get(start).get(u), 3 - color.get(start));
                dfs(g.get(start).get(u), g);
            } else if (color.get(g.get(start).get(u)).equals(color.get(start))){
                System.out.println("no");
                System.exit(0);
            }
        }
    }
}
