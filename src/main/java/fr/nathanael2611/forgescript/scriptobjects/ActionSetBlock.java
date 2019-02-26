package fr.nathanael2611.forgescript.scriptobjects;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class ActionSetBlock extends ScriptAction {


    public ActionSetBlock(String[] actionArgs) {
        super("setblock", actionArgs);

    }


    public void execute(World world){
        if(actionArgs.length == 2) {

            System.out.println(ScriptGetters.getBlockByAliases(actionArgs[1]).getDefaultState());
            world.setBlockState((BlockPos)ScriptGetters.get(this, actionArgs[0]), ScriptGetters.getBlockByAliases(actionArgs[1]).getDefaultState());
        }
    }


}
