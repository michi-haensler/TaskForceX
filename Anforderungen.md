# Anforderungsmanagement - SchoolMatch

## 1. Einleitung
### 1.1 Ziel des Projekts
SchoolMatch ist eine Webanwendung, die es Schülern ermöglicht, Lernpartner, Freundschaften und Gruppen für Schulprojekte basierend auf gemeinsamen Interessen zu finden. Das System soll ähnlich wie Tinder funktionieren, jedoch mit einem Fokus auf Bildung und Teamarbeit. Durch ein intelligentes Matching-System und interaktive Funktionen wird eine effiziente Vernetzung zwischen Schülern ermöglicht.

### 1.2 Projektumfang
Das Projekt umfasst folgende Hauptkomponenten:
- **Benutzerregistrierung und -anmeldung**: Sicheres Anmeldeverfahren, um die Identität der Nutzer zu bestätigen.
- **Matching-System für Nutzer**: Algorithmus zur Berechnung kompatibler Nutzerprofile basierend auf Interessen und Lernfächern.
- **Echtzeit-Chat**: Kommunikation zwischen gematchten Nutzern mit Medien- und Dateiaustausch.
- **Gruppen- und Event-Management**: Erstellung und Verwaltung von Lerngruppen und Schulprojekten.
- **Sichere Authentifizierung**: Schutz der Nutzerdaten durch moderne Verschlüsselungsmethoden.
- **Deployment als Web-App**: Responsive Anwendung für verschiedene Endgeräte mit Cloud-Hosting.

---
## 2. Funktionale Anforderungen

### 2.1 Benutzerverwaltung
- **Registrierung mit Schul-E-Mail und Passwort**: Jeder Nutzer muss sich mit einer gültigen Schuladresse registrieren.
- **Login/Logout-Funktion**: Sicherer Zugang mit verschlüsseltem Passwort.
- **Passwort-Reset-Funktion**: Möglichkeit zur Wiederherstellung des Passworts über eine Verifizierungs-E-Mail.
- **Benutzerprofilverwaltung**:
  - Eingabe von Name, Interessen, Klasse und einem Profilbild.
  - Bearbeitung der persönlichen Daten über eine benutzerfreundliche Oberfläche.
  - Datenschutzoptionen zur Kontrolle der Sichtbarkeit des Profils.

### 2.2 Matching-System
- **Swipe-Funktion**:
  - Nutzer können durch vorgeschlagene Profile navigieren und Matches durch "Like" oder "Dislike" markieren.
  - UI-Elemente zur einfachen Nutzung der Swipe-Funktion.
- **Matching-Algorithmus**:
  - Analyse der angegebenen Interessen und Lernfächer.
  - Berücksichtigung vergangener Matches für intelligentere Vorschläge.
  - Möglichkeit, nach spezifischen Kriterien zu filtern (z. B. bevorzugte Fächer, Lernmethoden).
- **Anzeige der Matches**:
  - Eine separate Match-Übersicht mit aktiven und vergangenen Matches.
  - Möglichkeit, Matches nach Relevanz zu sortieren.

### 2.3 Gruppen & Events
- **Erstellung von Lerngruppen**:
  - Gruppen können öffentlich oder privat sein.
  - Admin-Funktionen zur Verwaltung der Gruppenmitglieder.
- **Events und Lernmeetings planen**:
  - Möglichkeit, Veranstaltungen mit Datum, Uhrzeit und Ort zu erstellen.
  - Erinnerungsfunktion für anstehende Lerntermine.
- **Beitreten zu Gruppen**:
  - Nutzer können Gruppenanfragen stellen oder offene Gruppen beitreten.

### 2.4 Sicherheit
- **Authentifizierung über JWT**: Sicheres Token-basiertes Login-System.
- **HTTPS-Verschlüsselung**: Alle Datenübertragungen erfolgen über sichere Protokolle.
- **Profildaten nur für registrierte Nutzer sichtbar**: Einschränkung der Sichtbarkeit für nicht eingeloggte Nutzer.

---
## 3. Nicht-funktionale Anforderungen

### 3.1 Performance
- **Antwortzeit des Servers < 2 Sekunden**: Optimierung der API-Aufrufe für schnelle Ladezeiten.
- **Skalierbarkeit für 500+ Nutzer**: Nutzung von Cloud-Diensten zur flexiblen Skalierung.

### 3.2 Usability
- **Intuitive Benutzeroberfläche**: Klare Navigation und ansprechendes Design für eine einfache Bedienung.
- **Responsive Design**: Optimierung für Mobilgeräte und Desktops.

### 3.3 Wartbarkeit
- **Modularer Code für einfache Erweiterungen**: Klare Trennung zwischen Frontend und Backend.
- **Dokumentation für Entwickler**: Bereitstellung einer API-Dokumentation und Coding-Guidelines.

### 3.4 Datenschutz
- **DSGVO-konforme Speicherung von Nutzerdaten**: Transparente Speicherung und Nutzung personenbezogener Daten.
- **Löschen von Accounts auf Anfrage**: Möglichkeit zur vollständigen Datenlöschung nach Nutzerwunsch.

---
## 4. Technische Anforderungen

### 4.1 Backend
- **Spring Boot** mit **REST-API**
- **PostgreSQL** oder **MySQL** als Datenbank
- **JWT-Authentifizierung** für sicheren Zugriff

### 4.2 Frontend
- **HTML, CSS, JavaScript**
- **React oder Vue.js** für interaktive UI-Komponenten

### 4.3 Infrastruktur
- **Deployment auf Heroku oder AWS** für skalierbare Bereitstellung
- **WebSockets** für Echtzeit-Chat und Live-Interaktionen

---
## 5. Risikoanalyse
| Risiko                     | Wahrscheinlichkeit | Auswirkungen | Maßnahmen |
|----------------------------|-------------------|-------------|------------|
| Fehlende Erfahrung mit Spring Boot | Hoch | Mittel | Tutorials, externe Hilfe einholen |
| Sicherheitslücken im Login-System | Mittel | Hoch | JWT-Auth, HTTPS nutzen |
| Verzögerung durch Bugs | Mittel | Mittel | Agile Entwicklung mit Tests |

---
## 6. Zeitplan (4 Monate)
| Woche | Aufgabe |
|--------|---------|
| 1-2    | Planung & UI-Design |
| 3-5    | Backend-Entwicklung |
| 6-8    | Frontend-Entwicklung |
| 9-11   | Integration & Testing |
| 12-16  | Optimierung & Deployment |

---
