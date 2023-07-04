package com.AddressBook;
import java.util.*;

public class AddressBookMain {


        private static Map<String, AddressBook> addressBooks = new HashMap<>();

        public static void main(String[] args) {
            System.out.println("Welcome to Address Book Program");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Create Address Book");
                System.out.println("2. Add a Contact to Address Book");
                System.out.println("3. Edit Contact in Address Book");
                System.out.println("4. Delete Contact from Address Book");
                System.out.println("5. Search Person by Name");
                System.out.println("6. Search Person by City or State");
                System.out.println("7. View Persons by City or State");
                System.out.println("8. Get Count of Contacts by City or State");
                System.out.println("0. Exit");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 0:
                        System.out.println("Exiting the program...");
                        System.exit(0);
                        break;
                    case 1:
                        createAddressBook(scanner);
                        break;
                    case 2:
                        addContact(scanner);
                        break;
                    case 3:
                        editContact(scanner);
                        break;
                    case 4:
                        deleteContact(scanner);
                        break;
                    case 5:
                        searchByName(scanner);
                        break;
                    case 6:
                        searchByCityOrState(scanner);
                        break;
                    case 7:
                        viewByCityOrState(scanner);
                        break;
                    case 8:
                        getCountByCityOrState(scanner);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void createAddressBook(Scanner scanner) {
            System.out.println("Enter the name of the Address Book:");
            String addressBookName = scanner.nextLine();

            if (addressBooks.containsKey(addressBookName)) {
                System.out.println("Address Book with the same name already exists.");
            } else {
                AddressBook addressBook = new AddressBook();
                addressBooks.put(addressBookName, addressBook);
                System.out.println("Address Book created successfully.");
            }
        }

        private static void addContact(Scanner scanner) {
            System.out.println("Enter the name of the Address Book:");
            String addressBookName = scanner.nextLine();

            if (addressBooks.containsKey(addressBookName)) {
                AddressBook addressBook = addressBooks.get(addressBookName);
                Contact contact = new Contact();

                System.out.println("Enter First Name:");
                contact.setFirstName(scanner.nextLine());

                System.out.println("Enter Last Name:");
                contact.setLastName(scanner.nextLine());

                System.out.println("Enter Address:");
                contact.setAddress(scanner.nextLine());

                System.out.println("Enter City:");
                contact.setCity(scanner.nextLine());

                System.out.println("Enter State:");
                contact.setState(scanner.nextLine());

                System.out.println("Enter Zip:");
                contact.setZip(scanner.nextLine());

                System.out.println("Enter Phone Number:");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter Email:");
                contact.setEmail(scanner.nextLine());

                addressBook.addContact(contact);
                System.out.println("Contact added successfully.");
            } else {
                System.out.println("Address Book not found.");
            }
        }

        private static void editContact(Scanner scanner) {
            System.out.println("Enter the name of the Address Book:");
            String addressBookName = scanner.nextLine();

            if (addressBooks.containsKey(addressBookName)) {
                AddressBook addressBook = addressBooks.get(addressBookName);

                System.out.println("Enter the name of the contact to edit:");
                String name = scanner.nextLine();

                Contact contact = addressBook.getContactByName(name);

                if (contact != null) {
                    System.out.println("Contact found. Enter new details:");

                    System.out.println("Enter First Name:");
                    contact.setFirstName(scanner.nextLine());

                    System.out.println("Enter Last Name:");
                    contact.setLastName(scanner.nextLine());

                    System.out.println("Enter Address:");
                    contact.setAddress(scanner.nextLine());

                    System.out.println("Enter City:");
                    contact.setCity(scanner.nextLine());

                    System.out.println("Enter State:");
                    contact.setState(scanner.nextLine());

                    System.out.println("Enter Zip:");
                    contact.setZip(scanner.nextLine());

                    System.out.println("Enter Phone Number:");
                    contact.setPhoneNumber(scanner.nextLine());

                    System.out.println("Enter Email:");
                    contact.setEmail(scanner.nextLine());

                    System.out.println("Contact edited successfully.");
                } else {
                    System.out.println("Contact not found in the Address Book.");
                }
            } else {
                System.out.println("Address Book not found.");
            }
        }

        private static void deleteContact(Scanner scanner) {
            System.out.println("Enter the name of the Address Book:");
            String addressBookName = scanner.nextLine();

            if (addressBooks.containsKey(addressBookName)) {
                AddressBook addressBook = addressBooks.get(addressBookName);

                System.out.println("Enter the name of the contact to delete:");
                String name = scanner.nextLine();

                boolean deleted = addressBook.deleteContactByName(name);

                if (deleted) {
                    System.out.println("Contact deleted successfully.");
                } else {
                    System.out.println("Contact not found in the Address Book.");
                }
            } else {
                System.out.println("Address Book not found.");
            }
        }

        private static void searchByName(Scanner scanner) {
            System.out.println("Enter the name to search:");
            String name = scanner.nextLine();
            List<Contact> searchResults = new ArrayList<>();

            for (AddressBook addressBook : addressBooks.values()) {
                searchResults.addAll(addressBook.searchByName(name));
            }

            if (!searchResults.isEmpty()) {
                System.out.println("Search results:");
                for (Contact contact : searchResults) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("No contacts found with the given name.");
            }
        }

        private static void searchByCityOrState(Scanner scanner) {
            System.out.println("Enter the city or state to search:");
            String searchString = scanner.nextLine();
            List<Contact> searchResults = new ArrayList<>();

            for (AddressBook addressBook : addressBooks.values()) {
                searchResults.addAll(addressBook.searchByCityOrState(searchString));
            }

            if (!searchResults.isEmpty()) {
                System.out.println("Search results:");
                for (Contact contact : searchResults) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("No contacts found in the given city or state.");
            }
        }

        private static void viewByCityOrState(Scanner scanner) {
            System.out.println("Enter the city or state to view contacts:");
            String searchString = scanner.nextLine();

            System.out.println("Contacts in the specified city or state:");
            for (AddressBook addressBook : addressBooks.values()) {
                List<Contact> contacts = addressBook.searchByCityOrState(searchString);
                if (!contacts.isEmpty()) {
                    System.out.println("Address Book: " + addressBook.getName());
                    for (Contact contact : contacts) {
                        System.out.println(contact);
                    }
                    System.out.println("---------------------------");
                }
            }
        }

        private static void getCountByCityOrState(Scanner scanner) {
            System.out.println("Enter the city or state to get the count of contacts:");
            String searchString = scanner.nextLine();
            int count = 0;

            for (AddressBook addressBook : addressBooks.values()) {
                count += addressBook.getCountByCityOrState(searchString);
            }

            System.out.println("Number of contacts in the specified city or state: " + count);
        }

        // AddressBook class
        static class AddressBook {
            private String name;
            private List<Contact> contacts;

            public AddressBook() {
                this.contacts = new ArrayList<>();
            }

            public AddressBook(String name) {
                this.name = name;
                this.contacts = new ArrayList<>();
            }

            public String getName() {
                return name;
            }

            public void addContact(Contact contact) {
                contacts.add(contact);
            }

            public Contact getContactByName(String name) {
                for (Contact contact : contacts) {
                    if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                        return contact;
                    }
                }
                return null;
            }

            public boolean deleteContactByName(String name) {
                for (Contact contact : contacts) {
                    if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                        contacts.remove(contact);
                        return true;
                    }
                }
                return false;
            }

            public List<Contact> searchByName(String name) {
                List<Contact> searchResults = new ArrayList<>();
                for (Contact contact : contacts) {
                    if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                        searchResults.add(contact);
                    }
                }
                return searchResults;
            }

            public List<Contact> searchByCityOrState(String searchString) {
                List<Contact> searchResults = new ArrayList<>();
                for (Contact contact : contacts) {
                    if (contact.getCity().equalsIgnoreCase(searchString) || contact.getState().equalsIgnoreCase(searchString)) {
                        searchResults.add(contact);
                    }
                }
                return searchResults;
            }

            public int getCountByCityOrState(String searchString) {
                int count = 0;
                for (Contact contact : contacts) {
                    if (contact.getCity().equalsIgnoreCase(searchString) || contact.getState().equalsIgnoreCase(searchString)) {
                        count++;
                    }
                }
                return count;
            }
        }


        static class Contact {
            private String firstName;
            private String lastName;
            private String address;
            private String city;
            private String state;
            private String zip;
            private String phoneNumber;
            private String email;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            // toString() method and other methods go here...
        }

}



