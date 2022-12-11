package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Invoice;

public class DeleteInvoice implements Command{
    private DataAccessObject<Invoice> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Usun fakture";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanej faktury");
        String id = scanner.nextLine();
        Long compId = Long.parseLong(id);
        if(dao.delete(Invoice.class,compId)){
            System.out.println("Usunieto fakture");
        } else {
            System.err.println("Nie znalezniono faktury");
        }

    }
}
