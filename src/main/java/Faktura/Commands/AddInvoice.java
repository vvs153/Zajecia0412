package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.Company;
import Faktura.model.Contractor;
import Faktura.model.Invoice;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.Optional;

public class AddInvoice implements Command{
    private DataAccessObject<Invoice> dao = new DataAccessObject<>();
    private DataAccessObject<Company> daoCompany = new DataAccessObject<>();
    private DataAccessObject<Contractor> daoContractor = new DataAccessObject<>();
    @Override
    public String getCommand() {
        return "Dodaj fakture";
    }

    @Override
    public void service() {

        System.out.println("Podaj id firmy");
        String idCompanyString = Command.scanner.nextLine();
        Long idCompany = Long.parseLong(idCompanyString);
        Optional<Company> companyOptional = daoCompany.find(Company.class, idCompany);
        if (companyOptional.isEmpty()) {
            System.err.println("Firma o podanym id nie istnieje");
            return;
        }
        System.out.println("Podaj id kontrahenta");
        String idContractorString = Command.scanner.nextLine();
        Long idContractor = Long.parseLong(idContractorString);
        Optional<Contractor> contractorOptional = daoContractor.find(Contractor.class, idContractor);
        if (contractorOptional.isEmpty()) {
            System.err.println("Kontrahent o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj nr faktury");
        String invoiceNr = Command.scanner.nextLine();
        System.out.println("Podaj termin platnosci (YYYY-MM-DD)");
        String stringPaymentDate = Command.scanner.nextLine();
        LocalDate paymentDate  = LocalDate.parse(stringPaymentDate);
        System.out.println("Podaj kwote");
        String sumString = Command.scanner.nextLine();
        Double sum = Double.parseDouble(sumString);


        Invoice invoice = Invoice.builder()
                .contractor(contractorOptional.get())
                .company(companyOptional.get())
                .invoiceNr(invoiceNr)
                .paymentDate(paymentDate)
                .sum(sum)
                .build();
        dao.insert(invoice);
    }
}
