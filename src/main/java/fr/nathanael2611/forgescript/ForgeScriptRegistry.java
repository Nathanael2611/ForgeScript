package fr.nathanael2611.forgescript;

import fr.nathanael2611.forgescript.commands.CommandCustom;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

public class ForgeScriptRegistry {

    public static void registerPerms(){
        for(String perm : ForgeScript.permissions){
            PermissionAPI.registerNode(perm, DefaultPermissionLevel.OP, "Commande générée par ScriptForge.");
        }
    }

    public static void registerCommands(FMLServerStartingEvent e){
        for(CommandCustom commandCustom : ForgeScript.commands){
            e.registerServerCommand(commandCustom);
        }
    }

}
