package br.com.fuctura.biblioteca.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class LivroDto {
    private Integer id;

    @Length(min = 3, max = 20)
    @NotBlank(message = "O campo  título é Requerido ")
    private String titulo;

    @Length(min = 3, max = 20)
    @NotBlank(message = "O campo  Autor é Requerido")
    private String autor;

    public LivroDto(){

    }


    public LivroDto(Integer id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
