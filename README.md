# CarSelection

Functionalities of this app:

Finding a car
- A user can find the car they are interested in via a searching interface

Viewing car details
- Once a user selects a car, details information for that vehicle will be shown including vehicle information, links to articles for this car, as well as directions to dealership
- There is also the ability to show nearest dealerships for that car's manufacture near their location, and show them the direction to getting there.

The app uses edmunds open access data points.

Project build flavor

Dev 
  - Mock data to provide consistent data for the use of Android espresso (UI) test.

Prod
  - Real time backend data
  
Tools/paradigms used:
  - Dependency Injection (dagger 2)
  - Reactive programming (rxjava 2)
  - Android Model View Presenter (MVP)
  - Repository pattern
  
Test cases:
  - Unit Test: CarDetailsPresenterTest
  - UI expresso test: Run in devDebug build flavor using mocked backend point.
