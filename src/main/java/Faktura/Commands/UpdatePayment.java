package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Contractor;
import Faktura.model.Payment;
import Faktura.model.PaymentMethod;

import java.time.LocalDate;
import java.util.Optional;

public class UpdatePayment implements Command{
    private DataAccessObject<Payment> dao = new DataAccessObject<>();

    public UpdatePayment() {
        this.dao = new DataAccessObject<>();
    }

    @Override
    public String getCommand() {
        return "Aktualizuj platnosc";
    }

    @Override
    public void service() {
        System.out.println("Podaj id platnosci");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        if(!dao.exists(Payment.class,id)){
            System.err.println("Nie ma platnosci o takim id");
            return;
        }
        Optional<Payment> originalPayment = dao.find(Payment.class, id);
        System.out.println("Podaj kwote");
        String sumString = Command.scanner.nextLine();
        Double sum = Double.parseDouble(sumString);
        System.out.println("Podaj rodzaj platnosci");
        String paymentMethodString = scanner.nextLine().toUpperCase();
        PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodString);


        Payment payment = Payment.builder()
                .id(id)
                .paymentMethod(paymentMethod)
                .realisationDate(originalPayment.get().getRealisationDate())
                .sum(sum)
                .build();
        dao.update(Payment.class,id,payment);
    }
}
