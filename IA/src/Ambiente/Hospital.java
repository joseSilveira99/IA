/*Ésta classe cuida da construção do hospital onde o agente(Doutor) irá percorrer.
 *Ultima alteração: 24/09/2017
 *Autor: Cássio Elias da Silva
 *PP = Paciente com Problema
 *DO = Doutor/Médico
 *PL = Paciente Livre de Problemas
*/ 
package ambiente;

import agente.AgenteHospital;
import geral.PosicaoXY;

public class Hospital{

	final private int tamanhoHospital;
	
	private String[][] hospital;
	
	private AgenteHospital agente;
	
	public Hospital(int tamanhoHospital){
		this.tamanhoHospital = tamanhoHospital;
		this.construirNovoHospital();
	}
	private void construirNovoHospital(){
		hospital = new String[this.tamanhoHospital][this.tamanhoHospital];
		for (int i = 0; i < this.tamanhoHospital; i++){
			for (int j = 0; j < this.tamanhoHospital; j++){
				this.hospital[i][j] = "PP";
			}
		}
	}
	public void exibirHospital(){
		atualizarPosicaoAgente();
		for (int i = 0; i < tamanhoHospital; i++){
			for (int j = 0; j < tamanhoHospital; j++){
				if (hospital[i][j].equals("*DO*")){
					System.out.print("|" + hospital[i][j] + "|");
				} else {
					System.out.print("| " + hospital[i][j] + " |");
				}	
			}
			System.out.println("");
		}
		System.out.println("");
	}
	private void atualizarPosicaoAgente(){
		if (this.agente != null){
			PosicaoXY posAgente = this.agente.getPosicao();
			hospital[posAgente.getPosX()][posAgente.getPosY()] = "*DO*";
		}
	}
	public int getTamanhoHospital(){
		return this.tamanhoHospital;
	}
	public String retornarValorPosicaoHospital(PosicaoXY posicao){
		return this.hospital[posicao.getPosX()][posicao.getPosY()];
	}
	public void setAgente(AgenteHospital agente){
		this.agente = agente;
	}
	public void limpar(){
		PosicaoXY posicao = this.agente.getPosicao();
		hospital[posicao.getPosX()][posicao.getPosY()] = "PL";
	}
}