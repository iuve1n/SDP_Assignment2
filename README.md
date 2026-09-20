# SDP Assignment 2

This is a Java console program about delivery and UI factories. The user chooses
how to deliver cargo and which UI style to use.

## Patterns

### Factory Method

Classes in `logistics` use Factory Method.

- `Transport` is the product interface.
- `Truck` and `Ship` are products.
- `Logistics` is the creator.
- `RoadLogistics` creates a `Truck`.
- `SeaLogistics` creates a `Ship`.

`planDelivery()` is in `Logistics`, so the same delivery steps are used for both
transport types.

### Abstract Factory

Classes in `ui` use Abstract Factory.

- `Button` and `Checkbox` are UI products.
- `GUIFactory` creates the UI products.
- `WindowsFactory` creates Windows widgets.
- `MacOSFactory` creates macOS widgets.

`DeliveryApplication` uses `GUIFactory` and `Logistics`. It does not need to know
which concrete classes were selected.

## Project folders

```
src/com/aitu/sdp/
├── Main.java
├── app/DeliveryApplication.java
├── logistics/
├── startup/ConsoleLauncher.java
└── ui/
    ├── macos/
    └── windows/
```

## Requirements

Use JDK 17 or newer. Maven and Gradle are not needed.

## Build and run

Compile the project:

```bash
javac --release 17 -Xlint:all -d out $(find src -name "*.java")
```

Run it:

```bash
java -cp out com.aitu.sdp.Main
```

Example with input:

```bash
printf 'ROAD\nWINDOWS\n' | java -cp out com.aitu.sdp.Main
```

## Inputs

Delivery mode can be `ROAD` or `SEA`.

Platform can be `WINDOWS` or `MACOS`.

Inputs can use lowercase letters too. Spaces at the start and end are ignored.

## Example output

```text
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): UI: rendering a Windows style button.
UI: rendering a Windows style checkbox.
Logistics: planning delivery of laboratory equipment to Aktau warehouse.
Truck: driving laboratory equipment to Aktau warehouse by road.
Logistics: delivery planned.
```

The full verification runs are in `docs/verification.md`.

## History

The commit history was made step by step while creating the project.
