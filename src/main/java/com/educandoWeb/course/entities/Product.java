package com.educandoWeb.course.entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table (name = "tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private Double price;

    @Setter
    private String imgUrl;

    //Set representa um conjunto, com isso não tenho um produto com a mesma categoria mais de uma vez
    //Ou seja, quando o set não vai deixar ser adicionado categorias com o mesmo ID
    @Transient//Comando para o java ignorar o conteúdo deste atributo
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }


}
