package JourneyUI;

/**
 * Created by Mohammad Butt on 11/10/14.
 */
import JourneyGameComponents.City;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JourneyUI {
    private Stage primaryStage;
    private BorderPane mainPane;
    private StackPane splashScreenPane;
    private GridPane selectPlayersPane;
    private BorderPane selectPlayersParentPane;
    private Label history;
    private Label about;
    private AnchorPane historyPane;
    private AnchorPane aboutPane;
    private ArrayList<City> cities;
    private AnchorPane gridPane;
    private VBox leftBox;

    public GridPane getGamePane() {
        return gamePane;
    }

    public void setGamePane(GridPane gamePane) {
        this.gamePane = gamePane;
    }

    private GridPane gamePane;
    private String ImgPath = "images/";
    JourneyEventHandler eventHandler = new JourneyEventHandler(this);
    Font font = new Font("Calibri", 30);

    public JourneyUI(){
        initMainPane();
        initSplashScreen();
    }

    public void initSplashScreen() {
        splashScreenPane = new StackPane();
        splashScreenPane.setPrefSize(1000, 1000);
        // INIT THE SPLASH SCREEN CONTROLS
        String splashScreenImagePath = "splash.jpg";
        Image splashScreenImage = loadImage(splashScreenImagePath);
        ImageView splashScreenImageView = new ImageView(splashScreenImage);


        //splashScreenImageView.resize(800,800);

        Label splashScreenImageLabel = new Label();
        splashScreenImageLabel.resize(1000,1000);
        splashScreenImageLabel.setAlignment(Pos.CENTER);
        splashScreenImageLabel.setGraphic(splashScreenImageView);


        //Button Stuff
        Image playButtonImage = loadImage("start.png");
        ImageView playButtonImageView = new ImageView(playButtonImage);
        VBox buttonBox = new VBox();
        Button playButton = new Button();
        playButton.setGraphic(playButtonImageView);
        Image loadButtonImage = loadImage("load.png");
        ImageView loadButtonImageView = new ImageView(loadButtonImage);
        Button loadButton = new Button();
        loadButton.setGraphic(loadButtonImageView);
        Image aboutButtonImage = loadImage("about.png");
        ImageView aboutButtonImageView = new ImageView(aboutButtonImage);
        Button aboutButton = new Button();
        aboutButton.setGraphic(aboutButtonImageView);
        Image quitButtonImage = loadImage("quit.png");
        ImageView quitButtonImageView = new ImageView(quitButtonImage);
        Button quitButton = new Button();
        quitButton.setGraphic(quitButtonImageView);
        buttonBox.getChildren().add(playButton);
        buttonBox.getChildren().add(loadButton);
        buttonBox.getChildren().add(aboutButton);
        buttonBox.getChildren().add(quitButton);
        buttonBox.setVisible(true);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        // the pane
        splashScreenPane.getChildren().add(splashScreenImageLabel);
        splashScreenPane.getChildren().add(buttonBox);
        quitButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                eventHandler.quitButtonRequest();
            }
        });
        playButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try{
                eventHandler.startButtonRequest();} catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mainPane.setCenter(splashScreenPane);
    }

    public void initSelectPlayersScreen(){
        Label player1Label = new Label("Player 1");
        player1Label.setFont(font);
        TextField player1Field = new TextField("Name");
        Image player1Flag = loadImage("flag_black.png");
        ImageView player1ImageView = new ImageView(player1Flag);
        Button goButton = new Button("GO!");
        HBox player1Box = new HBox();
        VBox player1Buttons = new VBox();
        ToggleGroup player1Group = new ToggleGroup();
        RadioButton player1None = new RadioButton("None");
        player1None.setSelected(true);
        player1None.setToggleGroup(player1Group);
        RadioButton player1Human = new RadioButton("Human");
        player1Human.setToggleGroup(player1Group);
        RadioButton player1Computer = new RadioButton("Computer");
        player1Computer.setToggleGroup(player1Group);
        player1Buttons.getChildren().add(player1Label);
        player1Buttons.getChildren().add(player1Field);
        player1Buttons.getChildren().add(player1None);
        player1Buttons.getChildren().add(player1Human);
        player1Buttons.getChildren().add(player1Computer);
        player1Buttons.getChildren().add(goButton);
        //player1Box.getChildren().addAll(goButton);
        player1Box.getChildren().add(player1Buttons);
        player1Box.getChildren().add(player1ImageView);

        TextField player2Field = new TextField("Name");
        Label player2Label = new Label("Player 2");
        player2Label.setFont(font);
        Image player2Flag = loadImage("flag_white.png");
        ImageView player2ImageView = new ImageView(player2Flag);
        HBox player2Box = new HBox();
        VBox player2Buttons = new VBox();
        ToggleGroup player2Group = new ToggleGroup();
        RadioButton player2None = new RadioButton("None");
        player2None.setSelected(true);
        player2None.setToggleGroup(player2Group);
        RadioButton player2Human = new RadioButton("Human");
        player2Human.setToggleGroup(player2Group);
        RadioButton player2Computer = new RadioButton("Computer");
        player2Computer.setToggleGroup(player2Group);
        player2Buttons.getChildren().add(player2Label);
        player2Buttons.getChildren().add(player2Field);
        player2Buttons.getChildren().add(player2None);
        player2Buttons.getChildren().add(player2Human);
        player2Buttons.getChildren().add(player2Computer);
        player2Box.getChildren().add(player2Buttons);
        player2Box.getChildren().add(player2ImageView);

        Label player3Label = new Label("Player 3");
        TextField player3Field = new TextField("Name");
        player3Label.setFont(font);
        Image player3Flag = loadImage("flag_red.png");
        ImageView player3ImageView = new ImageView(player3Flag);
        HBox player3Box = new HBox();
        VBox player3Buttons = new VBox();
        ToggleGroup player3Group = new ToggleGroup();
        RadioButton player3None = new RadioButton("None");
        player3None.setSelected(true);
        player3None.setToggleGroup(player3Group);
        RadioButton player3Human = new RadioButton("Human");
        player3Human.setToggleGroup(player3Group);
        RadioButton player3Computer = new RadioButton("Computer");
        player3Computer.setToggleGroup(player3Group);
        player3Buttons.getChildren().add(player3Label);
        player3Buttons.getChildren().add(player3Field);
        player3Buttons.getChildren().add(player3None);
        player3Buttons.getChildren().add(player3Human);
        player3Buttons.getChildren().add(player3Computer);
        player3Box.getChildren().add(player3Buttons);
        player3Box.getChildren().add(player3ImageView);

        Label player4Label = new Label("Player 4");
        TextField player4Field = new TextField("Name");
        player4Label.setFont(font);
        Image player4Flag = loadImage("flag_yellow.png");
        ImageView player4ImageView = new ImageView(player4Flag);
        HBox player4Box = new HBox();
        VBox player4Buttons = new VBox();
        ToggleGroup player4Group = new ToggleGroup();
        RadioButton player4None = new RadioButton("None");
        player4None.setSelected(true);
        player4None.setToggleGroup(player4Group);
        RadioButton player4Human = new RadioButton("Human");
        player4Human.setToggleGroup(player4Group);
        RadioButton player4Computer = new RadioButton("Computer");
        player4Computer.setToggleGroup(player4Group);
        player4Buttons.getChildren().add(player4Label);
        player4Buttons.getChildren().add(player4Field);
        player4Buttons.getChildren().add(player4None);
        player4Buttons.getChildren().add(player4Human);
        player4Buttons.getChildren().add(player4Computer);
        player4Box.getChildren().add(player4Buttons);
        player4Box.getChildren().add(player4ImageView);

        Label player5Label = new Label("Player 5");
        TextField player5Field = new TextField("Name");
        player5Label.setFont(font);
        Image player5Flag = loadImage("flag_green.png");
        ImageView player5ImageView = new ImageView(player5Flag);
        HBox player5Box = new HBox();
        VBox player5Buttons = new VBox();
        ToggleGroup player5Group = new ToggleGroup();
        RadioButton player5None = new RadioButton("None");
        player5None.setSelected(true);
        player5None.setToggleGroup(player5Group);
        RadioButton player5Human = new RadioButton("Human");
        player5Human.setToggleGroup(player5Group);
        RadioButton player5Computer = new RadioButton("Computer");
        player5Computer.setToggleGroup(player5Group);
        player5Buttons.getChildren().add(player5Label);
        player5Buttons.getChildren().add(player5Field);
        player5Buttons.getChildren().add(player5None);
        player5Buttons.getChildren().add(player5Human);
        player5Buttons.getChildren().add(player5Computer);
        player5Box.getChildren().add(player5Buttons);
        player5Box.getChildren().add(player5ImageView);


        Label player6Label = new Label("Player 6");
        player6Label.setFont(font);
        TextField player6Field = new TextField("Name");
        Image player6Flag = loadImage("flag_blue.png");
        ImageView player6ImageView = new ImageView(player6Flag);
        HBox player6Box = new HBox();
        VBox player6Buttons = new VBox();
        ToggleGroup player6Group = new ToggleGroup();
        RadioButton player6None = new RadioButton("None");
        player6None.setSelected(true);
        player6None.setToggleGroup(player6Group);
        RadioButton player6Human = new RadioButton("Human");
        player6Human.setToggleGroup(player6Group);
        RadioButton player6Computer = new RadioButton("Computer");
        player6Computer.setToggleGroup(player6Group);
        player6Buttons.getChildren().add(player6Label);
        player6Buttons.getChildren().add(player6Field);
        player6Buttons.getChildren().add(player6None);
        player6Buttons.getChildren().add(player6Human);
        player6Buttons.getChildren().add(player6Computer);
        player6Box.getChildren().add(player6Buttons);
        player6Box.getChildren().add(player6ImageView);

        selectPlayersParentPane = new BorderPane();
        selectPlayersPane = new GridPane();
        selectPlayersPane.setPrefSize(1000,1000);
        selectPlayersPane.setAlignment(Pos.CENTER);
        selectPlayersPane.setGridLinesVisible(true);
        selectPlayersPane.setVisible(true);
        //Add the VBox's
        selectPlayersPane.add(player1Box, 0, 0);
        selectPlayersPane.add(player2Box, 0, 1);
        selectPlayersPane.add(player3Box, 1, 0);
        selectPlayersPane.add(player4Box, 1, 1);
        selectPlayersPane.add(player5Box, 2, 0);
        selectPlayersPane.add(player6Box, 2, 1);
        selectPlayersParentPane.getChildren().add(selectPlayersPane);

        goButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    eventHandler.goButtonRequest();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void initGameScreen() throws FileNotFoundException, IOException{
        gamePane = new GridPane();
        gamePane.setPrefSize(1000,1000);

        gamePane.setVisible(true);

        aboutPane = new AnchorPane();
        historyPane = new AnchorPane();
        leftBox = new VBox();
        Label player1Label = new Label("Player 1");
        player1Label.setFont(new Font("Calibri", 52));
        leftBox.getChildren().add(player1Label);
        gridPane = new AnchorPane();
        Image grid1Image = loadImage("grid1.jpg");
        final ImageView grid1ImageView = new ImageView(grid1Image);
        grid1ImageView.setFitHeight(800);
        grid1ImageView.setFitWidth(600);
        //middleBox.getChildren().add(grid1ImageView);
        gridPane.getChildren().addAll(grid1ImageView);
        gamePane.add(historyPane, 1, 0);
        history = new Label("No history ");
        history.setFont(new Font("Calibri", 100));
        historyPane.getChildren().add(history);
        historyPane.setVisible(false);
        gamePane.add(aboutPane, 1, 0);
        about = new Label("Journey through Europe is a family board game published by Ravensburger. " +
                "\nThe board is a map of Europe with various major cities marked, for example, Athens, Amsterdam and London. " +
                "\nThe players are given a home city from which they will begin " +
                "\nand are then dealt a number of cards with various other cities on them. " +
                "\nThey must plan a route between each of the cities in their hand of cards. " +
                "\nOn each turn they throw a die and move between the cities. " +
                "\nThe winner is the first player to visit each of their cities and then return to their home base.");
        aboutPane.getChildren().add(about);
        aboutPane.setVisible(false);

        VBox rightBox = new VBox();
        Button flightPlanButton = new Button ();
        flightPlanButton.setGraphic(new ImageView(loadImage("flightplanbutton.png")));
        final Button historyButton = new Button ();
        historyButton.setGraphic(new ImageView(loadImage("history.png")));
        historyButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {

                aboutPane.setVisible(false);
                gridPane.setVisible(false);
                historyPane.setVisible(true);

            }
        });
        Button aboutButton = new Button ();
        aboutButton.setGraphic(new ImageView(loadImage("aboutgame.png")));
        aboutButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                gridPane.setVisible(false);
                historyPane.setVisible(false);
                aboutPane.setVisible(true);
            }
        });
        Button saveButton = new Button();
        saveButton.setGraphic(new ImageView(loadImage("save.png")));
        Button grid1Button = new Button();
        grid1Button.setGraphic(new ImageView(loadImage("orange.png")));
        grid1Button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                historyPane.setVisible(false);
                aboutPane.setVisible(false);
                gridPane.setVisible(true);

            }
        });
        Button grid2Button = new Button();
        grid2Button.setGraphic(new ImageView(loadImage("yellow.png")));
        Button grid3Button = new Button();
        grid3Button.setGraphic(new ImageView(loadImage("green.png")));
        Button grid4Button = new Button();
        grid4Button.setGraphic(new ImageView(loadImage("purple.png")));
        Button diceButton = new Button();
        diceButton.setGraphic(new ImageView(loadImage("die_6.jpg")));
        Label turnLabel = new Label("Player 1 Turn");
        VBox gridVbox = new VBox();
        HBox gridHbox1 = new HBox();
        Label firstLeftLabel = new Label("1-4");
        gridHbox1.getChildren().add(firstLeftLabel);
        gridHbox1.getChildren().add(grid1Button);
        gridHbox1.getChildren().add(grid2Button);
        gridHbox1.setAlignment(Pos.CENTER);
        HBox gridHbox2 = new HBox();
        Label secondLeftLabel = new Label("5-8");
        gridHbox2.getChildren().add(secondLeftLabel);
        gridHbox2.getChildren().add(grid3Button);
        gridHbox2.getChildren().add(grid4Button);
        gridHbox2.setAlignment(Pos.CENTER);
        HBox gridHbox3 = new HBox();
        Label firstTopLabel = new Label("A-C");
        Label secondTopLabel = new Label("D-F");
        gridHbox3.getChildren().addAll(firstTopLabel, secondTopLabel);
        gridHbox3.setAlignment(Pos.CENTER);
        gridVbox.getChildren().addAll(gridHbox3, gridHbox1, gridHbox2);
        gridVbox.setAlignment(Pos.CENTER);

        turnLabel.setFont(font);
        turnLabel.setAlignment(Pos.TOP_CENTER);
        rightBox.getChildren().addAll(turnLabel, diceButton, gridVbox, flightPlanButton, historyButton,
                aboutButton, saveButton);
        turnLabel.setLayoutX(500);
        rightBox.setAlignment(Pos.TOP_CENTER);

        gamePane.add(leftBox, 0, 0);
        gamePane.add(gridPane, 1, 0);
        gamePane.add(rightBox, 2, 0);
        initCoordinateLoader();





    }
    public void initCoordinateLoader() throws FileNotFoundException, IOException{
        File f = null;


        try{
            cities = new ArrayList<City>();
            f = new File("untitled.txt");
            Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            Scanner sc = new Scanner(s.nextLine());
            sc.useDelimiter("\t");
            final City newCity = new City();
            newCity.setName(sc.next());
            newCity.setColor(sc.next());
            newCity.setQuarter(Integer.parseInt(sc.next()));

            int x = (int)(((sc.nextInt() + 0.0)/2010.0)*600.0);
            x-=10;

            int y = (int)(((sc.nextInt() + 0.0)/2569.0)*800.0);
            y-=10;
            newCity.setxCoordinate(x);
            newCity.setyCoordinate(y);
            cities.add(newCity);


        }
        }catch (Exception e){
            System.out.println(f.getAbsoluteFile());
            e.printStackTrace();
        }
        gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i = 0; i < cities.size(); i++) {
                    if((event.getX() + 20 >= cities.get(i).getxCoordinate() && event.getX() - 20 <= cities.get(i).getxCoordinate()
                            && event.getY() + 20 >= cities.get(i).getyCoordinate() && event.getY() - 20 <= cities.get(i).getyCoordinate()) && cities.get(i).getQuarter() ==1 ){
                        System.out.println(cities.get(i).getName());
                        Label cityName = new Label(cities.get(i).getName());
                        leftBox.getChildren().add(cityName);

                    }
                }
            }
        });
    }

    public void switchScreenRequest(String screenName) throws IOException, FileNotFoundException{
        int caseNum = 0;
        if (screenName.equals("selectPlayers"))
            caseNum = 1;
        else if(screenName.equals("gameScreen"))
            caseNum=2;

        switch(caseNum){
            case 1:
                initSelectPlayersScreen();
                mainPane.setCenter(selectPlayersPane);
                break;
            case 2:
                initGameScreen();
                mainPane.setCenter(gamePane);
        }
    }
    public Image loadImage(String imageName) {
        Image img = new Image(ImgPath + imageName);
        return img;
    }

    public void initMainPane() {
        mainPane = new BorderPane();
        mainPane.resize(1000,1000);

    }


    public BorderPane GetMainPane() {
        return this.mainPane;
    }

    public void SetStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void displayHistory(){
        Label history = new Label("No history ");
        history.setFont(new Font("Calibri", 100));
        gamePane.add(history, 1, 0);
    }
}
