import java.util.Scanner;

public class Exit implements IOOperation{

    Scanner s;
    Database database;
    User user;


    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;
        System.out.println("\nAre you sure that you want to quit?\n"
                + "1. Yes\n2. Main Menu");
        s = new Scanner(System.in);
        int i = s.nextInt();
        if (i==1) {
            System.out.println("0.Exit\n1. Login\n2. New User");
            s = new Scanner(System.in);
            int num = s.nextInt();

            switch (num) {
                case 1: login(); break;
                case 2: Main.newuser(); break;
            }
        } else {
            user.menu(database, user);
        }
    }

    private void login() {
        System.out.println("Enter phone number:");
        String phonenumber = s.next();

        System.out.println("Enter email:");
        String email = s.next();
        int n = database.login(phonenumber, email);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database, user);
        }
        else {
            System.err.println("User doesn't exist!");
        }
    }

    private void newuser() {
        System.out.println("New User Registration:");

        System.out.println("Enter full name:");
        String fullname = s.next();  //switch "fullname" to "nickname"

        System.out.println("Enter phone number:");
        String phonenumber = s.next();

        System.out.println("Enter email:");
        String email = s.next();

        System.out.println("1. Admin\n2. Normal User");
        int n2 = s.nextInt();
        User user;
        if (n2 == 1 ) {
            user = new Admin(fullname, email, phonenumber);
        }
        else {
            user = new NormalUser(fullname, email, phonenumber);
        }
        database.AddUser(user);
        user.menu(database, user);
    }
}
