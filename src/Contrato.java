import java.util.Iterator;
import java.util.List;

/**
 * Manipula um contrato de um hotel associado a um hospede.
 * @author Joao Victor Barroso Mafra
 */

public class Contrato {
	private Hospede hospede;
	private List<Servicos> servicos;
	private EstrategiaCobranca e;
	private String formaDePagamento;
	private int periodo;
	private boolean aberto;
	
	/**
	 * Cosntrutor que recebe as informacoes necessarias para criacao de um contrato
	 * @param servicos
	 * 			Recebe uma lista de servicos (obrigatoriamente um quarto no minimo) ou outros servicos contratados no momento do cadastro
	 * @param hospede
	 * 			Recebe todas as informacoes a respeito de um hospede
	 * @param e
	 * 			Recebe uma estrategia de cobranca que dependera do periodo do cadastro do hospede
	 * @param periodo
	 * 			Recebe o periodo de hospedagem
	 * @param formaDePagamento
	 * 			Recebe a forma de pagamento do hospede
	 */
	public Contrato (List<Servicos> servicos, Hospede hospede, EstrategiaCobranca e, int periodo, String formaDePagamento) throws Exception{
		if (periodo <= 0)
			throw new Exception("Periodo invalido");
		
		if (formaDePagamento.equals("") || formaDePagamento == null)
			throw new Exception("Forma de pagamento invalida");
		
		this.hospede = hospede;
		this.servicos = servicos;
		this.e = e;
		this.formaDePagamento = formaDePagamento;
		this.periodo = periodo;
		
		aberto = true;
	}
	
	/**
	 * Retorna a estrategia atual de cobranca
	 */
	public EstrategiaCobranca getEstrategia() {
		return e;
	}
	
	/**
	 * Modifica a estrategia atual de cobranca
	 * @param e
	 * 			A nova estrategia
	 */
	public void setE(EstrategiaCobranca e) {
		this.e = e;
	}
	
	/**
	 * Retorna a forma de pagamento atual do cliente
	 */
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	
	/**
	 * Modifica a forma de pagamento
	 * @param formaDePagamento
	 * 			A nova forma de pagamento
	 */
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	/**
	 * Retorna a lista atual de servicos presentes no contrato
	 */
	public List<Servicos> getServicos() {
		return servicos;
	}
	
	/**
	 * Retorna o periodo da estadia
	 * @return periodo
	 * 			Periodo da estadia do hospede
	 */
	public int getPeriodo() {
		return periodo;
	}
	
	/**
	 * Adiciona um novo servico a lista de servicos do hospede
	 * @param servico
	 * 			Um novo servico a ser adicionado
	 */
	public void adicionaServico(Servicos servico) throws Exception{
		if (!(isAberto()))
			throw new Exception("O contrato ja foi fechado");
		
		servicos.add(servico);
	}
	
	/**
	 * Verifica se o contrato esta aberto ou fechado
	 * @return aberto
	 * 			True se o contrato estiver aberto ou False caso contrario
	 */
	public boolean isAberto(){
		return aberto;
	}
	
	/**
	 * Modifica o status do contrato. De fechado para aberto ou vice-versa
	 */
	public void setStatus(){
		if (isAberto())
			aberto = false;
		else
			aberto = true;
	}
	
	/**
	 * Calcula o valor de todos os servicos usados pelo hospede (Quarto e servicos especiais)
	 * @return soma
	 * 			O somatorio do valor de todos os servicos
	 */
	public double calculaValorServicos(){
		double soma = 0;
		Iterator<Servicos> it = servicos.iterator();
		while(it.hasNext()) {
			Servicos umServico = it.next();
			soma += umServico.valor();		
		}
		
		return soma;
	}
	
	/**
	 * Calcula o valor de todos os servicos usando a estrategia de cobranca, que depende do periodo
	 */
	public double calculaValorTotal(){
		return calculaValorServicos() * getEstrategia().getFator();
	}
	
	/**
	 * Retorna o objeto hospede
	 */
	public Hospede getHospede(){
		return hospede;
	}
	
	/**
	 * Retorna o telefone do hospede
	 */
	public int getTelefone() {
		return hospede.getTelefone();
	}
	
	/**
	 * Retorna o nome do hospede
	 */
	public String getNome() {
		return hospede.getNome();
	}
	
	/**
	 * Retorna o CPF do hospede
	 */
	public String getCPF() {
		return hospede.getCPF();
	}
	
	/**
	 * Retorna o RG do hospede
	 */
	public String getRG() {
		return hospede.getRG();
	}
	
	/**
	 * Retorna o email do hospede
	 */
	public String getEmail() {
		return hospede.getEmail();
	}
	
	/**
	 * Retorna o endereco do hospede
	 */
	public String getEndereco() {
		return hospede.getEndereco();
	}
	
	/**
	 * Imprime o status do quarto
	 * @return Status
	 * 			Retorna a string ABERTO ou FECHADO
	 */
	private String mostraStatus(){
		if (isAberto())
			return "ABERTO";
		else
			return "FECHADO";
	}
	
	/**
	 * Imprime todos os servicos especiais consumidos que constara na fatura final
	 */
	private String imprimeCadaServicoEspecial(){
		String servicosEspeciais = "-";
		for (int i = 1; i < servicos.size(); i++) {
			servicosEspeciais += "\n\n" + servicos.get(i).toString();
		}
		
		return servicosEspeciais;
	}
	
	/**
	 * Imprime a fatura final com todas as caracteristicas da hospedagem
	 * @return String
	 * 			Contem as informacoes do hospede, o quarto, todos servicos usados e seu valor total, alem do valor final da estadia, a forma de pagamento e o status atual do contrato
	 */
	public String imprimeFaturaFinal(){
		return hospede.toString() + servicos.get(0).toString()
				+ "\nServicos especiais (pela ordem): " + imprimeCadaServicoEspecial()
				+ "\nValor total dos servicos: " + calculaValorServicos() 
				+ "\n\nValor total da estadia: " + calculaValorTotal()
				+ "\nForma de pagamento: " + getFormaDePagamento()
				+ "\n\nStatus do contrato: " + mostraStatus();
	}
	
	/**
	 * Verifica um contrato atualmente. Como sera usado apenas para rapida verificacao nao contem informacoes de pagamento (apenas em relacao ao quarto ,que e fixo)
	 * @return String
	 * 			Contem as informacoes do hospede, o periodo, o quarto e o statis
	 */
	@Override
	public String toString(){
		return hospede.toString()
				+ "\nPeriodo da hospedagem: " + getPeriodo() 
				+ servicos.get(0).toString()
				+ "Status do contrato: " + mostraStatus();
	}
	
	/**
	 * Verifica se dois contratos sao iguais
	 */
	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato c1 = (Contrato) obj;
		
		return getHospede().equals(c1.getHospede()) && isAberto() == c1.isAberto() && calculaValorTotal() == c1.calculaValorTotal();
	}
	
	
}
