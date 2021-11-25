package movielist;

public class croll_movieBean {
	
	private int mnum;
	private String imgsrc_DB;//d
	private String title_DB;//d
	private String subtitle_DB;// n
	private String story_DB;//d
	private String userRating_DB;//n
	private String director_DB;//n
	private String actor_DB;//n
	private String pubdate_DB;//n
	
	public croll_movieBean() {
		
	}
	
	
	
	
	public croll_movieBean(int mnum, String imgsrc_DB, String title_DB, String subtitle_DB, String story_DB,
			String userRating_DB, String director_DB, String actor_DB, String pubdate_DB) {
		super();
		this.mnum = mnum;
		this.imgsrc_DB = imgsrc_DB;
		this.title_DB = title_DB;
		this.subtitle_DB = subtitle_DB;
		this.story_DB = story_DB;
		this.userRating_DB = userRating_DB;
		this.director_DB = director_DB;
		this.actor_DB = actor_DB;
		this.pubdate_DB = pubdate_DB;
	}




	public croll_movieBean(String imgsrc_DB, String title_DB, String subtitle_DB, String story_DB, String userRating_DB,
			String director_DB, String actor_DB, String pubdate_DB) {
		super();
		this.imgsrc_DB = imgsrc_DB;
		this.title_DB = title_DB;
		this.subtitle_DB = subtitle_DB;
		this.story_DB = story_DB;
		this.userRating_DB = userRating_DB;
		this.director_DB = director_DB;
		this.actor_DB = actor_DB;
		this.pubdate_DB = pubdate_DB;
	}


	public String getImgsrc_DB() {
		return imgsrc_DB;
	}
	public void setImgsrc_DB(String imgsrc_DB) {
		this.imgsrc_DB = imgsrc_DB;
	}
	public String getTitle_DB() {
		return title_DB;
	}
	public void setTitle_DB(String title_DB) {
		this.title_DB = title_DB;
	}
	public String getSubtitle_DB() {
		return subtitle_DB;
	}
	public void setSubtitle_DB(String subtitle_DB) {
		this.subtitle_DB = subtitle_DB;
	}
	public String getStory_DB() {
		return story_DB;
	}
	public void setStory_DB(String story_DB) {
		this.story_DB = story_DB;
	}
	public String getUserRating_DB() {
		return userRating_DB;
	}
	public void setUserRating_DB(String userRating_DB) {
		this.userRating_DB = userRating_DB;
	}
	public String getDirector_DB() {
		return director_DB;
	}
	public void setDirector_DB(String director_DB) {
		this.director_DB = director_DB;
	}
	public String getActor_DB() {
		return actor_DB;
	}
	public void setActor_DB(String actor_DB) {
		this.actor_DB = actor_DB;
	}
	public String getPubdate_DB() {
		return pubdate_DB;
	}
	public void setPubdate_DB(String pubdate_DB) {
		this.pubdate_DB = pubdate_DB;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
	

}
