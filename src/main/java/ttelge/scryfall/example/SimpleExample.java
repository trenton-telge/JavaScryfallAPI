package ttelge.scryfall.example;
import java.util.ArrayList;

import ttelge.scryfall.api.Card;
import ttelge.scryfall.api.MTGCardQuery;


public class SimpleExample {
	public static void main(String[] args) {
		String query = "Sky Hussar";
		ArrayList<Card> cards = MTGCardQuery.search(query);

		System.out.println("The resulting cards: ");

		for(Card card:cards)
		{
			System.out.println(card);
		}
	}
}
