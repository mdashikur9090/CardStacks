package cardStack;

import java.util.ArrayList;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class CardStackTypeList {
    private ArrayList<GenarateCardStack> cardStackList= new ArrayList<GenarateCardStack>();
    
    public CardStackTypeList(){
    }

    public GenarateCardStack getCardStackListItem(int position) {
        return cardStackList.get(position);
    }

    public void setCardStackListItem(GenarateCardStack cardStackName) {
        this.cardStackList.add(cardStackName);
    }
    
    
}
