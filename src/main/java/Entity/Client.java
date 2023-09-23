package Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Client")
@Data
public class Client {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", length = 200)
    private String name;
}

