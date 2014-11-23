package JourneyUI;

/**
 * Created by Mohammad Butt on 11/10/14.
 */
import JourneyGameComponents.City;
import JourneyGameComponents.Player;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
    private AnchorPane gridPane1;
    private AnchorPane gridPane2;
    private AnchorPane gridPane3;
    private AnchorPane gridPane4;
    private VBox leftPlayer1Box = new VBox();
    private VBox leftPlayer2Box = new VBox();
    private VBox leftPlayer3Box;
    private VBox leftPlayer4Box;
    private VBox leftPlayer5Box;
    private VBox leftPlayer6Box;
    private final int MAX = 6;
    private int faceValue;
    private int activePlayers = 2;
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3;
    Player player4;
    Player player5;
    Player player6;
    private Random randomCityGenerator = new Random();
    private ArrayList<Player> activePlayersList = new ArrayList<Player>();
    private ArrayList<City> redCities = new ArrayList<City>();
    private ArrayList<City> yellowCities = new ArrayList<City>();
    private ArrayList<City> greenCities = new ArrayList<City>();
    private String[] cityDealOrder = new String[]{"Red, Green, Yellow", "Green, Yellow, Red", "Yellow, Red, Green"};
    ImageView player1ImageView;
    ImageView player2ImageView;
    ImageView player3ImageView;
    ImageView player4ImageView;
    ImageView player5ImageView;
    ImageView player6ImageView;
    ImageView player1PieceImageView;
    ImageView player2PieceImageView;
    ImageView player3PieceImageView;
    ImageView player4PieceImageView;
    ImageView player5PieceImageView;
    ImageView player6PieceImageView;


    private void setBoxSizes(){
        leftPlayer1Box.setPrefSize(200,800);

    }
    private Label currentPlayerLabel = new Label("Player 1");



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
        final TextField player1Field = new TextField("Name");
        Image player1Flag = loadImage("flag_black.png");
        player1ImageView = new ImageView(player1Flag);
        Button goButton = new Button("GO!");
        HBox player1Box = new HBox();
        VBox player1Buttons = new VBox();
        ToggleGroup player1Group = new ToggleGroup();

        RadioButton player1Human = new RadioButton("Human");
        player1Human.setSelected(true);
        player1Human.setToggleGroup(player1Group);
        final RadioButton player1Computer = new RadioButton("Computer");
        player1Computer.setToggleGroup(player1Group);
        player1Buttons.getChildren().add(player1Label);
        player1Buttons.getChildren().add(player1Field);
        player1Buttons.getChildren().add(player1Human);
        player1Buttons.getChildren().add(player1Computer);
        player1Buttons.getChildren().add(goButton);
        //player1Box.getChildren().addAll(goButton);
        player1Box.getChildren().add(player1Buttons);
        player1Box.getChildren().add(player1ImageView);

        final TextField player2Field = new TextField("Name");
        Label player2Label = new Label("Player 2");
        player2Label.setFont(font);
        Image player2Flag = loadImage("flag_white.png");
        player2ImageView = new ImageView(player2Flag);
        HBox player2Box = new HBox();
        VBox player2Buttons = new VBox();
        ToggleGroup player2Group = new ToggleGroup();
        RadioButton player2Human = new RadioButton("Human");
        player2Human.setToggleGroup(player2Group);
        final RadioButton player2Computer = new RadioButton("Computer");
        player2Computer.setToggleGroup(player2Group);
        player2Computer.setSelected(true);
        player2Buttons.getChildren().add(player2Label);
        player2Buttons.getChildren().add(player2Field);
        player2Buttons.getChildren().add(player2Human);
        player2Buttons.getChildren().add(player2Computer);
        player2Box.getChildren().add(player2Buttons);
        player2Box.getChildren().add(player2ImageView);

        Label player3Label = new Label("Player 3");
        final TextField player3Field = new TextField("Name");
        player3Label.setFont(font);
        Image player3Flag = loadImage("flag_red.png");
        player3ImageView = new ImageView(player3Flag);
        HBox player3Box = new HBox();
        VBox player3Buttons = new VBox();
        ToggleGroup player3Group = new ToggleGroup();
        final RadioButton player3None = new RadioButton("None");
        player3None.setSelected(true);
        player3None.setToggleGroup(player3Group);
        RadioButton player3Human = new RadioButton("Human");
        player3Human.setToggleGroup(player3Group);
        final RadioButton player3Computer = new RadioButton("Computer");
        player3Computer.setToggleGroup(player3Group);
        player3Buttons.getChildren().add(player3Label);
        player3Buttons.getChildren().add(player3Field);
        player3Buttons.getChildren().add(player3None);
        player3Buttons.getChildren().add(player3Human);
        player3Buttons.getChildren().add(player3Computer);
        player3Box.getChildren().add(player3Buttons);
        player3Box.getChildren().add(player3ImageView);

        Label player4Label = new Label("Player 4");
        final TextField player4Field = new TextField("Name");
        player4Label.setFont(font);
        Image player4Flag = loadImage("flag_yellow.png");
        player4ImageView = new ImageView(player4Flag);
        HBox player4Box = new HBox();
        VBox player4Buttons = new VBox();
        ToggleGroup player4Group = new ToggleGroup();
        final RadioButton player4None = new RadioButton("None");
        player4None.setSelected(true);
        player4None.setToggleGroup(player4Group);
        RadioButton player4Human = new RadioButton("Human");
        player4Human.setToggleGroup(player4Group);
        final RadioButton player4Computer = new RadioButton("Computer");
        player4Computer.setToggleGroup(player4Group);
        player4Buttons.getChildren().add(player4Label);
        player4Buttons.getChildren().add(player4Field);
        player4Buttons.getChildren().add(player4None);
        player4Buttons.getChildren().add(player4Human);
        player4Buttons.getChildren().add(player4Computer);
        player4Box.getChildren().add(player4Buttons);
        player4Box.getChildren().add(player4ImageView);

        Label player5Label = new Label("Player 5");
        final TextField player5Field = new TextField("Name");
        player5Label.setFont(font);
        Image player5Flag = loadImage("flag_green.png");
        player5ImageView = new ImageView(player5Flag);
        HBox player5Box = new HBox();
        VBox player5Buttons = new VBox();
        ToggleGroup player5Group = new ToggleGroup();
        final RadioButton player5None = new RadioButton("None");
        player5None.setSelected(true);
        player5None.setToggleGroup(player5Group);
        RadioButton player5Human = new RadioButton("Human");
        player5Human.setToggleGroup(player5Group);
        final RadioButton player5Computer = new RadioButton("Computer");
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
        final TextField player6Field = new TextField("Name");
        Image player6Flag = loadImage("flag_blue.png");
        player6ImageView = new ImageView(player6Flag);
        HBox player6Box = new HBox();
        VBox player6Buttons = new VBox();
        ToggleGroup player6Group = new ToggleGroup();
        final RadioButton player6None = new RadioButton("None");
        player6None.setSelected(true);
        player6None.setToggleGroup(player6Group);
        RadioButton player6Human = new RadioButton("Human");
        player6Human.setToggleGroup(player6Group);
        final RadioButton player6Computer = new RadioButton("Computer");
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
                    player1.setName(player1Field.getText());
                    System.out.println("Player 1's name is " + player1.getName());
                    currentPlayerLabel.setText(player1.getName());
                    if (player1Computer.isSelected()) {
                        player1.setComputer(true);
                    } else
                        player1.setHuman(true);
                    activePlayersList.add(player1);
                    player2.setName(player2Field.getText());
                    System.out.println("Player 2's name is " + player2.getName());
                    if (player2Computer.isSelected()) {
                        player2.setComputer(true);
                    } else
                        player2.setHuman(true);
                    activePlayersList.add(player2);
                    if (!player3None.isSelected()) {
                        activePlayers++;
                        leftPlayer3Box = new VBox();
                        player3 = new Player(player3Field.getText());
                        System.out.println("Player 3's name is " + player3.getName());
                        if (player3Computer.isSelected()) {
                            player3.setComputer(true);
                        } else
                            player3.setHuman(true);
                        activePlayersList.add(player3);
                    }
                    if (!player4None.isSelected()) {
                        activePlayers++;
                        leftPlayer4Box = new VBox();
                        player4 = new Player(player4Field.getText());
                        System.out.println("Player 4's name is " + player4.getName());

                        if (player4Computer.isSelected()) {
                            player4.setComputer(true);
                        } else
                            player4.setHuman(true);
                        activePlayersList.add(player4);
                    }
                    if (!player5None.isSelected()) {
                        activePlayers++;
                        leftPlayer5Box = new VBox();
                        player5 = new Player(player5Field.getText());
                        System.out.println("Player 5's name is " + player5.getName());

                        if (player5Computer.isSelected()) {
                            player5.setComputer(true);
                        } else
                            player5.setHuman(true);
                        activePlayersList.add(player5);
                    }
                    if (!player6None.isSelected()) {
                        activePlayers++;
                        leftPlayer6Box = new VBox();
                        player6 = new Player(player6Field.getText());
                        System.out.println("Player 6's name is " + player6.getName());
                        if (player6Computer.isSelected()) {
                            player6.setComputer(true);
                        } else
                            player6.setHuman(true);
                        activePlayersList.add(player6);
                    }
                    gameSetup();

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
        leftPlayer1Box = new VBox();
        currentPlayerLabel.setFont(new Font("Calibri", 32));
        leftPlayer1Box.getChildren().add(currentPlayerLabel);
        setBoxSizes();
        gridPane1 = new AnchorPane();
        gridPane1.setPrefSize(600,800);
        Image grid1Image = loadImage("grid1.jpg");
        final ImageView grid1ImageView = new ImageView(grid1Image);
        grid1ImageView.setFitHeight(800);
        grid1ImageView.setFitWidth(600);
        gridPane1.getChildren().addAll(grid1ImageView);
        gridPane2 = new AnchorPane();
        gridPane2.setPrefSize(600,800);
        Image grid2Image = loadImage("grid2.jpg");
        final ImageView grid2ImageView = new ImageView(grid2Image);
        grid2ImageView.setFitHeight(800);
        grid2ImageView.setFitWidth(600);
        gridPane2.getChildren().addAll(grid2ImageView);
        gridPane3 = new AnchorPane();
        gridPane3.setPrefSize(600,800);
        Image grid3Image = loadImage("grid3.jpg");
        final ImageView grid3ImageView = new ImageView(grid3Image);
        grid3ImageView.setFitHeight(800);
        grid3ImageView.setFitWidth(600);
        gridPane3.getChildren().addAll(grid3ImageView);
        gridPane4 = new AnchorPane();
        gridPane4.setPrefSize(600,800);
        Image grid4Image = loadImage("grid4.jpg");
        final ImageView grid4ImageView = new ImageView(grid4Image);
        grid4ImageView.setFitHeight(800);
        grid4ImageView.setFitWidth(600);
        gridPane4.getChildren().addAll(grid4ImageView);

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
                gridPane1.setVisible(false);
                historyPane.setVisible(true);
                gridPane2.setVisible(false);
                gridPane3.setVisible(false);
                gridPane4.setVisible(false);

            }
        });
        Button aboutButton = new Button ();
        aboutButton.setGraphic(new ImageView(loadImage("aboutgame.png")));
        aboutButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                gridPane1.setVisible(false);
                historyPane.setVisible(false);
                aboutPane.setVisible(true);
                gridPane2.setVisible(false);
                gridPane3.setVisible(false);
                gridPane4.setVisible(false);
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
                gridPane1.setVisible(true);
                gridPane2.setVisible(false);
                gridPane3.setVisible(false);
                gridPane4.setVisible(false);

            }
        });
        Button grid2Button = new Button();
        grid2Button.setGraphic(new ImageView(loadImage("yellow.png")));
        grid2Button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                historyPane.setVisible(false);
                aboutPane.setVisible(false);
                gridPane1.setVisible(false);
                gridPane2.setVisible(true);
                gridPane4.setVisible(false);
                gridPane3.setVisible(false);



            }
        });

        Button grid3Button = new Button();
        grid3Button.setGraphic(new ImageView(loadImage("green.png")));
        grid3Button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                historyPane.setVisible(false);
                aboutPane.setVisible(false);
                gridPane1.setVisible(false);
                gridPane3.setVisible(true);
                gridPane2.setVisible(false);
                gridPane4.setVisible(false);
            }
        });

        Button grid4Button = new Button();
        grid4Button.setGraphic(new ImageView(loadImage("purple.png")));
        grid4Button.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {

                historyPane.setVisible(false);
                aboutPane.setVisible(false);
                gridPane1.setVisible(false);
                gridPane2.setVisible(false);
                gridPane3.setVisible(false);
                gridPane4.setVisible(true);
            }
        });

        final Button diceButton = new Button();
        diceButton.setGraphic(new ImageView(loadImage("die_6.jpg")));
        diceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                faceValue = (int)(Math.random() * MAX) + 1;


                if(faceValue == 1)
                    diceButton.setGraphic(new ImageView(loadImage("die_1.jpg")));
                else if(faceValue == 2)
                    diceButton.setGraphic(new ImageView(loadImage("die_2.jpg")));
                else if(faceValue == 3)
                    diceButton.setGraphic(new ImageView(loadImage("die_3.jpg")));
                else if(faceValue == 4)
                    diceButton.setGraphic(new ImageView(loadImage("die_4.jpg")));
                else if(faceValue == 5)
                    diceButton.setGraphic(new ImageView(loadImage("die_5.jpg")));
                else
                    diceButton.setGraphic(new ImageView(loadImage("die_6.jpg")));




            }
        });
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
        rightBox.setPrefSize(200, 800);
        gamePane.add(leftPlayer1Box, 0, 0);
        gamePane.add(gridPane1, 1, 0);
        gamePane.add(gridPane2, 1, 0);
        gridPane2.setVisible(false);
        gamePane.add(gridPane3, 1, 0);
        gridPane3.setVisible(false);
        gamePane.add(gridPane4, 1, 0);
        gridPane4.setVisible(false);
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
                int x = 0;
                int y = 0;
                if(newCity.getQuarter() == 1){
                    x = (int)(((sc.nextInt() + 0.0)/2010.0)*600.0);
                    y = (int)(((sc.nextInt() + 0.0)/2569.0)*800.0);
                }
                else if(newCity.getQuarter() == 2){
                    x = (int)(((sc.nextInt() + 0.0)/1903.0)*600.0);
                    y = (int)(((sc.nextInt() + 0.0)/2585.0)*800.0);

                }
                else if(newCity.getQuarter() == 3){
                    x = (int)(((sc.nextInt() + 0.0)/1985.0)*600.0);
                    y = (int)(((sc.nextInt() + 0.0)/2583.0)*800.0);

                }
                else if(newCity.getQuarter() == 4){
                    x = (int)(((sc.nextInt() + 0.0)/1927.0)*600.0);
                    y = (int)(((sc.nextInt() + 0.0)/2561.0)*800.0);

                }
                newCity.setxCoordinate(x);
                newCity.setyCoordinate(y);
                if(newCity.getColor().equalsIgnoreCase("red"))
                    redCities.add(newCity);
                else if (newCity.getColor().equalsIgnoreCase("yellow"))
                    yellowCities.add(newCity);
                else
                    greenCities.add(newCity);
                cities.add(newCity);


            }
        }catch (Exception e){
            System.out.println(f.getAbsoluteFile());
            e.printStackTrace();
        }
        gridPane1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                for (int i = 0; i < cities.size(); i++) {
                    if((event.getX() + 20 >= cities.get(i).getxCoordinate() &&  event.getX() - 20 <= cities.get(i).getxCoordinate() &&
                            event.getY() + 20 >= cities.get(i).getyCoordinate() && event.getY() - 20 <= cities.get(i).getyCoordinate()) && cities.get(i).getQuarter() == 1){
                        System.out.println(cities.get(i).getName());
                        System.out.println(cities.get(i).getQuarter());
                        System.out.println(cities.get(i).getxCoordinate());
                        System.out.println(cities.get(i).getyCoordinate());

                        Label cityName = new Label(cities.get(i).getName());
                        leftPlayer1Box.getChildren().add(cityName);
                        break;

                    }
                }
            }
        });
        gridPane2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                for (int i = 0; i < cities.size(); i++) {
                    if((event.getX() + 20 >= cities.get(i).getxCoordinate() &&  event.getX() - 20 <= cities.get(i).getxCoordinate() &&
                            event.getY() + 20 >= cities.get(i).getyCoordinate() && event.getY() - 20 <= cities.get(i).getyCoordinate()) && cities.get(i).getQuarter() == 2){
                        System.out.println(cities.get(i).getName());
                        System.out.println(cities.get(i).getQuarter());
                        System.out.println(cities.get(i).getxCoordinate());
                        System.out.println(cities.get(i).getyCoordinate());

                        Label cityName = new Label(cities.get(i).getName());
                        leftPlayer1Box.getChildren().add(cityName);
                    }
                }
            }
        });
        gridPane3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                for (int i = 0; i < cities.size(); i++) {
                    if((event.getX() + 20 >= cities.get(i).getxCoordinate() &&  event.getX() - 20 <= cities.get(i).getxCoordinate() &&
                            event.getY() + 20 >= cities.get(i).getyCoordinate() && event.getY() - 20 <= cities.get(i).getyCoordinate()) && cities.get(i).getQuarter() == 3){
                        System.out.println(cities.get(i).getName());
                        System.out.println(cities.get(i).getQuarter());
                        System.out.println(cities.get(i).getxCoordinate());
                        System.out.println(cities.get(i).getyCoordinate());

                        Label cityName = new Label(cities.get(i).getName());
                        leftPlayer1Box.getChildren().add(cityName);
                    }
                }
            }
        });
        gridPane4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(event.getX());
                System.out.println(event.getY());
                for (int i = 0; i < cities.size(); i++) {
                    if((event.getX() + 20 >= cities.get(i).getxCoordinate() &&  event.getX() - 20 <= cities.get(i).getxCoordinate() &&
                            event.getY() + 20 >= cities.get(i).getyCoordinate() && event.getY() - 20 <= cities.get(i).getyCoordinate() && cities.get(i).getQuarter() == 4)){
                        System.out.println(cities.get(i).getName());
                        System.out.println(cities.get(i).getQuarter());
                        System.out.println(cities.get(i).getxCoordinate());
                        System.out.println(cities.get(i).getyCoordinate());

                        Label cityName = new Label(cities.get(i).getName());
                        leftPlayer1Box.getChildren().add(cityName);
                    }
                }
            }
        });

    }
    public void gameSetup(){
        int redIndex = randomCityGenerator.nextInt(redCities.size());
        int greenIndex = randomCityGenerator.nextInt(greenCities.size());
        int yellowIndex = randomCityGenerator.nextInt(yellowCities.size());
        player1.setHomeCity(redCities.get(redIndex));
        player1ImageView.setFitHeight(75);
        player1ImageView.setFitWidth(75);
        player1PieceImageView = new ImageView(loadImage("piece_black.png"));
        player1PieceImageView.setFitWidth(50);
        player1PieceImageView.setFitHeight(50);

        if(player1.getHomeCity().getQuarter() == 1){
            player1ImageView.relocate(player1.getHomeCity().getxCoordinate(), player1.getHomeCity().getyCoordinate()-50);
            player1PieceImageView.relocate(player1.getHomeCity().getxCoordinate() - 20, player1.getHomeCity().getyCoordinate()-42);
            gridPane1.getChildren().add(player1ImageView);
            gridPane1.getChildren().add(player1PieceImageView);

        }
        else if(player1.getHomeCity().getQuarter()== 2){
            player1ImageView.relocate(player1.getHomeCity().getxCoordinate(), player1.getHomeCity().getyCoordinate()-50);
            player1PieceImageView.relocate(player1.getHomeCity().getxCoordinate() - 20, player1.getHomeCity().getyCoordinate()-42);

            gridPane2.getChildren().add(player1ImageView);
            gridPane2.getChildren().add(player1PieceImageView);
        }
        else if(player1.getHomeCity().getQuarter() == 3){

            player1ImageView.relocate(player1.getHomeCity().getxCoordinate(), player1.getHomeCity().getyCoordinate()-50);
            player1PieceImageView.relocate(player1.getHomeCity().getxCoordinate() - 20, player1.getHomeCity().getyCoordinate()-42);

            gridPane3.getChildren().add(player1ImageView);
            gridPane3.getChildren().add(player1PieceImageView);

        }
        else{

            player1ImageView.relocate(player1.getHomeCity().getxCoordinate(), player1.getHomeCity().getyCoordinate()-50);
            player1PieceImageView.relocate(player1.getHomeCity().getxCoordinate() - 20, player1.getHomeCity().getyCoordinate()-42);

            if(player1ImageView.getY()<0){
                player1ImageView.relocate(player1.getHomeCity().getxCoordinate(), 0);
            }
            else if(player1ImageView.getX()>350){
                player1ImageView.relocate(350, player1.getHomeCity().getyCoordinate()-50);
            }

            gridPane4.getChildren().add(player1ImageView);
            gridPane4.getChildren().add(player1PieceImageView);

        }
        player1.getDestinations().add(redCities.get(redIndex));
        player1.getDestinations().add(greenCities.get(greenIndex));
        player1.getDestinations().add(yellowCities.get(yellowIndex));

        player2.setHomeCity(greenCities.get(randomCityGenerator.nextInt(greenCities.size())));
        player2.getDestinations().add(player2.getHomeCity());
        player2.getDestinations().add(yellowCities.get(randomCityGenerator.nextInt(yellowCities.size())));
        player2.getDestinations().add(redCities.get(randomCityGenerator.nextInt(redCities.size())));
        player2ImageView.setFitHeight(75);
        player2ImageView.setFitWidth(75);

        player2PieceImageView = new ImageView(loadImage("piece_white.png"));
        player2PieceImageView.setFitHeight(50);
        player2PieceImageView.setFitWidth(50);
        if(player2.getHomeCity().getQuarter() == 1){

            player2ImageView.relocate(player2.getHomeCity().getxCoordinate(), player2.getHomeCity().getyCoordinate()-50);

            gridPane1.getChildren().add(player2ImageView);
            player2PieceImageView.relocate(player2.getHomeCity().getxCoordinate() - 20, player2.getHomeCity().getyCoordinate()-42);
            gridPane1.getChildren().add(player2PieceImageView);


        }
        else if(player2.getHomeCity().getQuarter()== 2){


            player2ImageView.relocate(player2.getHomeCity().getxCoordinate(), player2.getHomeCity().getyCoordinate()-50);
            gridPane2.getChildren().add(player2ImageView);
            player2PieceImageView.relocate(player2.getHomeCity().getxCoordinate() - 20, player2.getHomeCity().getyCoordinate()-42);
            gridPane2.getChildren().add(player2PieceImageView);

        }
        else if(player2.getHomeCity().getQuarter() == 3){

            player2ImageView.relocate(player2.getHomeCity().getxCoordinate(), player2.getHomeCity().getyCoordinate()-50);

            gridPane3.getChildren().add(player2ImageView);
            player2PieceImageView.relocate(player2.getHomeCity().getxCoordinate() - 20, player2.getHomeCity().getyCoordinate()-42);
            gridPane3.getChildren().add(player2PieceImageView);

        }
        else{

            player2ImageView.relocate(player2.getHomeCity().getxCoordinate(), player2.getHomeCity().getyCoordinate()-50);
            if(player2ImageView.getY()<0){
                player2ImageView.relocate(player2.getHomeCity().getxCoordinate(), 0);
            }
            else if(player2ImageView.getX()>350){
                player2ImageView.relocate(350, player2.getHomeCity().getyCoordinate()-50);
            }

            gridPane4.getChildren().add(player2ImageView);
            player2PieceImageView.relocate(player2.getHomeCity().getxCoordinate() - 20, player2.getHomeCity().getyCoordinate()-42);
            gridPane4.getChildren().add(player2PieceImageView);

        }
        if(player3 != null){
            player3.setHomeCity(yellowCities.get(randomCityGenerator.nextInt(yellowCities.size())));
            player3.getDestinations().add(player3.getHomeCity());
            player3.getDestinations().add(redCities.get(randomCityGenerator.nextInt(redCities.size())));
            player3.getDestinations().add(greenCities.get(randomCityGenerator.nextInt(greenCities.size())));
            player3ImageView.setFitHeight(75);
            player3ImageView.setFitWidth(75);
            player3PieceImageView = new ImageView(loadImage("piece_red.png"));
            player3PieceImageView.setFitHeight(50);
            player3PieceImageView.setFitWidth(50);
            player3PieceImageView.relocate(player3.getHomeCity().getxCoordinate() - 20, player3.getHomeCity().getyCoordinate()-42);
            player3ImageView.relocate(player3.getHomeCity().getxCoordinate(), player3.getHomeCity().getyCoordinate()-50);
            if(player3ImageView.getY()<0){
                player3ImageView.relocate(player3.getHomeCity().getxCoordinate(), 0);
            }
            else if(player3ImageView.getX()>350){
                player3ImageView.relocate(350, player3.getHomeCity().getyCoordinate()-50);
            }

            if(player3.getHomeCity().getQuarter() == 1){
                gridPane1.getChildren().add(player3ImageView);
                gridPane1.getChildren().add(player3PieceImageView);
            }
            else if(player3.getHomeCity().getQuarter()== 2){
                gridPane2.getChildren().add(player3ImageView);
                gridPane2.getChildren().add(player3PieceImageView);
            }
            else if(player3.getHomeCity().getQuarter() == 3){
                gridPane3.getChildren().add(player3ImageView);
                gridPane3.getChildren().add(player3PieceImageView);
            }
            else{
                gridPane4.getChildren().add(player3ImageView);
                gridPane4.getChildren().add(player3PieceImageView);
            }
        }
        if(player4!=null){
            player4.setHomeCity(redCities.get(randomCityGenerator.nextInt(redCities.size())));
            player4.getDestinations().add(player4.getHomeCity());
            player4.getDestinations().add(greenCities.get(randomCityGenerator.nextInt(greenCities.size())));
            player4.getDestinations().add(yellowCities.get(randomCityGenerator.nextInt(yellowCities.size())));
            player4ImageView.setFitHeight(75);
            player4ImageView.setFitWidth(75);
            player4PieceImageView = new ImageView(loadImage("piece_yellow.png"));
            player4PieceImageView.relocate(player4.getHomeCity().getxCoordinate() - 20, player4.getHomeCity().getyCoordinate() - 42);
            player4PieceImageView.setFitHeight(50);
            player4PieceImageView.setFitWidth(50);
            player4ImageView.relocate(player4.getHomeCity().getxCoordinate(), player4.getHomeCity().getyCoordinate()-50);
            if(player4ImageView.getY()<0){
                player4ImageView.relocate(player4.getHomeCity().getxCoordinate(), 0);
            }
            else if(player4ImageView.getX()>350){
                player4ImageView.relocate(350, player4.getHomeCity().getyCoordinate()-50);
            }
            if(player4.getHomeCity().getQuarter() == 1){
                gridPane1.getChildren().add(player4ImageView);
                gridPane1.getChildren().add(player4PieceImageView);
            }
            else if(player4.getHomeCity().getQuarter()== 2){
                gridPane2.getChildren().add(player4ImageView);
                gridPane2.getChildren().add(player4PieceImageView);
            }
            else if(player4.getHomeCity().getQuarter() == 3){
                gridPane3.getChildren().add(player4ImageView);
                gridPane3.getChildren().add(player4PieceImageView);
            }
            else{
                gridPane4.getChildren().add(player4ImageView);
                gridPane4.getChildren().add(player4PieceImageView);
            }
        }
        if(player5!=null){
            player5.setHomeCity(greenCities.get(randomCityGenerator.nextInt(greenCities.size())));
            player5.getDestinations().add(player5.getHomeCity());
            player5.getDestinations().add(yellowCities.get(randomCityGenerator.nextInt(yellowCities.size())));
            player5.getDestinations().add(redCities.get(randomCityGenerator.nextInt(redCities.size())));
            player5ImageView.setFitHeight(75);
            player5ImageView.setFitWidth(75);
            player5PieceImageView = new ImageView(loadImage("piece_green.png"));
            player5PieceImageView.setFitHeight(50);
            player5PieceImageView.setFitWidth(50);
            player5PieceImageView.relocate(player5.getHomeCity().getxCoordinate() - 20, player5.getHomeCity().getyCoordinate()-42);
            player5ImageView.relocate(player5.getHomeCity().getxCoordinate(), player5.getHomeCity().getyCoordinate()-50);


            if(player5ImageView.getY()<0){
                player5ImageView.relocate(player5.getHomeCity().getxCoordinate(), 0);
            }
            else if(player5ImageView.getX()>350){
                player5ImageView.relocate(350, player5.getHomeCity().getyCoordinate()-50);
            }


            if(player5.getHomeCity().getQuarter() == 1){


                gridPane1.getChildren().add(player5ImageView);
                gridPane1.getChildren().add(player5PieceImageView);

            }
            else if(player5.getHomeCity().getQuarter()== 2){

                gridPane2.getChildren().add(player5ImageView);
                gridPane2.getChildren().add(player5PieceImageView);


            }
            else if(player5.getHomeCity().getQuarter() == 3){


                gridPane3.getChildren().add(player5ImageView);
                gridPane3.getChildren().add(player5PieceImageView);


            }
            else{

                gridPane4.getChildren().add(player5ImageView);
                gridPane4.getChildren().add(player5PieceImageView);


            }
        }
        if(player6!=null){
            player6.setHomeCity(yellowCities.get(randomCityGenerator.nextInt(yellowCities.size())));
            player6.getDestinations().add(player6.getHomeCity());
            player6.getDestinations().add(redCities.get(randomCityGenerator.nextInt(redCities.size())));
            player6.getDestinations().add(greenCities.get(randomCityGenerator.nextInt(greenCities.size())));
            player6ImageView.setFitHeight(75);
            player6ImageView.setFitWidth(75);
            player6PieceImageView = new ImageView(loadImage("piece_blue.png"));
            player6PieceImageView.setFitHeight(50);
            player6PieceImageView.setFitWidth(50);
            player6PieceImageView.relocate(player6.getHomeCity().getxCoordinate()-20, player6.getHomeCity().getyCoordinate()-42);
            player6ImageView.relocate(player6.getHomeCity().getxCoordinate(), player6.getHomeCity().getyCoordinate()-50);
            if(player6ImageView.getY()<0){
                player6ImageView.relocate(player6.getHomeCity().getxCoordinate(), 0);
            }
            else if(player6ImageView.getX()>350){
                player6ImageView.relocate(350, player6.getHomeCity().getyCoordinate()-50);
            }
            if(player6.getHomeCity().getQuarter() == 1){
                gridPane1.getChildren().add(player6ImageView);
                gridPane1.getChildren().add(player6PieceImageView);
            }
            else if(player6.getHomeCity().getQuarter()== 2){
                gridPane2.getChildren().add(player6ImageView);
                gridPane2.getChildren().add(player6PieceImageView);
            }
            else if(player6.getHomeCity().getQuarter() == 3){
                gridPane3.getChildren().add(player6ImageView);
                gridPane3.getChildren().add(player6PieceImageView);
            }
            else{
                gridPane4.getChildren().add(player6ImageView);
                gridPane4.getChildren().add(player6PieceImageView);
            }
        }
        for (int i = 0; i < activePlayersList.size(); i++) {
            System.out.println("Player " + (i + 1) + "'s cities are:");
            System.out.println("Home City " + activePlayersList.get(i).getHomeCity().getName());
            System.out.println(activePlayersList.get(i).getDestinations().get(1).getName());
            System.out.println(activePlayersList.get(i).getDestinations().get(2).getName());
        }
        movePlayers();
    }
    public void movePlayers(){
        player1PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = player1ImageView.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                Image sourceImage = player1PieceImageView.getImage();
                content.putImage(sourceImage);
                db.setContent(content);
                event.consume();
            }
        });
        player2PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = player2ImageView.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                Image sourceImage = player2PieceImageView.getImage();
                content.putImage(sourceImage);
                db.setContent(content);
                event.consume();
            }
        });
        if(player3!=null){
        player3PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = player3ImageView.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                Image sourceImage = player3PieceImageView.getImage();
                content.putImage(sourceImage);
                db.setContent(content);
                event.consume();
            }
        });}
        if(player4!=null){
        player4PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");

                /* allow any transfer mode */
                Dragboard db = player4ImageView.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                Image sourceImage = player4PieceImageView.getImage();
                content.putImage(sourceImage);
                db.setContent(content);
                event.consume();
            }
        });}
        if(player5!=null){
            player5PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                /* allow any transfer mode */
                    Dragboard db = player5ImageView.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    Image sourceImage = player5PieceImageView.getImage();
                    content.putImage(sourceImage);
                    db.setContent(content);
                    event.consume();
                }
            });
        }
        if(player6!=null){
            player6PieceImageView.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                    System.out.println("onDragDetected");

                /* allow any transfer mode */
                    Dragboard db = player6ImageView.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    Image sourceImage = player6PieceImageView.getImage();
                    content.putImage(sourceImage);
                    db.setContent(content);
                    event.consume();
                }
            });
        }
        gridPane1.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });
        gridPane1.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println(db.getImage().getHeight());
                System.out.println(player1PieceImageView.getImage().getHeight());
                if(db.hasImage()) {
                    if(db.getImage().getHeight() == player1PieceImageView.getImage().getHeight()) {
                        gridPane1.getChildren().remove(player1PieceImageView);
                        player1PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player1PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player2PieceImageView.getImage().getHeight()){
                        gridPane1.getChildren().remove(player2PieceImageView);
                        player2PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player2PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player3PieceImageView.getImage().getHeight()) {
                        gridPane1.getChildren().remove(player3PieceImageView);
                        player3PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player3PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player4PieceImageView.getImage().getHeight()){
                        gridPane1.getChildren().remove(player4PieceImageView);
                        player4PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player4PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player5PieceImageView.getImage().getHeight()){
                        gridPane1.getChildren().remove(player5PieceImageView);
                        player5PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player5PieceImageView);
                    }
                    else {
                        gridPane1.getChildren().remove(player6PieceImageView);
                        player6PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane1.getChildren().add(player6PieceImageView);
                    }

                }
            }
        });
        gridPane2.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });
        gridPane2.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println(db.getImage().getHeight());
                System.out.println(player1PieceImageView.getImage().getHeight());
                if(db.hasImage()) {
                    if(db.getImage().getHeight() == player1PieceImageView.getImage().getHeight()) {
                        gridPane2.getChildren().remove(player1PieceImageView);
                        player1PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player1PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player2PieceImageView.getImage().getHeight()){
                        gridPane2.getChildren().remove(player2PieceImageView);
                        player2PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player2PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player3PieceImageView.getImage().getHeight()) {
                        gridPane2.getChildren().remove(player3PieceImageView);
                        player3PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player3PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player4PieceImageView.getImage().getHeight()){
                        gridPane2.getChildren().remove(player4PieceImageView);
                        player4PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player4PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player5PieceImageView.getImage().getHeight()){
                        gridPane2.getChildren().remove(player5PieceImageView);
                        player5PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player5PieceImageView);
                    }
                    else {
                        gridPane2.getChildren().remove(player6PieceImageView);
                        player6PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane2.getChildren().add(player6PieceImageView);
                    }

                }
            }
        });
        gridPane3.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });
        gridPane3.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println(db.getImage().getHeight());
                System.out.println(player1PieceImageView.getImage().getHeight());
                if(db.hasImage()) {
                    if(db.getImage().getHeight() == player1PieceImageView.getImage().getHeight()) {
                        gridPane3.getChildren().remove(player1PieceImageView);
                        player1PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player1PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player2PieceImageView.getImage().getHeight()){
                        gridPane3.getChildren().remove(player2PieceImageView);
                        player2PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player2PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player3PieceImageView.getImage().getHeight()) {
                        gridPane3.getChildren().remove(player3PieceImageView);
                        player3PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player3PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player4PieceImageView.getImage().getHeight()){
                        gridPane3.getChildren().remove(player4PieceImageView);
                        player4PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player4PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player5PieceImageView.getImage().getHeight()){
                        gridPane3.getChildren().remove(player5PieceImageView);
                        player5PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player5PieceImageView);
                    }
                    else {
                        gridPane3.getChildren().remove(player6PieceImageView);
                        player6PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane3.getChildren().add(player6PieceImageView);
                    }

                }
            }
        });
        gridPane4.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {

                Dragboard db = event.getDragboard();

                if(db.hasImage()){
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });
        gridPane4.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                System.out.println(db.getImage().getHeight());
                System.out.println(player1PieceImageView.getImage().getHeight());
                if(db.hasImage()) {
                    if(db.getImage().getHeight() == player1PieceImageView.getImage().getHeight()) {
                        gridPane4.getChildren().remove(player1PieceImageView);
                        player1PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player1PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player2PieceImageView.getImage().getHeight()){
                        gridPane4.getChildren().remove(player2PieceImageView);
                        player2PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player2PieceImageView);
                    }
                    else if(db.getImage().getHeight() == player3PieceImageView.getImage().getHeight()) {
                        gridPane4.getChildren().remove(player3PieceImageView);
                        player3PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player3PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player4PieceImageView.getImage().getHeight()){
                        gridPane4.getChildren().remove(player4PieceImageView);
                        player4PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player4PieceImageView);
                    }
                    else if (db.getImage().getHeight() == player5PieceImageView.getImage().getHeight()){
                        gridPane4.getChildren().remove(player5PieceImageView);
                        player5PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player5PieceImageView);
                    }
                    else {
                        gridPane4.getChildren().remove(player6PieceImageView);
                        player6PieceImageView.relocate(event.getX() - 20, event.getY() - 25);
                        gridPane4.getChildren().add(player6PieceImageView);
                    }

                }
            }
        });

    }


    public void switchScreenRequest(String screenName) throws IOException{
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
