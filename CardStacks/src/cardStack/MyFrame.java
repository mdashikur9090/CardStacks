package cardStack;



import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public abstract class  MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        ArrayList<GenarateCardStack> genarateCardStacks = new ArrayList<GenarateCardStack>();
        CardStackTypeList cardStackTypeList = new CardStackTypeList();
        ArrayList<String> cardStackName = new ArrayList<String>();
        InputValidation inputValidation;
        JPanel mJPanel = new JPanel();
        JPanel cardStackTypePanel = new JPanel();
        JLabel applicationTitle = new JLabel("Card Stacks");
        JLabel lblDiceNotation = new JLabel("Please Insert Dice Notation");
        JLabel rollDiceOutput = new JLabel("", SwingConstants.CENTER);
        JLabel stackType = new JLabel("Stack Type", SwingConstants.CENTER);
        JLabel pickRemainCards = new JLabel("Remain Cards", SwingConstants.CENTER);
        JLabel pickRemovedCards = new JLabel("Dealt Cards", SwingConstants.CENTER);
        JLabel pickDealtCards = new JLabel("Removed Cards", SwingConstants.CENTER);
        JTextField mJTextField = new JTextField();
        JButton btnroolDice = new JButton("Roll Dice");
        JButton btnpeek = new JButton("Peek");
        JButton shuffle = new JButton("Shuffle");
        JButton showChart = new JButton("Show Chart");
        ButtonGroup radiogroupButton = new ButtonGroup();
        JTextArea showRemainCardStack = new JTextArea();
        JTextArea showRemovedCardStack = new JTextArea();
        JTextArea showDealtCardStack = new JTextArea();
        JScrollPane showRemainCardStackScroll = new JScrollPane (showRemainCardStack, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane showRemovedCardStackScroll = new JScrollPane (showRemovedCardStack, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane showDealtCardStackScroll = new JScrollPane (showDealtCardStack, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane cardStackTypeScroll = new JScrollPane (cardStackTypePanel, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
        Font font1 = new Font("SansSerif", Font.BOLD, 16);
        public final String  REMAIN_CARD_STACK_TAG="1";
        public final String  REMOVED_CARD_STACK_TAG="2";
        public final String  DEALT_CARD_STACK_TAG="3";
        
        
        
	public MyFrame(){
            this.setSize(800, 600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            
            //add panel
            mJPanel.setLayout(null);
            mJPanel.setSize(750, 650);
            mJPanel.setOpaque(true);
            mJPanel.setBackground(Color.decode("#eee6ff"));
            this.add(mJPanel);
            
            cardStackTypePanel.setLayout(new BoxLayout(cardStackTypePanel, BoxLayout.Y_AXIS));
            
            //add label
            applicationTitle.setBounds(320, 0, 200, 50);
            applicationTitle.setFont(new Font("Serif", 3, 30));
            applicationTitle.setForeground(Color.PINK);
            mJPanel.add(applicationTitle);
                    
            lblDiceNotation.setBounds(30, 50, 200, 50);
            mJPanel.add(lblDiceNotation);
            
            rollDiceOutput.setOpaque(true);
            rollDiceOutput.setFont(new Font("Serif", 1, 20));
            rollDiceOutput.setBounds(30, 170, 150, 50);
            rollDiceOutput.setBackground(Color.white);
            mJPanel.add(rollDiceOutput);
            
            stackType.setOpaque(true);
            stackType.setBounds(200, 50, 100, 50);
            stackType.setBackground(null);
            mJPanel.add(stackType);
            
            pickRemainCards.setOpaque(true);
            pickRemainCards.setBounds(330, 50, 100, 50);
            pickRemainCards.setBackground(null);
            mJPanel.add(pickRemainCards);
            
           
            pickDealtCards.setOpaque(true);
            pickDealtCards.setBounds(460, 50, 100, 50);
            pickDealtCards.setBackground(null);
            mJPanel.add(pickDealtCards);
            
            pickRemovedCards.setOpaque(true);
            pickRemovedCards.setBounds(590, 50, 100, 50 );
            pickRemovedCards.setBackground(null);
            mJPanel.add(pickRemovedCards);
            
            //add text field
            mJTextField.setBounds(30, 100, 150, 50);
            mJTextField.setFont(font1);
            mJTextField.setHorizontalAlignment(JTextField.CENTER);
            mJPanel.add(mJTextField);
            
            //add button
            btnroolDice.setBounds(30, 240, 150, 50);
            mJPanel.add(btnroolDice);
            
            btnpeek.setBounds(30, 310, 150, 50);
            mJPanel.add(btnpeek);
            
            shuffle.setBounds(30, 380, 150, 50);
            mJPanel.add(shuffle);
            
            showChart.setBounds(30, 450, 150, 50);
            mJPanel.add(showChart);
            
            //set text are font size
            showRemainCardStack.setFont(font1);
            showRemovedCardStack.setFont(font1);
            showDealtCardStack.setFont(font1);
            
            cardStackTypeScroll.setBounds(200, 100, 100, 400);
            mJPanel.add(cardStackTypeScroll);
            
            showRemainCardStackScroll.setBounds(330, 100, 100, 400);
            mJPanel.add(showRemainCardStackScroll);
            
            showRemovedCardStackScroll.setBounds(460, 100, 100, 400);
            mJPanel.add(showRemovedCardStackScroll);
            
            showDealtCardStackScroll.setBounds(590, 100, 100, 400);
            mJPanel.add(showDealtCardStackScroll);
            
            
            
            
            
            
            
            
            
            
	}
        
        public abstract void addRadioButton();
        
        public abstract void setButtonAction();

        
        public Boolean CardStackNameAvailability (){
            for(int i=0; i<cardStackName.size(); i++){
                if(cardStackName.get(i).equals(mJTextField.getText())){
                    return true;
                }
            }
        return false;
        }
        
        public int getStackTypePositon(){
                for(int a=0; a<cardStackName.size(); a++){
                    if(radiogroupButton.getSelection().getActionCommand().equals(cardStackName.get(a))){
                         return a;
                        }
                }
        return -1;
        }


}
