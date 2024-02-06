/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import java.io.InputStream;
import java.util.ArrayList;
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
import za.ac.bakery.daoImpl.StoreDaoImpl;
import za.ac.bakery.model.Catergory;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.AdminService;
import za.ac.bakery.service.StoreService;

/**
 *
 * @author Train
 */
public class StoreServiceImpl implements StoreService {

    private StoreDaoImpl storeservice;
    private Person person;

    public StoreServiceImpl(String url, String username, String password) {
        this.storeservice = new StoreDaoImpl(url, username, password);

    }

    public int createItem(Item item) {

        return storeservice.createItem(item);

    }

    @Override
    public Item getItem(int itemId) {
        Item item = storeservice.getItem(itemId);

        return item;

    }

    @Override
    public void deleteItem(int ItemId) {

        storeservice.deleteItem(ItemId);

    }

    @Override
    public void updateItem(Item item) {

        storeservice.updateItem(item);
    }

    @Override
    public void uploadPicture(InputStream is, int id) {
        storeservice.uploadPicture(is, id);
    }

    @Override
    public List<Item> getItems() {
        List<Item> items = storeservice.getItems();

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    public static void main(String[] args) {
        List<Item> items;

        StoreServiceImpl service = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
        items = service.getItems();
        
        items.forEach(System.out::println);

    }

    @Override
    public List<Catergory> catergories() {
        List<Catergory> catergorys = storeservice.catergories();

        if (catergorys.isEmpty()) {
            return new ArrayList<>();
        }

        return catergorys;
    }

    @Override
    public List<Item> getItemWithCategoryId(int id) {

        List<Item> items = storeservice.getItemWithCategoryId(id);

        if (items.isEmpty()) {
            return new ArrayList<>();
        }
        return items;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = storeservice.getAllItems();
        if (items.isEmpty()) {
            return new ArrayList<>();
        }

        return items;

    }

    @Override
    public List<Person> getAllPeople() {

        List<Person> people = storeservice.getAllPeople();

        if (people.isEmpty()) {
            return new ArrayList<>();
        }
        return people;
    }

    @Override
    public String forgotPassword(String email) {

        List<Person> people = storeservice.getAllPeople();

        for (int i = 0; i < people.size(); i++) {

            if (email.equalsIgnoreCase(people.get(i).getEmail())) {

                String fpassword = people.get(i).getPassword();

                String name = people.get(i).getName().toUpperCase();

                String surname = people.get(i).getSurname().toUpperCase();

                String title = people.get(i).getTitle().toUpperCase();

                final String username = "fentse283@gmail.com";
                final String password = "ydwx qndp pzaf ffbw";

                // Recipient's email address
                String to = email;

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
                    message.setSubject("Web Password Requested " + email);
                    message.setText("\n"
                            + "Web Password Was Requested\n"
                            + "PLEASE DO NOT REPLY TO THIS E-MAIL\n"
                            + "Request for : " + email + "," + title + name + " " + surname + "\n"
                            + "Current Password : " + fpassword + "\n"
                            + "Once you login you can change your password .");

                    Transport.send(message);

                    System.out.println("Email sent successfully.");

                } catch (MessagingException e) {
                    System.out.println("Error " + e.getMessage());
                }

                return "success";
            }

        }

        return "notsucess";

    }
}
