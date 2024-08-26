import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Adds a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getID())) {
            throw new IllegalArgumentException("ID is not unique");
        }
        contacts.put(contact.getID(), contact);
    }

    // Deletes a contact
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Cannot delete contact. Contact ID not found.");
        }
        contacts.remove(contactID);
    }

    // Updates fields
    public void updateContact(String ID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(ID);
        if (contact == null) {
            throw new IllegalArgumentException("ID not found. Could not update information.");
        }

        // if not null
        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    // Method to get a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
