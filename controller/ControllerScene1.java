/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 13/03/2024
* Ultima alteracao.: 14/03/2024
* Nome.............: ControllerScene1.java
* Funcao...........: Controlar os nodes da primeira tela
*************************************************************** */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import util.DataSingleton;

public class ControllerScene1 implements Initializable {

  @FXML
  private Button iniciarButton;
  @FXML
  private ChoiceBox<String> choiceCasos;

  @FXML
  private ImageView imagemSom;

  DataSingleton data = DataSingleton.getInstance(); // concecta as telas

  private String[] casos = { "Inferior Esquerdo/Inferior Direito", "Superior Direito/Superior Esquerdo", "Inferior Esquero/Superior Direito", "Inferior Direito/Superior Esquerdo" }; // Valores que irão no choice box
  private Parent root;
  private Scene scene;
  private Stage stage;

  /*
   * ***************************************************************
   * Metodo: initialize
   * Funcao: implementar alteracoes na interface apos a sua contrucao
   * Parametros: URL(representa o local do arquivo FXML) , ResourceBundlue(Este
   * parâmetro é um objeto ResourceBundle que contém recursos específicos para o
   * arquivo FXML)
   * Retorno: void
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    choiceCasos.getItems().addAll(casos); // adicionando os textos a choice box
    choiceCasos.setValue(choiceCasos.getItems().get(data.getOpcao())); // nao deixa o choiceBox comecar como default

  }

  /*
   * ***************************************************************
   * Metodo: iniciarButton
   * Funcao: controlar a acao do button iniciar, ao ser chamado troca a tela atual
   * para a tela em que ocorre a animacao
   * Parametros: Recebe um action event que ao ser acionado executa o bloco de
   * comandos
   * Retorno: void
   */
  @FXML
  public void iniciarButton(ActionEvent event) throws IOException {
    data.setOpcao(choiceCasos.getSelectionModel().getSelectedIndex()); // armazena o index do choixe box no
                                                                       // DataSingleton
    root = FXMLLoader.load(getClass().getResource("/view/scene2.fxml")); // Carrega o FXML para a scene2
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root); // Passa a scene para o root
    stage.setScene(scene); // passa a scene para o stage
    stage.show(); // exibe o stage

    /*
     * e.getSource(): e é um parâmetro do tipo ActionEvent, que é comumente usado
     * para eventos de
     * interface do usuário, como cliques em botões. getSource() retorna o objeto
     * que acionou o
     * evento, que no seu caso seria um nó da interface gráfica (por exemplo, um
     * botão).
     * 
     * ((Node)e.getSource()): Este trecho converte o objeto obtido em um tipo Node,
     * que é uma classe
     * base para todos os elementos de interface gráfica no JavaFX.
     * 
     * getScene(): Obtém a cena à qual o nó pertence. A cena é basicamente um
     * contêiner para o
     * conteúdo gráfico em JavaFX.
     * 
     * getWindow(): Obtém a janela (window) à qual a cena está associada. Uma janela
     * é uma área
     * retangular na tela onde a interface gráfica é exibida.
     * 
     * (Stage)((Node)e.getSource()).getScene().getWindow(): Finalmente, converte a
     * janela obtida para
     * o tipo Stage. Um Stage é uma janela JavaFX principal que geralmente contém
     * uma ou mais
     * cenas.
     */
}

  

}
