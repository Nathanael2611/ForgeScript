package fr.nathanael2611.forgescript.scriptobjects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class ScriptGetters {


    public static Object get(ScriptAction action, String varToGet){
        varToGet = varToGet.replace(".", " ");
        String[] varDivideByPoints = varToGet.split(" ");
        if(varDivideByPoints.length>=1 && varDivideByPoints[0].equalsIgnoreCase("sender")||varDivideByPoints[0].equalsIgnoreCase("player")){
            if(action.entity != null) {
                if (varDivideByPoints[1] != null && varDivideByPoints[1].equalsIgnoreCase("position")) {
                    System.out.println(varToGet + "   "+varDivideByPoints[0]);
                    return action.entity.getPosition();
                }else{
                    return action.entity;
                }
            }
        }
        return null;
    }

    public static Block getBlockByAliases(String aliases){
        if(aliases.equalsIgnoreCase("planks")){
            return Blocks.PLANKS;
        }
        return null;
    }


}
