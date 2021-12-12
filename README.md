
This project will be keep improving...

# 1Valet-Challenge
A  Mobile Application Version that consumes a mock of data devices

## Installation and how to run

Android Studio 4.+ 
The SDK target used to compile the Application is the version 31

Once that the project is cloned:

Open the terminal go to the root of the project and run the command "./gradlew wiremockserver" or "gradlew wiremockserver", it will depends on the system.

Once that wiremock is running, you can run the application.

OBS: The wiremock runs on port 8282, so be sure the it is not blocked by the firewall. 

If you want to run your application on a physical device, you will will to change the buildConfigField value of property "BASE_URL" on the build.gradle of module app:

<img width="665" alt="Screen Shot 2021-12-12 at 17 47 27" src="https://user-images.githubusercontent.com/8905885/145729035-6c87e9a6-020a-4daa-9f71-682779c7de1d.png">

And also you will need to allow your ip on network_security_config.xml

<img width="782" alt="Screen Shot 2021-12-12 at 17 48 36" src="https://user-images.githubusercontent.com/8905885/145729066-a5350a5e-6797-4bf7-ad37-2f72ba987541.png">

## Arquitetura MVVM + Clean Architecture

The application uses MVVM Architecture in order to provide a better communication between the layers of View, State and Data.

Also was applied the clean architecture providing a better separation of Views, Business Rules, Datasources, it provides us a lot of benefits, as maintainability, unit tests, a better way to apply SOLID Principals and so much more.

## Packages project structure

The project uses the following packages structure:

- ### Business
  In this package are the UseCases, these classes provide us the business logic and also are responsible to communicate with the repositories
  
- ### Common
  In this package are some of the Helper Classes that are common between the packages

- ### Datasource
  In this package are all repositories classes and its dependencies, here are the layers for local datasource and remote datasource as well

- ### Domain
  In this package are the Models, Dtos and Entities classes

- ### Presentation
  This package contains all classes that represent the view, this package contains Activities, Fragments, ViewModels

* Each package contains internal packages in order to separate by business content

## Libraries

- MVVM + Data binding
- Navigation Component
- ViewModel
- LiveData
- Flow
- Coil
- Coroutines
- Koin
- Mockito
- Retrofit


