package Faktura.Commands;

import Faktura.database.DataAccessObject;
import Faktura.model.*;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateInvoice implements Command{
    private DataAccessObject<Invoice> dao = new DataAccessObject<>();
    private DataAccessObject<Company> daoCompany = new DataAccessObject<>();
    private DataAccessObject<Contractor> daoContractor = new DataAccessObject<>();

    public UpdateInvoice() {
        this.dao = new DataAccessObject<>();
        this.daoContractor = new DataAccessObject<>();
        this.daoCompany = new DataAccessObject<>();
    }

    @Override
    public String getCommand() {
        return "Aktualizuj fakture";
    }

    @Override
    public void service() {
        System.out.println("Podaj id faktury");
        String idInvoiceString = Command.scanner.nextLine();
        Long idInvoice = Long.parseLong(idInvoiceString);
        Optional<Invoice> invoiceOptional = dao.find(Invoice.class, idInvoice);
        if (invoiceOptional.isEmpty()) {
            System.err.println("Faktura o podanym id nie istnieje");
            return;
        }
        Optional<Invoice> originalInvoice = dao.find(Invoice.class, idInvoice);
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
                .id(idInvoice)
                .addDate(invoiceOptional.get().getAddDate())
                .contractor(contractorOptional.get())
                .company(companyOptional.get())
                .invoiceNr(invoiceNr)
                .paymentDate(paymentDate)
                .sum(sum)
                .build();

        dao.update(Invoice.class,idInvoice,invoice);
    }
}
