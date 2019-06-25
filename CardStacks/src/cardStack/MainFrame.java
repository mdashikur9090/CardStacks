package cardStack;



import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;



/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class MainFrame extends MyFrame implements ActionListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new MainFrame().setVisible(true);

	}
        
    public MainFrame(){
    setButtonAction();
    }

    @Override
    public void setButtonAction() {
    	btnroolDice.addActionListener(this);
    	btnpeek.addActionListener(this);
        shuffle.addActionListener(this);
        showChart.addActionListener(this);
    }
    
    @Override
    public void addRadioButton() {
        JRadioButton cardTypeRadioButton = new JRadioButton(mJTextField.getText());
        cardTypeRadioButton.setActionCommand(mJTextField.getText());
        cardTypeRadioButton.setFont(font1);
        radiogroupButton.add(cardTypeRadioButton);
        cardStackTypePanel.add(cardTypeRadioButton);
        cardStackTypePanel.revalidate();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent ob) {
        String buttonName=ob.getActionCommand();
		switch(buttonName){
                    
                    case "Roll Dice":
                        inputValidation = new InputValidation(mJTextField.getText());
                        if(inputValidation.validation()){
                            if(CardStackNameAvailability()){
                                if(radiogroupButton.getSelection()!=null){
                                    if(genarateCardStacks.get(getStackTypePositon()).getCardStackSize(REMAIN_CARD_STACK_TAG)>0){
                                        genarateCardStacks.get(getStackTypePositon()).dealtCards();
                                        rollDiceOutput.setText(""+genarateCardStacks.get(getStackTypePositon()).getCards(DEALT_CARD_STACK_TAG,
                                        genarateCardStacks.get(getStackTypePositon()).getCardStackSize(DEALT_CARD_STACK_TAG)-1));
                                        
                                    }else{
                                        //if all the number of card stack exhausted 
                                        JOptionPane.showMessageDialog(this, "After all card numbers exhausted from \n the stack, now Stack is regenarate.",
                                                "Validation warning!", JOptionPane.INFORMATION_MESSAGE);
                                        GenarateCardStack gl = new GenarateCardStack(inputValidation.getSplit());
                                        gl.makeStack();
                                        genarateCardStacks.set(getStackTypePositon(), gl);
                                        }
                                   
                                }else{JOptionPane.showMessageDialog(this, "You must select al least one cardStack ", 
                                        "Validation warning!", JOptionPane.INFORMATION_MESSAGE);}
                                
                            }else{cardStackName.add(mJTextField.getText());
                                GenarateCardStack gl = new GenarateCardStack(inputValidation.getSplit());
                                gl.makeStack();
                                genarateCardStacks.add(gl);
                                addRadioButton();
                                
                                }
                            
                           
                        }else{JOptionPane.showMessageDialog(this, "Plese input currect dice notation like \n <dice number>d<faces>."
                                + "Exmaple 1d6-2.", "Validation warning!", JOptionPane.INFORMATION_MESSAGE);}

                        break;
                        
                    case "Peek":
                        
                        if(radiogroupButton.getSelection()!=null){
                            
                            
                            
                            try {
                                String remainCards = "";
                            for(int n=0; n<genarateCardStacks.get(getStackTypePositon()).getCardStackSize(REMAIN_CARD_STACK_TAG); n++){
                            remainCards+= "       " + genarateCardStacks.get(getStackTypePositon()).getCards(REMAIN_CARD_STACK_TAG, n)+"\n";
                            }

                            

                            String removeCards = "";
                            for(int n=0; n<genarateCardStacks.get(getStackTypePositon()).getCardStackSize(REMOVED_CARD_STACK_TAG); n++){
                            removeCards+= "       " + genarateCardStacks.get(getStackTypePositon()).getCards(REMOVED_CARD_STACK_TAG, n)+"\n";
                            }

                            

                            String dealtCards = "";
                            for(int n=0; n<genarateCardStacks.get(getStackTypePositon()).getCardStackSize(DEALT_CARD_STACK_TAG); n++){
                            dealtCards+= "       " + genarateCardStacks.get(getStackTypePositon()).getCards(DEALT_CARD_STACK_TAG, n)+"\n";
                            }

                            showRemainCardStack.setText("");
                            showRemovedCardStack.setText("");
                            showDealtCardStack.setText("");
                            showRemainCardStack.setText(remainCards);
                            showRemovedCardStack.setText(removeCards);
                            showDealtCardStack.setText(dealtCards);
                            
                            } catch (NullPointerException e) {
                                System.out.println("Exception thrown  :" + e);
                            }
                           
                        }else{
                            
                            JOptionPane.showMessageDialog(this, "You must select al least one cardStack ", 
                                        "Validation warning!", JOptionPane.INFORMATION_MESSAGE);
                        }
                       
                        break;
                        
                    case "Shuffle":
                        if(radiogroupButton.getSelection()!=null){
                            genarateCardStacks.get(getStackTypePositon()).shuffleCardStack();
                            
                            String remainCards = "";
                            for(int n=0; n<genarateCardStacks.get(getStackTypePositon()).getCardStackSize(REMAIN_CARD_STACK_TAG); n++){
                            try {
                                remainCards+= "       " + genarateCardStacks.get(getStackTypePositon()).getCards(REMAIN_CARD_STACK_TAG, n)+"\n";
                            }catch (NullPointerException e) {
                                System.out.println("Exception thrown  :" + e);
                            }
                            }
                            showRemainCardStack.setText("");
                            showRemainCardStack.setText(remainCards);
                             
                           
                        }else{JOptionPane.showMessageDialog(this, "You must select al least one cardStack ", 
                                        "Validation warning!", JOptionPane.INFORMATION_MESSAGE);}
                        
                        break;
                        
                    case "Show Chart":
                        try {
                            if(radiogroupButton.getSelection()!=null){
                            
                           genarateCardStacks.get(getStackTypePositon()).CreateChart(genarateCardStacks.get(getStackTypePositon()).getStackArrayList(1), 1, "Percentage of Remain card.");
                           genarateCardStacks.get(getStackTypePositon()).CreateChart(genarateCardStacks.get(getStackTypePositon()).getStackArrayList(2), 2, "Percentage of dealt cards.");
                           
                        }else{JOptionPane.showMessageDialog(this, "You must select al least one cardStack ", 
                                        "Validation warning!", JOptionPane.INFORMATION_MESSAGE);}
                        } catch (NullPointerException e) {
                            System.out.println("Exception thrown  :" + e);
                        }
                        
                        break;
                }
    }

    

    

}
