package thirukkural;

import java.util.Scanner;

import static thirukkural.GetKural.*;
import static thirukkural.GetKural.RESET;

public class Input {
    public void getInput(){
        Scanner sc = new Scanner(System.in);
        GetKural getkural = new GetKural();
        System.out.println(PURPLE + "\u200B\uD83D\uDE4F WELCOME TO THIRUKKURAL APPLICATION \u200B\uD83D\uDE4F " + RESET);
        boolean flag = false;
        do {
            System.out.println(CYAN+"Please Enter Your Choice to continue"+RESET);
            System.out.println("""
                    1. அறத்துப்பால்
                    2. பொருட்பால்
                    3. காமத்துப்பால்
                    4. Enter the no of thirukural
                    5. Enter the no of athikaram
                    6. Exit
                    """);
            String op = sc.next();
            switch(op){
                case "1":
                    getkural.getArathupaal();
                    break;
                case "2":
                    getkural.getPorulPaal();
                    break;
                case "3":
                    getkural.getKamathuPaal();
                    break;
                case "4":
                    getkural.getByNumber();
                    break;
                case "5":
                    getkural.getByAthikaram();
                    break;
                case "6":
                    System.out.println(GREEN+ "\u200B\uD83D\uDE4F Thank You for Choosing Us \u200B\uD83D\uDE4F"+ RESET);
                    flag = true;
                    break;
                default:
                    System.out.println(RED+"Please Enter Valid Choice"+RESET);
            }
        }while(!flag);
    }
}
