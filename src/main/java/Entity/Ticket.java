package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


    @Data
    @Entity
    @Table(name="ticket")
    public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client clientId;

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "from_planet_id")
        private Planet fromPlanet;

        @ManyToOne
        @JoinColumn(name = "to_planet_id")
        private Planet toPlanet;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreated_at() {
        return createdAt;
    }

    public void setCreated_at(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Client getClient() {
        return clientId;
    }

        public void setClient(Client clientId) {
            this.clientId = clientId;
        }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setTo_planet_id(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }
}
