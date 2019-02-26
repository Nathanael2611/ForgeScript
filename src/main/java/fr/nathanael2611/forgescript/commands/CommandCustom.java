package fr.nathanael2611.forgescript.commands;

import fr.nathanael2611.forgescript.ForgeScript;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandCustom extends CommandBase {

    String name;
    String usage;
    String permission;

    public CommandCustom(String name, String usage, String permission){
        this.name = name;
        this.usage = usage;
        this.permission = permission;
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

    }
}
