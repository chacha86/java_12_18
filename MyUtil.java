package exam.day3.board;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtil {

	// static 써라 마라.
	// static 기본적으로 안쓴다.
	// 예외적으로 사용하는 경우. 
	// 누가봐도 공유데이터일 때(로그인데이터)
	// 지역변수만 사용하는 함수에 국한해서 -> 유틸 함수같은 경우 static 붙이고 
	
	public static String getCurrentDate() {
		// 오늘 날짜 구하기
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatedNow = now.format(formatter);
		
		return formatedNow;
	}
	
	
}
