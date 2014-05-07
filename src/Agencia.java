import java.util.List;


public class Agencia {
	private String numero;
	
	//UMA AGENCIA POSSUI VARIAS CONTAS
	//USEI List POIS E SEMPRE MELHOR USAR AS CLASSES MAIS ALTAS DA ABSTRACAO (INTERFACES E CLASSES ABSTRATAS)
	private List<Conta> contas;

		
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the contas
	 */
	public List<Conta> getContas() {
		return contas;
	}

	/**
	 * @param contas the contas to set
	 */
	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Agencia other = (Agencia) obj;
		boolean retorno = false;
		
		if (contas == null) {
			if (other.contas != null)
				retorno = false;
		}else{
			//PERCORRENDO AS CONTAS PARA VERIFICAR SE ELAS BATEM
			for(int i = 0 ; i < contas.size(); i++){
				if(other.contas.contains(contas.get(i))){
					retorno = true;
				}
			}
		}
		
		if (numero == null) {
			if (other.numero != null)
				retorno = false;
		} else if (!numero.equals(other.numero))
			retorno = false;
		retorno = true;
		
		return retorno;
	}
	
	
	
}
