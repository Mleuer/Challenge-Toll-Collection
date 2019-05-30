### Problem Description
For this programming challenge, you are tasked with writing software that processes highway tolls. At its most basic, your program first reads in text input listing all vehicles that have passed through some toll booth on a certain day, then it computes and outputs the toll that should be charged to the driver of each vehicle as well as the total toll revenue earned at that toll booth for the day.

#### Input
The format of the input your program will read in is exactly as specified here: the record of all vehicles that have passed through the toll booth for the day will be in a file named `DetectedVehicles.txt`. Within `DetectedVehicles.txt`, each line represents a vehicle identified by the toll booth's Automated Vehicle Identification technology. Each line will contain the vehicle' **registration** ("license plate") **number**, **make**, **model**, **year**, **number of axles**, and **number of occupants**, in precisely that order. Below are a few example lines that follow this exact format, as found in `DetectedVehicles.txt` - you should design your program with the assumption that its input will be in this form:

```Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4```
```Registration: PRIME, Make: Peterbilt , Model: 379, Year: 1992, Axles: 3, Occupants: 0```
```Registration: NO1DAD, Make: Dodge, Model: Caravan, Year: 2015, Axles: 2, Occupants: 3```
```Registration: L43S322, Make: Mack, Model: Titan, Year: 2008, Axles: 6, Occupants: 1```
```Registration: OUTATIME, Make: DeLorean, Model: DeLorean, Year: 1982, Axles: 2, Occupants: 1```

As its first step, your program will need to read and parse its input from `DetectedVehicles.txt`.

#### Computation & Calculation
After reading in the data from `DetectedVehicles.txt`, your program will compute the toll owed by the owner of each vehicle using the following set of rules:
1.  The baseline toll charge for _every_ vehicle, regardless of the specific attributes of that vehicle, is $0.50.
2.  Vehicles with more than two axles pay an additional $0.50 for every axle after the first two.
3.  Vehicles with more than two occupants receive a $0.25 car-pool discount.
4.  Vehicles manufactured before 1995 pay an additional $0.25 emissions surcharge.

After calculating the toll owed by the owner of each vehicle, your program should compute the total revenue earned at the toll booth for the day by adding all the tolls from each vehicle together.

#### Expected Output
After computing the tolls for each vehicle and the total of all tolls collected, your program should output its results in the exact format described here. The output should start with a series of lines, each corresponding to a single vehicle (similar to the format of the provided input in `DetectedVehicles.txt`). However, unlike the input format, each line need only contain the registration number of the vehicle and the toll amount collected from that vehicle. The vehicle lines should be arranged in the same order as they were given in `DetectedVehicles.txt`. Finally, on the line below the line for the last vehicle, your program should give the total toll revenue earned across all vehicles. So for a program that took the above example input as its input, its output should be:

```Registration: Ecto-1, Toll: $0.50```
```Registration: PRIME, Toll: $1.25```
```Registration: NO1DAD, Toll: $0.25```
```Registration: L43S322, Toll: $2.50```
```Registration: OUTATIME, Toll: $0.75```
```Total: $5.25```

The exact expected output for your program, corresponding to the input given in `DetectedVehicles.txt`, can be found in `ExpectedOutput.txt`.

While your results must follow the format given above _exactly_, you have some flexibility in how you choose to output your results. You might choose to write them to a console window, or log them in a file, or use some other means altogether. As long as your text output follows the above format and matches what's given in `ExpectedOutput.txt` character-for-character, the medium by which you relay it is left to your discretion.

#### Additional Information
This should go without saying, but make no assumptions in your code about what particular vehicles (or attributes of those vehicles) will be listed inside `DetectedVehicles.txt`. While it's true that you'll be provided with a specific `DetectedVehicles.txt` with a set list of vehicles and their attributes, your code will be tested against an entirely different `DetectedVehicles.txt` with a wholly different set of vehicles. This means your program needs to read and parse `DetectedVehicles.txt` at runtime in order to compute tolls.

You can complete this challenge in whatever language you like, although Java or C# are recommended. You should include a README with your code that provides the user instructions on how to build and run your program. In case it wasn't already obvious, you will want to include `DetectedVehicles.txt` in your project so that it can be read from when your program is run.
