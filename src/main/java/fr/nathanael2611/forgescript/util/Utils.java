package fr.nathanael2611.forgescript.util;

public class Utils {


    public static boolean checkIfCalcIsPossibleInAString(String calc){

        if(calc.contains("+")||calc.contains("-")||calc.contains("*")||calc.contains("/")){
            return true;
        }

        return false;

    }


}
