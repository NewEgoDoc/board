package com.example.board.vo;

import java.util.Objects;

public class BoardVO {
	private long seq; //number(11) primary key,
	private String title; //varchar2(250) CONSTRAINT bd_title_nn not null,
	private String writer; //varchar2(25),
	private String content; //varchar2(2000),
    private String regDate; //date default sysdate,
    private long cnt; //number(11)
    //
	public BoardVO() {
		
	}
	
	public BoardVO(long seq, String title) {
		super();
		this.seq = seq;
		this.title = title;
	}

	public BoardVO(long seq, String title, String writer, String content, String regDate, long cnt) {
		this.seq = seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.cnt = cnt;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public long getCnt() {
		return cnt;
	}

	public void setCnt(long cnt) {
		this.cnt = cnt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnt, content, regDate, seq, title, writer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return cnt == other.cnt && Objects.equals(content, other.content) && Objects.equals(regDate, other.regDate)
				&& seq == other.seq && Objects.equals(title, other.title) && Objects.equals(writer, other.writer);
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}
    
    
}
