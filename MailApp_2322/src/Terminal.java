import java.util.Scanner;
import max.*;

public class Terminal {
    public static void SendMail() throws Exception {
        Mail mail = new Mail();
        Scanner eingabe = new Scanner(System.in);
        while (true) {
            System.out.println("Bitte geben Sie die gewünschte Mailadresse ein: ");
            String empfaenger = eingabe.nextLine();
            mail.setRecipient(empfaenger);
            boolean isvalid = false;

            try {
                isvalid = Validator.isValid(empfaenger);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if (isvalid) {
                break;
            }
        }

        System.out.println("Bitte geben Sie das gewünschte Betreff ein: ");
        String betreff = eingabe.nextLine();
        mail.setSubject(betreff);

        System.out.println("Bitte geben Sie den Text der Mail ein: ");
        String nachricht = eingabe.nextLine();
        mail.setMessage(nachricht);
        //mail.setRecipient("yuriy@solovyov.de");
        //mail.setSubject("Hallo Yuriy");
        //mail.setMessage("Hallo, wie geht es dir? Gruß, Christoph");

        try {
        Sender sender = new Sender();
        sender.send(mail);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
