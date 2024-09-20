/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 13/03/2024
* Ultima alteracao.: 24/05/2024
* Nome.............: ControllerScene2.java
* Funcao...........: Controlar os nodes da segunda tela
*************************************************************** */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.ThreadTrem1;
import model.ThreadTrem2;
import util.DataSingleton;

public class ControllerScene2 implements Initializable {

  DataSingleton data = DataSingleton.getInstance();


  private Parent root;
  private Scene scene;
  private Stage stage;



  @FXML
  private ImageView imageTrem1;
  @FXML
  private ImageView imageTrem2;
  @FXML
  private Slider sliderTrem1;
  @FXML
  private Slider sliderTrem2;


  @FXML
  private ToggleGroup tipoTravamento;
  @FXML
  private RadioButton varTravamento , estritaAlternancia , peterson;
  public int escolhaRadioButton ;

  @FXML
  private Label labelVelocidadeSlider1;
  private int velocidadeLabel1;

  @FXML
  Label labelVelocidadeSlider2;
  private int velocidadeLabel2;

  private ThreadTrem1 trem1;
  private ThreadTrem2 trem2;
  // trem1 = o trem azul
  // trem2 = trem vermelho


  // variaveis de travamento
  public static int travaZona1 = 0;
  public static int travaZona2 = 0;

  // estrita alternancia
  public static int turno1 =0;
  public static int turno2 =0;

  // solucao de peterson
  public static int vez1;
  public static boolean interese1[] = {false,false};
    public static int vez2;
  public static boolean interese2[] = {false,false};
  


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

    // iniciar os trens com base no index escolhido pelo choice box
    switch (data.getOpcao()) {
      case 0: {
       trem1 = new ThreadTrem1(imageTrem1, 0 ,sliderTrem1 , escolhaRadioButton); // inferior esquerda
      trem2 = new ThreadTrem2(imageTrem2, 1 , sliderTrem2 , escolhaRadioButton); // inferior direita
        break;
      }
      case 1: {
        trem1 = new ThreadTrem1(imageTrem1, 2 , sliderTrem1 , escolhaRadioButton); // superior esquerda
       trem2 = new ThreadTrem2(imageTrem2, 3 , sliderTrem2 , escolhaRadioButton); // superior direita
        break;
      }
      case 2: {
        trem1 = new ThreadTrem1(imageTrem1, 0 , sliderTrem1 , escolhaRadioButton); // inferior esquerda
       trem2 = new ThreadTrem2(imageTrem2, 3 , sliderTrem2 , escolhaRadioButton); // superior direita
        break;
      }
      case 3: {
        trem1 = new ThreadTrem1(imageTrem1, 2 , sliderTrem1 , escolhaRadioButton); // inferior direita
        trem2 = new ThreadTrem2(imageTrem2, 1 , sliderTrem2 , escolhaRadioButton); // superior esquerda
        break;
      }
      default:
        break;
    }

