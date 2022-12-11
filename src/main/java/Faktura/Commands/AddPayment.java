package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Invoice;
import Faktura.model.Payment;
import Faktura.model.PaymentMethod;

import java.util.Optional;

public class AddPayment implements Command{
    private DataAccessObject<Payment> dao = new DataAccessObject<>();
    private DataAccessObject<Invoice> daoInvoice = new DataAccessObject<>();

    public AddPayment() {
        this.dao = new DataAccessObject<>();
        this.daoInvoice = new DataAccessObject<>();
    }

    @Override
    public String getCommand() {
        return "Dodaj platnosc";
    }

    @Override
    public void service() {
        System.out.println("Podaj id faktury");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<Invoice> optionalInvoice = daoInvoice.find(Invoice.class, id);
        if(optionalInvoice.isEmpty()){
            System.err.println("Nr faktury nie istnieje");
            return;
        }

        System.out.println("Podaj kwote");
        String sumString = Command.scanner.nextLine();
        Double sum = Double.parseDouble(sumString);
        System.out.println("Podaj rodzaj platnosci");
        String paymentMethodString = scanner.nextLine().toUpperCase();
        PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodString);


        Payment payment = Payment.builder()
                .invoice(optionalInvoice.get())
                .sum(sum)
                .paymentMethod(paymentMethod)
                .build();


        dao.insert(payment);
    }
}
