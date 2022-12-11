package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;

public class DeleteCompany implements Command{
    private DataAccessObject<Company> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Usun firme";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwanej firmy");
        String id = scanner.nextLine();
        Long compId = Long.parseLong(id);
        if(dao.delete(Company.class,compId)){
            System.out.println("Usunieto firme");
        } else {
            System.err.println("Nie znalezniono firmy");
        }

    }
}
