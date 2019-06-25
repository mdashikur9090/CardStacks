package cardStack;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public interface Stack {
   
    public void pushCard(int value);
    
    public int nextCard();
    
    public int getCards(String cardStackTag, int position);
    
    public int getCardStackSize(String cardStackTag);
    
}
