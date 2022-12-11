package Faktura.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double sum;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @CreationTimestamp
    private LocalDate realisationDate;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Invoice invoice;


}
