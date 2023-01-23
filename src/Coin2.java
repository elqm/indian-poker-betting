
public class Coin2 extends Coin {

	private static int coin2 = 20;
	
	@Override
	public int Coin() {
		return coin2;
	}
	
	@Override
	public int callCoin(int userBet) {

		coin2 -= userBet;
		return coin2;
		
	}

	@Override
	public int raiseCoin(int userRaise) {

		coin2 -= userRaise;
		return coin2;

	}

	@Override
	public int foldCoin(int userRaise) {

		return coin2;

	}

	@Override
	public int matchWinCoin(int userBet, int userRaise) {

		coin2 = coin2 + (userBet * 2) + (userRaise * 2);
		return coin2;
		
	}
	
	@Override
	public int matchLoseCoin(int userBet, int userRaise) {

		return coin2;
		
	}

}
