package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;

public class UpdateCompany implements Command{
    private DataAccessObject<Company> dao = new DataAccessObject<>();

    public UpdateCompany() {
        this.dao = new DataAccessObject<>();
    }

    @Override
    public String getCommand() {
        return "Aktualizuj firme";
    }

    @Override
    public void service() {
        System.out.println("Podaj id firmy");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        if(!dao.exists(Company.class,id)){
            System.err.println("Nie ma firmy o takim id");
            return;
        }
        System.out.println("Podaj nazwe firmy");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj nip firmy");
        String nip = Command.scanner.nextLine();
        System.out.println("Podaj adres firmy");
        String adress = Command.scanner.nextLine();

        Company company = Company.builder()
                .id(id)
                .adres(adress)
                .name(name)
                .nip(nip)
                .build();
        dao.update(Company.class,id,company);
    }
}
