package entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends SuperID {

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private List<Booking> bookings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(address, client.address) && Objects.equals(bookings, client.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, phoneNumber, address, bookings);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", bookings=" + bookings +
                '}';
    }
}
