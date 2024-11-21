import java.util.ArrayList;

public class ViewBooks implements IOOperation {

    @Override
    public void oper(Database database, User user) {
        ArrayList<Book> books = database.getAllBooks();
        // print formatting data
        System.out.println("Name\tAuthor\tPublisher\tCollection location Address\tStatus\tQty\tPrice"
            + "\tBorrowing copies");
        for (Book b : books) {
            System.out.println(b.getName() + "\t" +b.getAuthor() + "\t" + b.getPublisher() + "\t" +
                    b.getAddress() + "\t" + b.getStatus()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+ b.getBrwcopies());
        }
        System.out.println();
        user.menu(database, user);
    }
}
