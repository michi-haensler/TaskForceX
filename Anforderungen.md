# Anforderungsmanagement - SchoolMatch

## 1. Einleitung
### 1.1 Ziel des Projekts
SchoolMatch ist eine Webanwendung, die es Schülern ermöglicht, Lernpartner, Freundschaften und Gruppen für Schulprojekte basierend auf gemeinsamen Interessen zu finden. Das System soll ähnlich wie Tinder funktionieren, jedoch mit einem Fokus auf Bildung und Teamarbeit.

### 1.2 Projektumfang
Das Projekt umfasst:
- Benutzerregistrierung und -anmeldung
- Matching-System für Nutzer
- Echtzeit-Chat
- Gruppen- und Event-Management
- Sichere Authentifizierung
- Deployment als Web-App

---
## 2. Funktionale Anforderungen
### 2.1 Benutzerverwaltung
- Registrierung mit Schul-E-Mail und Passwort
- Login/Logout-Funktion
- Bearbeiten des Benutzerprofils (Name, Interessen, Klasse, Bild-Upload)

### 2.2 Matching-System
- Swipe-Funktion nach Interessen und Lernfächern
- Vorschlag von Nutzern basierend auf Matching-Algorithmus
- Like/Dislike-Funktion
- Anzeige von Matches

### 2.3 Chat-Funktion
- Nachrichtenversand zwischen gematchten Nutzern
- Dateiaustausch (z. B. für Notizen)
- Gruppen-Chats für gemeinsame Lernmeetings

### 2.4 Gruppen & Events
- Erstellung von Lerngruppen
- Events und Lernmeetings planen
- Beitreten zu Gruppen

### 2.5 Sicherheit
- Authentifizierung über JWT
- HTTPS-Verschlüsselung
- Profildaten nur für registrierte Nutzer sichtbar

---
## 3. Nicht-funktionale Anforderungen
### 3.1 Performance
- Antwortzeit des Servers < 2 Sekunden
- Skalierbarkeit für 500+ Nutzer

### 3.2 Usability
- Intuitive Benutzeroberfläche
- Responsive Design für mobile und Desktop-Nutzung

### 3.3 Wartbarkeit
- Modularer Code für einfache Erweiterungen
- Dokumentation für Entwickler

### 3.4 Datenschutz
- DSGVO-konforme Speicherung von Nutzerdaten
- Löschen von Accounts auf Anfrage
