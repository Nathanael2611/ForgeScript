package fr.nathanael2611.forgescript;

import fr.nathanael2611.forgescript.commands.CommandCustom;
import fr.nathanael2611.forgescript.commands.CommandScript;
import fr.nathanael2611.forgescript.proxies.CommonProxy;
import fr.nathanael2611.forgescript.scriptobjects.ActionSetBlock;
import fr.nathanael2611.forgescript.scriptobjects.ScriptObject;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Mod(modid="forgescript")
public class ForgeScript {


    public static File configDir;
    public static File configFile;
    public static File scriptsDir;


    public static List<String> permissions = new ArrayList<>();
    public static List<CommandCustom> commands = new ArrayList<>();

    public static final String MODID = "forgescript";


    @Mod.Instance(ForgeScript.MODID)
    public static ForgeScript instance;


    public static Logger logger = Logger.getLogger("forgescript");


    @SidedProxy(clientSide="fr.nathanael2611.forgescript.proxies.ClientProxy", serverSide="fr.nathanael2611.forgescript.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

        proxy.preInit(e.getSuggestedConfigurationFile());

        configDir = new File(e.getSuggestedConfigurationFile().getParentFile().getPath()+"/forgescript/");
        configFile = new File(configDir.getPath()+"/forgescript.cfg");
        scriptsDir = new File(configDir.getPath()+"/scripts/");
        if(!configDir.exists()){
            configDir.mkdir();
            sendLog("Création du dossier forgescripts car il n'existait pas...");
        }
        if(!configFile.exists()){
            try {
                configFile.createNewFile();
                sendLog("Création du fichier forgescript.cfg car il n'existait pas...");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if(!scriptsDir.exists()){
            scriptsDir.mkdir();
        }



        for(int x = 0; x < 100; x++){
            System.out.println("   =   "+configFile.exists());
        }

    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init();
        PermissionAPI.registerNode(MODID+".command.script", DefaultPermissionLevel.OP, "Allow usage of script command.");
        ForgeScriptRegistry.registerPerms();


    }


    public static void sendLog(String log){
        logger.info("[FORGESCRIPT] "+log);
    }

    @Mod.EventHandler
    public void serverStartingEvent(FMLServerStartingEvent e) throws IOException {
        commands.clear();
        for(File script : scriptsDir.listFiles()){

            ScriptParser parser = new ScriptParser(script);
            for(CommandCustom cmd : parser.parseCommands()){
                commands.add(cmd);
                for(int x = 0; x<100; x++){
                    System.out.println(cmd.getName());
                }
            }

        }
        ForgeScriptRegistry.registerCommands(e);
        e.registerServerCommand(new CommandScript());
    }

}
