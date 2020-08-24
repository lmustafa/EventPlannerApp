run the application by writing: ./gradlew run

There are two main methods, one that shows the capabilities of the user (in Main),
and one that shows the capabilities of a data provider (in InstructorMain).


User stories that are implemented:
- (1) A user gets data from an API
- (2) A user can view all the data from the API
- (3) A user can add an event to that data

Acceptance Criteria:

(1) : 

Given that there needs to be data

When the user runs the application

Then data is taken from the API and stored in a list of Events

(2) :

Given that a user would like to view all the events

When the user selects the appropriate option

Then data is taken from the list and displayed to the user

(3) :

Given that a user would like to add their event

When the user selects the appropriate option

Then an event object is created that stores the information and adds it to the list

Single Responsibility Principle:
Each class is responsible for its own implementation. 
For example, the Event class is just a class of Events which can be instantiated
every time data is retrieved or the user wants to add an event. TicketMaster implements
Data, this ensures that everything a class that needs to retrieve data is done. The compiler will
throw an error if I forget to implement an important method. 

Open-Close Principle:
The Event object is wrapped in an EventWrapper class which handles how the data is stored.
The current implementation is as a linked list but it could be changed into a HashMap or an ArrayList and
I would need to change the EventWrapper class only - this will be more useful when I have data from different 
sources. This way I won't have to go into each class that gets data and change how the data is stored, I will only 
have to change how data is stored in the EventWrapper class. 