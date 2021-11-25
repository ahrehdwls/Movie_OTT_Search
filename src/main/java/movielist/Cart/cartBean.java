package movielist.Cart;

public class cartBean {
	
	private int cartnum;
	private String cart_img;
	private String cart_title;
	private String cart_subtitle;
	private String cart_story;
	private String cart_rate;
	private String cart_director;
	private String cart_actor;
	private String cart_pubdate;
	
	public cartBean() {
		
	}
	
	public cartBean(int cartnum, String cart_img, String cart_title, String cart_subtitle, String cart_story,
			String cart_rate, String cart_director, String cart_actor, String cart_pubdate) {
		super();
		this.cartnum = cartnum;
		this.cart_img = cart_img;
		this.cart_title = cart_title;
		this.cart_subtitle = cart_subtitle;
		this.cart_story = cart_story;
		this.cart_rate = cart_rate;
		this.cart_director = cart_director;
		this.cart_actor = cart_actor;
		this.cart_pubdate = cart_pubdate;
	}
	public int getCartnum() {
		return cartnum;
	}
	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}
	public String getCart_img() {
		return cart_img;
	}
	public void setCart_img(String cart_img) {
		this.cart_img = cart_img;
	}
	public String getCart_title() {
		return cart_title;
	}
	public void setCart_title(String cart_title) {
		this.cart_title = cart_title;
	}
	public String getCart_subtitle() {
		return cart_subtitle;
	}
	public void setCart_subtitle(String cart_subtitle) {
		this.cart_subtitle = cart_subtitle;
	}
	public String getCart_story() {
		return cart_story;
	}
	public void setCart_story(String cart_story) {
		this.cart_story = cart_story;
	}
	public String getCart_rate() {
		return cart_rate;
	}
	public void setCart_rate(String cart_rate) {
		this.cart_rate = cart_rate;
	}
	public String getCart_director() {
		return cart_director;
	}
	public void setCart_director(String cart_director) {
		this.cart_director = cart_director;
	}
	public String getCart_actor() {
		return cart_actor;
	}
	public void setCart_actor(String cart_actor) {
		this.cart_actor = cart_actor;
	}
	public String getCart_pubdate() {
		return cart_pubdate;
	}
	public void setCart_pubdate(String cart_pubdate) {
		this.cart_pubdate = cart_pubdate;
	}
	
	
	

}
