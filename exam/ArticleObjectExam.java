package exam.day3.board.exam;

import exam.day3.board.Article;

public class ArticleObjectExam {

	public static void main(String[] args) {
		
//		Article a1 = new Article(); // 게시물 하나 만들겠다.
//		a1.id = 1;
//		a1.title = "aaa";
//		a1.body = "bbb";
		
		Article a1 = new Article(1, "aaa", "bbb"); // 게시물 하나 만들겠다.
		
		// a1이라는 객체 -> 세개의 데이터(게시물 데이터)를 들고 있는 바구니
		System.out.println(a1.id);
		System.out.println(a1.title);
		System.out.println(a1.body);
		
	}

}
