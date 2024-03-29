package exam.day3.board;

import java.util.ArrayList;
import java.util.Scanner;
///
public class ArticleController {

	Scanner scan = new Scanner(System.in);
	ArrayList<Article> articles = new ArrayList<>();
	MemberController memberController = new MemberController();
	ReadController readController = new ReadController();
	int lastArticleId = 4;

	public ArticleController() {
		makeTestData();
	}

	public void doCommand(String cmd) {

		if (cmd.equals("list")) {
			list();

		} else if (cmd.equals("delete")) {
			delete();

		} else if (cmd.equals("update")) {
			update();

		} else if (cmd.equals("add")) {

			if (memberController.loginedMember == null) {
				System.out.println("로그인이 필요한 기능입니다.");
				return;
			}

			add();

		} else if (cmd.equals("search")) {
			search();

		} else if (cmd.equals("read")) {
			read();
		}
	}

	private void read() {

		System.out.print("상세보기할 게시물 번호를 입력해주세요 :");
		int id = Integer.parseInt(scan.nextLine());
		int targetIndex = findIndexByArticleId(id);

		if (targetIndex == -1) {
			System.out.println("없는 게시물입니다.");
		} else {
			Article article = articles.get(targetIndex);
			article.hit++; // 조회수 1증가
			printArticle(article);

			// 상세보기 프로세스
			while (true) {
				System.out.println("reply. 댓글 등록, like. 좋아요, update. 수정, delete. 삭제, back. 목록으로 ");
				String cmd = scan.nextLine();
				if (cmd.equals("back")) {
					break;
				}
				readController.doCommand(cmd, article);
				printArticle(article);
			}
		}

	}

	private void printArticle(Article article) {

		String nicknameOfArticle = memberController.getNicknameByMemberId(article.memberId);

		System.out.println("==== " + article.id + "번 게시물 ====");
		System.out.println("번호 : " + article.id);
		System.out.println("제목 : " + article.title);
		System.out.println("-------------------");
		System.out.println("내용 : " + article.body);
		System.out.println("-------------------");
		System.out.println("작성자 : " + nicknameOfArticle);
		System.out.println("등록날짜 : " + article.regDate);
		
		Like like = readController.getLikeByArticleIdAndMemberId(article.id, MemberController.loginedMember.id);
		int count = readController.getLikeCountOfArticle(article.id);
		
		if (like == null) {			
			System.out.println("좋아요 : ♡ " + count);
		} else {
			System.out.println("좋아요 : ♥ " + count);			
		}
		System.out.println("조회수 : " + article.hit);
		System.out.println("===================");
		System.out.println("======= 댓글 =======");

		ArrayList<Reply> replies = readController.replies;

		for (int i = 0; i < replies.size(); i++) {
			Reply reply = replies.get(i);
			
			if(reply.articleId == article.id) {				
				String nicknameOfReply = memberController.getNicknameByMemberId(reply.memberId);
				System.out.println("내용 : " + reply.body);
				System.out.println("작성자 : " + nicknameOfReply);
				System.out.println("작성일 : " + reply.regDate);
				System.out.println("====================");
			}
			
			
		}

	}

	private void printArticles(ArrayList<Article> targetList) {
		for (int i = 0; i < targetList.size(); i++) {
			Article article = targetList.get(i);
			String nickname = memberController.getNicknameByMemberId(article.memberId);
			System.out.println("번호 : " + article.id);
			System.out.println("제목 : " + article.title);
			System.out.println("작성자 : " + nickname);
			System.out.println("등록날짜 : " + article.regDate);
			System.out.println("조회수 : " + article.hit);
			System.out.println("=====================");
		}
	}

	private void search() {
		System.out.print("검색 키워드를 입력해주세요 :");
		String keyword = scan.nextLine();

		ArrayList<Article> searchedList = new ArrayList<>();

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.title.contains(keyword)) {
				searchedList.add(article);
			}
		}

		printArticles(searchedList);
	}

	private void delete() {

		System.out.print("삭제할 게시물 번호 : ");
		int targetId = Integer.parseInt(scan.nextLine());

		int index = findIndexByArticleId(targetId);

		if (index == -1) {
			System.out.println("없는 게시물 번호입니다.");
		} else {

			articles.remove(index);
			System.out.println("삭제가 완료되었습니다.");
			list();
		}
	}

	private void list() {
		printArticles(articles);
	}

	public int findIndexByArticleId(int targetId) {
		int index = -1;

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			if (targetId == article.id) {
				index = i;
				break;
			}
		}

		return index;
	}

	private void add() {
		// ids[lastIndex] = lastIndex + 1;
		// ids.add(lastIndex + 1);

		System.out.print("제목을 입력해주세요 : ");
		String title = scan.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = scan.nextLine();
		String currentDate = MyUtil.getCurrentDate();

		Article a1 = new Article(lastArticleId, title, body, memberController.loginedMember.id, currentDate, 0);
		articles.add(a1);

		System.out.println("게시물이 저장되었습니다.");
		lastArticleId++;
	}

	private void update() {
		System.out.print("수정할 게시물 번호 : ");
		int targetId = Integer.parseInt(scan.nextLine());

		int index = findIndexByArticleId(targetId);

		if (index == -1) {
			System.out.println("없는 게시물 번호입니다.");
		} else {
			System.out.print("제목 : ");
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String body = scan.nextLine();

			articles.set(index, new Article(targetId, title, body, 1, "2021.01.02", 0));

			System.out.println("게시물 수정이 완료되었습니다.");
			list();
		}
	}

	private void makeTestData() {
		Article a1 = new Article(1, "안녕하세요", "내용1", 1, "2021.01.02", 0);
		Article a2 = new Article(2, "반갑습니다", "내용2", 2, "2021.01.02", 0);
		Article a3 = new Article(3, "안녕2", "내용3", 1, "2021.01.02", 0);

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
	}
}
