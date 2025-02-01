/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

public class CineBelasArtes extends Cinema {
	
	private static final long serialVersionUID = 1L;
	private static CineBelasArtes instance; 	// Instância única para o Singleton

    // Valores padrão
    private static final String NOME_PADRAO = "Cine Belas Artes";
    private static final String ID_PADRAO = "1135";
    private static final String LOCAl_PADRAO = "Rua Gonçalves Dias, 1581 - BH.";
    
    private CineBelasArtes() throws IdExistenteException {
        super(ID_PADRAO, NOME_PADRAO, LOCAl_PADRAO);
    }

    // Método para obter a única instância da classe CineBelasArtes
    
    public static CineBelasArtes getInstance() throws IdExistenteException {
        if (instance == null) {
            instance = new CineBelasArtes();
        }
        return instance;
    }    
}