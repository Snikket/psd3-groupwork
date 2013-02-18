README

- Installation instructions
-Operating instructions
- A file manifest (list of files included)
- Known bugs
- Implementation Overview
- Data File Formats
- Contact information for the distributor or programmer


Operating instructions

In order to create new users, call addUser method inside the utility component Utility class. It accepts User type variable as adds it to the userStore (therefore you can create a coursecoordinator user type and student user type like this).

Using the command line interface, at any point, type help as a command to receive help on the available commands.

Available commands:

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

ApproveOffer <Matriculation>
        Approves offer most recently accepted by student with this matriculation id.

File manifest

.\...\AdvertisementManagement\Advertisement.java
.\...\AdvertisementManagement\AdvertisementAPI.java
.\...\AdvertisementManagement\advertisementTestClass.java
.\...\AdvertisementManagement\Company.java
.\...\AdvertisementManagement\Employer.java
.\...\AdvertisementManagement\Role.java
.\...\internman\InternMan.java
.\...\internman\Internship.java
.\...\internman\InternshipImpl.java
.\...\internman\InternshipStore.java
.\...\internman\InternshipStoreImpl.java
.\...\internman\Student.java
.\...\internman\UoGGrade.java
.\...\internman\Visit.java
.\...\internman\Visitor.java
.\...\internman\impl\InternManStub.java
.\...\internman\ui\AcceptOfferCommand.java
.\...\internman\ui\ApproveOfferCommand.java
.\...\internman\ui\AssignAcademicVisitorCommand.java
.\...\internman\ui\InternManCLUI.java
.\...\internman\ui\LoginCommand.java
.\...\internman\ui\PublishAdvertisementCommand.java
.\...\internman\ui\RecordVisitAssessmentCommand.java
.\...\internman\ui\RegisterEmployerCommand.java
.\...\internman\ui\SubmitAdvertisementCommand.java
.\...\internman\ui\ViewAdvertisementDetailCommand.java
.\...\internman\ui\ViewAdvertisementSummaryCommand.java
.\...\internman\ui\ViewStudentDetailCommand.java
.\...\internman\ui\ViewStudentSummaryCommand.java
.\...\OfferManagement\Offer.java
.\...\OfferManagement\OfferAPI.java
.\...\OfferManagement\offerManagementTestClass.java
.\...\Utility\User.java
.\...\Utility\UserStore.java
.\...\Utility\UserStoreImpl.java
.\...\Utility\Utility.java
.\...\Utility\UtilityAPI.java
.\...\Utility\utilityTestClass.java
.\...\VisitManagement\UoGGrade.java
.\...\VisitManagement\Visit.java
.\...\VisitManagement\VisitAPI.java
.\...\VisitManagement\VisitAPIImpl.java
.\...\VisitManagement\VisitImpl.java
.\...\VisitManagement\Visitor.java
.\...\VisitManagement\VisitorImpl.java
.\...\VisitManagement\visitTestClass.java

Known bugs

    There is no visitor user level implemented, therefore recording visit assessment can only be done by the course coordinator user level.
    The date method used to add roles into the system is deprecated, and is not considered part of the library. This created complications when creating Java Junit test classes against the relevant facade methods.
    Parts of the facade do not take into account the privileges of the users invoking the method.



Implementation overview



AdvertisementManagement :

The AdvertisementManagement package is composed of an interface (AdvertisementStore) and 6 classes:
-Role
-Advertisement
-AdvertisementStoreImpl
-Employer
-Company
-Internship   

The set of classes Advertisement/AdvertisementStoreImpl is similar to the User/UserStoreImpl classes provided: their purpose is to instantiate, store and retrieve advertisements to/from a .obj file.
The Employer is a special instance of User which is created when registering a new employer or when trying to submit an advertisement, if the currentUser status is “Employer”. The User class has been modified to contain some getter functions and a new status field to store the type of the user.
The Company class stores basic informations about the company hosting the employer; it is not under use as of now, as it would require to modify the existing commands, which is not a must have as of now.
The Role class was implemented as according to the specifications; an advertisement can have a number of roles mapped by an integer id; roles are created based of the information submitted using the command SubmitAdvertisement.




OfferManagement :


An offer tracking system similar to the UserStore and the AdvertisementStore has been implemented. The Offer object links a student to an internship object and is described by a status and comments fields, as required by the specifications. The tracking of Offer is unsupported as of now; it is, however, possible to notify an accepted offer to a manager with the stub method  notifyAcceptedOffer. It is also possible to approve an accepted offer; but since there’s no command generating offers for now, this functionality is not usable.


Utility :

The Utility package is composed of 2 interfaces (UtilityAPI and UserStore) and 4 classes:
- StudentImpl
- User
- UserStore
- Utility   

The UserStore interface, User class and UserStoreImpl class purpose is to instantiate, store and retrieve users to/from a .obj file.
Utility class implements the UtilityAPI interface, which is the interface that’s being used to communicate with the Utility component.
StudentImpl class implements the Student interface in the uk.ac.glasgow.internman package and extends the above User class.

VisitManagement :

The VisitManagement package is composed of an interface (VisitAPI) and 3 classes:
- VisitAPIImpl
- VisitImpl
- VisitorImpl

VisitAPIImpl class implements the VisitAPIinterface, which is the interface that’s being used to communicate with the VisitManagement component.
VisitImpl class implements the Visit interface in the uk.ac.glasgow.internman package and extends. VisitorImpl class implements the Visitor interface in the uk.ac.glasgow.internman package and extends.

Data File formats
This system uses .obj files for the userStore and advertisementStore. These entire object files can be replaced for new

Contact Details

Gediminas Leikus         10050311l@student.gla.ac.uk
Alexander Ferguson         1005994f@student.gla.ac.uk
Andrew Gibson         1003163g@student.gla.ac.uk
Arthur Bigeard         arthur.bigeard@gmail.com
Liam Bell            liambell91@gmail.com

