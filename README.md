# CarSelection

Functionalities of this app:

Finding a car
- A user should be able to find the car they are interested in via a car browsing or searching interface

Viewing car details
- Once a user selects a car, they should be able to view details information for that vehicle, these are the minium requirements:
images
- vehicle information
- links to articles for this car
- Directions to dealership
- Call to action on the vehicle details page that shows them the nearest dealerships for that car's manufacture near them, and show them the direction to getting there.

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
