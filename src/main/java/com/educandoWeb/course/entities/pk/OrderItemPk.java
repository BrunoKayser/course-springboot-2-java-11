package com.educandoWeb.course.entities.pk;

import com.educandoWeb.course.entities.Order;
import com.educandoWeb.course.entities.Product;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Podia ser simplismente @EqualsAndHashCode que ele ja faz para os dois atributos a comparação
@EqualsAndHashCode(of = {"order", "product"})
@Embeddable
public class OrderItemPk implements Serializable {
    private static final long serialVersionUUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
