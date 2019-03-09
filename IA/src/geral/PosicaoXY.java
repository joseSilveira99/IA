/*Ésta classe é capaz de setar as variaveis posX, posY e manipulalas,
 *estas variaveis são usadas para o agente se mover pelo hospital tendo,
 *sempre uma nova posição.
 *Ultima alteração: 24/09/2017
 *Autor: Cássio Elias da Silva
*/
package geral;

public class PosicaoXY {

	private int posX;
	private int posY;
	
	public PosicaoXY() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public PosicaoXY(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}	
}