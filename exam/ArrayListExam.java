package exam.day3.board.exam;

import java.util.ArrayList;

public class ArrayListExam {

	public static void main(String[] args) {
		// 선언
		// 이름을 저장할 수 있는 ArrayList를 선언하고 만들어주세요.
		// int -> Integer
		ArrayList<String> names = new ArrayList<>();


		// add()
		// 리스트에 값을 추가해주세요.
		// "홍길동", "이순신", "황진이", "임꺽정", "강감찬", "을지문덕" 을 ArrayList에 추가 해주세요.
		names.add("홍길동");
		names.add("이순신");
		names.add("황진이");
		names.add("임꺽정");
		names.add("강감찬");
		names.add("을지문덕");
				

		// size()
		// 리스트의 사이즈를 출력해주시고, 값이 6이 맞다면 계속 진행해주세요.
		// 출력결과 : 6

		System.out.println(names.size());



		// get()
		// 리스트의 2,3 인덱스의 값을 출력해주세요.
		// 출력결과 : 황진이, 임꺽정
		System.out.println(names.get(2));
		System.out.println(names.get(3));




		System.out.println("=================================");
		// 리스트의 모든 값을 출력해주세요.
		// 출력 결과 : 홍길동 이순신 황진이 임꺽정 강감찬 을지문덕
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		
		// remove()
		// 리스트에서 홍길동, 이순신을 지운 뒤, 다시 2,3 인덱스의 값을 출력해주시고 어떤 변화가 있는지 체크해주세요.
		// 배열, 리스트 여러개의 데이터를 저장하고 있는 것에서 여러분이 직접 데이터를 찾는 것은 불가능. -> 탐색
		// 출력 결과 : 강감찬, 을지문덕
		
		
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);			
			if (name == "홍길동") {
				names.remove(i);
			}			
		}
		
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);			
			if (name == "이순신") {
				names.remove(i);
			}			
		}
		

		System.out.println("=================================");
		
		// 리스트의 모든 값을 출력해주세요.
		// 출력 결과 : 황진이 임꺽정 강감찬 을지문덕
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}


		// add()
		// 리스트에 정약용을 추가시켜주세요.
		names.add("정약용");
		System.out.println("=================================");



		// 리스트의 모든 값을 출력해주세요.
		// 출력 결과 : 황진이 임꺽정 강감찬 을지문덕 정약용
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		// set()
		// 임꺽정과 을지문덕을 신사임당과 유관순으로 바꿔주세요.
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);	
			if(name == "임꺽정") {
				names.set(i, "신사임당");				
			}
			if(name == "을지문덕") {				
				names.set(i, "유관순");
			}
		}
		
		
		
		System.out.println("=================================");
		// 리스트의 모든 값을 출력해주세요.
		// 출력 결과 : 황진이 신사임당 강감찬 유관순 정약용
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		// 리스트에서 황진이 신사임당 유관순만 출력해주세요.
		// 출력 결과 : 황진이 신사임당 유관순
		System.out.println("=================================");
		for(int i = 0; i < names.size(); i++) {
			String name = names.get(i);	
			if(name == "황진이" ||  name == "신사임당" || name == "유관순") {
				System.out.println(name);
			} 
		}
		
	}

}
