import java.io.IOException;


public class Principal {

	public static void main(String[] args) {
		ContaDAO CONTA_DAO = ContaDAO.getInstance();
		//ContaUtils CONTA_UTILS = ContaUtils.getInstance();
		
		try {
			//EXEMPLO DE COMO CHAMAR O METODO PARA VALIDAR O USUARIO
			System.out.println(CONTA_DAO.verficaConta("0001", "14564-2", "1234"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
