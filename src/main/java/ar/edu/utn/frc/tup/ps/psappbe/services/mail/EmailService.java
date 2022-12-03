package ar.edu.utn.frc.tup.ps.psappbe.services.mail;

import javax.servlet.UnavailableException;

public interface EmailService {

    void sendSimpleEmail(String toEmailAddress,
                         String fromEmailAddress,
                         String subject,
                         String bodyText) throws UnavailableException;

}
