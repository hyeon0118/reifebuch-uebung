# Demo-API von Reifebuch

Die Demo-API stellt synthetische Chargendaten bereit.
Sie dient als lokaler Test-Endpunkt für den JMeter-Lasttest.

## Endpunkt

GET http://127.0.0.1:8080/api/chargen

## Antwortfelder

Die API liefert eine JSON-Liste mit folgenden Feldern:

- chargennummer: Nummer der Charge.
- sorte: Käsesorte der Charge.
- laibeImKeller: Anzahl der Laibe im Keller.
## API starten

Im Projektverzeichnis ausführen:

```bash
mvn clean compile
mvn exec:java
```

Das Terminal geöffnet lassen und den Endpunkt im Browser aufrufen:
http://127.0.0.1:8080/api/chargen

## Beispielantwort

```json
[
  {
    "laibeImKeller": 24,
    "sorte": "Bergkaese",
    "chargennummer": "2026-112"
  }
]
```