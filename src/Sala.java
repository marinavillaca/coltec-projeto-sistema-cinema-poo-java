/* Trabalho Final - Cinema
 * Aluna: Marina Laura Villaça e Melo
 * Disciplina: POO - Coltec
 * Prof: Leandro Maia
*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sala implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String nomeSala;
    protected int capacidade;
    protected Cinema cinema;
    private List<Sessao> sessoes; // Lista para armazenar sessões 

    // Construtor
    public Sala(String nomeSala, int capacidade, Cinema cinema) {
        this.nomeSala = nomeSala;
        this.capacidade = capacidade;
        this.cinema = cinema;
        this.sessoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    private int gerarId_random() {
        Random random = new Random();
        return random.nextInt(9000) + 1000; // Gera ID aleatório para a Sessão
    }

    // Método para criar e adicionar Sessão (substitui o método adicional adicionaSessao() ) 
    public void criarSessao(Filme filme, String data, String horario, Cinema cinema) {
    	
        int idSessao = gerarId_random();
        Sessao novaSessao = new Sessao(idSessao, filme, data, horario);
        sessoes.add(novaSessao);
    }

    public void listarSessoes() {
        if (sessoes.isEmpty()) {
            System.out.println("\nNão há sessões disponíveis para a sala " + nomeSala + ".");
        } 
        
        else {
            System.out.println("\nSessões da " + nomeSala + ":");
            for (Sessao sessao : sessoes) {
                System.out.println("ID: " + sessao.getIdSessao() + " | Filme: " + sessao.getFilme().getNomeFilme() +
                                   " | Data: " + sessao.getData() + " | Horário: " + sessao.getHorario());
            }
        }
    }
    
    private class Sessao implements Serializable {
        private static final long serialVersionUID = 1L;

        private int idSessao;
        private Filme filme;
        private String data;
        private String horario;

        public Sessao(int idSessao, Filme filme, String data, String horario) {
            this.idSessao = idSessao;
            this.filme = filme;
            this.data = data;
            this.horario = horario;
        }

        public int getIdSessao() {
            return idSessao;
        }

        public Filme getFilme() {
            return filme;
        }

        public String getData() {
            return data;
        }

        public String getHorario() {
            return horario;
        }
    }
}
