package model;

import java.util.Date;

public class Auction {

	private long id;
	private long listingId;
	private Date endTime;
	private Money startingPrice;
	private WinningBid winningBid;

	private boolean hasEnded;

	public Auction(long id, long listngId, Money startingPrice, Date endTime) {
		this.id = id;
		this.listingId = listngId;
		this.startingPrice = startingPrice;
		this.endTime = endTime;
	}

	public void reduceTheStartingPrice() {
		// TODO only if no bids and more than 12 hours left
	}

	public boolean isInProgress(Date currentTime) {
		return endTime.after(currentTime);
	}

	public boolean canPlaceBid() {
		return hasEnded == false;
	}

	public boolean isBidderIncreasingMaximumBidToNew(Offer offer) {
		return winningBid.wasMadeBy(offer.getBidder())
				&& offer.getMaximumBid().isGreaterThan(winningBid.getMaximumBid());
	}

	public boolean isFirstOffer() {
		return winningBid == null;
	}

	public void placeABidForTheFirst(Offer offer) {
		if (offer.getMaximumBid().isGreaterThanOrEqualTo(startingPrice)) {

		}
	}

	public void place(WinningBid newBid) {
		if (!isFirstOffer() && winningBid.wasMadeBy(newBid.getBidder())) {
			// TODO outbid event
		}

		winningBid = newBid;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getListingId() {
		return listingId;
	}

	public void setListingId(long listingId) {
		this.listingId = listingId;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Money getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Money startingPrice) {
		this.startingPrice = startingPrice;
	}

	public WinningBid getWinningBid() {
		return winningBid;
	}

	public void setWinningBid(WinningBid winningBid) {
		this.winningBid = winningBid;
	}

}
