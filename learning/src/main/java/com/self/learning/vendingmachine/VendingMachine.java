package com.self.learning.vendingmachine;

import java.util.List;

import com.self.learning.vendingmachine.Item;
import com.self.learning.vendingmachine.Bucket;
import com.self.learning.vendingmachine.Coin;

/**
 * 
 * Decleare public API for Vending Machine *
 * 
 */

public interface VendingMachine {
	public long selectItemAndGetPrice(Item item);

	public void insertCoin(Coin coin);

	public List<Coin> refund();

	public Bucket<Item, List<Coin>> collectItemAndChange();

	public void reset();

}
