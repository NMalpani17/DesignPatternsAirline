# DesignPatternsAirline

A comprehensive Java application demonstrating various design patterns through an airline booking system. This project showcases the implementation of multiple Gang of Four (GoF) design patterns in a real-world scenario.

## Project Overview

DesignPatternsAirline is an educational project that implements 12 different design patterns to create a fully functional airline booking system. Each pattern is demonstrated through specific features and functionality within the application.

## Design Patterns Implemented

### 1. **Singleton Pattern**

- **Location**: `Factory/AirlineFactory.java`
- **Purpose**: Ensures only one instance of the airline factory exists
- **Usage**: Airline instance creation

### 2. **Factory Pattern**

- **Location**: `Factory/` directory
- **Purpose**: Creates airline objects without exposing instantiation logic
- **Usage**: Airline object creation

### 3. **Builder Pattern**

- **Location**: `Builder/` directory
- **Purpose**: Constructs complex objects step by step
- **Usage**: Customer and Flight object construction
- **Files**: `CustomerBuilder.java`, `FlightBuilder.java`

### 4. **Command Pattern**

- **Location**: `Command/` directory
- **Purpose**: Encapsulates requests as objects
- **Usage**: Booking and canceling tickets
- **Files**: `BookTicketCommand.java`, `CancelTicketCommand.java`, `TicketInvoker.java`

### 5. **Strategy Pattern**

- **Location**: `Strategy/` directory
- **Purpose**: Defines a family of algorithms and makes them interchangeable
- **Usage**: Different discount strategies
- **Files**: `ChristmasDiscountStrategy.java`, `SummerPromoStrategy.java`, `VeteranDiscountStrategy.java`

### 6. **Decorator Pattern**

- **Location**: `Decorator/` directory
- **Purpose**: Adds new functionality to objects dynamically
- **Usage**: Flight upgrades and enhancements
- **Files**: `ExtraLegRoomUpgrade.java`, `ExtraLuggageUpgrade.java`, `PremiumUpgrade.java`

### 7. **State Pattern**

- **Location**: `State/` directory
- **Purpose**: Allows objects to alter behavior when internal state changes
- **Usage**: Flight status management
- **Files**: `FlightCancelled.java`, `FlightDelayed.java`, `FlightInTransit.java`, etc.

### 8. **Observer Pattern**

- **Location**: `Observer/` directory
- **Purpose**: Defines a one-to-many dependency between objects
- **Usage**: Notifications for booking status changes
- **Files**: `EmailObserver.java`, `SMSObserver.java`

### 9. **Adapter Pattern**

- **Location**: `Adapter/` directory
- **Purpose**: Allows incompatible interfaces to work together
- **Usage**: Currency conversion for different regions
- **Files**: `CurrencyAdapter.java`, `USCurrency.java`, `EuroCurrency.java`, etc.

### 10. **Bridge Pattern**

- **Location**: `Bridge/` directory
- **Purpose**: Decouples abstraction from implementation
- **Usage**: Ticket features like meal preferences and seat changes
- **Files**: `MealPreferenceFeature.java`, `SeatChangeFeature.java`, `TicketFeature.java`

### 11. **Facade Pattern**

- **Location**: `Facade/` directory
- **Purpose**: Provides a simplified interface to a complex subsystem
- **Usage**: Data saving and loading operations
- **Files**: `SaveAndLoadFacadeAPI.java`, `SaveAndLoadToLocal.java`

### 12. **Prototype Pattern**

- **Location**: `Prototype/` directory
- **Purpose**: Creates new objects by cloning existing ones
- **Usage**: Booking cloning functionality
- **Files**: `TicketPrototype.java`

## Features

- **Flight Management**: Add, view, and manage flights with different states
- **Customer Management**: Create and manage customer profiles
- **Booking System**: Book and cancel tickets with command pattern
- **Discount System**: Apply various discount strategies
- **Upgrade System**: Add flight upgrades using decorator pattern
- **Currency Conversion**: Support for multiple currencies
- **Notification System**: Email and SMS notifications for booking changes
- **Data Persistence**: Save and load data using facade pattern
- **State Management**: Track flight status changes
- **Feature Management**: Handle seat changes and meal preferences

## Project Structure

```
src/main/java/edu/neu/csye7374/
├── Adapter/          # Currency conversion adapters
├── Bridge/           # Ticket feature implementations
├── Builder/          # Object construction patterns
├── Command/          # Booking command implementations
├── Decorator/        # Flight upgrade decorators
├── Facade/           # Data persistence facade
├── Factory/          # Object creation patterns
├── Interface/        # API interfaces
├── Observer/         # Notification system
├── Prototype/        # Object cloning
├── State/            # Flight state management
├── Strategy/         # Discount strategies
├── Util/             # Utility classes
├── Airline.java      # Main airline class
├── Booking.java      # Booking entity
├── Customers.java    # Customer entity
├── Demo.java         # Main demonstration class
├── Driver.java       # Application entry point
└── Flight.java       # Flight entity
```

## Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

## How to Run

1. **Clone the repository**:

   ```bash
   git clone <repository-url>
   cd DesignPatternsAirline
   ```

2. **Open in your IDE**:

   - Import as a Java project
   - Ensure the source folder `src/main/java` is marked as source root

3. **Run the application**:

   - Execute `Driver.java` or `Demo.java`
   - Follow the interactive menu to explore different design patterns
