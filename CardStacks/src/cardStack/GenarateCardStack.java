package cardStack;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */

public class GenarateCardStack implements Stack{
    String[] ary;
    int[] diceRoll;
    private ArrayList<Integer> cardStack=new ArrayList<Integer>();
    private ArrayList<Integer> removedCardStack=new ArrayList<Integer>();
    private ArrayList<Integer> dealtCardStack=new ArrayList<Integer>();
    
    int lowestValue;
    int highestValue;
    int removeCard;
    
    public GenarateCardStack(String[] ary){
        this.ary=ary;
    }
    
    public void makeStack(){
        lowestValue = Integer.parseInt(ary[0]);
        highestValue = lowestValue * Integer.parseInt(ary[1]);
        removeCard = Integer.parseInt(ary[2]);
        diceRoll = new int[highestValue+1];
        
        
                            
        Random random= new Random();
                                                 
        for(int r=0; r<10000; r++){
            int sum=0;
            for(int x=0; x<lowestValue; x++){
                sum+=1+random.nextInt(Integer.parseInt(ary[1]));
            }
        ++diceRoll[sum];
                                
        }
                            

      
        for(int a=lowestValue; a<diceRoll.length; a++){
            int stackCardCount=(int) Math.round(diceRoll[a]*0.01);
           
            for(int b=0; b<stackCardCount; b++){
                pushCard(a);
            }
              
        }
        
        //first shuffle the stack then initial  card
        shuffleCardStack();
                
        for(int b=0; b<removeCard; b++){
                removedCardStack.add(nextCard());
            }
        
        
    }
    
    public void removeCard(){
        removedCardStack.add(nextCard());
        }
    
    public ArrayList<Integer> getStackArrayList(int stackName){
        if(stackName==1)return cardStack;
        else return dealtCardStack;
    }
    
    public void shuffleCardStack(){
        Random random = new Random();
        int stackLength=cardStack.size();
        try {
            for(int i=0; i<stackLength; i++){
            int index=random.nextInt(stackLength);
            int tmp=cardStack.get(i);
            cardStack.set(i, cardStack.get(index));
            cardStack.set(index, tmp);
            
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
            }
        }
    
    
    
    
    public void dealtCards(){
        try {
            dealtCardStack.add(nextCard());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }
        }
    
    @Override
    public void pushCard(int value) {
        cardStack.add(value);
    }
   
    @Override
    public int nextCard() {
        return cardStack.remove(cardStack.size()-1);
    }

    @Override
    public int getCardStackSize(String cardStackTag) {
        if(cardStackTag.equals("1"))return cardStack.size();
        else if(cardStackTag.equals("2"))return removedCardStack.size();
        else if(cardStackTag.equals("3"))return dealtCardStack.size();
        return 0;
    }

    @Override
    public int getCards(String cardStackTag, int position) {
        if(cardStackTag.equals("1"))return cardStack.get(position);
        else if(cardStackTag.equals("2"))return removedCardStack.get(position);
        else if(cardStackTag.equals("3"))return dealtCardStack.get(position);
        return 0;
    }
    
    
    void CreateChart(ArrayList<Integer> percentagecard, int cartName, String JFTitle) { 
        ///int[] countStackValue = new int[];
         int[] countStackValue=new int[((highestValue-lowestValue)+1)];
              
               for (int a=0;a<percentagecard.size();a++){
                   int temp = percentagecard.get(a);
                  countStackValue[temp-lowestValue]+=1;
               }
        
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        int low=lowestValue;
        for (int k=0;k<countStackValue.length;k++){
       dataset .setValue(countStackValue[k],"Out of 100",Integer.toString(low) );
       low +=1;
        }
        JFreeChart barChart=ChartFactory.createBarChart(JFTitle, "Dice Faces", "How Many Times Came", dataset, PlotOrientation.VERTICAL, false,true, false);
        CategoryPlot  p=barChart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.cyan);
        ChartFrame frame=new ChartFrame("Parcentage Graph",barChart);
        if(cartName==1){
            frame.setBounds(280, 100, 400,500);
            frame.setVisible(true);
        }else{
            frame.setBounds(680, 100, 400,500);
            frame.setVisible(true);
            }
        
        
    }
    
}
