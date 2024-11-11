package cardenas;

public class Textbook {
	private int sku;
	private String title;
	private double price;
	private int quantity;
	
	public Textbook() {
		sku = 0;
		title = "null";
		price = 0;
		quantity = 0;
	}
	
	public Textbook(int sku, String title, double price, int quantity) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getSku() {
		return sku;
	}
	
	public void setSku(int sku) {
		this.sku = sku;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		String p = String.format("%.2f", price);
		return "SKU: " + sku + " Title: " + title + " Price: $" + p + " Quantity: " + quantity + "\n";
	}
	
}
