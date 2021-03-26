# CleanArchitecture with Koin

Implementation of Clean Architecture and Koin library

## Layers of Clean Architecture

Clean architecture is also referred to as Onion architecture as it has different layers. As per our requirement, we need to define the layers, however, architecture doesn’t specify the number of layers.

For a basic idea, let us consider there are 5 layers for now:
### App Layer
MainActivity & WeatherViewModel : This layer that interacts with the UI.

### Domain Layer
WeatherModel : Contains the business logic of the application. It is the individual and innermost module.

### Interactor or UseCase Layer
GetWeatherDataUseCaseImpl & GetWeatherDataUseCase : Defines actions the user can trigger.

### Data Layer
WeatherRepository, WeatherDataSourceImpl & WeatherDataSource : Abstract definition of all the data sources.

### Framework
Implements interaction with the Android SDK and provides concrete implementations for the data layer.


