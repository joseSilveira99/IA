/*Ésta classe irá controlar o agente guiando-o dentro do hospital.
 *Ultima alteração: 24/09/2017
 *Autor: Cássio Elias da Silva
 *PP = Paciente com Problema
 *DO = Doutor/Médico
 *PL = Paciente Livre de Problemas
*/ 
package agente;
import ambiente.Hospital;
import geral.PosicaoXY;

public class AgenteHospital{
	
	private final Hospital hospital;//Variavel do tipo hospital e final, não poderá ser usada em outro método.
	private MovimentosAgenteHospital movimento;//Variavel do tipo MovimentosAgenteHospital.
	
	private PosicaoXY posXY;//Variavel do tipo PosicaoXY.
	
	private int pilhaMovimentos;//Variavel para saber quantos movimentos o agente fez.

	public AgenteHospital(Hospital hospital){//Construtor recebendo um hospital por parâmetro.
		this.hospital = hospital;//Atribuindo um valor a variavel hospital de outra variavel recebida por parâmetro.
		hospital.setAgente(this);//Mandando um agentehospital para classe hospital
		this.posXY = new PosicaoXY();//criando uma nova posição para o agente, esta posição será 0.
		this.movimento = MovimentosAgenteHospital.CIMA;//Inicializando o movimento do agente com CIMA.
	}
	
	public void movimentar(){
		if (this.pilhaMovimentos >= 4){
			return;
		}
		PosicaoXY proximoMovimento = retornarMovimento();//Retorna o movimento atualizado do agente para a variavél proximoMovimento
		String valor = this.hospital.retornarValorPosicaoHospital(proximoMovimento);//Atribui a variavél valor a nova posição do agente, mandando a posição como parâmetro
		if (valor.equals("PL") || valor.equals("*DO*")) {//Se o valor for atribuido a variavél "valor" for igual a PL ou *DO*
			proximoMovimento();//Chamada do método para atualizar a posição do agente
			aumentarPilha();
			movimentar();//Fazendo o uso da recursividade pois existe local para o agente se movimentar ainda
		} else {
			this.hospital.limpar();//Chamada do método para limpar os pacientes com problemas
			this.posXY = proximoMovimento;//Retornando a posição atualizada do agente para a variavel posXY que determina a posição do agente
		}
	}
	
	private void aumentarPilha(){
		this.pilhaMovimentos++;
	}

	private void proximoMovimento(){
		switch(this.movimento){
                        case CIMA:
				this.movimento = MovimentosAgenteHospital.BAIXO;
				break;
			case BAIXO:
				this.movimento = MovimentosAgenteHospital.ESQUERDA;
				break;
			case ESQUERDA:
				this.movimento = MovimentosAgenteHospital.DIREITA;
				break;
			case DIREITA:
				this.movimento = MovimentosAgenteHospital.CIMA;
				break;
		}
	}
	public PosicaoXY retornarMovimento(){
		int retornoPosX = this.posXY.getPosX();
		int retornoPosY = this.posXY.getPosY();
		switch(movimento){
			case CIMA:
				if (retornoPosX > 0){//se não esta no canto pela posição X
					retornoPosX -= 1;
				}
				break;
			case BAIXO:
				if (retornoPosX < this.hospital.getTamanhoHospital() - 1){//se for menor que o tamanho do hospital menos 1 entao ele aumentará o hospital pela posição X
					retornoPosX += 1;
				}
				break;
			case ESQUERDA:
				if (retornoPosY > 0){//se não esta no canto pela posição Y
					retornoPosY -= 1;
				}
				break;
			case DIREITA:
				if (retornoPosY < this.hospital.getTamanhoHospital() - 1){//se for menor que o tamanho do hospital menos 1 entao ele aumentará o hospital pela posição Y
					retornoPosY += 1;
				}
				break;
		}
		return new PosicaoXY(retornoPosX, retornoPosY);//atualizando a posiçao do agente no hospital
	}

	public PosicaoXY getPosicao(){
		return this.posXY;
	}

	public boolean isAindaLimpando(){
		return pilhaMovimentos < 4;
	}

	public void zerarPilha(){
		this.pilhaMovimentos = 0;
	}

	public void setPosicao(PosicaoXY posicaoXY){
		this.posXY = posicaoXY;
        }
}