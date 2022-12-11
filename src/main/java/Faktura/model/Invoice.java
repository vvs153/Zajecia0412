package Faktura.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNr;
    @CreationTimestamp
    private LocalDate addDate;
    private LocalDate paymentDate;
    private Double sum;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Company company;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contractor contractor;

    @OneToMany(mappedBy = "invoice")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Payment> paymentSet;
}
