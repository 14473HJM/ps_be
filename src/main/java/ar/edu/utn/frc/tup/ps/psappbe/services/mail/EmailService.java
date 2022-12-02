package ar.edu.utn.frc.tup.ps.psappbe.services.mail;

public interface EmailService {

    void sendSimpleEmail(String toEmailAddress,
                         String fromEmailAddress,
                         String subject,
                         String bodyText);

}
