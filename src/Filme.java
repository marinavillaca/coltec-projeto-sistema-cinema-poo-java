/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.io.Serializable;

public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idFilme;
	private String nomeFilme;
	private long duracao_s; // em segundos
	private String diretorFilme;
	private String genero;
	private String classificacao;
	
	public Filme(int idFilme, String nomeFilme, long duracao_s, String diretorFilme){
		this.idFilme = idFilme;
		this.nomeFilme = nomeFilme;
		this.duracao_s = duracao_s;
		this.diretorFilme = diretorFilme;
		this.classificacao = "18 anos.";
		this.genero = "Ação";
	}
	
    public Filme(String nomeFilme, String classificacao) {
        this.nomeFilme = nomeFilme;
        this.classificacao = classificacao;
    }
	
	public int getIdFilme() {
		return idFilme;
	}
	
	public String getNomeFilme() {
		return nomeFilme;
	}
	
	public long getDuracao_s() {
		return duracao_s;
	}
	
	public String getDiretorFilme() {
		return diretorFilme;
	}
	
	public String getClassificacao() {
		return classificacao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}
	
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	public void setDuracao_s(long duracao_s) {
		this.duracao_s = duracao_s;
	}
	
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setDiretorFilme(String diretorFilme) {
		this.diretorFilme = diretorFilme;
	}
	
	/** Métodos **/
	// Formata hora em segundos para padrao Hora:minutos
    public String getDuracaoFormatada() {
        long horas = duracao_s / 3600;
        long minutos = (duracao_s % 3600) / 60;
        return String.format("%02d:%02d", horas, minutos);
    }
	    
	void infoFilme() {
		System.out.println("ID-Filme: " + getIdFilme() +
				"| Nome: " + getNomeFilme() + "| Diretor: " + getDiretorFilme() + 
				"| Duração: " + getDuracaoFormatada() + "\nGênero: " + getGenero() + "| Classificação: " + getClassificacao() + "\n");
	}
	
	// Método que verifica se uma pessoa de determinada idade pode assistir ao filme
	public boolean podeAssistirFilme(int idade) {
	    if (classificacao.equals("Livre")) {
	        return true;
	    } 
	    
	    else if (classificacao.equals("10 anos")) {
	        return idade >= 10;
	    } 
	    
	    else if (classificacao.equals("12 anos")) {
	        return idade >= 12;
	    } 
	    
	    else if (classificacao.equals("14 anos")) {
	        return idade >= 14;
	    } 
	    
	    else if (classificacao.equals("16 anos")) {
	        return idade >= 16;
	    } 
	    
	    else if (classificacao.equals("18 anos")) {
	        return idade >= 18;
	    } 
	    
	    else {
	        System.out.println("Classificação desconhecida: " + classificacao);
	        return false;
	    }
	}	
}