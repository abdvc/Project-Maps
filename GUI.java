public class GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        GraphBuilder graph = new GraphBuilder();
        graph.buildGraph();
        Button btn = new Button();
        
        LinkGenerator Linkgen = new LinkGenerator();
        Linkgen.setApiKey("AIzaSyCxkwnaGiEcNqla43FKBPfNR3sW-ApIQ5E");
        Label start = new Label("Starting point: ");
        TextField a = new TextField();
        Label end = new Label("Ending point: ");
        TextField b = new TextField();
        ImageView show;
        btn.setText("Show map");
        
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        root.getChildren().add(start);
        root.getChildren().add(end);
        root.getChildren().add(a);
        root.getChildren().add(b);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
             Image map;
             ImageView MapView;
             String startLoc = graph.network.find(a.getText()).Location;
             String endLoc = graph.network.find(a.getText()).Location;
             Linkgen.setPath(startLoc, endLoc);
             String url = new String(Linkgen.generateLink());
             map = new Image(url);
             MapView = ImageViewBuilder.create().image(map).build();
             root.getChildren().add(MapView);
             Linkgen.clearParam();
            }
        });
        
        Scene scene = new Scene(root, 700, 650);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
