import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContactDuplicateID() {
        Contact contact1 = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        Contact contact2 = new Contact("1234567890", "Anthony", "Vargas", "0987654321", "14 Vicky Lane");
        contactService.addContact(contact1);
        contactService.addContact(contact2);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteContactNonexistentID() {
        contactService.deleteContact("1234567890");
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Anthony", "Vargas", "0987654321", "14 Vicky Lane");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Anthony", updatedContact.getFirstName());
        assertEquals("Vargas", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("14 Vicky Lane", updatedContact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateContactNonexistentID() {
        contactService.updateContact("1234567890", "Anthony", "Vargas", "0987654321", "14 Vicky Lane");
    }

    @Test
    public void testGetContact() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contactService.addContact(contact);
        Contact retrievedContact = contactService.getContact("1234567890");
        assertEquals(contact, retrievedContact);
    }

    @Test
    public void testGetContactNonexistentID() {
        assertNull(contactService.getContact("1234567890"));
    }
}
