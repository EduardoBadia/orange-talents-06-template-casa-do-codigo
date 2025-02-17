package br.com.zupacademy.eduardo.casadocodigo.controller.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.eduardo.casadocodigo.config.anotacao.UniqueValue;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Autor;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Categoria;
import br.com.zupacademy.eduardo.casadocodigo.modelo.Livro;

public class NovoLivroRequest {

	@NotBlank
	@UniqueValue(domainClass = Livro.class,fieldName = "titulo")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class,fieldName = "isbn")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	private Long idCategoria;
	@NotNull
	private Long idAutor;

	public NovoLivroRequest(@NotBlank String titulo,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotNull @Min(20) BigDecimal preco, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/*
	 * criei esse setter pq o jackson não estava sendo capaz de desserializar o
	 * json com a data no parâmetro pelo construtor. Talvez exista um jeito
	 * melhor, mas neste momento que vos escrevo, não sei.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		/*
		 * A mensagem de Assert.state só é retornada caso autor ou categoria forem nulos. 
		 * Caso contrário, o fluxo do programa segue.
		 */
		
		Assert.state(Objects.nonNull(autor),"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+idAutor);
		Assert.state(Objects.nonNull(categoria),"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
				dataPublicacao, autor, categoria);
	}
}	