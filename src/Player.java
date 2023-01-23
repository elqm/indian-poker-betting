import java.util.Random;

public class Player { 
	
	public void betGame(int num) {
		
		System.out.println("플레이어가 " + num + "개를 베트했습니다.");
		
	}
	
	public void callGame(int num) {
		
		System.out.println("플레이어가 " + num + "개를 콜했습니다.");
		
	}
	
	public void shareCard(int num) {
		
		System.out.println("플레이어가 카드 " + num + "장을 받았습니다.");
		
	}
	
	public void selectCard(int num) {
		
		System.out.println("플레이어가 카드 " + num + "장을 선택했습니다.");
		
	}
	
	public void openCard(int num) {
		
		System.out.println("플레이어가 상대에게 카드를 공개합니다.");
		System.out.println("상대의 카드는 [" + num +"] 입니다.");
		
	}
	
	public void raiseGame(int num) {
		
		System.out.println("플레이어가 " + num + "개를 레이즈했습니다.");
		
	}
	
	public void foldGame(int num1, int num2, int userBet, int userRaise) {

		System.out.println("인디언 포커 포기...");

	}
	
	public void matchGame(int num1, int num2, int card1, int card2) {

		System.out.println("인디언 포커 시작!");

	}
	
	public void continueGame() {
		
		System.out.println("\n인디언 포커를 계속 진행합니다.\n");
		
	}

	public void exitGame() {

		System.out.println("\n인디언 포커를 종료합니다.\n");

	}
	
}
