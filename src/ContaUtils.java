import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ContaUtils {
	
	/**
	 * Atributo de instancia Singleton
	 */
	private static ContaUtils instance;
	
	/**
	 * Construtor privado para Singleton
	 */
	private ContaUtils(){}
	
	/**
	 * @return
	 */
	public static ContaUtils getInstance(){
		if(instance==null){
			instance = new ContaUtils();
		}
		return instance;
	}
	
	public File getArquivoTxt() throws IOException{
		File arquivo = new File("/home/lcunha/conta.txt");
		
		if(!arquivo.exists()){
			arquivo.createNewFile();
			gravaConteudoBase(arquivo);
		}
		
		return arquivo;
	}
	
	private void gravaConteudoBase(File arquivo){
		try {
			FileWriter writer = new FileWriter(arquivo, true);
			writer.write("0001\n");
			writer.write("14564-2,1234,100;11223-2,6757,100;11234-7,5758,210.22;39393-8,4040,200.30\n");
			writer.write("0002\n");
			writer.write("33345-1,2323,200;33222,6757,400;44444-3,6859,4500;11234-5,3333,4150.50\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
