package br.fiap.app.exemplo.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDecolagem;

	@Column(nullable = false)
	private Integer duracaoEstadia;

	@Column(nullable = false)
	private Integer assentosDisponiveis;

	@Column(nullable = false)
	@Pattern(regexp = "[a-z]{4}-\\d{4}")
	private String modeloNave;

	@Column(nullable = false)
	@NotBlank
	private String nomePrimeiroComandante;

	@Column(nullable = false)
	@Pattern(regexp = "[A-Z]{3}\\d{4}-[A-Z]\\d[A-Z]")
	private String matriculaPrimeiroComandante;

	@Column(nullable = false)
	@NotBlank
	private String nomeSegundoComandante;

	@Column(nullable = false)
	@Pattern(regexp = "[A-Z]{3}\\d{4}-[A-Z]\\d[A-Z]")
	private String matriculaSegundoComandante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(LocalDate dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public Integer getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(Integer duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public Integer getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public void setAssentosDisponiveis(Integer assentosDisponiveis) {
		this.assentosDisponiveis = assentosDisponiveis;
	}

	public String getModeloNave() {
		return modeloNave;
	}

	public void setModeloNave(String modeloNave) {
		this.modeloNave = modeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}

}
