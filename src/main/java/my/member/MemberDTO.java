package my.member;

public class MemberDTO {
	private int no;
	private String name;
	private String id;
	private String password;
	private String rrn1;
	private String rrn2; 
	private String email;
	
	public MemberDTO() {
		
	}
	public MemberDTO(int no, String name, String id, String password, String rrn1, String rrn2, String email) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.password = password;
		this.rrn1 = rrn1;
		this.rrn2 = rrn2;
		this.email = email;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRrn1() {
		return rrn1;
	}
	public void setRrn1(String rrn1) {
		this.rrn1 = rrn1;
	}
	public String getRrn2() {
		return rrn2;
	}
	public void setRrn2(String rrn2) {
		this.rrn2 = rrn2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
