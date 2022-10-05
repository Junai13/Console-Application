package contactmanagement;
public class Contact {
    public void allFunction(int n){
        Oprations oprations = new Oprations();
        Database data = new Database();
        switch (n){
            case 1:
                oprations.addContact();
                break;
            case 2:
                oprations.deleteContact();
                break;
            case 3:
                oprations.searchContact();
                break;
            case 4:
                oprations.updateContact();
                break;
            case 5:
                data.viewAllContact();
                break;
            default:
                System.out.println("Please enter valid input!!!!");
                break;
        }
    }
}
