package contactmanagement;
import java.util.Scanner;
public class GetInput {
    public void getInput(){
        Validator validator= new Validator();
        Contact allfn = new Contact();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println(".....................");
            System.out.println("Please enter one option to continue");
            System.out.println("""
                    1. Add contact
                    2. Delete contact
                    3. Search contact
                    4. Edit contact
                    5. View all contact
                    6. Exit""");
            int choice = Integer.parseInt(validator.validateChoice());
            if(choice==6){
                System.out.println("Thank you \n your application will be closing");
                flag = false;
            }else{
                allfn.allFunction(choice);
            }
        }while(flag);
    }
}
