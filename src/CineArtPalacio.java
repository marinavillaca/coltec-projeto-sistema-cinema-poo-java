/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

public class CineArtPalacio extends Cinema{
	
	private static final long serialVersionUID = 1L;
	private static CineArtPalacio instance; 	// Instância única para o Singleton

    
    /* Anotação:
     Características principais do Singleton:
	- Apenas uma instância: O Singleton impede que mais de uma instância da classe seja criada.
	- Controle global de acesso: A instância única é acessível de qualquer lugar do programa por meio de um método público, geralmente chamado getInstance().
	- Construtor privado: O construtor da classe é declarado como private para impedir que outros objetos criem instâncias diretamente.

     */
	
    // Valores padrão
    private static final String NOME_PADRAO = "Cine Art Palacio";
    private static final String ID_PADRAO = "0405";
    private static final String LOCAl_PADRAO = "Av. São João, 419 - SP.";
    
    private CineArtPalacio() throws IdExistenteException{
        super(ID_PADRAO, NOME_PADRAO, LOCAl_PADRAO);
    }

    // Método para obter a única instância da classe CineBelasArtes
    public static CineArtPalacio getInstance() throws IdExistenteException {
        if (instance == null) {
            instance = new CineArtPalacio();
        }
        return instance;
    }	
}