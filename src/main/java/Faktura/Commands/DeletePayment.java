package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Payment;

public class DeletePayment implements Command{
    private DataAccessObject<Payment> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Usun platnosc";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanej platnosci");
        String id = scanner.nextLine();
        Long compId = Long.parseLong(id);
        if(dao.delete(Payment.class,compId)){
            System.out.println("Usunieto platnosc");
        } else {
            System.err.println("Nie znalezniono platnosci");
        }

    }
}
