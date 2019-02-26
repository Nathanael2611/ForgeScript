package fr.nathanael2611.forgescript.commands;

import fr.nathanael2611.forgescript.ForgeScript;
import fr.nathanael2611.forgescript.scriptobjects.ActionSetBlock;
import fr.nathanael2611.forgescript.scriptobjects.ScriptAction;
import fr.nathanael2611.forgescript.scriptobjects.ScriptObject;
import fr.nathanael2611.forgescript.scriptobjects.ScriptVerification;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class CommandCustom extends CommandBase {

    String name;
    String usage;
    String permission;

    List<ScriptObject> actionList;

    public CommandCustom(String name, String usage, String permission, List<ScriptObject> actionList){
        this.name = name;
        this.usage = usage;
        this.permission = permission;
        this.actionList = actionList;
        ForgeScript.permissions.add(permission);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return usage;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        for(ScriptObject action : actionList){



            if(action instanceof ScriptVerification){
                ScriptVerification verification = (ScriptVerification) action;
                if(verification.verif()){
                    continue;
                }else{

                }
            }

            if(action instanceof ScriptAction) {
                if(sender instanceof Entity) {
                    ((ScriptAction) action).setEntity((Entity)sender);
                }
                if (action instanceof ActionSetBlock) {
                    ActionSetBlock setBlockAction = (ActionSetBlock) action;
                    setBlockAction.execute(sender.getEntityWorld());
                }
            }

        }

    }
}
