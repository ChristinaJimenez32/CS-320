import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testCreateContact() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        assertEquals("1234567890", contact.getID());
        assertEquals("Tina", contact.getFirstName());
        assertEquals("Jimenez", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals("139 Draper Lane", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactInvalidID() {
        new Contact(null, "Tina", "Jimenez", "0123456789", "139 Draper Lane");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactInvalidFirstName() {
        new Contact("1234567890", null, "Jimenez", "0123456789", "139 Draper Lane");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactInvalidLastName() {
        new Contact("1234567890", "Tina", null, "0123456789", "139 Draper Lane");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactInvalidPhone() {
        new Contact("1234567890", "Tina", "Jimenez", "01234", "139 Draper Lane");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactInvalidAddress() {
        new Contact("1234567890", "Tina", "Jimenez", "0123456789", null);
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setFirstName("Anthony");
        assertEquals("Anthony", contact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFirstNameInvalid() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setFirstName(null);
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setLastName("Vargas");
        assertEquals("Vargas", contact.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLastNameInvalid() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setLastName(null);
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setPhone("12345");
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setAddress("14 Vicky Lane");
        assertEquals("14 Vicky Lane", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAddressInvalid() {
        Contact contact = new Contact("1234567890", "Tina", "Jimenez", "0123456789", "139 Draper Lane");
        contact.setAddress(null);
    }
}
