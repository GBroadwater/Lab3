package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.ScoreHand();
		System.out.println("");

		assertEquals(hp.isFourOfAKind(), true);
	}
	@Test
	public void FourOfAKindTest2() {
		System.out.println("HandScoreTest Four of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.FourOfAKind, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.ScoreHand();
		System.out.println("");

		assertEquals(hp.isThreeOfAKind(), true);
	}
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("HandScoreTest Three of a Kind");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.ThreeOfAKind, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.THREE));
		hp.ScoreHand();
		System.out.println("");

		assertEquals(hp.isTwoPair(), true);
	}
	@Test
	public void TwoPaidTest2() {
		System.out.println("HandScoreTest Two Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.TwoPair, hsp.geteHandStrength());

		System.out.println("");
	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.ScoreHand();

		assertEquals(hp.isFullHouse(), true);

		System.out.println("");
	}
	@Test
	public void FullHouseTest2() {
		System.out.println("HandScoreTest Full house");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.AddCard(new Card(eSuit.SPADES, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.FullHouse, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void StraightTest1() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.ScoreHand();

		assertEquals(hp.isStraight(), true);

		System.out.println("");
	}

	@Test
	public void StraightTest2() {
		System.out.println("Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.NINE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SEVEN));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.EIGHT));
		hp.ScoreHand();

		assertEquals(hp.isStraight(), true);

		System.out.println("");
	}
	@Test
	public void StraightTest3() {
		System.out.println("HandScoreTest Straight");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SEVEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FIVE));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.Straight, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void RoyalFlushTest1() {
		System.out.println("Royal");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.ScoreHand();

		assertEquals(hp.isRoyalFlush(), true);

		System.out.println("");
	}
	@Test
	public void RoyalFlushTest2() {
		System.out.println("HandScoreTest Royal Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.RoyalFlush, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void StraightFlushTest1() {
		System.out.println("StraightFlush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.SPADES, eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.THREE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES, eRank.FOUR));
		hp.ScoreHand();

		assertEquals(hp.isStraightFlush(), true);

		System.out.println("");
	}
	@Test
	public void StraightFlushTest2() {
		System.out.println("HandScoreTest Straight Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.NINE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.QUEEN));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.StraightFlush, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void FlushTest1() {
		System.out.println("Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS, eRank.KING));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.EIGHT));
		hp.ScoreHand();

		assertEquals(hp.isFlush(), true);

		System.out.println("");
	}
	@Test
	public void FlushTest2() {
		System.out.println("HandScoreTest Flush");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TEN));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.TWO));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.Flush, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void PairTest1() {
		System.out.println("Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.SIX));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES, eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.KING));
		hp.ScoreHand();

		assertEquals(hp.isPair(), true);

		System.out.println("");
	}
	@Test
	public void PairTest2() {
		System.out.println("HandScoreTest Pair");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TEN));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.AddCard(new Card(eSuit.SPADES, eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.Pair, hsp.geteHandStrength());

		System.out.println("");
	}

	@Test
	public void HighCardTest1() {
		System.out.println("HighCard");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.JACK));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.SIX));
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.ScoreHand();

		assertEquals(hp.isHighCard(), true);

		System.out.println("");
	}

	@Test
	public void HighCardTest2() {
		System.out.println("HandScoreTest High Card");
		System.out.println("");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS, eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS, eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS, eRank.JACK));
		hp.AddCard(new Card(eSuit.SPADES, eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS, eRank.FOUR));
		hp.ScoreHand();
		HandScorePoker hsp = (HandScorePoker) hp.getHS();

		assertEquals(eHandStrength.HighCard, hsp.geteHandStrength());

		System.out.println("");
	}

}
