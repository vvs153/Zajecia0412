package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Contractor;

public class UpdateContractor implements Command{
    private DataAccessObject<Contractor> dao = new DataAccessObject<>();

    public UpdateContractor() {
        this.dao = new DataAccessObject<>();
    }

    @Override
    public String getCommand() {
        return "Aktualizuj kontrahenta";
    }

    @Override
    public void service() {
        System.out.println("Podaj id kontrahenta");
        String idString = Command.scanner.nextLine();
        Long id = Long.parseLong(idString);
        if(!dao.exists(Contractor.class,id)){
            System.err.println("Nie ma kontrahenta o takim id");
            return;
        }
        System.out.println("Podaj nazwe kontrahenta");
        String name = Command.scanner.nextLine();
        System.out.println("Podaj nip kontrahenta");
        String nip = Command.scanner.nextLine();
        System.out.println("Podaj adres kontrahenta");
        String adress = Command.scanner.nextLine();

        Contractor contractor = Contractor.builder()
                .id(id)
                .adres(adress)
                .name(name)
                .nip(nip)
                .build();
        dao.update(Contractor.class,id,contractor);
    }
}
