import java.io.*;
import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

public class FileOperation {
    public void write_topFive_in_file(TreeMap<Integer,String> topFive){
        try{
            // Open the top_five file
            FileOutputStream fostream = new FileOutputStream(""file_path"/file/top_five.txt");

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

    public void find_top_five(TreeMap<Integer,String> treeMap){
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
        write_topFive_in_file(topFive);
    }

    public void read_write_from_file(){
        // Create object
        UvaStats obj = new UvaStats();

        TreeMap<Integer,String> treeMap=new TreeMap<Integer,String>();

        // Read User Name from File and write in File
        try{
            // Open the file
            FileInputStream fstream = new FileInputStream(""file_path"/file/input.txt");
            FileOutputStream fostream = new FileOutputStream(""file_path"/file/output.txt");

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

            find_top_five(treeMap);

        }catch (Exception ex){
            System.out.println("Error : " + ex.getMessage());
        }
    }
}
