package entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product extends SuperID{

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Booking> bookings;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Delivery> deliveries;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(bookings, product.bookings) && Objects.equals(deliveries, product.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, price, description, bookings, deliveries);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", bookings=" + bookings +
                ", deliveries=" + deliveries +
                '}';
    }
}
