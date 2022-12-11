package Faktura.Commands;

import Faktura.database.DataAccessObject;

import Faktura.model.Contractor;

import java.util.List;

public class ListContractor implements Command{
    private DataAccessObject<Contractor> dataAccessObject;
    public ListContractor(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista kontrahentow";
    }

    @Override
    public void service() {
        List<Contractor> contractors = dataAccessObject.findAll(Contractor.class);
        contractors.forEach(System.out::println);
    }
}
