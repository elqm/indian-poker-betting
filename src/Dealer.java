import java.util.Random;
import java.util.Scanner;

public class Dealer {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Player user1 = new User1();
		Player user2 = new User2();
		Coin user1Coin = new Coin1();
		Coin user2Coin = new Coin2();
		Random ranCard = new Random();

		/* 인디언 포커 게임 카드 */
		int[] cardArr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] cardArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		/* 베트와 레이즈할 코인 개수 */
		int userBet = 0; 
		int userRaise = 0;

		/* 중복 베트 방지 카운트 */
		int betCount = 0;

		/* 카드 장수 및 카드 중복 배분 방지 카운트 */
		int shareCount1 = 0;
		int shareCount2 = 0;

		/* 카드 중복 선택 방지 카운트 */
		int selectCount = 0;

		/* 카드 중복 공개 방지 카운트 */
		int openCount = 0;

		/* 중복 레이즈 방지 카운트 */
		int raiseCount = 0;

		/* 중복 폴드 방지 카운트 */
		int foldCount = 0;

		/* 중복 매치 방지 카운트 */ 
		int matchCount = 0;

		/* 선택한 랜덤 카드 변수 */
		int user1Card = 0;
		int user2Card = 0;

		while(user1Coin.coin() >= 0 || user2Coin.coin() >= 0) {
			System.out.println("======= 인디언 포커 =======");
			System.out.println("1. 인디언 포커 베트(Bet)");
			System.out.println("2. 카드 배분");
			System.out.println("3. 카드 선택");
			System.out.println("4. 카드 공개");
			System.out.println("5. 인디언 포커 레이즈(Raise)");
			System.out.println("6. 인디언 포커 포기(Fold)");
			System.out.println("7. 인디언 포커 승부(Match)");			
			System.out.println("8. 인디언 포커 계속 진행(Continue)");
			System.out.println("9. 게임 초기화(Reset)");
			System.out.println("0. 게임 종료(Exit)");
			System.out.println("========================");
			System.out.print("메뉴 선택 : ");
			int no = sc.nextInt();

			switch(no) {
			case 1 :
				if(betCount == 0) {
					System.out.print("\n- 베트를 진행해주십시오 : ");
					userBet = sc.nextInt();
					if(betCount == 0) {
						if(userBet <= user1Coin.coin() && userBet <= user2Coin.coin()) {
							user1.betGame(userBet);
							user2.callGame(userBet);
							++betCount;
						} else if(userBet > user1Coin.coin()) {
							System.out.println("\n[유저1(나)이 가진 코인보다 더 많이 베트했습니다.]");
							System.out.println("[베트를 다시 진행해주십시오.]\n");
						} else if(userBet > user2Coin.coin()) {
							System.out.println("\n[유저2(상대)가 가진 코인보다 더 많이 베트했습니다.]");
							System.out.println("[베트를 다시 진행해주십시오.]\n");
						}
					} 
				} else if(betCount == 1) {
					System.out.println("\n[이미 베트를 진행했습니다.]\n");
				}
				break;
			case 2 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					for(int i = cardArr1.length; i > 0; i--) {
						++shareCount1;
					}
					user1.shareCard(shareCount1);
					for(int i = cardArr2.length; i > 0; i--) {
						++shareCount2;
					}
					user2.shareCard(shareCount2);
				} else if(shareCount1 != 0) {
					System.out.println("\n[이미 카드 " + shareCount1 + "장을 받았습니다.]\n");
				}
				break;
			case 3 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					user1Card = (int) cardArr1[ranCard.nextInt(10)];
					user2Card = (int) cardArr2[ranCard.nextInt(10)];
					++selectCount;
					user1.selectCard(1);
					user2.selectCard(1);
				} else if(selectCount == 1 ){
					System.out.println("\n[이미 카드를 선택했습니다.]\n");
				}
				break;
			case 4 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					user1.openCard(user1Card);
					user2.openCard(user2Card);
					++openCount;
				} else if(openCount == 1) {
					System.out.println("\n[이미 카드를 공개했습니다.]\n");
				}
				break;
			case 5 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					System.out.println("\n[아직 카드를 공개하지 않았습니다.]\n");
				} else if(user1Coin.coin() == 0 || user1Coin.coin() == 0) {
					if(user1Coin.coin() == 0) {
						System.out.println("\n[유저1(나)의 남은 코인 수 : [" + user1Coin.coin() + "]]");
						System.out.println("[유저2(상대)의 남은 코인 수 : [" + user2Coin.coin() + "]]");
						System.out.println("[레이즈를 진행할 수 없습니다.]\n");
					} else {
						System.out.println("\n[유저1(나)의 남은 코인 수 : [" + user1Coin.coin() + "]]");
						System.out.println("[유저2(상대)의 남은 코인 수 : [" + user2Coin.coin() + "]]");
						System.out.println("[레이즈를 진행할 수 없습니다.]\n");
					}
				} else if(raiseCount == 0 && foldCount == 0 && matchCount == 0) {
					System.out.print("\n- 레이즈를 진행해주십시오 : ");
					userRaise = sc.nextInt();
					if(userRaise <= user1Coin.coin() && userRaise <= user2Coin.coin()) {
						user1.raiseGame(userRaise);
						user2.raiseGame(userRaise);
						++raiseCount;
					} else if(userRaise > user1Coin.coin()) {
						System.out.println("\n[유저1(나)이 가진 코인보다 더 많이 레이즈했습니다.]");
						System.out.println("[레이즈를 다시 진행해주십시오.]\n");
					} else if(userRaise > user2Coin.coin()) {
						System.out.println("\n[유저2(상대)가 가진 코인보다 더 많이 레이즈했습니다.]");
						System.out.println("[레이즈를 다시 진행해주십시오.]\n");
					}
				} else if(raiseCount == 1){
					System.out.println("\n[이미 레이즈를 진행했습니다.]\n");
				} else if(foldCount == 1) {
					System.out.println("\n[이미 승부를 포기했습니다.]\n");
				} else if(matchCount == 1) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				}
				break;
			case 6 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					System.out.println("\n[아직 카드를 공개하지 않았습니다.]\n");
				} else if(foldCount == 0 && matchCount == 0) {
					user1.foldGame(user1Card, user2Card, userBet, userRaise);
					user2.foldGame(user1Card, user2Card, userBet, userRaise);
					++foldCount;
				} else if(matchCount == 1) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				} else if(matchCount == 1 && foldCount == 0) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				} else if(foldCount == 1 && matchCount == 0) {
					System.out.println("\n[이미 승부를 포기했습니다.]\n");
				}
				break;
			case 7 :
				if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(shareCount1 == 0) {
					System.out.println("\n[아직 카드를 받지 않았습니다.]\n");
				} else if(selectCount == 0) {
					System.out.println("\n[아직 카드를 선택하지 않았습니다.]\n");
				} else if(openCount == 0) {
					System.out.println("\n[아직 카드를 공개하지 않았습니다.]\n");
				} else if(betCount == 0) {
					System.out.println("\n[아직 베트를 하지 않았습니다.]\n");
				} else if(foldCount == 1 && matchCount == 0) {
					System.out.println("\n[이미 승부를 포기했습니다.]\n");
				} else if(matchCount == 0 && foldCount == 0) {
					user1.matchGame(user1Card, user2Card, userBet, userRaise);
					user2.matchGame(user1Card, user2Card, userBet, userRaise);
					++matchCount;
				} else if(matchCount == 1 && foldCount == 0) {
					System.out.println("\n[이미 승부를 겨루었습니다.]\n");
				}

				break;
			case 8 :
				if(user1Coin.coin() == 0 || user2Coin.coin() == 0) {
					if(user1Coin.coin() == 0 && user2Coin.coin() != 0) {
						System.out.println("\n[유저1(나)의 남은 코인 수 : [" + user1Coin.coin() + "]]");
						System.out.println("[유저2(상대)의 남은 코인 수 : [" + user2Coin.coin() + "]]\n");
						System.out.println("[유저1(나)의 패배했습니다...]");
						System.out.println("[인디언 포커를 종료합니다.]\n");
					} else if(user2Coin.coin() == 0 && user1Coin.coin() != 0){
						System.out.println("\n[유저1(나)의 남은 코인 수 : [" + user1Coin.coin() + "]]");
						System.out.println("[유저2(상대)의 남은 코인 수 : [" + user2Coin.coin() + "]]\n");
						System.out.println("[유저1(나)이 승리했습니다!!!]");
						System.out.println("[인디언 포커를 종료합니다.]\n");
					} else {
						System.out.println("\n[유저1(나)의 남은 코인 수 : [" + user1Coin.coin() + "]]");
						System.out.println("[유저2(상대)의 남은 코인 수 : [" + user2Coin.coin() + "]]\n");
						System.out.println("[무승부입니다.]");
						System.out.println("[인디언 포커를 종료합니다.]\n");
					}
					return;
				}
				betCount = 0;
				shareCount1 = 0;
				shareCount2 = 0;
				selectCount = 0;
				openCount = 0;
				raiseCount = 0;
				matchCount = 0;
				foldCount = 0;
				userBet = 0;
				userRaise = 0;
				user1Card = 0;
				user2Card = 0;
				user1.continueGame();
				break;
			case 9 :
				betCount = 0;
				shareCount1 = 0;
				shareCount2 = 0;
				selectCount = 0;
				openCount = 0;
				raiseCount = 0;
				matchCount = 0;
				foldCount = 0;
				userBet = 0;
				userRaise = 0;
				user1Card = 0;
				user2Card = 0;
				user1.resetGame();
				break;
			case 0 :
				user1.exitGame();
				return;
			default :
				System.out.println("\n[잘못된 번호를 선택하셨습니다.]\n");
				break;
			}

		}

	}

}

