package it.generationitaly.events.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 45, nullable = false)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Date data;

	@Column(name = "citta", length = 45, nullable = false)
	private String citta;

	@Column(name = "descrizione", length = 3000, nullable = false)
	private String descrizione;

	@Column(name = "descrizione_card", length = 500, nullable = false)
	private String descrizioneCard;

	@Column(name = "indirizzo", length = 45, nullable = false)
	private String indirizzo;

	@Column(name = "immagine", length = 3000, nullable = false)
	private String immagine;

	@Column(name = "gratuito", nullable = false)
	private boolean gratuito;

	@Column(name = "prezzo", nullable = false)
	private double prezzo;

	@ManyToOne
	@JoinColumn(name = "tag_evento_id", nullable = false)
	private TagEvento tagEvento;

	@OneToMany(mappedBy = "evento")
	private List<Prenotazione> prenotazione = new ArrayList<Prenotazione>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDescrizioneCard() {
		return descrizioneCard;
	}

	public void setDescrizioneCard(String descrizioneCard) {
		this.descrizioneCard = descrizioneCard;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public boolean isGratuito() {
		return gratuito;
	}

	public void setGratuito(boolean gratuito) {
		this.gratuito = gratuito;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public TagEvento getTagEvento() {
		return tagEvento;
	}

	public void setTagEvento(TagEvento tagEvento) {
		this.tagEvento = tagEvento;
	}

	public List<Prenotazione> getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(List<Prenotazione> prenotazione) {
		this.prenotazione = prenotazione;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", data=" + data + ", citta=" + citta + ", descrizione="
				+ descrizione + ", descrizioneCard=" + descrizioneCard + ", indirizzo=" + indirizzo + ", immagine="
				+ immagine + ", gratuito=" + gratuito + ", prezzo=" + prezzo + "]";
	}

}
