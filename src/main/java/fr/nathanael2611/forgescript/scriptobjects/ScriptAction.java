package fr.nathanael2611.forgescript.scriptobjects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ScriptAction extends ScriptObject{

    String actionName;
    String[] actionArgs;

    Entity entity;

    public ScriptAction(String actionName, String[] actionArgs){
        this.actionName = actionName;
        this.actionArgs = actionArgs;
    }

    public void execute() {

    }

    public String getActionName() {
        return actionName;
    }

    public String[] getActionArgs() {
        return actionArgs;
    }

    public void setEntity(Entity entity){
        this.entity = entity;
    }

}
