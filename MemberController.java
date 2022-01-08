package exam.day3.board;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
	static Scanner scan = new Scanner(System.in);
	ArrayList<Member> members = new ArrayList<>();	
	int lastMemberId = 1;
	
	static Member loginedMember = null;
	
	public MemberController() {
		makeTestData();
		loginedMember = members.get(0);
	}
	
	public void doCommand(String cmd) {

		if (cmd.equals("signup")) {
			signup();
			
		} else if (cmd.equals("signin")) {
			signin();

		} else if (cmd.equals("logout")) {
			logout();
		}

	}

	private void logout() {
		loginedMember = null;
		System.out.println("로그아웃 되셨습니다.");

	}

	private void signin() {
		System.out.print("아이디 : ");
		String loginId = scan.nextLine();
		System.out.print("비밀번호 : ");
		String loginPw = scan.nextLine();

		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);
			if (member.loginId.equals(loginId)) {
				if (member.loginPw.equals(loginPw)) {
					System.out.println(member.nickname + "님 반갑습니다!");
					loginedMember = member;
				}
			}
		}

		if (loginedMember == null) {
			System.out.println("잘못된 회원정보입니다.");
		}

	}

	private void signup() {

		System.out.println("==== 회원 가입을 진행합니다 ====");
		System.out.print("아이디를 입력해주세요 :");
		String loginId = scan.nextLine();
		System.out.print("비밀번호를 입력해주세요 :");
		String loginPw = scan.nextLine();
		System.out.print("닉네임을 입력해주세요 :");
		String nickname = scan.nextLine();
		System.out.println("==== 회원가입이 완료되었습니다. ====");

		Member member = new Member(lastMemberId, loginId, loginPw, nickname);
		members.add(member);
		lastMemberId++;

		printMembers(members);
	}

	private void printMembers(ArrayList<Member> members) {
		System.out.println("==== 현재 가입한 회원 목록 ====");
		for (int i = 0; i < members.size(); i++) {
			Member member = members.get(i);

			System.out.println("아이디 : " + member.loginId);
			System.out.println("비밀번호 : " + member.loginPw);
			System.out.println("이름 : " + member.nickname);
			System.out.println("====================");

		}
	}
	
	private void makeTestData() {
		Member m1 = new Member(1, "hong123", "h1234", "홍길동");
		Member m2 = new Member(2, "lee123", "1234", "이순신");
	
		members.add(m1);
		members.add(m2);
	}
}
