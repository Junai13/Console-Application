package library;
public class Person {
    protected int id;           // ID of every person related to library
    protected String name;      // Name of every person related to library
    protected String address;   // Address of every person related to library
    protected String phoneNo;      // PhoneNo of every person related to library
    static int currentIdNumber = 0;
    //when a person is created
    public Person(int idNum, String name, String address, String phoneNum)
    {
        currentIdNumber++;
        if(idNum==-1)
        {
            id = currentIdNumber;
        }
        else
            id = idNum;
        this.name = name;
        this.address = address;
        phoneNo = phoneNum;
    }
    // Printing Info of a Person
    public void printInfo()
    {
        System.out.println("-----------------------------------------");
        System.out.println("\nThe details are: \n");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone No: " + phoneNo + "\n");
    }
    public void setAddress(String a)
    {
        address = a;
    }

    public void setPhone(String p)
    {
        phoneNo = p;
    }

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhoneNumber()
    {
        return phoneNo;
    }
    public int getID()
    {
        return id;
    }
    public static void setIDCount(int n)
    {
        currentIdNumber=n;
    }
}
