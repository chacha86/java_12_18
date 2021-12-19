package exam.day3.board;

import java.util.Scanner;

public class BoardMain {

	static Scanner scan = new Scanner(System.in);
	static int[] ids = new int[3]; // 번호 저장소
	static String[] titles = new String[3]; // 제목 저장소
	static String[] bodies = new String[3]; // 내용 저장소
	static int lastIndex = 0; // 데이터 하나 저장할 때마다 1증가
	
	public static void main(String[] args) {
		
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
			// 삭제 코드 작성
			System.out.println("삭제 기능 실행");
		}
	}

	private static void printHelp() {
		System.out.println("add  : 게시물 등록");
		System.out.println("list : 게시물 목록 조회");	
	}

	private static void add() {
		ids[lastIndex] = lastIndex + 1;
		System.out.print("제목을 입력해주세요 : ");
		titles[lastIndex] = scan.nextLine();
		System.out.print("내용을 입력해주세요 : ");
		bodies[lastIndex] = scan.nextLine();
		
		System.out.println("게시물이 저장되었습니다.");
		lastIndex++;
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
			
			titles[index] = title;
			bodies[index] = body;
			
			System.out.println("게시물 수정이 완료되었습니다.");
			list();
		}
		
	}

	private static void list() {
		for(int i = 0; i < lastIndex; i++) {		
			System.out.println("번호 : " + ids[i]);
			System.out.println("제목 : " + titles[i]);
			System.out.println("=====================");
		}	
	}
	
	public static int findIndexByArticleId(int targetId) {
		int index = -1;
		
		for(int i = 0; i < lastIndex; i++) {
			if(targetId == ids[i]) {						
				index = i;
				break;
			}
		}
		
		return index;
	}

}
