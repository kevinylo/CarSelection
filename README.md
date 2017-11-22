# CarSelection

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
