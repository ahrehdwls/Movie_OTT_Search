package movielist.Colletion;

public class collectionBean {
	
	private int clnum;
	private String cl_img;
	private String cl_title;
	private String cl_subtitle;
	private String cl_story;
	private String cl_rate;
	private String cl_director;
	private String cl_actor;
	private String cl_pubdate;
	
	
	public collectionBean() {
		
	}
	
	
	public collectionBean(int clnum, String cl_img, String cl_title, String cl_subtitle, String cl_story,
			String cl_rate, String cl_director, String cl_actor, String cl_pubdate) {
		super();
		this.clnum = clnum;
		this.cl_img = cl_img;
		this.cl_title = cl_title;
		this.cl_subtitle = cl_subtitle;
		this.cl_story = cl_story;
		this.cl_rate = cl_rate;
		this.cl_director = cl_director;
		this.cl_actor = cl_actor;
		this.cl_pubdate = cl_pubdate;
	}
	public int getClnum() {
		return clnum;
	}
	public void setClnum(int clnum) {
		this.clnum = clnum;
	}
	public String getCl_img() {
		return cl_img;
	}
	public void setCl_img(String cl_img) {
		this.cl_img = cl_img;
	}
	public String getCl_title() {
		return cl_title;
	}
	public void setCl_title(String cl_title) {
		this.cl_title = cl_title;
	}
	public String getCl_subtitle() {
		return cl_subtitle;
	}
	public void setCl_subtitle(String cl_subtitle) {
		this.cl_subtitle = cl_subtitle;
	}
	public String getCl_story() {
		return cl_story;
	}
	public void setCl_story(String cl_story) {
		this.cl_story = cl_story;
	}
	public String getCl_rate() {
		return cl_rate;
	}
	public void setCl_rate(String cl_rate) {
		this.cl_rate = cl_rate;
	}
	public String getCl_director() {
		return cl_director;
	}
	public void setCl_director(String cl_director) {
		this.cl_director = cl_director;
	}
	public String getCl_actor() {
		return cl_actor;
	}
	public void setCl_actor(String cl_actor) {
		this.cl_actor = cl_actor;
	}
	public String getCl_pubdate() {
		return cl_pubdate;
	}
	public void setCl_pubdate(String cl_pubdate) {
		this.cl_pubdate = cl_pubdate;
	}
	

	
}
