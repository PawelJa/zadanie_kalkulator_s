zadanie_kalkulator_s

# Api description

Project created to calculate earnings per month using Api from NBP to get actual currencies rates.
As data source is used XML file. Default, there are 3 countries available : Uunited Kingdom, Germany and Poland but You can add your own countries.

Used:
-Java
-Spring Boot
-HTML
-CSS
-JavaSCript
-jQuery


# Runing jUnit tests

in main directory of project use command [*mvn test*]


# Build and run application

**Building:
in main directory of project use command [*mvn spring-boot:run*]
Default port for application: 8080

**Running:
to run front-end run file [\\*src/main/resources/views/index.html\*]


# Adding new countries to database file
In file [*(src/main/resources/data/data.xml)*] you can add your own countries to api.
Add complited lines:

<countries id= /*shortcut of country name*/ >
	<fullName> /*full name of Country */ </fullName>
	<taxPErcent> /*tax in % in this country*/ </taxPercent>
	<oncost> /* oncosts in this country */ </oncost>
	<currency> /* simbol of currency */ </currency>
</country>

into section:
<countries>
	here
</countries>

for example:

Some basic Git commands are:
```
<countries>
	<countries id= /*shortcut of country name*/>
		<fullName> [*full name of Country *] </fullName>
		<taxPErcent> /*tax in % in this country*/ </taxPercent>
		<oncost> /* oncosts in this country */ </oncost>
		<currency> /* simbol of currency */ </currency>
</country>
</countries>


```
