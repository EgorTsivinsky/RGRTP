package entity;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking extends SuperID {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Product")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "booking_date")
    private String booking_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booking booking = (Booking) o;
        return quantity == booking.quantity && Objects.equals(booking_date, booking.booking_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, booking_date);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "quantity=" + quantity +
                ", booking_date='" + booking_date + '\'' +
                '}';
    }
}
