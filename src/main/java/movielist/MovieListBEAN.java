package movielist;

public class MovieListBEAN {

	private String title;
	private String imgSrc;
	private String story;
	private String mde_addr;
	
	public MovieListBEAN() {
		
	}

	
	public MovieListBEAN(String title, String imgSrc, String story, String mde_addr) {
		super();
		this.title = title;
		this.imgSrc = imgSrc;
		this.story = story;
		this.mde_addr = mde_addr;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getMde_addr() {
		return mde_addr;
	}

	public void setMde_addr(String mde_addr) {
		this.mde_addr = mde_addr;
	}

	
	
	
	
	
}
