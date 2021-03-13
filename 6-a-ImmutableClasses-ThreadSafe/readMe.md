# Immutable Class

## 1 - What is an Immutable Class

      Immutable classes are those class, whose object can not be modified once created, 
      It means any modification on immutable object will result in another immutable object 
      Ex) String, String Buffer, Primitive Wrapper Classes 

## 2 - Advantage
    - Thread safe : can be shared without synchronization in concurrent environment
      Since String is immutable in Java, it's inherently thread-safe.

## 3 - Use case
    - Good choice for HashMap-Key 
      [Fore More Info] : https://www.thetechnojournals.com/2019/10/why-hashmap-key-should-be-immutable-in.html
 
## 4 - How to make a class Immutable : https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
     I)Steps to create an Immutable Class
       - Class       :  Final : No class can extend it 
       - All Fields  : 
             Private :  no outside class will be able to access instance variables
             Final    :  Once initialized, cannot be changed.
       - 1 Full-Arg-constructor
       - Getter Methods
       - No Setter Methods, so that field value cannot be changed after object creation.

##
    II) Immutable Class with Mutable Reference
    
        ---------------------------------------------
        Given : 
	
        public final class Employee {
          private final String name;
          private final Address address;

          //1 full-Arg-parametrized constructor 
          //Getter Methods 
        }
        ---------------------------------------------
        public class Address{
          private String city
          private String state

          //1 full-Arg-parametrized constructor 
          //Getter Methods 
          //Setter Methods 
        }
        ---------------------------------------------
        Is Employee-Class Immutable : NO 

         How can you make Employee Class Immutable 
          - The address class must implement the 'Cloneable interface'
          - Employee class :Address Getter method : return address.clone() 
               public Address getAddress() throws CloneNotSupportedException {
		    return (Address) address.clone();
	     }
		
##

      III) Immutable Class with Mutable Reference
         
           --------------------------------------------- 
           Given : 
	   
           If  In above Employee class
            - private final Date birthday; 
            - private final Address address; is replaced with  private final List<Address> addresses;

           public final class Employee {
             private final String name;
             private final Date birthday;
             private final List<Address> addresses;

             //1 full-Arg-parametrized constructor 
             //Getter Methods 
           }

           ---------------------------------------------
           Is Employee-Class Immutable : NO

           How can you make Employee Class Immutable 

            public Date getBirthday() {
              return (Date) birthday.clone();
            }

            public Address getAddress() throws CloneNotSupportedException {
              return (ArrayList)Collections.unmodifiableCollection(addressList);
            }


          SOURCE : https://codepumpkin.com/immutable-class-with-mutable-member-fields-in-java/	
                   https://www.thetechnojournals.com/2019/10/why-hashmap-key-should-be-immutable-in.html
