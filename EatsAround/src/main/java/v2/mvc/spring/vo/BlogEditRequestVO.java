package v2.mvc.spring.vo;

public class BlogEditRequestVO {
	private int blogContSeq;
	private String title;
	private String contBdy;
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBlogContSeq() {
		return blogContSeq;
	}
	public void setBlogContSeq(int blogContSeq) {
		this.blogContSeq = blogContSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContBdy() {
		return contBdy;
	}
	public void setContBdy(String contBdy) {
		this.contBdy = contBdy;
	}
}
