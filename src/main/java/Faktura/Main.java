package Faktura;

import Faktura.Commands.*;
import Faktura.database.DataAccessObject;
import Faktura.model.Company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //SELECT * from firma;
        // new DataAccessObject<Company>().findAll(Company.class);
        List<Command> commandList = List.of(
                new AddCompany(),
                new AddContractor(),
                new AddInvoice(),
                new AddPayment(),
                new ListCompany(),
                new ListContractor(),
                new ListInvoice(),
                new ListPayment(),
                new DeleteCompany(),
                new DeleteContractor(),
                new DeleteInvoice(),
                new DeletePayment(),
                new UpdateCompany(),
                new UpdateContractor(),
                new UpdateInvoice(),
                new UpdatePayment()
        );
        String command;
        do {
            System.out.println("Lista dostepnych komand: "); //wypsianie komand w formie 1. dodajx
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println((i + 1) + ". " + commandList.get(i).getCommand());
            }
            System.out.println();

            System.out.println("Podaj komende");
            command = Command.scanner.nextLine();

            for (Command availableCommand : commandList) {
                if (availableCommand.getCommand().equalsIgnoreCase(command)) {
                    availableCommand.service();
                }
            }
        } while (!command.equalsIgnoreCase("exit"));
    }
}