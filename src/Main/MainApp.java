package Main;
import Check.Check;
import Method.ChoseMethod;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    //输入标签，输入URL。起始端口，终止端口
    private TextField InputUrl;
    private TextField InputstartPort;
    private TextField InputendPort;

    //按钮
    private Button AttackButton;
    private Button CleanText;

    //输出框
    public static TextArea OutputText;

    public static void getText(String text){
        OutputText.appendText(text+"\n");
    }


    @Override
    public void start(Stage primaryStage) {

        AnchorPane RootLayout=new AnchorPane();
        //创建根节点，根容器

        Label LabelInputUrl=new Label("URL");
        LabelInputUrl.setLayoutX(25);
        LabelInputUrl.setLayoutY(25);
        LabelInputUrl.setPrefSize(43,23);

        InputUrl=new TextField("Input Check Url");
        InputUrl.setLayoutX(88);
        InputUrl.setLayoutY(25);
        InputUrl.setPrefSize(328,23);

        OutputText=new TextArea();
        OutputText.setLayoutX(80);
        OutputText.setLayoutY(150);
        OutputText.setPrefSize(400,150);

        InputstartPort=new TextField("startPort"){
            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };


        InputstartPort.setLayoutX(88);
        InputstartPort.setLayoutY(88);
        InputstartPort.setPrefSize(100,23);

        InputendPort=new TextField("EndPort"){
            @Override
            public void replaceText(int start, int end, String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceText(start, end, text);
                }
            }

            @Override
            public void replaceSelection(String text) {
                if (!text.matches("[a-z]")) {
                    super.replaceSelection(text);
                }
            }
        };


        InputendPort.setLayoutX(198);
        InputendPort.setLayoutY(88);
        InputendPort.setPrefSize(100,23);


        AttackButton = createButton("开始扫描",500,25,86,27);

        AttackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                if(Check.Check(InputUrl.getText(),Integer.parseInt(InputstartPort.getText()),Integer.parseInt(InputendPort.getText()))){
                    ChoseMethod.ChoseMethod(InputUrl.getText(),Integer.parseInt(InputstartPort.getText()),Integer.parseInt(InputendPort.getText()));
                    System.out.println("test");

                }
            }
        });

        CleanText=createButton("清空结果",500,180,86,27);

        CleanText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                OutputText.setText(" ");
            }
        });



        //创建场景
        Scene scene=new Scene(RootLayout,740,480);

        RootLayout.getChildren().addAll(LabelInputUrl,InputUrl,InputstartPort,InputendPort,AttackButton,OutputText,CleanText);
        //将场景添加到窗口

        primaryStage.setScene(scene);


        System.out.println("strat...");
        primaryStage.setTitle("test");
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init...");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop...");
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Button createButton(String text, double x, double y, double preW, double preH) {
        Button button = new Button(text);
        button.setPrefSize(preW, preH);
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }


}
