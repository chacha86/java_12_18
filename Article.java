package exam.day3.board;

// 유사한 데이터를 모아두는 것
public class Article {
	
	public int id;// 번호
	public String title;// 제목
	public String body;// 내용
	
	// 생성자 -> 객체를 만들 때 반드시 실행되는 메서드
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
}
