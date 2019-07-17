/**
 *  An object of type Deck.  The Deck represents a deck of 52 playing cards
 */
public class Deck {

    /**
     * An object of type Card represents a playing card.
     * The card has a suit (spades, hearts, diamonds, clubs) and
     * value (ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, jack, queen, and king)
     * We will use 1, 11, 12, and 13 to represent ace, jack, queen, and king relatively.
     * 
     * As this is out of scope I will skip for now. But in fact, a public class named Card
     * should be defined in a file named Card.java and imported here in this file.
     */
    private Card[] deck;

    /**
     * Number of cards that were dealt from the deck.
     */
    private int usedCards;

    /**
     * Constructs a poker deck by Card.
     */
    public Deck() {
    	
    	//create an instance of Card object named deck
        deck = new Card[52];
        
        //set createdCards integer to hold the number of cards that are created during construction
        int createdCards = 0;

        for ( int suit = 0; suit <= 3; suit++ ) { //suits that can be hearts, spades, clubs, diamonds
        	for ( int value = 1; value <= 13; value++ ) { //values that 1, 11, 12, 13 stand for Ace, Jack, Queen, and King relatively
                deck[createdCards] = new Card(value,suit);
                createdCards++;
            }
        }
        
        //we should set usedCards to zero as the Deck is just constructed.
        usedCards = 0;
    }

    /**
     * Put all cards into the deck, and shuffle into a random order.
     */
    public void shuffle() {
        for ( int i = 51; i > 0; i-- ) { //we start with 51 as we will bound with random fn by incrementing +1 
            int r = (int)(Math.random()*(i+1)); //generate a random integer in the range of [1,52]

            /*
             * swap ith card and rth card
             * the following is the best part to swap as explained below link not only in java but also in all languages
             * https://stackoverflow.com/questions/13766209/effective-swapping-of-elements-of-an-array-in-java  
             */
            Card temp = deck[i]; //assign ith card to a temp card
            deck[i] = deck[r]; //assign rth card to the ith card
            deck[r] = temp; //assign temp card which used to be ith to the rth card.
        }
        usedCards = 0; //after every shuffle usedCards should be zero
    }

    /**
     * Deal a card from the deck.
     * Increase the number of used cards and return the next card that is still in the deck.
     * @return the next card.
     * @throws IllegalStateException if there is no card left in the deck.
     */
    public Card dealOneCard() {
        if (usedCards == deck.length)
            throw new IllegalStateException("No card left in the deck.");
        
        //increase the number of used cards
        usedCards++;
        
        //return the next card
        return deck[usedCards - 1];
    }

} // end class Deck
