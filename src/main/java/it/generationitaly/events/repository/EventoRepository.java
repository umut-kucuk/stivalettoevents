package it.generationitaly.events.repository;

import java.util.Date;
import java.util.List;
import it.generationitaly.events.entity.Evento;


public interface EventoRepository extends JpaRepository<Evento, Integer> {

	List<Evento> findByTagId(int id);

	List<Evento> findByNome(String searchTerm);

	List<Evento> findByCitta(String citta);

	List<Evento> findByGratuito(boolean gratuito);

	List<Evento> findByDataBetween(Date date1, Date date2);
	
	List<Evento> findEventi1(int id, String citta);
	
	List<Evento> findByNomeAndCitta(String nome, String citta);
	
	List<Evento> findByCittaAndGratuito(String citta, boolean gratuito);

	List<Evento> findByCittaDateBetween (String citta, Date date1, Date date2);
	
	List<Evento> findEventi2(int id, String nome);
	
	List<Evento> findByTagIdAndGratuito (int id, boolean gratuito);
	
	List<Evento> findByTagIdAndDataBetween(int id, Date date1, Date date2);
	
	List<Evento> findByNomeAndDataBetween(String searchterm, Date date1, Date date2);
	
	List<Evento> findByNomeAndTagIdAndCittaAndGratuitoAndDataBetween(String searchterm, int id, String citta, boolean gratuito, Date date1, Date date2);
	
	List<Evento> findByCittaAndTagEventoAndDataBetween(String citta, int id, Date date1, Date date2);

}
