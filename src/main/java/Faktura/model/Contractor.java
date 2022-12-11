package Faktura.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nip;
    private String adres;
    @OneToMany(mappedBy = "contractor")
    @ToString.Exclude
    Set<Invoice> invoiceSet;
}
