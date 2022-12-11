package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Contractor;

public class AddContractor implements Command{
    private DataAccessObject<Contractor> dao = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Dodaj kontrahenta";
    }

    @Override
    public void service() {
        System.out.println("Podaj nazwe kontrahenta");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj nip kontrahenta");
        String nip = Command.scanner.nextLine();
        System.out.println("Podaj adres kontrahenta");
        String adress = Command.scanner.nextLine();

        Contractor contractor = Contractor.builder()
                .adres(adress)
                .name(name)
                .nip(nip)
                .build();
        dao.insert(contractor);
    }
}
