package movielist;

public class MovieDetailBean {

	private String image;
	private String userRating;
	private String title;
	private String subtitle;
	private String pubDate;
	private String director;
	private String actor;
	private String link;
	
	public MovieDetailBean() {
		
	}
	
	public MovieDetailBean(String image, String userRating, String title, String subtitle, String pubDate,
			String director, String actor, String link) {
		super();
		this.image = image;
		this.userRating = userRating;
		this.title = title;
		this.subtitle = subtitle;
		this.pubDate = pubDate;
		this.director = director;
		this.actor = actor;
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserRating() {
		return userRating;
	}
	public void setUserRating(String userRating) {
		this.userRating = userRating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	
	
	
	}


