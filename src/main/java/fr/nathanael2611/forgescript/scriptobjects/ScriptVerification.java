package fr.nathanael2611.forgescript.scriptobjects;

public class ScriptVerification extends ScriptObject{


    Object val1;

    String comparator;

    Object val2;


    public boolean verif(){

        if(val2 != null){

            if(comparator.equalsIgnoreCase("=")){
                if(val1 == val2){
                    return true;
                }
            }
            if(comparator.equalsIgnoreCase("equal")){
                if(val1.equals(val2)){
                    return true;
                }
            }
            return false;


        }else{



        }
        return false;
    }


}
