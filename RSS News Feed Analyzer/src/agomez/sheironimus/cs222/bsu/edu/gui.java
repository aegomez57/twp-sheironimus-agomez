package agomez.sheironimus.cs222.bsu.edu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class gui extends Application{

    public GridPane root = new GridPane();

    @Override
    public void start(Stage primaryStage) {
        Button NewsButton = new Button();
        Button MusicButton = new Button();
        Button BooksButton = new Button();
        Button MEButton = new Button();
        Button ArtsLifeButton = new Button();
        Button BlackistButton = new Button();

        NewsButton.setText("News");
        MusicButton.setText("Music");
        BooksButton.setText("Books");
        MEButton.setText("Morning Edition");
        ArtsLifeButton.setText("Arts & Life");
        BlackistButton.setText("Blacklist");

        NewsButton.setMaxWidth(Double.MAX_VALUE);
        MusicButton.setMaxWidth(Double.MAX_VALUE);
        BooksButton.setMaxWidth(Double.MAX_VALUE);
        MEButton.setMaxWidth(Double.MAX_VALUE);
        ArtsLifeButton.setMaxWidth(Double.MAX_VALUE);
        BlackistButton.setMaxWidth(Double.MAX_VALUE);

        RSSParser newsFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1001");
        RSSParser musicFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1039");
        RSSParser booksFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1032");
        RSSParser morningeditionFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=3");
        RSSParser artslifeFeed = new RSSParser("http://www.npr.org/rss/rss.php?id=1008");

        newsFeed.parseFeed();
        musicFeed.parseFeed();
        booksFeed.parseFeed();
        morningeditionFeed.parseFeed();
        artslifeFeed.parseFeed();

        ArrayList<FeedItems> parsedNewsItems = newsFeed.parsedItems;
        ArrayList<FeedItems> parsedMusicItems = musicFeed.parsedItems;
        ArrayList<FeedItems> parsedBooksItems = booksFeed.parsedItems;
        ArrayList<FeedItems> parsedMEItems = morningeditionFeed.parsedItems;
        ArrayList<FeedItems> parsedArtsLifeItems = artslifeFeed.parsedItems;

        setGridPane();

        Scene MainScene = new Scene(root, 750, 500);
        primaryStage.setScene(MainScene);

        final TextArea TitleDescriptionTextArea = TextAreaBuilder.create()
                .prefWidth(400)
                .prefHeight(1000)
                .wrapText(true)
                .build();

        final TextArea WordFreqTextArea = TextAreaBuilder.create()
                .prefWidth(200)
                .prefHeight(270)
                .wrapText(true)
                .build();

        Text RSSNewsFeedlabel = new Text(10,50, "RSS News Feeds:");
        RSSNewsFeedlabel.setFont(new Font(20));
        Text RSSTitleDescriptionlabel = new Text(10,50, "Titles/Description:");
        RSSTitleDescriptionlabel.setFont(new Font(20));
        Text WordFrequencyLabel = new Text(10,50, "Word/Word Count:");
        WordFrequencyLabel.setFont(new Font(20));

        root.add(NewsButton, 0, 2);
        root.add(MusicButton, 0, 4);
        root.add(BooksButton, 0, 6);
        root.add(MEButton, 0, 8);
        root.add(ArtsLifeButton, 0, 10);
        root.add(BlackistButton, 0, 12);
        root.add(TitleDescriptionTextArea, 10, 2, 1, 15);
        root.add(WordFreqTextArea, 0, 16);
        root.add(RSSNewsFeedlabel,0,1);
        root.add(RSSTitleDescriptionlabel,10,1);
        root.add(WordFrequencyLabel,0,15);

        primaryStage.setTitle("NPR Feeds");
        primaryStage.setScene(MainScene);
        primaryStage.show();

        NewsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TitleDescriptionTextArea.clear();
                int i = 1;
                for(FeedItems feedItem : parsedNewsItems){
                    TitleDescriptionTextArea.appendText(i + ") " + feedItem.toString());
                    TitleDescriptionTextArea.appendText("\n");
                    i++;
                }
                WordFreqTextArea.clear();
                i = 1;
                for(FeedItems feedItem : parsedNewsItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreqTextArea.appendText(i + ") " + freq.Output());
                    WordFreqTextArea.appendText("\n");
                    i++;
                }
            }
        });

        MusicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TitleDescriptionTextArea.clear();
                int i = 1;
                for(FeedItems feedItem : parsedMusicItems){
                    TitleDescriptionTextArea.appendText(i + ") " + feedItem.toString());
                    TitleDescriptionTextArea.appendText("\n");
                    i++;
                }
                WordFreqTextArea.clear();
                i = 1;
                for(FeedItems feedItem : parsedMusicItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreqTextArea.appendText(i + ") " + freq.Output());
                    WordFreqTextArea.appendText("\n");
                    i++;
                }
            }
        });

        BooksButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TitleDescriptionTextArea.clear();
                int i = 1;
                for(FeedItems feedItem : parsedBooksItems){
                    TitleDescriptionTextArea.appendText(i + ") " + feedItem.toString());
                    TitleDescriptionTextArea.appendText("\n");
                    i++;
                }
                WordFreqTextArea.clear();
                i = 1;
                for(FeedItems feedItem : parsedBooksItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreqTextArea.appendText(i + ") " + freq.Output());
                    WordFreqTextArea.appendText("\n");
                    i++;
                }
            }
        });

        MEButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TitleDescriptionTextArea.clear();
                int i = 1;
                for(FeedItems feedItem : parsedMEItems){
                    TitleDescriptionTextArea.appendText(i + ") " + feedItem.toString());
                    TitleDescriptionTextArea.appendText("\n");
                    i++;
                }
                WordFreqTextArea.clear();
                i = 1;
                for(FeedItems feedItem : parsedMEItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreqTextArea.appendText(i + ") " + freq.Output());
                    WordFreqTextArea.appendText("\n");
                    i++;
                }
            }
        });

        ArtsLifeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TitleDescriptionTextArea.clear();
                for(FeedItems feedItem : parsedArtsLifeItems){
                    TitleDescriptionTextArea.appendText(feedItem.toString());
                    TitleDescriptionTextArea.appendText("\n");
                }
                WordFreqTextArea.clear();
                for(FeedItems feedItem : parsedArtsLifeItems){
                    String description = feedItem.getDescription();
                    Frequency freq = new Frequency(description);
                    WordFreqTextArea.appendText(freq.Output());
                    WordFreqTextArea.appendText("\n");
                }
            }
        });


        BlackistButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage blacklist = new Stage();
                blacklistStage(blacklist);
            }
        });

    }

    private void blacklistStage(Stage BlacklistStage) {
        BlacklistAnalyzer blAnalyzer = new BlacklistAnalyzer();

        GridPane rootBlacklist = new GridPane();
        rootBlacklist.setAlignment(Pos.TOP_LEFT);
        rootBlacklist.setHgap(10);
        rootBlacklist.setVgap(10);
        rootBlacklist.setPadding(new Insets(25, 25, 25, 25));

        Scene sceneBlacklist = new Scene(rootBlacklist, 575, 500);
        BlacklistStage.setScene(sceneBlacklist);
        BlacklistStage.setTitle("Blacklisted Words");

        Button addToBlacklist = new Button();
        addToBlacklist.setText("Add to Blacklist");

        final TextArea BlacklistTextArea = TextAreaBuilder.create()
                .prefWidth(400)
                .prefHeight(540)
                .wrapText(true)
                .build();

        blAnalyzer.analyzeBlacklist();

        BlacklistTextArea.appendText(blAnalyzer.blacklistedWords);
        BlacklistTextArea.setWrapText(true);

        rootBlacklist.add(addToBlacklist,0,0);
        rootBlacklist.add(BlacklistTextArea,1,0);

        BlacklistStage.show();

        addToBlacklist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String changedBlacklist = BlacklistTextArea.getText();
                blAnalyzer.saveBlacklist(changedBlacklist);
                BlacklistStage.close();
            }
        });
    }

    public void setGridPane(){
        root.setAlignment(Pos.TOP_LEFT);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

