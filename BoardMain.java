package exam.day3.board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardMain {

	static Scanner scan = new Scanner(System.in);

//	static ArrayList<Integer> ids = new ArrayList<>();
//	static ArrayList<String> titles = new ArrayList<>();
//	static ArrayList<String> bodies = new ArrayList<>();
	
	static ArrayList<Article> articles = new ArrayList<>();
	static int lastArticleId = 1; // 가장 마지막에 만들어지 게시물 번호
	
	public static void main(String[] args) {
		
		Article a1 = new Article(1, "제목1", "내용1");
		Article a2 = new Article(2, "제목2", "내용2");
		Article a3 = new Article(3, "제목3", "내용3");
		
		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("list")) {
				list();
				
			}
			else if(cmd.equals("delete")) {
				delete();
			}
			else if(cmd.equals("update")) {		
				update();
				
			}	
			else if(cmd.equals("add")) {			
				add();
				
			}
			else if(cmd.equals("help")) {
				printHelp();	
				
			} 
			else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
		
	}

	private static void delete() {
		
		System.out.print("삭제할 게시물 번호 : ");
		int targetId = Integer.parseInt(scan.nextLine());
		
		int index = findIndexByArticleId(targetId);
		
		if(index == -1) {
			System.out.println("없는 게시물 번호입니다.");
		} else {
			
			articles.remove(index);			
			System.out.println("삭제가 완료되었습니다.");
			list();
		}
	}
	
	private static void printHelp() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");	
	}

	private static void add() {
		//ids[lastIndex] = lastIndex + 1;
		//ids.add(lastIndex + 1);
		
		
			
		System.out.print("제목을 입력해주세요 : ");
		String title = scan.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		String body = scan.nextLine();
		
		Article a1 = new Article(lastArticleId, title, body);
		articles.add(a1);
		
		System.out.println("게시물이 저장되었습니다.");
		lastArticleId++;
	}

	private static void update() {
		System.out.print("수정할 게시물 번호 : ");
		int targetId = Integer.parseInt(scan.nextLine());
		
		int index = findIndexByArticleId(targetId);
		
		if(index == -1) {
			System.out.println("없는 게시물 번호입니다.");
		} else {
			System.out.print("제목 : ");
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String body = scan.nextLine();
			
			articles.set(index, new Article(targetId, title, body));
			
			System.out.println("게시물 수정이 완료되었습니다.");
			list();
		}
		
	}

	private static void list() {
		for(int i = 0; i < articles.size(); i++) {		
			Article article = articles.get(i);
			System.out.println("번호 : " + article.id);
			System.out.println("제목 : " + article.title);
			System.out.println("=====================");
		}	
	}
	
	public static int findIndexByArticleId(int targetId) {
		int index = -1;
		
		for(int i = 0; i < articles.size(); i++) {
			Article article =  articles.get(i);
			if(targetId == article.id) {						
				index = i;
				break;
			}
		}
		
		return index;
	}

}

