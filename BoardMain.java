package exam.day3.board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String[] titles = new String[3]; // 제목 저장소
		String[] bodies = new String[3]; // 내용 저장소
		int lastIndex = 0; // 데이터 하나 저장할 때마다 1증가
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = scan.nextLine();
			
			if(cmd.equals("list")) {
				
				for(int i = 0; i < lastIndex; i++) {					
					System.out.println("제목 : " + titles[i]);
					System.out.println("내용 : " + bodies[i]);
					System.out.println("=====================");
				}
				
				
			}
			else if(cmd.equals("add")) {
			
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
