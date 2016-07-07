package vista.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vista.mainApp;

public class AlertasController {
    @FXML
    Label mensaje;


    @FXML
    private void initialize() {
    }

    public void setearMensaje(String mensajeDeAlerta){

        mensaje.setText(mensajeDeAlerta);

    }

    @FXML
    public void close(){
        mainApp.dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage) {
        mainApp.dialogStage = dialogStage;
    }



}