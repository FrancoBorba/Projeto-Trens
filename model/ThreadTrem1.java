/* ***************************************************************
* Autor: Franco Ribeiro Borba
* Matricula........: 202310445
* Inicio...........: 14/03/2024
* Ultima alteracao.: 24/05/2024
* Nome.............: ThreadTrem1
* Funcao...........: Criar e configurar a Thread que movimentara os trens da equerda
*************************************************************** */
package model;




import controller.ControllerScene2;
import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class ThreadTrem1 extends Thread {

  private double speedX; // velocidade no eixo x
  private double speedY; // velocidade no eixo y
  private int posicao; // posicao inicial do trem escolhida pelo usuario
  private Slider slider;
  private int solucao;
  private int processo = 0; // numero do processo

 

  private boolean zonaCritica1 = false;
  private boolean zonaCritica2 = false;
  

  private ImageView imageTrem; // imagem associada ao trem
  
  
  @Override
  public void run(){
  //animacao.start();   
  while (true) {
    setSpeedX(slider.getValue());   
    setSpeedY(slider.getValue());
    Platform.runLater(() -> {moverTrem();});
   try{
      Thread.sleep(17);
   } catch(InterruptedException e){
   e.printStackTrace();
    }
  }
}
  

  public ThreadTrem1(ImageView imageTrem, int posicao , Slider slider , int solucao) {
    this.imageTrem = imageTrem;
    this.posicao = posicao;
    this.slider = slider;
    this.solucao = solucao;
    switch (posicao) {
      case 0: { // posicao inferior esquerda
        imageTrem.setLayoutX(257);
        imageTrem.setLayoutY(421);
        imageTrem.setRotate(270);
        break;
      }
     /*  case 1: {
        imageTrem.setLayoutX(314);
        imageTrem.setLayoutY(422);
        imageTrem.setRotate(270);
        break;
      }*/
      case 2: { // posicao superior esquerda
        imageTrem.setLayoutX(250);
        imageTrem.setLayoutY(-31);
        imageTrem.setRotate(90);
        break;
      } 
     /*  case 3: {
        imageTrem.setLayoutX(305);
        imageTrem.setLayoutY(-31);
        imageTrem.setRotate(90);
        break;
      }*/

      default:
        break;
    }
  }


/*
   * ***************************************************************
   * Metodo: moverTrem
   * Funcao: controle do movimento do Trem na esquerda(em cima ou em baixo)
   * Parametros: void
   * Retorno: void
   */
  public void moverTrem(){
    switch (posicao) {
      case 0:{ // moimentacao na posicao inferior esquerda
        if (this.getImageTrem().getLayoutY() <= 450 && this.getImageTrem().getLayoutY() > 331) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
    } // fim do primeiro if
    else if (this.getImageTrem().getLayoutY() <= 331 && this.getImageTrem().getLayoutY() > 313) {

       if( !entraZonaCritica1(solucao) && !zonaCritica1){
        break;
      }
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(310);
    } // fim do segundo if
    else if (this.getImageTrem().getLayoutY() <= 313 && this.getImageTrem().getLayoutY() > 302) {
      
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(270);
    } // fim do terceito if
    else if (this.getImageTrem().getLayoutY() <= 302 && this.getImageTrem().getLayoutY() > 252) {
      
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
    } // fim do quarto if
    else if (this.getImageTrem().getLayoutY() <= 252 && this.getImageTrem().getLayoutY() > 230) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(240);
    } // fim do quinto if
    else if (this.getImageTrem().getLayoutY() <= 230 && this.getImageTrem().getLayoutY() > 225) {
      saiZonaCritica1(solucao);
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(270);
    } // fim do sexto if
    else if (this.getImageTrem().getLayoutY() <= 225 && this.getImageTrem().getLayoutY() > 169) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
    } // fim do setimo if
    else if (this.getImageTrem().getLayoutY() <= 169 && this.getImageTrem().getLayoutY() > 150) {
      if(!entraZonaCritica2(solucao) && !zonaCritica2){
        break;
      }

      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(310);
    } // fim do oitavo if
    else if (this.getImageTrem().getLayoutY() <= 150 && this.getImageTrem().getLayoutY() > 140) {
      this.getImageTrem().setRotate(270);
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
    } // fim do nono if
    else if (this.getImageTrem().getLayoutY() <= 140 && this.getImageTrem().getLayoutY() > 93) {
      
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());

    } // fim do decimo if
    else if (this.getImageTrem().getLayoutY() <= 93 && this.getImageTrem().getLayoutY() > 66) {
      saiZonaCritica2(solucao);
      this.getImageTrem().setRotate(250);
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
    } // fim do decimo primeiro if
    else if (this.getImageTrem().getLayoutY() <= 66 && this.getImageTrem().getLayoutY() > -40) {
      this.getImageTrem().setRotate(270);
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() - this.getSpeedY());
    } // fim do decimo segundo if
    else {
      this.getImageTrem().setLayoutX(257);
      this.getImageTrem().setLayoutY(422);
      this.getImageTrem().setRotate(270);
    }
        break;
      }
    case 2:{ // movimentacao na posicao superior esquerda 
         if (this.getImageTrem().getLayoutY() < 40) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
    } // fim do primeiro if
    else if (this.getImageTrem().getLayoutY() < 56) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(45);
    } // fim do segundo if
    else if (this.getImageTrem().getLayoutY() < 73) {
        if(!entraZonaCritica2(solucao) && !zonaCritica2){
        break;
      }

      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(90);
    } // fim do terceitthis
    else if (this.getImageTrem().getLayoutY() < 121) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
    } // fim do quarto if
    else if (this.getImageTrem().getLayoutY() < 142) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(135);
    } // fim do quinto if
    else if (this.getImageTrem().getLayoutY() < 147) {
      saiZonaCritica2(solucao);
    this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(90);
    } // fim do sexto if
    else if (this.getImageTrem().getLayoutY() < 198) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
    } // fim do setimo if
    else if (this.getImageTrem().getLayoutY() < 218) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(45);
    } // fim do oitavohis
    else if (this.getImageTrem().getLayoutY() < 225) {
        if( !entraZonaCritica1(solucao) && !zonaCritica1){
        break;
      }
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() + this.getSpeedX());
      this.getImageTrem().setRotate(90);
    } // fim do nono if
    else if (this.getImageTrem().getLayoutY() < 275) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
    } // fim do decimo if
    else if (this.getImageTrem().getLayoutY() < 297) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(135);
    } // fim do decimo primeiro if
    else if (this.getImageTrem().getLayoutY() < 305) {
      saiZonaCritica1(solucao);
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
      this.getImageTrem().setLayoutX(this.getImageTrem().getLayoutX() - this.getSpeedX());
      this.getImageTrem().setRotate(90);
    } // fim do decimo segundo if
    else if (this.getImageTrem().getLayoutY() < 410) {
      this.getImageTrem().setLayoutY(this.getImageTrem().getLayoutY() + this.getSpeedY());
    } // fim do decimo terceiro if
    else {
      this.getImageTrem().setLayoutX(250);
      this.getImageTrem().setLayoutY(-31);
      this.getImageTrem().setRotate(90);
    }
    break;

}
      default:
        break;
    }
  }

