package JourneyUI;

import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by omar on 11/10/14.
 */
public class JourneyEventHandler {
    private JourneyUI ui;
    public JourneyEventHandler(JourneyUI initUI){
        ui = initUI;
    }

    public void startButtonRequest() throws FileNotFoundException, IOException{
        try{
        ui.switchScreenRequest("selectPlayers");}
        catch (Exception e){
        }
    }

    public void goButtonRequest() throws FileNotFoundException, IOException{
        try{
        ui.switchScreenRequest("gameScreen");}
        catch (Exception e){
        }
    }
    public void historyButtonRequest(){
        ui.displayHistory();
    }
    public void quitButtonRequest() {
        System.exit(0);
    }
}
