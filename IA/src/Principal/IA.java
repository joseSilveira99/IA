/*Ésta classe contém o método main que ditará o que o agente
 *deverá fazer dentro do hospital
 *Ultima alteração: 24/09/2017
 *Autor: Cássio Elias da Silva
*/
package principal;

import agente.AgenteHospital;
import ambiente.Hospital;
import geral.PosicaoXY;

public class IA {
    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{//InterruptedException usado para poder implementar o método sleep
		
		Hospital labirinto = new Hospital(4);//Construindo um novo hospital de tamanho 4
		//labirinto.exibirHospital();//Imprimindo o hospital, esta função mostra todos campos, sem o agente
		
		AgenteHospital agente = new AgenteHospital(labirinto);//Construindo um novo agente passando o hospital por parâmetro
		agente.setPosicao(new PosicaoXY(0,0));//Destina a posição do agente na matriz(hospital) de tamanho 4//Apresenta erro quando mando posição 2,2

		while(agente.isAindaLimpando()) {//Chamada da função em que verifica se tem local onde percorrer
			agente.zerarPilha();//Zera a variavel pilhasMovimentos
			agente.movimentar(); //Para que o agente possa se movimentar pelo hospital é usado esta função
			labirinto.exibirHospital();//Função capaz de mostrar o hospital atualizando-o a cada chamada
			//Thread.sleep(1500);//Para que não seja executado tudo de uma vez é usado esta função
		}
	}

}