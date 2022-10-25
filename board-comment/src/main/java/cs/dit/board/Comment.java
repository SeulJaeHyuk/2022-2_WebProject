package cs.dit.board;

import java.sql.Date;

public class Comment {
	private int num;
	private int bcode;
	private int ccode;
	private String content;
	private Date regdate;
	public Comment(int num, int bcode, int ccode, String content, Date regdate) {
		super();
		this.num = num;
		this.bcode = bcode;
		this.ccode = ccode;
		this.content = content;
		this.regdate = regdate;
	}
}
