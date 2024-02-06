/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.daoImpl.CustomerDaoImpl;
import za.ac.bakery.daoImpl.OrderDaoImpl;
import za.ac.bakery.daoImpl.StockDaoImpl;
import za.ac.bakery.model.Address;
import za.ac.bakery.model.Customer;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Order;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.CustomerService;

/**
 *
 * @author Train
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerdao;

    public CustomerServiceImpl(String url, String username, String password) {

        this.customerdao = new CustomerDaoImpl(url, username, password);

    }

    @Override
    public void createCustomer(Customer customer) {

        customerdao.createCustomer(customer);

    }

    @Override
    public void deleteCustomer(String email) {
        customerdao.deleteCustomer(email);
    }

    @Override
    public void updateCustomer(Customer customer, String email) {
        customerdao.updateCustomer(customer, email);
    }

    @Override
    public Customer getCustomer(String email) {
        Customer customer = customerdao.getCustomer(email);

        if (customer.getEmail() != null) {
            return customer;
        }

        return new Customer();
    }

    @Override
    public void addAddress(Address address, Customer p) {
        customerdao.addAddress(address, p);
    }

    @Override
    public List<Customer> customers() {
        return customerdao.customers();
    }

    public String RegisteringEmailOutcome(Customer c) {
        final String username = "fentse283@gmail.com";
        final String password = "ydwx qndp pzaf ffbw";

        // Recipient's email address
        String to = c.getEmail();

        Timestamp tm = Timestamp.from(Instant.now());

        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);

            // Set the sender's and recipient's email addresses
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set the email subject and body
            message.setSubject("Successfully Registered!");
            message.setText("Hello " + c.getTitle() + " " + c.getName() + " " + c.getSurname() + "\n"
                    + "Thank you for registering!\n"
                    + "Details:\n"
                    + "Title: " + c.getTitle() + "\n"
                    + "Name: " + c.getName() + "\n"
                    + "Surname: " + c.getSurname() + "\n"
                    + "Email: " + c.getEmail() + "\n"
                    + "Date & Time : " + tm.toString());

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully.");
            return "success";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "error";
        }
    }

}
