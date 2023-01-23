public class User2 extends Player {
	
	Coin2 coin2 = new Coin2();
	
	@Override
	public void callGame(int num2) {

		System.out.println("[유저2(상대)가 [" + num2 + "]개를 베트했습니다.]");
		System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.callCoin(num2) + "]]\n");
		
	}
	
	@Override
	public void shareCard(int num2) {
		
		System.out.println("[유저2(상대)가 카드 [" + num2 + "]장을 받았습니다.]\n");
	}
	
	@Override
	public void selectCard(int num2) {
		
		System.out.println("[유저2(상대)가 카드 [" + num2 + "]장을 선택했습니다.]\n");
		
	}
	
	@Override
	public void openCard(int num2) {
		
		System.out.println("[유저2(상대)가 유저1(나)에게 카드를 공개합니다.]");
		System.out.println("[유저2(상대)의 카드는 [" + num2 +"] 입니다.]\n");

	}
	
	@Override
	public void raiseGame(int userRaise) {
		
			System.out.println("[유저2(상대)가 [" + userRaise + "]개를 레이즈했습니다.]");
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.raiseCoin(userRaise) + "]]\n");
		
	}
	
	@Override
	public void foldGame(int user1Card, int user2Card, int userBet, int userRaise) {
		
		if(user1Card > user2Card) {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchWinCoin(userBet, userRaise) + "]]\n");
		} else if(user1Card == user2Card) {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchWinCoin(userBet, userRaise) + "]]\n");
		} else {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchWinCoin(userBet, userRaise) + "]]\n");
		}

	}

	@Override
	public void matchGame(int user1Card, int user2Card, int userBet, int userRaise) {
		
		if(user1Card > user2Card) {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchLoseCoin(userBet, userRaise) + "]]\n");
		} else if(user1Card == user2Card) {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchLoseCoin(userBet, userRaise) + "]]\n");
		} else {
			System.out.println("[유저2(상대)의 남은 코인 수 : [" + coin2.matchWinCoin(userBet, userRaise) + "]]\n");
		}
		
	}
	
}
