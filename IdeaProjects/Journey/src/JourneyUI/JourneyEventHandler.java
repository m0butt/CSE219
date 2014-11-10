package JourneyUI;

import javafx.scene.control.Label;

/**
 * Created by omar on 11/10/14.
 */
public class JourneyEventHandler {
    private JourneyUI ui;
    public JourneyEventHandler(JourneyUI initUI){
        ui = initUI;
    }

    public void startButtonRequest(){
        ui.switchScreenRequest("selectPlayers");
    }

    public void goButtonRequest(){
        ui.switchScreenRequest("gameScreen");
    }
    public void historyButtonRequest(){
        ui.displayHistory();
    }
    public void quitButtonRequest() {
        System.exit(0);
    }
}
