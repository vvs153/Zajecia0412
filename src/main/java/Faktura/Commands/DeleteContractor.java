package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Contractor;

public class DeleteContractor implements Command{
    private DataAccessObject<Contractor> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Usun kontrahenta";
    }

    @Override
    public void service() {
        System.out.println("Podaj id usuwango kontrahenta");
        String id = scanner.nextLine();
        Long contId = Long.parseLong(id);
        if(dao.delete(Contractor.class,contId)){
            System.out.println("Usunieto kontrahenta");
        } else {
            System.err.println("Nie znalezniono kontrahenta");
        }

    }
}