/*
   * ***************************************************************
   * Metodo: entraZonaCritica1
   * Funcao: verificar qual trem entrou na zona primeiro e com base nisso aplicar os metodos de parada
   * Parametros: metodo de travamanento que sera utilizado
   * Retorno: boolean
    * ***************************************************************
   */
  public boolean entraZonaCritica1(int solucao){

    switch (solucao) {
      
      case 0:{ // variavel de travamento
    if(ControllerScene2.travaZona1 == 1){
        return false;
    }else{
        ControllerScene2.travaZona1 = 1;
        zonaCritica1 = true;
        return true;
    }
}
    case 1:{
      if(ControllerScene2.turno1 == 1){
        return false;
      }else{
        zonaCritica1 = true;
        return true;
      }
    }
    case 2:{
      int other; // numero do outro processo
      other = 1 - processo; // o oposto do processo
      ControllerScene2.interese1[processo] = true; // mostra que o processo esta interessado
    ControllerScene2.vez1 = processo; // alterar o valor do turno
    if(ControllerScene2.vez1 == processo && ControllerScene2.interese1[other] == true){
      return false; 
    }else{
      zonaCritica1 = true;
      return true;
    }
    }
      default:
      return true;    
    }
   
      
  }
  /*
   * ***************************************************************
   * Metodo: saiZonaCritica1
   * Funcao: verificar se o trem ja saiu da zona critica assim permitindo a passagem de outros trens
   * Parametros: metodo de travamanento que sera utilizado
   * Retorno: void
    * ***************************************************************
   */
  public  void saiZonaCritica1(int solucao){
    switch (solucao) {
      case 0:{ // variavel de travamento
    ControllerScene2.travaZona1 = 0;
    zonaCritica1 = false;
    break;
      }
      case 1:{
        ControllerScene2.turno1 = 1;
        zonaCritica1 = false;
        break;
      }
      case 2:{
        ControllerScene2.interese1[processo] = false; // mostra que o processo nao tem interesse na zona critia
        zonaCritica1 = false; // mostra que o trem nao tem interesse
      }
    
    
      default:
        break;
   
   
  }
}
  /*
   * ***************************************************************
   * Metodo: entraZonaCritica2
   * Funcao: verificar qual trem entrou na zona critica primeiro e com base nisso aplicar os metodos de parada
   * Parametros: metodo de travamanento que sera utilizado
   * Retorno: boolean
    * ***************************************************************
   */
  public boolean entraZonaCritica2(int solucao){
    switch (solucao) {
      case 0:{ // variavel de travamento
      if(ControllerScene2.travaZona2 == 1){
      return false;
      } else{
      ControllerScene2.travaZona2 = 1;
      zonaCritica2 = true;
      return true;
    }
  }
      case 1:{
        if(ControllerScene2.turno2 == 1){
          return false;
        } else{
          zonaCritica2 = true;
          return true;
        }
  }
    case 2:{
      int other; // numero do outro processo
      other = 1 - processo; // recebe o oposto do processo
      ControllerScene2.interese2[processo] = true; // mostra que o processo quer acessar a zona critica
      ControllerScene2.vez2 = processo; // altera o valor do turno
       if(ControllerScene2.vez2 == processo && ControllerScene2.interese2[other] == true){
      return false; 
    }else{
      zonaCritica2 = true;
      return true;
    }
  }
 
      default:
       return true;
 }
    }

     /*
   * ***************************************************************
   * Metodo: saiZonaCritica2
   * Funcao: verificar se o trem ja saiu da zona critica assim permitindo a passagem de outros trens
   * Parametros: metodo de travamanento que sera utilizado
   * Retorno: void
    * ***************************************************************
   */
  public  void saiZonaCritica2(int solucao){
      switch (solucao) {
        case 0:{
           ControllerScene2.travaZona2 = 0;
      zonaCritica2 = false;
      break;
        }
        case 1:{
          ControllerScene2.turno2 =1;
          zonaCritica2 = false;
          break;
        }
        case 2:{
           ControllerScene2.interese2[processo] = false; // mostra que o processo nao tem interesse na zona critia
        zonaCritica2 = false; // mostra que o trem nao tem interesse
        }
          
          
      
        default:
          break;
      }
     
  }


 

  /*
   * ***************************************************************
   * Metodo: getSpeedX
   * Funcao: retornar a velocidade no eixo x
   * Parametros: nao recebe
   * Retorno: double
   */
  public double getSpeedX() {
    return speedX;
  }

  /*
   * ***************************************************************
   * Metodo: setSpeedX
   * Funcao: modificar a velocidade no eixo X
   * Parametros: velocidade que deseja modificar
   * Retorno: void
   */
  public void setSpeedX(double d) {
    this.speedX = d;
  }

  /*
   * ***************************************************************
   * Metodo: getSpeedY
   * Funcao: retornar a velocidade no eixo y
   * Parametros: nao recebe
   * Retorno: double
   */
  public double getSpeedY() {
    return speedY;
  }

  /*
   * ***************************************************************
   * Metodo: setSpeedY
   * Funcao: modificar a velocidade no eixo y
   * Parametros: velocidade que deseja modificar
   * Retorno: void
   */
  public void setSpeedY(double d) {
    this.speedY = d;
  }

  /*
   * ***************************************************************
   * Metodo: getImageTrem
   * Funcao: retorna a imagem que esta alocada no objeto trem
   * Parametros: nenhum
   * Retorno: Um imageView
   */
  public ImageView getImageTrem() {
    return imageTrem;
  }

  /*
   * ***************************************************************
   * Metodo: setImageTrem
   * Funcao: definir a imagem do objeto Trem
   * Parametros: ImageView
   * Retorno: void
   */
  public void setImageTrem(ImageView imageTrem) {
    this.imageTrem = imageTrem;
  }

  /*
   * ***************************************************************
   * Metodo: getPosicao
   * Funcao: retornar a posicao a qual o trem comecara sua animacao
   * Parametros: nenhum
   * Retorno: int
   */
  public int getPosicao() {
    return posicao;
  }

}
