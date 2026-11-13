# Projektkontext

Dieses Repository ist eine lokale Java-21-Maven-Übung für Reifebuch.
Die Demo-API verwendet synthetische Daten und liest Chargeninformationen.

# Fachliche Regeln für spätere Reifebuch-Funktionen

- Pflegeereignisse gehören zur gesamten Charge.
- Gewicht, Entsorgung und Verkauf beziehen sich auf einzelne Laibe.
- Nur der Innendienst erteilt die Verkaufsfreigabe. Der Keller meldet die Reife.
- Der Onlineshop zeigt Verfügbarkeit und Reifetermine.
- Reservierung, Bestellung und Bezahlung sind außerhalb von Release 1.
- Gespeicherte Ereignisse bleiben unverändert. Korrekturen erfolgen als Storno-Ereignisse.
- Offline-Einträge müssen später ohne Verlust synchronisiert werden.

# Entwicklung

- Verwende Java 21 und die vorhandene Maven-Struktur.
- Behalte vorhandene FA- und NFA-IDs aus den Anforderungen bei.
- Verwende verständliche Namen und kleine, nachvollziehbare Änderungen.
- Ergänze Abhängigkeiten erst nach Prüfung von Nutzen, Lizenz und Sicherheitslage.
- Verwende ausschließlich synthetische Testdaten.
- Baue mit `mvn clean compile` und starte mit `mvn exec:java`.
- Erzeuge eine SBOM mit `mvn cyclonedx:makeAggregateBom`.
- Prüfe, ob Code bestehende fachliche Regeln und Akzeptanzkriterien erfüllt.
