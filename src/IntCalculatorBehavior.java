import java.awt.event.ActionEvent;
import java.util.*;

public class IntCalculatorBehavior extends CalculatorBehavior{
    /**
     * Uses the ActionEvent to determine what to do with the calculator
     * @param e
     * @return
     */
    public static String takeIntAction(ActionEvent e) {
        powerController(e);
        while(calcPower){
            /*
            Checks to see what value has been inputted
            */
            if(Arrays.asList(CALC_NUM).contains(e.getActionCommand())){
                if(!isNegative){
                    addInput(e);
                }else {
                    inputList = addIfNegative(e, inputList);
                    testPrint(inputList);
                }
            }else if(Arrays.asList(CALC_OPERATORS).contains(e.getActionCommand())){
                addOperator(e);

            }else {
                doOperator(e);
            }

            /*
            Returns the full string to set on the display
            */
            return printEquation(inputList);
        }
        return printEquation(inputList);
    }

    /**
     * Takes the list and creates a full string
     * @param list
     * @return
     */
    public static String printEquation(List<String> list){
        String output = "";
        for(String str: list){
            if(checkNum(str)){
                output += Math.round(Float.parseFloat(str));
            }else{
                output += str;
            }
        }

        return output;
    }

    private static boolean checkNum(String str){
        if(str.matches("\\d+")){
            return true;
        }else{
            return false;
        }

    }
}
