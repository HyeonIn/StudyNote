package model;

public class BoardDTO {
//	bno int primary key auto_increment,
//    title varchar(50) not null,
//    writer varchar(50) not null,
//    content text,
//	write_date datetime, 
//    read_count int default 0
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String writeDate;
	private int readCount;
	
	public BoardDTO() {}
	
	public BoardDTO(int bno, String title, String writer, String content, String writeDate, int readCount) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
		this.readCount = readCount;
	}

	public BoardDTO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content + ", writeDate="
				+ writeDate + ", readCount=" + readCount + "]";
	}
	
	
}
