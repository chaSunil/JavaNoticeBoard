package db.vo;

public class VisitVo {

	int idx;
	int no;
	String name;
	String content;
	String pwd;
	String ip;
	String regdate;
	// 오버로드 된 생성자를 만들면, 무조건 기본 생성자를 만들어야 한다. (매개변수 인자를 안넣은 곳이 있기 때문이다)
	public VisitVo(String name, String content, String pwd, String ip) {
		super();
		this.name = name;
		this.content = content;
		this.pwd = pwd;
		this.ip = ip;
	}
	
	public VisitVo() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}