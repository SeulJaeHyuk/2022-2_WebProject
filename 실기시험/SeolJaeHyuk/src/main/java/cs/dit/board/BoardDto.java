package cs.dit.board;

public class BoardDto {
	
	int num;
	String p_name;
	int quantity;
	int price;
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BoardDto() {
	}

	public BoardDto(int num, String p_name, int quantity, int price) {
		this.num = num;
		this.p_name = p_name;
		this.quantity = quantity;
		this.price = price;
	}
	
	
		
}
