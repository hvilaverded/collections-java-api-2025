package map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }
    public void adicionarEventos(LocalDate data,String nome,String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data,evento);

    }
    public void exibirEventos(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        System.out.println(eventosTreeMap);
    }
    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventoMap);
        for (Map.Entry<LocalDate, Evento> entry: eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual)|| entry.getKey().isAfter(dataAtual)){
                System.out.println("O proximo evento: " + entry.getValue() + " acontecerá na data "+ entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();
        System.out.println(LocalDate.now());

        // Adiciona eventos à agenda
        agendaEventos.adicionarEventos(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
        agendaEventos.adicionarEventos(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
        agendaEventos.adicionarEventos(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
        agendaEventos.adicionarEventos(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
        agendaEventos.adicionarEventos(LocalDate.of(2025, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

        // Exibe a agenda completa de eventos
        agendaEventos.exibirEventos();

        // Obtém e exibe o próximo evento na agenda
        agendaEventos.obterProximoEvento();
    }
}
