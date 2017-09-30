package com.tkbi.utilidades;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Diego RM
 */
public class correos {

    public correos() {

    }

    public boolean enviarMail(String esDe, String msg) {
        String de = esDe;
        String contenido = msg;
        try {
            
//            String host = "smpt.gmail.com";
            String host = "smtp-mail.outlook.com";
            Properties prop = System.getProperties();
            
            prop.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
            prop.put("mail.smtp.host", "smtp-mail.outlook.com");
            prop.put("mail.smtp.starttls.enable", "true");
//            prop.put("mail.smpt.host", host);
            prop.put("mail.smpt.user", "trekbusi@outlook.com");
            prop.put("mail.smpt.password", "diego1023954713");
            prop.put("mail.smpt.port", "587");
            prop.put("mail.smpt.auth", "true");          
            
            Session sesion = Session.getDefaultInstance(prop, null);
            
            MimeMessage message = new MimeMessage(sesion);
            
            message.setFrom(new InternetAddress("trekbusi@outlook.com"));
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("daruiz31@misena.edu.co"));
            
            message.setSubject(de);                        
            
             MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(contenido);
            
            Multipart multi = new MimeMultipart();
            multi.addBodyPart(mimeBodyPart);
            
//            MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
//            File fichero = new File(adjunto);
//            mimeBodyPartAdjunto.attachFile(fichero.getAbsolutePath());
//            multi.addBodyPart(mimeBodyPartAdjunto);
            
//            BodyPart cuerpoMensaje = new MimeBodyPart();
//            cuerpoMensaje.setText(mensaje);
//            Multipart multi = new MimeMultipart();
//            multi.addBodyPart(cuerpoMensaje);
//            
//            //proceso para adjuntar el archivo
//            cuerpoMensaje = new MimeBodyPart();
//            String nombreArchivo = "HOJA DE VIDA CRISTIAN CAMILO.docx";
//            DataSource fuente = new FileDataSource(nombreArchivo);
//            cuerpoMensaje.setDataHandler(new DataHandler(fuente));
//            multi.addBodyPart(cuerpoMensaje);
//            
            
            message.setContent(multi);
            
            Transport t = sesion.getTransport("smtp");
            
            t.connect(host,"trekbusi@outlook.com","diego1023954713");
            
            t.sendMessage(message, message.getAllRecipients());
            
            t.close();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
//        try {
//            Properties propiedades = System.getProperties();
//            propiedades.put("mail.smtp.host", "smtp.gmail.com");
////            propiedades.put("mail.transport.protocol", "smtp");
//            propiedades.put("mail.smtp.starttls.enable", "true");
//            propiedades.setProperty("mail.smtp.port", "587");
//                propiedades.setProperty("mail.smtp.user", "trekbusiapp@gmail.com");
//                propiedades.setProperty("mail.smtp.password", "pbdgokatzlxavloa");
////            propiedades.setProperty("mail.smtp.user", "trekbusiapp@gmail.com");
//            propiedades.put("mail.transport.protocol", "smtp");            
//            propiedades.put("mail.smtp.auth", "true");
////            propiedades.setProperty("mail.password", "diego1023954713");
//
//            Session sesion = Session.getDefaultInstance(propiedades, null);
//            sesion.setDebug(true);
//
//            BodyPart texto = new MimeBodyPart();
//            texto.setText(contenido);
//
////            BodyPart adjunto = new MimeBodyPart();
////            if (!archivo.equals(" ")) {
////                adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
////                adjunto.setFileName(archivo);
////            }
//            MimeMultipart mMail = new MimeMultipart();
//            mMail.addBodyPart(texto);
//
//            MimeMessage messaje = new MimeMessage(sesion);
//            messaje.setFrom(new InternetAddress("trekbusiapp@gmail.com"));
//            messaje.addRecipient(Message.RecipientType.TO, new InternetAddress("daruiz31@misena.edu.co"));
//            messaje.setSubject(de);
//            messaje.setText(contenido);
//
//            Transport enviar = sesion.getTransport("smtp");
//            enviar.connect((String) propiedades.get("mail.smtp.user"), "pbdgokatzlxavloa");
//            javax.mail.Transport.send(messaje);
////            enviar.sendMessage(messaje, messaje.getAllRecipients());
//            enviar.close();
//            return true;
//        } catch (Exception e) {
//            System.out.println("ERROR DE ENVIO CORREO" + e);
//            return false;
//        }
    }

}
