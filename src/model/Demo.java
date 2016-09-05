package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Demo {

	static Auction auction;

	public static void main(String[] args) {

		auction = new Auction(1, 1, new Money("0.99"), new Date(2016, 9, 6));

		auction.placeBidFor(new Offer(1, new Money("10.00"), new Date(2016,9,5,14,5,22)), new Date(2016,9,5,14,5,22));
		auction.placeBidFor(new Offer(2, new Money("1.49"), new Date(2016,9,5,14,5,23)), new Date(2016,9,5,14,5,23));
		auction.placeBidFor(new Offer(2, new Money("10.01"), new Date(2016,9,5,14,5,24)), new Date(2016,9,5,14,5,24));
//		auction.placeBidFor(new Offer(2, new Money("12.00"), new Date()), new Date());
//		auction.placeBidFor(new Offer(1, new Money("12.00"), new Date()), new Date());

		List<HistoricalBid> list = auction.getBids();

		System.out.println(
				"Current Bid: " + auction.getWinningBid().getCurrentAuctionPrice().getAmount().getValue() + "\n");
		System.out.println("Winning Bidder: " + auction.getWinningBid().getBidder() + "\n");

		for (HistoricalBid historicalBid : list) {
			System.out.println(historicalBid.getBidder() + " - " + historicalBid.getAmount().getValue() + " at "
					+ historicalBid.getTimeOfBid().toString());
		}
	}

	public void createAuction() {
		auction = new Auction(1, 1, new Money("0.99"), new Date(2016, 9, 6));

		// return auction.getId();
	}

	public void bid(long aId, long memId, BigDecimal amount) {
		auction.placeBidFor(new Offer(memId, new Money(amount.toString()), new Date()), new Date());
	}

	public void printBidHistory() {
		List<HistoricalBid> list = auction.getBids();

		for (HistoricalBid historicalBid : list) {
			System.out.println(historicalBid.getBidder() + " - " + historicalBid.getAmount().getValue() + " at "
					+ historicalBid.getTimeOfBid().toString());
		}
	}

}
