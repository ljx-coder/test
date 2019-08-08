package entity;

public class Books {
	private Integer bid;
	private String name;
	private String types;
	private Double price;
	private Integer count;
	public Books() {
		super();
	}
	public Books(Integer bid, String name, String types, Double price, Integer count) {
		super();
		this.bid = bid;
		this.name = name;
		this.types = types;
		this.price = price;
		this.count = count;
	}
	public Books(String name, String types, Double price, Integer count) {
		super();
		this.name = name;
		this.types = types;
		this.price = price;
		this.count = count;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", count=" + count + ", name=" + name
				+ ", price=" + price + ", types=" + types + "]";
	}
	

}
