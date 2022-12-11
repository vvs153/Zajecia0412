package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;

import java.util.List;

public class ListCompany implements Command{
    private DataAccessObject<Company> dataAccessObject;
    public ListCompany(){
        this.dataAccessObject = new DataAccessObject<>();
    }
    @Override
    public String getCommand() {
        return "Lista firm";
    }

    @Override
    public void service() {
        List<Company> companies = dataAccessObject.findAll(Company.class);
        companies.forEach(System.out::println);
    }
}
