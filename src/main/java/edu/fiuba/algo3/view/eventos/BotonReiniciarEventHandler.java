package edu.fiuba.algo3.view.eventos;


import edu.fiuba.algo3.view.ContenedorInicial;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonReiniciarEventHandler implements EventHandler<ActionEvent>{
    private Stage stage;

    public BotonReiniciarEventHandler(Stage stage) {
        this.stage = stage;
    }

    public void handle(ActionEvent actionEvent) {
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage);
        Scene scene = new Scene(contenedorInicial ,500,270);
        stage.setScene(scene);
    }
}
