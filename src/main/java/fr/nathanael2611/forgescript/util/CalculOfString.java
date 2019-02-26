package fr.nathanael2611.forgescript.util;

//THIS CLASS WAS TAKE FROM "MaCalculette" GitHub REPOSITORIES.

public class CalculOfString {
    String val1;
    String val2;
    String signe;
    public CalculOfString(String val1, String signe, String val2){
        this.val1 = val1;
        this.signe = signe;
        this.val2 = val2;
    }

    public String getVal1() {
        return val1;
    }

    public String getVal2() {
        return val2;
    }

    public String getSigne() {
        return signe;
    }

    public static CalculOfString parseCalcul(String calcul){
        if(calcul.contains("*")||calcul.contains("/")||calcul.contains("+")||calcul.contains("-")){
            String signe = "+";
            if(calcul.contains("*")) signe = "*";
            if(calcul.contains("/")) signe = "/";
            if(calcul.contains("+")) signe = "+";
            if(calcul.contains("-")) signe = "-";
            String part1 = calcul.substring(0, calcul.indexOf(signe));
            String part2 = calcul.substring(calcul.indexOf(signe)+1, calcul.length());
            return new CalculOfString(part1, signe, part2);
        }else{
            System.err.println("Le calcul entré n'est pas valide !");
            return null;
        }
    }





}