import java.util.Random;
import java.util.Scanner;

public class User1 extends Player { 
	
	Coin1 coin1 = new Coin1();
	
	@Override
	public void betGame(int num1) {

		System.out.println("\n[유저1(나)이 [" + num1 + "]개를 베트했습니다.]");
		System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.betCoin(num1) + "]]");
		
	}
	
	@Override
	public void shareCard(int num1) {
		
		System.out.println("\n[유저1(나)이 카드 [" + num1 + "]장을 받았습니다.]");
	}

	@Override
	public void selectCard(int num1) {
		
		System.out.println("\n[유저1(나)이 카드 [" + num1 + "]장을 선택했습니다.]");

	}

	@Override
	public void openCard(int num1) {

		System.out.println("\n[유저1(나)이 유저2(상대)에게 카드를 공개합니다.]");
		System.out.println("[유저2(상대)가 유저1(나)의 카드를 확인했습니다.]");

		if(num1 == 1 || num1 == 10) {
			System.out.println("[유저2(상대)의 입꼬리가 슬며시 올라갑니다.]\n");
		} else {
			System.out.println("[유저2(상대)가 포커페이스를 유지합니다.]\n");
		}

	}
	
	@Override
	public void raiseGame(int userRaise) {
		
		System.out.println("\n[유저1(나)이 [" + userRaise + "]개를 레이즈했습니다.]");
		System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.raiseCoin(userRaise) + "]]");
		
	}
	
	@Override
	public void foldGame(int user1Card, int user2Card, int userBet, int userRaise) {

		System.out.println("\n[DIE...]");
		
		int max = 0;
		int min = 0;
		
		if(user1Card > user2Card) {
			max = user1Card;
			min = user2Card;
			System.out.println("[유저1(나)의 카드는 [" + max + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + min + "]]");
			System.out.println("[당신의 배짱은 물벼룩만 하군요. 겁쟁이는 돌아가서 잠이나 자세요~]\n");
			System.out.println("[유저1의 남은 코인 수 : [" + coin1.foldCoin(userRaise) + "]]");
		} else if(user1Card == user2Card) {
			System.out.println("[유저1(나)의 카드는 [" + user1Card + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + user2Card + "]]");
			System.out.println("[아쉽습니다. 배포를 조금 더 키워보는 건 어떨까요?]\n");
			System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.foldCoin(userRaise) + "]]");
		} else {
			max = user2Card;
			min = user1Card;
			System.out.println("[유저1(나)의 카드는 [" + min + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + max + "]]");
			System.out.println("[나쁘지 않은 판단입니다. 다음 기회를 노려보세요!]\n");
			System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.foldCoin(userRaise) + "]]");
		}

	}

	@Override
	public void matchGame(int user1Card, int user2Card, int userBet, int userRaise) {

		System.out.println("\n[GAME START!]");

		int max = 0;
		int min = 0;
		
		if(user1Card > user2Card) {
			max = user1Card;
			min = user2Card;
			System.out.println("[유저1(나)의 카드는 [" + max + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + min + "]]");
			System.out.println("[WIN!!!]\n");
			System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.matchWinCoin(userBet, userRaise) + "]]");
		} else if(user1Card == user2Card) {
			System.out.println("[유저1(나)의 카드는 [" + user1Card + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + user2Card + "]]");
			System.out.println("[DRAW!]\n");
			System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.matchLoseCoin(userBet, userRaise) + "]]");
		} else {
			max = user2Card;
			min = user1Card;
			System.out.println("[유저1(나)의 카드는 [" + min + "]]");
			System.out.println("[유저2(상대)의 카드는 [" + max + "]]");
			System.out.println("[LOSE...]\n");
			System.out.println("[유저1(나)의 남은 코인 수 : [" + coin1.matchLoseCoin(userBet, userRaise) + "]]");
		}
		
	}
	
	@Override
	public void continueGame() {
		
		System.out.println("\n[CONTINUE.]");
		System.out.println("인디언 포커를 계속 진행합니다.\n");
		
	}

	@Override
	public void exitGame() {

		System.out.println("\n[GAME OVER.]");
		System.out.println("[인디언 포커를 종료합니다.]\n");

	}
	
}
