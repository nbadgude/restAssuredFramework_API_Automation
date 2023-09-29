package pojo;

public class Pojo_CreateMPOrder {
	private String user_id;
	private String store_id;
	private String item_id;
	private int qty;
	
	
	public Pojo_CreateMPOrder(String user_id, String store_id, String item_id, int qty) {
		this.user_id = user_id;
		this.store_id = store_id;
		this.item_id = item_id;
		this.qty = qty;
	}

	

	@Override
	public String toString() {
		return "Pojo_CreateMPOrder [user_id=" + user_id + ", store_id=" + store_id + ", item_id=" + item_id + ", qty="
				+ qty + "]";
	}



	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getStore_id() {
		return store_id;
	}


	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}


	public String getItem_id() {
		return item_id;
	}


	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
