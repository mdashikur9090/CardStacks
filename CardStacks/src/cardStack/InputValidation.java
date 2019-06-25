package cardStack;


import java.util.StringTokenizer;

/**
 *
 * @author MD ASHIKUR RAHMAN
 */
public class InputValidation {
    private String getTexfieldText;
    private Boolean validInput = true;
    private String[] splitInput =new String[3];
    
   public InputValidation(String s){
        getTexfieldText=s;
    }
   
   public String[] getSplit() {
        return splitInput;
    }
   
   public Boolean validation(){
       
                    //check Minus is available or not And nothow number of "d" and "-"
                    Boolean minusAvailable = false;
                    int countD=0;
                    int countMinus=0;
                    for(int x=0; x<getTexfieldText.length(); x++){
                        if(getTexfieldText.charAt(x) == 'd'){
                            countD++;
                        }
                        if(getTexfieldText.charAt(x) == '-'){
                            minusAvailable=true;
                            countMinus++;
                        }
                    }
                    
                    
                    
                    
                    //if minus is available
                    if(minusAvailable){
                        if(countD==1 && countMinus==1){
                            //check "d" and "-" place their own position.
                            if(getTexfieldText.indexOf("d")==0 || getTexfieldText.indexOf("-")==0 || 
                                getTexfieldText.indexOf("d")+1 >= getTexfieldText.indexOf("-") ||
                                    getTexfieldText.indexOf("-")==getTexfieldText.length()-1){
                                validInput = false;
                                
                            }else{
                                StringTokenizer stringTokenizer = new StringTokenizer(getTexfieldText, "d-");
                                int count=0;
                                while(stringTokenizer.hasMoreTokens()){
                                String s = stringTokenizer.nextToken();
                                
                                
                                        
                                for(int y=0; y<s.length(); y++){
                                    int c = (int)s.charAt(y);
                                       if(c<48 || c>57){
                                        validInput=false;
                                       }
                                    }
                                     splitInput[count]=s;
                                     count++;
                                    }
                               
                                    
                                 }
                        
                        }else{validInput = false;}
                    }else{
                        //if minus is not available
                            if(getTexfieldText.indexOf("d")==0 || getTexfieldText.indexOf("d")==getTexfieldText.length()-1 || countD<1 ){
                                validInput = false;;
                            
                            } else{
                                    StringTokenizer stringTokenizer = new StringTokenizer(getTexfieldText, "d");
                                   int count=0;
                                    while(stringTokenizer.hasMoreTokens()){
                                        String s = stringTokenizer.nextToken();
                                        
                                        for(int y=0; y<s.length(); y++){
                                            int c = (int)s.charAt(y);
                                            if(c<48 || c>57){
                                                validInput=false;
                                            }
                                        }
                                        splitInput[count]=s;
                                        count++;
                                    }
                                    splitInput[2]="0";
                                
                                
                                    
                                
                                }
                        
                        }
  
   return validInput;}
    
}
