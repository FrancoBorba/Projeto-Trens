
/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 13/03/2024
* Ultima alteracao.: 20/03/2024
* Nome.............: Principal.java
* Funcao...........: Classe principal do projeto de trens onde contem o main do arquivo
*************************************************************** */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import controller.ControllerScene1;
import controller.ControllerScene2;

public class Principal extends Application {
  public static void main(String[] args) {
    launch(args);
    } 

    /*
     * ***************************************************************
     * Metodo: start
     * Funcao: A chamada para start é uma parte do ciclo de vida da aplicação
     * JavaFX, que começa com o método launch da classe Application. O launch
     * inicializa o sistema JavaFX, o que eventualmente leva à chamada do método
     * start. Após start ser executado, a UI se torna visível para o usuário quando
     * você chama primaryStage.show().
     * escolhido junto com a velocidade inicial
     * Parametros: Stage
     * Retorno: void
     */
    @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view/scene1.fxml")); // carrega o fxml da tela
    Scene scene = new Scene(root); // passa o root na scene
    Image icon = new Image("image/icon.png"); // adiciona a imagem ao object image na variavel icon
    primaryStage.setResizable(false); // nao permite aumentar o stage
    primaryStage.getIcons().add(icon); // adiciona um favicon ao stage
    primaryStage.setTitle("Projeto Trens"); // adiciona um titulo
    primaryStage.setScene(scene); // passa a scene para o stage
    primaryStage.show(); // inicia o stage
    primaryStage.setOnCloseRequest(e -> System.exit(0)); // encerra as thread quando o usario fecha a tela
}

}