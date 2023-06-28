package edu.fiuba.algo3.view.eventos;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ControladorSonido {
    
    public MediaPlayer setMusicaInicial(){
        Media media = new Media(getClass().getResource("/sonidos/intro.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.volumeProperty().bindBidirectional(new SimpleDoubleProperty(0.2));
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });
        return mediaPlayer;
    }
}
