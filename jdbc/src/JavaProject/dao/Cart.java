package JavaProject.dao;

public class Cart {
	
	private String Member_id;
	private int Product_no;
	private int Cart_amount;
	private int Cart_no;
	
	public int getCart_no() {
		return Cart_no;
	}
	public void setCart_no(int cart_no) {
		Cart_no = cart_no;
	}
	public String getMember_id() {
		return Member_id;
	}
	public void setMember_id(String member_id) {
		Member_id = member_id;
	}
	public int getProduct_no() {
		return Product_no;
	}
	public void setProduct_no(int product_no) {
		Product_no = product_no;
	}
	public int getCart_amount() {
		return Cart_amount;
	}
	public void setCart_amount(int cart_amount) {
		Cart_amount = cart_amount;
	}
	
}
