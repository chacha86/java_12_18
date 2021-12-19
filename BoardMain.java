package exam.day3.board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] ids = new int[3]; // 번호 저장소
		String[] titles = new String[3]; // 제목 저장소
		String[] bodies = new String[3]; // 내용 저장소
		int lastIndex = 0; // 데이터 하나 저장할 때마다 1증가
		//int articleId = 1; // 게시물 번호
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("list")) {
				
				for(int i = 0; i < lastIndex; i++) {		
					System.out.println("번호 : " + ids[i]);
					System.out.println("제목 : " + titles[i]);
					System.out.println("=====================");
				}
				
			}
			else if(cmd.equals("update")) {
				System.out.print("수정할 게시물 번호 : ");
				int targetId = Integer.parseInt(scan.nextLine());
				
				int index = -1;
				
				for(int i = 0; i < lastIndex; i++) {
					if(targetId == ids[i]) {						
						index = i;
						break;
					}
				}
				
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
					
					for(int i = 0; i < lastIndex; i++) {		
						System.out.println("번호 : " + ids[i]);
						System.out.println("제목 : " + titles[i]);
						System.out.println("=====================");
					}
				}
				
			}	
			else if(cmd.equals("add")) {			
				
				ids[lastIndex] = lastIndex + 1;
				System.out.print("제목을 입력해주세요 : ");
				titles[lastIndex] = scan.nextLine();
				System.out.print("내용을 입력해주세요 : ");
				bodies[lastIndex] = scan.nextLine();
				
				System.out.println("게시물이 저장되었습니다.");
				lastIndex++;
			}
			else if(cmd.equals("help")) {
				System.out.println("add  : 게시물 등록");
				System.out.println("list : 게시물 목록 조회");		
				
			} 
			else {
				System.out.println("알 수 없는 명령어입니다.");
			}
		}
		
	}

}
