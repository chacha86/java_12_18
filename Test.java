package exam.day3.board;

public class Test {

	public static void main(String[] args) {
		
		// 삭제 알고리즘 테스트	
		int[] arr = {1,2,3,4,5,6};
		int size = 6;
		

		for(int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		
		// 삭제
		int deleteTarget = 1;
		
		for(int i = deleteTarget; i < size - 1; i++) {
			arr[i] = arr[i + 1];
		}
		
		size--;
		
		System.out.println("========== 삭제 후 ==========");
		for(int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
		
		

	}

}
