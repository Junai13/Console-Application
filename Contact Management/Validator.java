package contactmanagement;
import java.util.Scanner;
import java.util.regex.Pattern;
public class Validator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String PURPLE="\u001B[35m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    private static Pattern choice_PATTERN = Pattern.compile("^\\d{1,6}$");
    private static Pattern mobileNo_Pattern = Pattern.compile("[0-9]+");
    private static Pattern option_pattern = Pattern.compile("^[0,1]$");
    private static Pattern dob_pattern = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
    static Scanner sc = new Scanner(System.in);

    public int validateOption(){
        String option;
        while(true){
            System.out.println("Enter choice: ");
            option = sc.next();
            if(!option_pattern.matcher(option).matches()){
                System.out.println(RED+ " SORRY PLEASE ENTER VALID CHOICE!!!!"+ RESET);
            }else break;
        }
        return Integer.parseInt(option);
    }
    public String validateDoB(){
        String doB;
        while(true){
            System.out.println("Enter Date of Birth(NOTE: PLEASE ENTER DOB AS YEAR-MON-DATE FORMAT ONLY. EX. 2001-03-01) : ");
            sc.nextLine();
            doB = sc.nextLine();
            if(!dob_pattern.matcher(doB).matches()){
                System.out.println(RED+ " SORRY!!! YOU HAD ENTER WRONG PATTERN. PLEASE ENTER CORRECT PATTERN."+ RESET);
            }
            else break;
        }
        return doB;
    }
    public String validateChoice() {
        String choice;
        while (true) {
            System.out.println("Enter choice ");
            choice = sc.nextLine();
            if (!choice_PATTERN.matcher(choice).matches()) {
                System.out.println(RED + "SORRY ! PLEASE ENTER VALID choice " + RESET);
            } else {
                break;
            }
        }
        return choice;
    }
    public long validatemobile() {
        String mobno;
        while (true) {
            System.out.println("Enter Mobile Number ");
            mobno = sc.nextLine();
            if (!mobileNo_Pattern.matcher(mobno).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID Mobile Number "+RESET);
            } else {
                break;
            }
        }
        return Long.parseLong(mobno);
    }
}