    velocidadeLabel1 = (int) sliderTrem1.getValue(); // passando a velocidade do slider para uma variavel int
    labelVelocidadeSlider1.setText(Integer.toString(velocidadeLabel1));// setando o texto do label com a velocidade
                                                                       // padrao do slider
    sliderTrem1.valueProperty().addListener(new ChangeListener<Number>() {

      /*
       * **************************************************************
       * Metodo: changed
       * Funcao: Em JavaFX, o método changed() é usado principalmente como parte de
       * propriedades observáveis. Este método é chamado quando o valor de uma
       * propriedade observável é alterado. Ele fornece uma maneira conveniente de
       * reagir a mudanças no estado de uma propriedade sem a necessidade de
       * implementar ou registrar ouvintes manualmente.
       * Parametros: observable: A propriedade observável que teve seu valor alterado.
       * oldValue: O valor antigo da propriedade antes da alteração.
       * newValue: O novo valor atribuído à propriedade após a alteração.observable: A
       * propriedade observável que teve seu valor alterado.
       * oldValue: O valor antigo da propriedade antes da alteração.
       * newValue: O novo valor atribuído à propriedade após a alteração.
       * Number newValue: Este parâmetro representa o novo valor do valor observável
       * após a mudança. Assim como `oldValue`, ele também é do tipo `Number`.
       * Retorno: vazio
       */
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeLabel1 = (int) (sliderTrem1.getValue()); // passando a velocidade do slider para uma variavel int
        labelVelocidadeSlider1.setText(Integer.toString(velocidadeLabel1)); // mudando o labal de acordo com a mudanca
                                                                            // do slider
      }

    });

    velocidadeLabel2 = (int) sliderTrem1.getValue(); // passando a velocidade do slider para uma variavel int
    labelVelocidadeSlider2.setText(Integer.toString(velocidadeLabel2));// setando o texto do label com a velocidade
                                                                       // padrao do slider

    sliderTrem2.valueProperty().addListener(new ChangeListener<Number>() {

      /*
       * **************************************************************
       * Metodo: changed
       * Funcao: Em JavaFX, o método changed() é usado principalmente como parte de
       * propriedades observáveis. Este método é chamado quando o valor de uma
       * propriedade observável é alterado. Ele fornece uma maneira conveniente de
       * reagir a mudanças no estado de uma propriedade sem a necessidade de
       * implementar ou registrar ouvintes manualmente.
       * Parametros: observable: A propriedade observável que teve seu valor alterado.
       * oldValue: O valor antigo da propriedade antes da alteração.
       * newValue: O novo valor atribuído à propriedade após a alteração.observable: A
       * propriedade observável que teve seu valor alterado.
       * oldValue: O valor antigo da propriedade antes da alteração.
       * newValue: O novo valor atribuído à propriedade após a alteração.
       * Number newValue: Este parâmetro representa o novo valor do valor observável
       * após a mudança. Assim como `oldValue`, ele também é do tipo `Number`.
       * Retorno: vazio
       */
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

        velocidadeLabel2 = (int) sliderTrem2.getValue(); // passando o valor do slider que é variavel para a velocidade
        labelVelocidadeSlider2.setText(Integer.toString(velocidadeLabel2)); // mudando o labal de acordo com a mudanca
                                                                            // do slider
      }

    });
  trem1.start();
  trem2.start();
  
  }

  /*
   * ***************************************************************
   * Metodo: getEscolha
   * Funcao: escolher a solucao de trvamento
   * Parametros: ActionEvent
   * Retorno: void
   * * ***************************************************************
   */
  public void getEscolha(ActionEvent event){
   if(varTravamento.isSelected()){ // escolhe variaveis de travamento
      escolhaRadioButton = 0;
      resetAnimacao(event);
    } 
    if(estritaAlternancia.isSelected()){ // escolhe estrita alternancia
      escolhaRadioButton = 1;
      resetAnimacao(event);
  }
    if(peterson.isSelected()){
      escolhaRadioButton = 2;
      resetAnimacao(event);
  } 
}  

  /*
   * ***************************************************************
   * Metodo: resetar a animacao
   * Funcao: Ao ser acionado o metodo coloca os trens na posicao inicial do caso
   * escolhido junto com a velocidade inicial
   * Parametros: ActionEvent
   * Retorno: void
   * * ***************************************************************
   */

  public void resetAnimacao(ActionEvent event) {

    switch (data.getOpcao()) {// reseta a posicao do trem para posicao inicial com base na escolha do
                              // choiceBox
      case 0: {
       trem1.getImageTrem().setLayoutX(257);
        trem1.getImageTrem().setLayoutY(422);
        trem1.getImageTrem().setRotate(270);
       trem2.getImageTrem().setLayoutX(314);
      trem2.getImageTrem().setLayoutY(422);
      trem2.getImageTrem().setRotate(270);
      

        break;

      }
      case 1: {
        trem1.getImageTrem().setLayoutX(250);
        trem1.getImageTrem().setLayoutY(-31);
        trem1.getImageTrem().setRotate(90);
       trem2.getImageTrem().setLayoutX(305);
        trem2.getImageTrem().setLayoutY(-31);
       trem2.getImageTrem().setRotate(90);
       
        break;
      }
      case 2: {
        trem1.getImageTrem().setLayoutX(257);
        trem1.getImageTrem().setLayoutY(422);
        trem1.getImageTrem().setRotate(270);
       trem2.getImageTrem().setLayoutX(305);
       trem2.getImageTrem().setLayoutY(-31);
       trem2.getImageTrem().setRotate(90); 
             
        break;
      }
      case 3: {
        trem1.getImageTrem().setLayoutX(257);
        trem1.getImageTrem().setLayoutY(422);
        trem1.getImageTrem().setRotate(270);
      trem2.getImageTrem().setLayoutX(314);
      trem2.getImageTrem().setLayoutY(422);
       trem2.getImageTrem().setRotate(270);
      }

      default:
        break;
    }

    sliderTrem1.setValue(5);
    sliderTrem2.setValue(5);
  }

  /*
   * ***************************************************************
   * Metodo: voltarTela
   * Funcao: chama a tela inicial de novo onde permite o usuario trocar a escolha
   * das posicoes dos trens
   * Parametros: ActionEvent
   * Retorno: void
   * * ***************************************************************
   */
  public void voltarTela(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("/view/scene1.fxml")); // Carrega o FXML para a scene1
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root); // Passa a scene para o root
    stage.setScene(scene); // passa a scene para o stage
    stage.show(); // exibe o stage
   stage.setOnCloseRequest(e -> System.exit(0)); //encerra as thread quando o usario fecha a tela
  }
}
