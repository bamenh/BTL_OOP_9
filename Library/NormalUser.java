import java.util.Scanner;

public class NormalUser extends User {
    
    protected IOOperation[] operations;

    public NormalUser(String name) {
        super(name);
        this.operations = new IOOperation[] {
            new ViewBooks(),
            new Search(),
            new PlaceOders(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()
        };
    }
    public NormalUser(String name, String email, String phonenumber) {
        super(name, email,  phonenumber);
        this.operations = new IOOperation[] {
            new ViewBooks(),
            new Search(),
            new PlaceOders(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
            new Exit()
        };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View books");
        System.out.println("2. Search");
        System.out.println("3. Place oders");
        System.out.println("4. Borrow book");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return book");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
        s.close();
    }
    public String toString() {
        return name + "<N/>" + email + "<N/>" + phonenumber + "<N/>" + "NormalUser";
    }
}
