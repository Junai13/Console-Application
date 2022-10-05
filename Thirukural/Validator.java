package thirukkural;

import java.util.Scanner;
import java.util.regex.Pattern;

import static thirukkural.GetKural.RED;
import static thirukkural.GetKural.RESET;

public class Validator {
    private static Pattern kural_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern athikaram_PATTERN = Pattern.compile("^\\{1,3}$");
    private static Pattern arathupaal_PATTERN = Pattern.compile("^[1,3][0,9]");
    Scanner sc = new Scanner(System.in);

    public String validateKural() {
        String kuralNo;
        while (true) {
            System.out.println("Enter Kural Number: ");
            kuralNo = sc.nextLine();
            if (!kural_PATTERN.matcher(kuralNo).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID KURAL NUMBER "+RESET);
            } else {
                break;
            }
        }
        return kuralNo;
    }
    public String validateAthikaram() {
        String athikaramNo;
        while (true) {
            System.out.println("Enter Athikaram Number: ");
            athikaramNo = sc.nextLine();
            if (!kural_PATTERN.matcher(athikaramNo).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID Athikaram NUMBER "+RESET);
            } else {
                if(Integer.parseInt(athikaramNo)<0||Integer.parseInt(athikaramNo)>130){
                    System.out.println(RED+"SORRY ! PLEASE ENTER VALID Athikaram NUMBER "+RESET);
                }else
                    break;
            }
        }
        return athikaramNo;
    }
    public String validateArathupaal(int num){
        while (true){

        }
    }
}
