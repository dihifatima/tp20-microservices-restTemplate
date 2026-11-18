package org.emsi.service_voiture.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.emsi.service_voiture.Client;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;    // Marque de la voiture
    private String model;    // Modèle de la voiture
    private String matricule; // Plaque d'immatriculation
    private Long client_id;  // ID du client propriétaire
}
