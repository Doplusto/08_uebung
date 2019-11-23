
_Übungsaufgabe zur Veranstaltung [IT
Systeme](https://hsro-wif-it.github.io) im [Bachelorstudiengang
Wirtschaftsinformatik](https://www.th-rosenheim.de/technik/informatik-mathematik/wirtschaftsinformatik-bachelor/) an der [Hochschule Rosenheim](http://www.th-rosenheim.de)._

# 08 - Netzwerke Part II (IP Adressen, Ports, Sockets)

Diese Übung behandelt das Thema _Netzwerke_ und vertieft dabei die
Themen IP Addressing, Ports und Sockets.

> Note: **Die Lösung befindet sich im Branch _Musterlösung_.**

## Aufgabe 1: Java und Sockets

"Jason Hunt, wir haben auf geheimen Wegen erfahren, dass bei einer uns
verdachtigen Orgnisation auf einem Computersystem ein Service laueft,
der ungesichert ist. Dieses wuerde uns gestatten in das System
einzudringen. Allerdings kennen wir nur die IP Adresse, wissen aber
nicht auf welchem Port die Applikation horcht.

Ihre Aufgabe ist nun:

**Schreiben Sie ein Java Programm, dass heraus findet, welcher Port
offen ist. Wir haben leider nur die Information, dass es einer von den
folgenden sein kann: 5005-5015, 5501-5599, 6003-6010, 6997-7023**

Hierzu gehen Sie am besten, wie folgt vor:
- Schreiben Sie eine Methode `isPortOpen`, die folgende Signatur `static
boolean portIsOpen(String ip, int port, int timeout)` hat.
- Iterieren Sie ueber die Liste der moeglichen Ports.

Akzeptieren Sie den Auftrag? - Wenn ja, dann uebermitteln wir Ihnen die
IP Adresse!

Viel Erfolg!

Dieser Auftrag zerstoert sich in 5 Sekunden selbst!"

## Aufgabe 2: Telnet Session

Nachdem Sie nun herausgefunden haben, welcher Port offen ist, koennen
Sie versuchen mit Telnet herauszufinden, was die Applikation macht!

Starten hierzu eine Telnet-Sitzung und verbinden sich gegen den
entsprechenden Port!


## Aufgabe 3: Socket Server und Client in Java


Bilden Sie eine Gruppe mit mindestens 2 Personen und schreiben Sie Chat
Programm fuer 2 Computer. Schreiben Sie hierzu einen `SocketServer.java`
und einen `SocketClient.java`, so dass Sie aehnlich wie in Aufgabe 2
miteinander kommunizieren.

Was muessen hierzu machen?

1. Einigen Sie sich wer von Ihnen den `SocketServer` entwickelt und wer
den `SocketClient`.
  - Einigen Sie sich auf den Port
  - Einigen Sie sich darauf, welche Nachrichten Sie austauschen wollen.
2. Schreiben Sie zunaechst den `SocketServer`
  - Dieser horcht auf einen Port. Welcher?
  - Er hat nur einen Thread und akzeptiert auch nur einen Client.
3. Testen Sie ihren `SocketServer`
  - Wie?
4. Schreiben Sie nun ihren `SocketClient` und testen, ob er sich mit dem
`SocketServer` verbindet
  - Erweitern Sie evtl. die Funktionalitaet, so dass Sie abwechselnd
Nachrichten schicken koennen.
