# Verification runs

All runs below were produced from a clean build of commit `1eea24e` and pasted
here exactly as the terminal printed them.

Build command (no warnings, no errors):

```
javac --release 17 -Xlint:all -d out $(find src -name "*.java")
```

Run command:

```
java -cp out com.aitu.sdp.Main
```

Scripted runs feed the two answers through a pipe, for example
`printf 'ROAD\nWINDOWS\n' | java -cp out com.aitu.sdp.Main`.
The two prompts are printed with `print`, not `println`, so in a piped run they
appear on the same line as the first line of output.

## Summary

| # | Delivery mode | Platform | Expected | Result | Exit code |
|---|---------------|----------|----------|--------|-----------|
| 1 | ROAD | WINDOWS | Truck delivery, Windows widgets | as expected | 0 |
| 2 | SEA | WINDOWS | Ship delivery, Windows widgets | as expected | 0 |
| 3 | ROAD | MACOS | Truck delivery, macOS widgets | as expected | 0 |
| 4 | SEA | MACOS | Ship delivery, macOS widgets | as expected | 0 |
| 5 | PLANE | WINDOWS | Validation message, no delivery | as expected | 0 |
| 6 | ROAD | LINUX | Validation message, no widgets | as expected | 0 |
| 7 | (empty) | (empty) | Validation message, no stack trace | as expected | 0 |

## Transcripts

### Run 1 — road delivery with the Windows family

Input:

```
ROAD
WINDOWS
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): UI: rendering a Windows style button.
UI: rendering a Windows style checkbox.
Logistics: planning delivery of laboratory equipment to Aktau warehouse.
Truck: driving laboratory equipment to Aktau warehouse by road.
Logistics: delivery planned.
```

Exit code: 0

### Run 2 — sea delivery with the Windows family

Input:

```
SEA
WINDOWS
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): UI: rendering a Windows style button.
UI: rendering a Windows style checkbox.
Logistics: planning delivery of laboratory equipment to Aktau warehouse.
Ship: shipping laboratory equipment to Aktau warehouse by sea.
Logistics: delivery planned.
```

Exit code: 0

### Run 3 — road delivery with the macOS family

Input:

```
ROAD
MACOS
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): UI: rendering a macOS style button.
UI: rendering a macOS style checkbox.
Logistics: planning delivery of laboratory equipment to Aktau warehouse.
Truck: driving laboratory equipment to Aktau warehouse by road.
Logistics: delivery planned.
```

Exit code: 0

### Run 4 — sea delivery with the macOS family

Input:

```
SEA
MACOS
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): UI: rendering a macOS style button.
UI: rendering a macOS style checkbox.
Logistics: planning delivery of laboratory equipment to Aktau warehouse.
Ship: shipping laboratory equipment to Aktau warehouse by sea.
Logistics: delivery planned.
```

Exit code: 0

### Run 5 — unsupported delivery mode

Input:

```
PLANE
WINDOWS
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): Unsupported delivery mode. Please start again and enter ROAD or SEA.
```

Exit code: 0

### Run 6 — unsupported platform

Input:

```
ROAD
LINUX
```

Output:

```
Choose delivery mode (ROAD or SEA): Choose platform (WINDOWS or MACOS): Unsupported platform. Please start again and enter WINDOWS or MACOS.
```

Exit code: 0

### Run 7 — no input at all (end of file)

Input: none, the standard input is closed immediately.

Output:

```
Choose delivery mode (ROAD or SEA): 
Choose platform (WINDOWS or MACOS): 
Unsupported delivery mode. Please start again and enter ROAD or SEA.
```

Exit code: 0

## What the runs prove

1. Runs 1 and 2 keep the platform and change only the delivery mode: the widgets
   stay Windows and the transport changes from a truck to a ship.
2. Runs 1 and 3 keep the delivery mode and change only the platform: the
   transport stays a truck and both widgets change to macOS at once.
3. All four valid combinations work without editing a single line of code.
4. Run 5 stops before any delivery is planned, and run 6 stops before any widget
   is created, because both answers are validated before any object is built.
5. Run 7 ends with the same clear message instead of an exception, so closed
   input is treated as invalid input.
6. The macOS family runs on this machine the same way the Windows family does;
   the classes only print text, so neither family depends on the real operating
   system.
