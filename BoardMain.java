package exam.day3.board;

import java.util.Scanner;
//////
public class BoardMain {

	static Scanner scan = new Scanner(System.in);
	//asdlkfjsldkfj
	public static void main(String[] args) {
		
		ArticleController articleController = new ArticleController();
		MemberController memberController = new MemberController();
		
		while (true) {

			if (memberController.loginedMember == null) {
				System.out.print("명령어를 입력해주세요 : ");
			} else {
				System.out.print("명령어를 입력해주세요 [" + memberController.loginedMember.loginId + "(" + memberController.loginedMember.nickname + ")]: ");
			}

			String cmd = scan.nextLine();			
			String[] cmdBits = cmd.split(" ");
			
			if(cmdBits.length < 2) {
				System.out.println("잘못된 명령입니다.");
				continue;
			}

			String module = cmdBits[0];
			String func = cmdBits[1];
			
			if(module.equals("article")) {				
				articleController.doCommand(func);
			} else if(module.equals("member")) {				
				memberController.doCommand(func);
			} else  {
				System.out.println("잘못된 명령어입니다.");
			}
			
		}

	}
}
