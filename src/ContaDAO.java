import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


public class ContaDAO {
	
	/**
	 * Atributo de instancia Singleton
	 */
	private static ContaDAO instance;
	
	/**
	 * Construtor privado para Singleton
	 */
	private ContaDAO(){}
	
	/**
	 * @return
	 */
	public static ContaDAO getInstance(){
		if(instance==null){
			instance = new ContaDAO();
		}
		return instance;
	}
	
	/**
	 * Dependencias
	 */
	
	private static final ContaUtils CONTA_UTILS = ContaUtils.getInstance();
	
	
	
	/*public void gravaConta(Conta conta){
		try {
			File arquivo  = CONTA_UTILS.getArquivoTxt();
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	public Boolean verficaConta(String numeroAgencia, String numeroConta, String senha) throws IOException{
		Agencia agencia = new Agencia();
		agencia.setNumero(numeroAgencia);
		List<Conta> contas = new ArrayList<Conta>();
		Conta conta = new Conta();
		conta.setNumero(numeroConta);
		conta.setSenha(senha);
		contas.add(conta);
		agencia.setContas(contas);
		
		//VERIFICANDO SE ESTA AGENCIA E CONTA SE ENCONTRA NO ARQUIVO
		List<Agencia> agenciasContasDoArquivo = getAgenciasArquivo();
		return agenciasContasDoArquivo.contains(agencia);		
	}
	
	/**
	 * @return
	 * @throws IOException
	 */
	private List<Agencia> getAgenciasArquivo() throws IOException{
		File arquivo = CONTA_UTILS.getArquivoTxt();
		List<String> linhas = FileUtils.readLines(arquivo);
		
		List<Agencia> agencias = new ArrayList<Agencia>();
		Integer controlador = new Integer(0);
		for (int i = 0; i < linhas.size(); i++) {
			if(i==0){
				Agencia agencia = new Agencia();
				agencia.setNumero(linhas.get(i));
				agencias.add(agencia);
				controlador = i;
			}else{
				String contas[] = StringUtils.split(linhas.get(i), ';');
				if(contas.length > 1){
					List<Conta> contasAgencia = new ArrayList<Conta>();
					for(int cont = 0; cont < contas.length; cont++){
						String dadosConta[] = StringUtils.split(contas[cont], ',');
						
						if(dadosConta.length == 3){
							Conta conta = new Conta();
							conta.setNumero(dadosConta[0]);
							conta.setSenha(dadosConta[1]);
							conta.setSaldo(dadosConta[2]);
							
							//ADICIONANDO AO ARRAYLIST
							contasAgencia.add(conta);
						}
					}
					
					agencias.get(controlador).setContas(contasAgencia);
				}else{
					Agencia agencia = new Agencia();
					agencia.setNumero(linhas.get(i));
					agencias.add(agencia);
					controlador++;
				}
				
			}
		}
		return agencias;
	}
	
}
