# Reifebuch Uebungsprojekt

Lokale Demo für Software Engineering I, Übung 2.1/3 und 2.2/3-4.
Die API liefert synthetische Daten. Fachliche Funktionen des Teamprojekts
werden in den UML-Modellen beschrieben.

## Start

JDK 21 und Maven 3.9 verwenden.

```bash
mvn clean compile
mvn exec:java
```

GET http://127.0.0.1:8080/api/chargen liefert eine JSON-Liste.
Mit Strg+C beenden.

## Abhängigkeiten und SBOM

```bash
mvn dependency:tree
mvn cyclonedx:makeAggregateBom
```

Die SBOM steht in target/bom.json.
