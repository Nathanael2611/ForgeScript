package fr.nathanael2611.forgescript.commands;

import fr.nathanael2611.forgescript.ForgeScript;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.permission.PermissionAPI;

public class CommandScript extends CommandBase {
    @Override
    public String getName() {
        return "script";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "Commande pour gérer les scripts.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        System.out.println("salut");
    }

    @Override

    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {

        if (sender instanceof EntityPlayer)

            return PermissionAPI.hasPermission((EntityPlayer) sender, ForgeScript.MODID+".command.script");

        return true;

    }
}
