import java.util.Scanner;

public class ReturnBook implements IOOperation {
    @Override
    public void oper(Database database, User user) {
        System.out.println("\nEnter book name:");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();
        s.close();
        for (Borrowing b : database.getBrws()) {
            if (b.getBook().getName().matches(user.getName())){
                Book book = b.getBook();
                if (b.getDaysLeft()<0) {
                    System.out.println("You are late!\n"
                    +"You have to pay" +Math.abs(b.getDaysLeft()*50)+ "as fine\n");
                }
                book.setBrwcopies(book.getBrwcopies()+1);
                int bookIndex = database.getBook(bookname);
                database.returnBook(b, book, bookIndex);
                System.out.println("Book return\n Thank you!");
                return;
            }
        }
        System.out.println("You didn't borrow this book!");
        user.menu(database, user);

    }
}

