package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Contractor;
import Faktura.model.Invoice;

import java.util.List;

public class ListInvoice implements Command{
    private DataAccessObject<Invoice> dataAccessObject;
    public ListInvoice(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista faktur";
    }

    @Override
    public void service() {
        List<Invoice> invoices = dataAccessObject.findAll(Invoice.class);
        invoices.forEach(System.out::println);
    }
}
