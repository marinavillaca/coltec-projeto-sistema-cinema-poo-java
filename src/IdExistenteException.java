/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

// Não devem existir dois cinemas com o mesmo identificador.

public class IdExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public IdExistenteException(String mensagem) {
        super(mensagem);
    }
}