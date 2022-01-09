package exam.day3.board;

public class Reply {

	int id;	// 댓글 식별 데이터
	int articleId;// 댓글이 달린 원래 게시물 번호
	String body; // 댓글내용
	int memberId; // 작성자
	String regDate; //작성일
	
	public Reply(int id, int articleId, String body, int memberId, String regDate) {
		super();
		this.id = id;
		this.articleId = articleId;
		this.body = body;
		this.memberId = memberId;
		this.regDate = regDate;
	}
	
}
