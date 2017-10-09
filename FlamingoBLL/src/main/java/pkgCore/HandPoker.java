package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {
		// TODO : Implement this method... call each of the 'is' methods (isRoyalFlush,
		// etc) until
		// one of the hands is true, then score the hand
		if (this.isRoyalFlush() == true)
			return this.getHS();
		if (this.isStraightFlush() == true)
			return this.getHS();
		if (this.isFourOfAKind() == true)
			return this.getHS();
		if (this.isFullHouse() == true)
			return this.getHS();
		if (this.isFlush() == true)
			return this.getHS();
		if (this.isStraight() == true)
			return this.getHS();
		if (this.isThreeOfAKind() == true)
			return this.getHS();
		if (this.isTwoPair() == true)
			return this.getHS();
		if (this.isPair() == true)
			return this.getHS();
		if (this.isHighCard() == true)
			return this.getHS();
		
		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {

		} else if (isStraightFlush()) {

		}

		return null;
	}

	private void Frequency() {

		CRC = new ArrayList<CardRankCount>();

		int iCnt = 0;
		int iPos = 0;

		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}

		Collections.sort(CRC);

		for (CardRankCount crcount : CRC) {
			System.out.print(crcount.getiCnt());
			System.out.print(" ");
			System.out.print(crcount.geteRank());
			System.out.print(" ");
			System.out.println(crcount.getiCardPosition());
		}

	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

	public boolean isRoyalFlush() {
		boolean bisRoyalFlush = false;

		if (this.isStraightFlush() == true && this.getCards().get(0).geteRank() == eRank.ACE) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.RoyalFlush);
			bisRoyalFlush = true;

			HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
			HSP.setLoCard(null);
			this.setHS(HSP);
		}
		return bisRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;
		if (this.isStraight() == true && this.isFlush() == true) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.StraightFlush);
			bisStraightFlush = true;

			HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
			HSP.setLoCard(null);
			this.setHS(HSP);
		}
		return bisStraightFlush;
	}

	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;

		if (this.getCRC().size() == 4) {
			if (this.getCRC().get(0).getiCnt() == 4) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FourOfAKind);
				bisFourOfAKind = true;

				HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
				HSP.setLoCard(null);

				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

			}
		}
		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;

		if (this.CRC.size() == 2) {
			if ((CRC.get(0).getiCnt() == 3) && (CRC.get(1).getiCnt() == 2)) {
				bisFullHouse = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FullHouse);
				HSP.setHiCard(this.getCards().get(CRC.get(0).getiCardPosition()));
				HSP.setLoCard(this.getCards().get(CRC.get(1).getiCardPosition()));
				ArrayList<Card> kickers = new ArrayList<Card>();
				HSP.setKickers(kickers);
				this.setHS(HSP);
			}
		}
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		HandScorePoker HSP = (HandScorePoker) this.getHS();
		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt) {
			bisFlush = true;
			HSP.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HSP.setLoCard(null);
			HSP.seteHandStrength(eHandStrength.Flush);
			this.setHS(HSP);
		} else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = false;
		HandScorePoker HSP = (HandScorePoker) this.getHS();
		int eRank = super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank().getiRankNbr();
		int i = 1;
		if (this.getCRC().size() == 5) {
			while (i < 5) {
				if ((eRank - i) == super.getCards().get(i).geteRank().getiRankNbr())
					;
				bisStraight = true;
				i++;
			}
			if (super.getCards().get(eCardNo.FIRST.getiCardNo()).geteRank() == pkgEnum.eRank.ACE
					&& super.getCards().get(eCardNo.SECOND.getiCardNo()).geteRank() == pkgEnum.eRank.FIVE
					&& super.getCards().get(eCardNo.FIFTH.getiCardNo()).geteRank() == pkgEnum.eRank.TWO) {
				bisStraight = true;
			}

		}
		if (bisStraight == true) {
			HSP.setHiCard(super.getCards().get(eCardNo.FIRST.getiCardNo()));
			HSP.setLoCard(null);
			HSP.seteHandStrength(eHandStrength.Straight);
			this.setHS(HSP);

		}
		return bisStraight;
	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;

		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(0).getiCnt() == 3) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				bisThreeOfAKind = true;

				int iGetCard = this.getCRC().get(0).getiCardPosition();

				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);

				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

			}
		}

		return bisThreeOfAKind;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		if (this.getCRC().size() == 3) {
			if (this.getCRC().get(0).getiCnt() == 2 && this.getCRC().get(2).getiCnt() == 2) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.TwoPair);
				bisTwoPair = true;

				HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
				HSP.setLoCard(this.getCards().get(this.getCRC().get(2).getiCardPosition()));

				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

			}
		}

		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;

		if (this.getCRC().size() == 4) {
			if (this.getCRC().get(0).getiCnt() == 2) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.TwoPair);
				bisPair = true;

				HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
				HSP.setLoCard(null);

				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

			}
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		if (this.getCRC().size() == 5) {
			if (this.getCRC().get(0).getiCnt() == 1) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.HighCard);
				bisHighCard = true;

				HSP.setHiCard(this.getCards().get(this.getCRC().get(0).getiCardPosition()));
				HSP.setLoCard(null);

				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);

			}
		}
		return bisHighCard;
	}

}
