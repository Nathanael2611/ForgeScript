package fr.nathanael2611.forgescript.scriptobjects;

import fr.nathanael2611.forgescript.util.Calcul;
import fr.nathanael2611.forgescript.util.CalculOfString;
import fr.nathanael2611.forgescript.util.Utils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class ActionSetBlock extends ScriptAction {


    public ActionSetBlock(String[] actionArgs) {
        super("setblock", actionArgs);

    }


    public void execute(World world){
        if(actionArgs.length == 2) {
            world.setBlockState((BlockPos)ScriptGetters.get(this, actionArgs[0]), ScriptGetters.getBlockByAliases(actionArgs[1]).getDefaultState());
        }else if (actionArgs.length == 4){
            if(Utils.checkIfCalcIsPossibleInAString(actionArgs[0])){
                CalculOfString cof = CalculOfString.parseCalcul(actionArgs[0]);
                actionArgs[0] = Integer.toString((int) new Calcul(Double.parseDouble(cof.getVal1()), cof.getSigne(), Double.parseDouble(cof.getVal2())).calc());
            }
            if(Utils.checkIfCalcIsPossibleInAString(actionArgs[1])){
                CalculOfString cof = CalculOfString.parseCalcul(actionArgs[1]);
                actionArgs[1] = Integer.toString((int) new Calcul(Double.parseDouble(cof.getVal1()), cof.getSigne(), Double.parseDouble(cof.getVal2())).calc());
            }
            if(Utils.checkIfCalcIsPossibleInAString(actionArgs[2])){
                CalculOfString cof = CalculOfString.parseCalcul(actionArgs[2]);
                actionArgs[2] = Integer.toString((int) new Calcul(Double.parseDouble(cof.getVal1()), cof.getSigne(), Double.parseDouble(cof.getVal2())).calc());
            }

            world.setBlockState(new BlockPos((int)ScriptGetters.get(this, actionArgs[0]), (int)ScriptGetters.get(this, actionArgs[1]), (int)ScriptGetters.get(this, actionArgs[2])), ScriptGetters.getBlockByAliases(actionArgs[3]).getDefaultState());
        }
    }




}
