package DTO;

public class LikedArticleDTO {
	private String userName;
	private int newsId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public LikedArticleDTO(String userName, int newsId) {
		super();
		this.userName = userName;
		this.newsId = newsId;
	}

	public LikedArticleDTO() {
		super();
	}

}
