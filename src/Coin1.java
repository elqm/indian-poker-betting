
public class Coin1 extends Coin{

	private static int coin1 = 20;
	
	@Override
	public int coin() {
		return coin1;
	}
	
	@Override
	public int betCoin(int userBet) {

		coin1 -= userBet;
		return coin1;

	}

	@Override
	public int raiseCoin(int userRaise) {

		coin1 -= userRaise;
		return coin1;

	}

	@Override
	public int foldCoin(int userRaise) {

		return coin1;

	}

	@Override
	public int matchWinCoin(int userBet, int userRaise) {

		coin1 = coin1 + (userBet * 2) + (userRaise * 2);
		return coin1;
		
	}
	
	@Override
	public int matchLoseCoin(int userBet, int userRaise) {

		return coin1;
		
	}


}
