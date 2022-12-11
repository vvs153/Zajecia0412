package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;

public class AddCompany implements Command{
    private DataAccessObject<Company> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Dodaj firme";
    }

    @Override
    public void service() {
        System.out.println("Podaj nazwe firmy");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj nip firmy");
        String nip = Command.scanner.nextLine();
        System.out.println("Podaj adres firmy");
        String adress = Command.scanner.nextLine();

        Company company = Company.builder()
                .adres(adress)
                .name(name)
                .nip(nip)
                .build();
        dao.insert(company);
    }
}
