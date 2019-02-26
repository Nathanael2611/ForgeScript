package fr.nathanael2611.forgescript.util;

//THIS CLASS WAS TAKE FROM "MaCalculette" GitHub REPOSITORIES.

public class Calcul {
    double val1;
    double val2;
    String signe;
    public Calcul(double val1, String signe, double val2){
        this.val1 = val1;
        this.signe = signe;
        this.val2 = val2;
    }

    public double calc(){
        if(signe == "*"){
            return val1*val2;
        }
        if(signe == "/"){
            return val1/val2;
        }
        if(signe == "+"){
            return val1+val2;
        }
        if(signe == "-"){
            return val1-val2;
        }
        return 0;
    }

    public static Calcul parseCalcul(String calcul){
        if(calcul.contains("*")||calcul.contains("/")||calcul.contains("+")||calcul.contains("-")){
            String signe = "+";
            if(calcul.contains("*")) signe = "*";
            if(calcul.contains("/")) signe = "/";
            if(calcul.contains("+")) signe = "+";
            if(calcul.contains("-")) signe = "-";
            String part1 = calcul.substring(0, calcul.indexOf(signe));
            String part2 = calcul.substring(calcul.indexOf(signe)+1, calcul.length());
            return new Calcul(Double.parseDouble(part1), signe, Double.parseDouble(part2));
        }else{
            System.err.println("Le calcul entré n'est pas valide !");
            return null;
        }
    }





}