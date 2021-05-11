import java.util.*;

public class Main {


    public static void main(String[] args) {

        String firstName;
        String lastName;
        String phoneNumber;
        String emailAddress;

        // Declared Array list & passed the AddressBook class as an object
        //this will act as a database for this project
        ArrayList<AddressBook> addressBook = new ArrayList<AddressBook>();


        // Scanner object is initiated with system.in to read the user input
        Scanner input = new Scanner(System.in);
        int option = 0;


        /// This block of code is displaying all the menu to choose
        //if the option is 6, the programme will quit
        while (option != 6) {
            System.out.println("1) Add an Entry\n");
            System.out.println("2) Remove an Entry\n");
            System.out.println("3) Search for a Specific Entry\n");
            System.out.println("4) Print Address Book\n");
            System.out.println("5) Delete Book\n");
            System.out.println("6) Quit\n");
            System.out.println("Please choose what you'd like to do with the database:");

            option = input.nextInt();

            ////// This block of code(line 35 - line 54) is taking the input from the user & adding it to the Array list
            if (option == 1) {
                Scanner inputAdd = new Scanner(System.in);
                System.out.println("First Name: ");
                firstName = inputAdd.nextLine();

                System.out.println("Last Name: ");
                lastName = inputAdd.nextLine();

                System.out.println("Phone Number: ");
                phoneNumber = inputAdd.nextLine();

                System.out.println("Email Address:");
                emailAddress = inputAdd.nextLine();

                int valid=emailAddress.indexOf("@");
                int valid2 = emailAddress.indexOf(".");

                if (valid == -1 || valid2 == -1){

                    System.out.println("You have entered an invalid email address!");
                }
                else {
                    System.out.println(firstName);
                    System.out.println(lastName);
                    System.out.println(phoneNumber);
                    System.out.println(emailAddress);
                    addressBook.add(new AddressBook(firstName, lastName, phoneNumber, emailAddress));
                }
            }

            /// This whole block of codes are for removing the entry against specific search( line 59 -line 80)
            if (option == 2) {

                String email;
                Scanner inputRemove = new Scanner(System.in);
                System.out.println("Enter an entry's email to remove: ");
                email = inputRemove.next();

                //Email validation
                int validationAtSymbol = email.indexOf("@");
                int validationDotSeparator = email.indexOf(".");

                if (validationAtSymbol == -1 || validationDotSeparator == -1){

                    System.out.println("You have entered an invalid email address!");
                }
                else {


                    AddressBook entryToBeRemoved = null;


                    for (AddressBook entry : addressBook) {
                        if (entry.getEmailAddress().equalsIgnoreCase(email))
                            entryToBeRemoved = entry;
                        System.out.println(addressBook.toString());
                    }


                    if (entryToBeRemoved != null) {
                        addressBook.remove(entryToBeRemoved);
                        System.out.println("Address deleted successfully\n");
                    } else
                        System.out.println("ERROR! Address not found!\n");
                }
            }

            //printing the options of the lists of entries
            if (option == 3) {

                System.out.println("1) First Name:");
                System.out.println("2) Last Name:");
                System.out.println("3) Phone Number:");
                System.out.println("4) Email Address\n");


                //Below taking the input for type & search from the console/ standard output
                System.out.println("Chose a search type: ");
                int type = input.nextInt();


                System.out.println("Enter your search: ");
                String search = input.next();


                //// With the specific type & search type , all the specific elements are displayed
                for (AddressBook entry : addressBook) {

                    if (type == 1) {
                        if (entry.getFirstName().equalsIgnoreCase(search))

                            System.out.println(addressBook.toString());

                    } else if (type == 2) {
                        if (entry.getLastName().equalsIgnoreCase(search))

                            System.out.println(addressBook.toString());
                    } else if (type == 3) {
                        if (entry.getPhoneNumber().equalsIgnoreCase(search))

                            System.out.println(addressBook.toString());
                    } else if (type == 4) {
                        if (entry.getEmailAddress().equalsIgnoreCase(search))

                            System.out.println(addressBook.toString());
                    } else
                        System.out.println("ERROR! Address not found!\n");
                }
            }

            /// Printing all the elements from the Array list
            if (option == 4) {
                System.out.println("Address list:");
                for (AddressBook entry : addressBook) {
                    System.out.println(entry.toString());

                }
            }



            ///Delete All elements from Array list
            if (option == 5) {
                addressBook.clear();
                System.out.println("Address deleted successfully\n");

            }

        }

    }
}