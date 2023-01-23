
public class Coin {

	private static int coin = 20;
	
	public int Coin() {
		return coin;
	}
	
	public int betCoin(int userBet) {

		coin -= userBet;
		return coin;

	}
	
	public int callCoin(int userBet) {

		coin -= userBet;
		return coin;
		
	}

	public int raiseCoin(int userRaise) {

		coin -= userRaise;
		return coin;

	}

	public int foldCoin(int userRaise) {

		return coin;

	}

	public int matchWinCoin(int userBet, int userRaise) {

		coin = coin + (userBet * 2) + (userRaise * 2);
		return coin;
		
	}
	
	public int matchLoseCoin(int userBet, int userRaise) {

		return coin;
		
	}
	
}
