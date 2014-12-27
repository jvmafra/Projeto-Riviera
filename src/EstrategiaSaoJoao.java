
public class EstrategiaSaoJoao implements EstrategiaCobranca{
	
	public static final double FATOR = 1.1;
	public static final double FATOR_ESPECIAL = 1.5;
	private boolean diaEspecial;
	
	public EstrategiaSaoJoao (boolean diaEspecial){
		this.diaEspecial = diaEspecial;
	}
	
	private boolean isDiaEspecial(){
		return diaEspecial;
	}
	
	@Override
	public double getFator(){
		if (isDiaEspecial())
			return FATOR_ESPECIAL;
		else
			return FATOR;
	}
	
}
