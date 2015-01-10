/**
 * Classe abstrata que representa
 * um quarto default do Hotel
 * @author Hugo Gabriel
 *
 */
public abstract class Quarto {
	private int numeroDoQuarto;
	private String hospede;
	
	/**
	 * Cria um quarto
	 * @param hospede 	
	 * 		O nome completo do hospede deste quarto
	 * @param numeroDoQuarto
	 * 		O numero relativo ao quarto
	 * @throws Exception
	 * 		O hospede deve ser identificado no minimo com nome e sobrenome
	 * 		O numero do quarto deve ser sempre inteiro positivo
	 */
	public Quarto(String hospede, int numeroDoQuarto) throws Exception{
		if (numeroDoQuarto <= 0)
			throw new Exception("Numero do Quarto invalido");
		if (hospede == null || hospede.split(" ").length < 2)
			throw new Exception("Hospede invalido");
		this.hospede = hospede;
		this.numeroDoQuarto = numeroDoQuarto;		
	}
	
	/**
	 * Busca o numero associado ao quarto
	 * @return
	 * 		O numero do quarto
	 */
	public int getNumeroDoQuarto(){ return numeroDoQuarto;	}
	
	/**
	 * Busca o nome do hospede associado ao quarto
	 * @return
	 * 		O nome do cliente
	 */
	public String getHospede(){ return hospede; }

	/**
	 * Verifica se o quarto comporta um dado numero de pessoas
	 * @param numeroDePessoas
	 * 		Quantidade de pessoas que se deseja hospedar no quarto
	 * @return
	 * 		false, se a capacidade maxima do quarto for excedida
	 * 		true, se o quarto suportar o numero de pessoas desejado
	 */
	public abstract boolean isCapacidadeValida(int numeroDePessoas);

	/**
	 * Fornece uma representacao do quarto como String
	 */
	@Override
	public String toString() {
		return "[Numero do Quarto = " + numeroDoQuarto + ", Hospede = "
				+ hospede + "]";
	}
	
	/**
	 * Verifica se o quarto e um objeto dado como parametro sao iguais
	 * 
	 * Dois objetos da classe Quarto sao iguais se possuem
	 * mesmo numero do quarto e mesmo hospede
	 * @param obj
	 * 		O objeto a ser comparado
	 * @return
	 * 		true, se os objetos forem iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Quarto))
			return false;
		Quarto q = (Quarto) obj;
		return getNumeroDoQuarto()== q.getNumeroDoQuarto() && getHospede().equals(q.getHospede());
	}
	
	

}
