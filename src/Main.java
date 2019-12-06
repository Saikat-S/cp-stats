import java.util.AbstractMap;

// Saikat Sharma
// @Saikat
public class Main {
    public static void main(String[] args) throws Exception {
        // Create objects

        // for uva information

        //UvaStats obj = new UvaStats();
        FileOperation fileOp = new FileOperation();

        fileOp.read_write_from_file_uva();
        fileOp.read_write_from_file_codeforces();
        fileOp.read_write_from_file_female();
        fileOp.read_write_from_file_jurior();


        // for codeforces informantion
        //Codeforces cf_obj = new Codeforces();
        //AbstractMap.SimpleEntry<Integer, String> rating = cf_obj.get_user_rating("the_belal");
        //System.out.println("User Rating : " + rating);

        //From user input
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your UVA ID: ");
        String usr_id = sc.nextLine();
        System.out.println(usr_id);
        AbstractMap.SimpleEntry<Integer, String> entry = obj.get_total_no_solve(usr_id);

        Integer total_solve = entry.getKey();
        String name = entry.getValue();

        System.out.println("Main Name : " + name);
        System.out.println("Main Tatal Solve : " + total_solve);
        */
    }
}