// Saikat Sharma
// @Saikat
public class Main {
    public static void main(String[] args) throws Exception {
        // Create objects
        UvaStats obj = new UvaStats();
        FileOperation fileOp = new FileOperation();

        fileOp.read_write_from_file();

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