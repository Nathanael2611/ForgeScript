package fr.nathanael2611.forgescript;

import fr.nathanael2611.forgescript.commands.CommandScript;
import fr.nathanael2611.forgescript.proxies.CommonProxy;
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
import java.util.logging.Logger;

@Mod(modid="forgescript")
public class ForgeScript {

    public static final String MODID = "forgescript";


    @Mod.Instance(ForgeScript.MODID)
    public static ForgeScript instance;


    public static Logger logger = Logger.getLogger("forgescript");


    @SidedProxy(clientSide="fr.nathanael2611.forgescript.proxies.ClientProxy", serverSide="fr.nathanael2611.forgescript.proxies.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

        proxy.preInit(e.getSuggestedConfigurationFile());

        File configDir = new File(e.getSuggestedConfigurationFile().getParentFile().getPath()+"/forgescript/");
        File configFile = new File(configDir.getPath()+"/forgescript.cfg");
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
        for(int x = 0; x < 100; x++){
            System.out.println("   =   "+configFile.exists());
        }

    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init();
        PermissionAPI.registerNode(MODID+".command.script", DefaultPermissionLevel.OP, "Allow usage of script command.");
    }


    public static void sendLog(String log){
        logger.info("[FORGESCRIPT] "+log);
    }

    @Mod.EventHandler
    public void serverStartingEvent(FMLServerStartingEvent e){
        e.registerServerCommand(new CommandScript());
    }

}