package fr.nathanael2611.forgescript;

import fr.nathanael2611.forgescript.commands.CommandCustom;
import fr.nathanael2611.forgescript.scriptobjects.ActionSetBlock;
import fr.nathanael2611.forgescript.scriptobjects.ScriptAction;
import fr.nathanael2611.forgescript.scriptobjects.ScriptObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptParser {

    File script;

    public ScriptParser(File script){
        this.script = script;
    }



    public List<CommandCustom> parseCommands() throws IOException {

        String name = "";
        String desc = "";
        String perm = "";

        List<CommandCustom> commandsList = new ArrayList<>();
        List<ScriptObject> actionList = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(script));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;

        boolean commandCreationInWork = false;

        while ((line = br.readLine()) != null) {




            if(line.startsWith("command(")&&line.endsWith("{")&&commandCreationInWork == false){


                commandCreationInWork = true;



                line = line.substring(8, line.length()-2);
                String[] params = line.split(",");
                if(params.length>=2){
                    System.out.println(params);

                    name = params[0];
                    desc = params[1];
                    if(params.length>=3){
                        perm = params[2];
                    }

                }else{
                    commandCreationInWork = false;
                }
            }

            if(line.startsWith("execute(")&&line.endsWith(");")){
                if(commandCreationInWork == true) {
                    line = line.substring(8, line.length() - 2);
                    actionList.add(parseAction(line));

                }
            }

            if(line.equalsIgnoreCase("}commandEnd;")&&commandCreationInWork==true){
                commandCreationInWork = false;
                for(int x = 0; x<100; x++){
                    System.out.println(actionList);
                }
                commandsList.add(new CommandCustom(name, desc, perm, actionList));

                actionList = new ArrayList<>();
                 name = "";
                 desc = "";
                 perm = "";
            }


        }
        br.close();

        return commandsList;
    }




    public ScriptAction parseAction(String action){
        String[] args;
        boolean isBuildingString = false;
        StringBuilder argsBuilder = new StringBuilder();
        for(int i = 0; i<action.length(); i++){
            String h = action.substring(i, i + 1);

            if(isBuildingString){
                if(h.equalsIgnoreCase(")")){
                    isBuildingString = false;
                }else{
                    argsBuilder.append(h);
                }

            }else {
                if (h.equalsIgnoreCase("(")) {
                    isBuildingString = true;

                }
            }
        }

        args = argsBuilder.toString().split(",");

        System.out.println(args);

        if(action.startsWith("setblock(")&&action.endsWith(")")){

            if(args.length == 2){
                return new ActionSetBlock(args);
            }else if(args.length==4){
                return new ActionSetBlock(args);
            }

        }
        return null;
    }
}
