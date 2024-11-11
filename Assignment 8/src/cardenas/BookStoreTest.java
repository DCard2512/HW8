package cardenas;

public class BookStoreTest {
	public static void main(String[] args) {
		Textbook book = new Textbook(430, "Test", 39.99, 4);
		System.out.println(book.toString());
		
		
		Store store = new Store();
		
		store.addTextbook(1, "Red Dead", 59.99, 10);
		store.addTextbook(2, "SpongeBob", 59.99, 10);
		store.addTextbook(434, "Green eggs and ham", 59.99, 10);
		store.addTextbook(2345, "Moby Dick", 59.99, 10);

		System.out.println(store.displayAll());
	}
}
