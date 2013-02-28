README
------

- Operating instructions
- Available commands
- Known bugs
- Implementation Overview

Operating Instructions
----------------------

For testing purposes we set up 2 users - a course coordinator and student.
In order to create new employers, simply call the RegisterEmployer method from the command line interface. This will add a new employer to the
system and allow all employer-related methods to be tested.

Using the command line interface, at any point, type 'help' as a command to receive a list of all available commands for the system.

Available Commands:
-------------------

help <command>
    Prints the help message for specified command, or if no arguments are specified, gives full listing of available commands.

RecordVisitAssessment <matriculation> <grade>
    Allows an academic visitor to record their assessment of a student's internship.

Login <Username> <Password>

logs into User’s account


PublishAdvertisement <advertisementid>
    Allows a course coordinator to release an internship advertisement to students.

RegisterEmployer <name> <email address>
    Adds a new employer to the system.

SubmitAdvertisement
    Initiates a dialogue to submit a new advertisement containing internship roles.

AssignVisitor <matriculation> <visitorName>
         Sends email to student, visitor and employer manager to let them know about assignment.


ViewStudentDetail <matriculation>
    Shows the detailed view of a SESP student in the system.

ViewAdvertisementDetail <advertisementid>
    Presents the detail of internship roles for a single advertisement.

AcceptOffer <advertid> <roleid>
    Accepts the specified role on behalf of the currently selected user.  If no role is specified, or the role does not exist, the user must enter the details of the role.

exit
    Exits the system.

ApproveOffer <Matriculation, internshipID>
        Approves offer, with specified internshipID, accepted by student with this matriculation id.


Known Bugs
----------

-All employers and their adverts must be created within one run of the system. If the system is stopped or crashes, the adverts are not stored properly, they are overwritten.
-There is no visitor user level implemented, therefore recording visit assessment cannot be done.
-A student has a list of internships. However, they can't accept more than one internship. The first accepted internship will be added to the list, but the system crashes when trying to accept another.
-As the multiple internships for students is not working, we haven't tested to see students have sufficient approved internships to cover a total of 12 weeks.
-When first running the system, you must run the system to add the coordinator and student users to the system. The next time the system is run, the code to add these users must be commented out to avoid overwriting the data stored for these users.

Implementation Overview
-----------------------

Stores:

The stores package is composed of 3 classes and 1 interface (UserStore):
-AdvertStore
-OfferStore
-UserStoreImpl

The purpose of these classes is to instantiate, store and retrieve adverts, offers and users.

Impl:

The Impl package is composed of 6 classes, 1 facade(InternManStub) and 1 JUnit test(InternManStubTest):
-Advert
-AdvertManagement
-InternManStub
-InternManStubTest
-Offer
-OfferManagement
-RoleImpl
-UserManagement

The Advert class is used to retrieve the details of an advert; the ID, roles, employer, application details and advertisement status. It is also used to set the Advertisement status and to add a new role.
The AdvertManagement class is used to add, store and retrieve adverts stored in the AdvertStore.
The Offer class is used to retrieve the details of an offer; the ID, manger, managerEmail, employer, role, Internship status, visit. It is also used to set the Internship status.
The OfferManagement class is used to add, store and retrieve offers stored in the OfferStore.
The RoleImpl class to retrieve the details of a role; the ID, startdate, enddate, description, salary, location and to find out if it is approved.
The UserManagement class is used to add, store and retrieve users stored in the UserStore.
The InternManStub is the main facade for the intern management system.

Users:

The Users package consists of 4 classes:
-CCUser
-EmployerUser
-StudentUser
-User

CCUser, EmployerUser, StudentUser all extend of User.
StudentUser implements the Student interface which sets the UserType to 'student' and is used to retrieve information about a student.
EmployerUser implements the Employer interface which sets the userType to 'employer' and is used to retrieve information about an employer.

