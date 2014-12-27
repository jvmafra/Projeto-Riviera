public class Hospede {
	private String nome, CPF, RG, email, endereco;
	private int telefone;
	
	public Hospede(String nome, String CPF, String RG, String email, int telefone, String endereco) throws Exception{
		if(nome.equals("") || nome.equals(null))
			throw new Exception("nome inválido");
		
		if(CPF.equals("") || CPF.equals(null) || CPF.length() != 11)
			throw new Exception("CPF inválido");
		
		if(RG.equals("") || RG.equals(null))
			throw new Exception("RG inválido");
		
		if(email.equals("") || email.equals(null))
			throw new Exception("e-mail inválido");
		
		if(endereco.equals("") || endereco.equals(null))
			throw new Exception("endereço inválido");
		
		if(telefone == 000000000)
			throw new Exception("telefone inválido");
		
	this.nome = nome;
	this.CPF = CPF;
	this.email= email;
	this.telefone = telefone;
	this.endereco = endereco;
	this.RG = RG;
	
	}

	public int getTelefone() {
		return telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getCPF() {
		return CPF;
	}

	public String getRG() {
		return RG;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public void setRG(String rg) {
		RG = rg;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Nome: " + getNome() + "\nCPF: " + getCPF()
				+ "\nRG: " + getRG() + "\nEmail: " + getEmail() + "\nEndereco: " + getEndereco()
				+ "\nTelefone: " + getTelefone();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Hospede))
			return false;
		Hospede h1 = (Hospede) obj;
		
		return getNome().equals(h1.getNome()) && getCPF().equals(h1.getCPF()) && RG.equals(h1.getRG())
				&& endereco.equals(h1.getEndereco());
	}

}
