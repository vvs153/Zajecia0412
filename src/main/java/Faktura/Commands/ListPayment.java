package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Invoice;
import Faktura.model.Payment;

import java.util.List;

public class ListPayment implements Command{
    private DataAccessObject<Payment> dataAccessObject;
    public ListPayment(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista platnosci";
    }

    @Override
    public void service() {
        List<Payment> payments = dataAccessObject.findAll(Payment.class);
        payments.forEach(System.out::println);
    }
}
