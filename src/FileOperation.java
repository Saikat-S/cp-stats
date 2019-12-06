import java.io.*;
import java.security.PrivilegedExceptionAction;
import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

public class FileOperation {
    public void write_topFive_in_file(TreeMap<Integer,String> topFive, String oj){
        try{
            // Open the top_five file
            FileOutputStream fostream;
            if(oj == "uva"){
                fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/output_file/uva_top_five.txt");
            }else if(oj == "female"){
                fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/output_file/female_uva_top_five.txt");
            }else{
                fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/output_file/junior_uva_top_five.txt");
            }

            // Get the object of DataOutputStream
            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            for(Integer key : topFive.descendingKeySet()){
                System.out.println(topFive.get(key) + " : " + key);

                String str = topFive.get(key) + " : " + key;
                bw.write(str);
                bw.newLine();
            }
            bw.close();
            out.close();

        }
        catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public void write_topFive_in_file_cf(TreeMap<Integer,String> topFive, TreeMap<String,Integer> userTree){
        try{
            // Open the top_five file
            FileOutputStream fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/output_file/codeforces_top_five.txt");


            // Get the object of DataOutputStream
            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            String str = "    Name    :   Rating   :  Number of Contest ";
            bw.write(str);
            bw.newLine();

            for(Integer key : topFive.descendingKeySet()){
                System.out.println(topFive.get(key) + " : " + key);

                str = topFive.get(key) + " : " + key + " : " + userTree.get(topFive.get(key));
                bw.write(str);
                bw.newLine();
            }
            bw.close();
            out.close();

        }
        catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }

    public void find_top_five(TreeMap<Integer,String> treeMap, TreeMap<String,Integer> userTree, String oj){
        System.out.println("---------------------- UnSorted --------------------------------");

        for(Map.Entry m:treeMap.entrySet()){
            System.out.println(m.getValue() + " : " + m.getKey());
        }
        System.out.println("----------------------- Sorted ---------------------------------");
        for(Integer key : treeMap.descendingKeySet()){
            System.out.println(treeMap.get(key) + " : " + key);
        }

        TreeMap<Integer,String> topFive = new TreeMap<Integer,String>();

        int i = 0;
        for(Integer key : treeMap.descendingKeySet()){
            topFive.put(key,treeMap.get(key));
            i++;
            if(i>=5){
                break;
            }
        }
        System.out.println("------------------------- Top Five -----------------------------");

        for(Integer key : topFive.descendingKeySet()){
            System.out.println(topFive.get(key) + " : " + key);
        }
        if(oj == "cf"){
            write_topFive_in_file_cf(topFive, userTree);
        }else{
            write_topFive_in_file(topFive,oj);
        }

    }

    public void read_write_from_file_uva(){
        // Create object
        UvaStats obj = new UvaStats();

        TreeMap<Integer,String> treeMap=new TreeMap<Integer,String>();
        TreeMap<String,Integer> userTree = new TreeMap<String,Integer>();
        // Read User Name from File and write in File
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("/home/saikats/IdeaProjects/uva-stats/file/input_file/uva_user_name.txt");
            FileOutputStream fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/all_user_info/uva_user_solve.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br  = new BufferedReader(new InputStreamReader(in));

            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            String usr_id;

            while((usr_id = br.readLine()) != null){
                System.out.println(usr_id);
                if(usr_id.charAt(0) == '#'){
                    bw.write(usr_id);
                    bw.newLine();
                }else{
                    AbstractMap.SimpleEntry<Integer, String> entry = obj.get_total_no_solve(usr_id);
                    Integer total_solve = entry.getKey();
                    String name = entry.getValue();
                    String str = name + " : " + total_solve;
                    bw.write(str);
                    bw.newLine();

                    treeMap.put(total_solve, name);
                }


            }

            // Close input and output file
            in.close();
            br.close();
            bw.close();
            out.close();
            find_top_five(treeMap, userTree, "uva");

        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public void read_write_from_file_codeforces() {
        // Create object
        Codeforces obj = new Codeforces();

        TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
        TreeMap<String,Integer> userTree = new TreeMap<String,Integer>();;
        // Read User Name from File and write in File
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("/home/saikats/IdeaProjects/uva-stats/file/input_file/codeforces_user_handle.txt");
            FileOutputStream fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/all_user_info/codeforces_user_rating.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br  = new BufferedReader(new InputStreamReader(in));

            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            String usr_id;

            while((usr_id = br.readLine()) != null){
                System.out.println(usr_id);
                if(usr_id.charAt(0) == '#'){
                    bw.write(usr_id);
                    bw.newLine();
                }else{
                    AbstractMap.SimpleEntry<Integer, Integer> entry = obj.get_user_rating(usr_id);
                    Integer user_rating = entry.getKey();
                    Integer total_contest = entry.getValue();
                    String name = usr_id;
                    String str = name + " : " + user_rating + " : " + total_contest;
                    bw.write(str);
                    bw.newLine();
                    treeMap.put(user_rating, name);
                    userTree.put(name,total_contest);
                }
            }

            // Close input and output file
            in.close();
            br.close();
            bw.close();
            out.close();

            find_top_five(treeMap, userTree, "cf");

        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public void read_write_from_file_female() {
        // Create object
        UvaStats obj = new UvaStats();

        TreeMap<Integer,String> treeMap=new TreeMap<Integer,String>();
        TreeMap<String,Integer> userTree = new TreeMap<String,Integer>();;
        // Read User Name from File and write in File
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("/home/saikats/IdeaProjects/uva-stats/file/input_file/female_uva_user.txt");
            FileOutputStream fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/all_user_info/female_uva_solve.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br  = new BufferedReader(new InputStreamReader(in));

            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            String usr_id;

            while((usr_id = br.readLine()) != null){
                System.out.println(usr_id);
                if(usr_id.charAt(0) == '#'){
                    bw.write(usr_id);
                    bw.newLine();
                }else{
                    AbstractMap.SimpleEntry<Integer, String> entry = obj.get_total_no_solve(usr_id);
                    Integer user_rating = entry.getKey();
                    String name = entry.getValue();
                    String str = name + " : " + user_rating;
                    bw.write(str);
                    bw.newLine();

                    treeMap.put(user_rating, name);
                }


            }

            // Close input and output file
            in.close();
            br.close();
            bw.close();
            out.close();

            //find_top_five(treeMap, userTree, "female");

        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
    public void read_write_from_file_jurior() {
        // Create object
        UvaStats obj = new UvaStats();

        TreeMap<Integer,String> treeMap=new TreeMap<Integer,String>();
        TreeMap<String,Integer> userTree = new TreeMap<String,Integer>();;

        // Read User Name from File and write in File
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream("/home/saikats/IdeaProjects/uva-stats/file/input_file/junior_uva_user.txt");
            FileOutputStream fostream = new FileOutputStream("/home/saikats/IdeaProjects/uva-stats/file/all_user_info/junior_uva_solve.txt");

            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br  = new BufferedReader(new InputStreamReader(in));

            DataOutputStream out = new DataOutputStream(fostream);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

            String usr_id;

            while((usr_id = br.readLine()) != null){
                System.out.println(usr_id);
                if(usr_id.charAt(0) == '#'){
                    bw.write(usr_id);
                    bw.newLine();
                }else{
                    AbstractMap.SimpleEntry<Integer, String> entry = obj.get_total_no_solve(usr_id);
                    Integer user_rating = entry.getKey();
                    String name = entry.getValue();
                    String str = name + " : " + user_rating;
                    bw.write(str);
                    bw.newLine();

                    treeMap.put(user_rating, name);
                }


            }

            // Close input and output file
            in.close();
            br.close();
            bw.close();
            out.close();

            //find_top_five(treeMap, userTree, "junior");

        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
}