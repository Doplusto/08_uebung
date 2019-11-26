
_Übungsaufgabe zur Veranstaltung [IT
Systeme](https://hsro-wif-it.github.io) im [Bachelorstudiengang
Wirtschaftsinformatik](https://www.th-rosenheim.de/technik/informatik-mathematik/wirtschaftsinformatik-bachelor/) an der [Hochschule Rosenheim](http://www.th-rosenheim.de)._

# 08 - Netzwerke Part II (IP Adressen, Ports, Sockets)

Diese Übung behandelt das Thema _Netzwerke_ und vertieft dabei die
Themen IP Addressing, Ports und Sockets.

> Note: **Die Lösung befindet sich im Branch _Musterlösung_.**

## Aufgabe 1: Java und Sockets

"Ethan Hunt, wir haben auf geheimen Wegen erfahren, dass bei einer uns
verdächtigen Organisation auf einem Computersystem ein Service läuft,
der ungesichert ist. Wenn wir Zugriff auf diesen Service erlangen würden, könnten wir in das System
eindringen und wichtige Daten abgreifen. Allerdings kennen wir nur die IP Adresse, wissen aber
nicht auf welchem Port die Applikation horcht.

Ihre Aufgabe ist nun:

**Schreiben Sie ein Java Programm, dass heraus findet, welcher Port
offen ist. Wir haben leider nur die Information, dass es einer von den
folgenden sein kann: 5501-5509, 6003-6010, 6997-7007**

Hierzu gehen Sie am besten, wie folgt vor:
- Schreiben Sie eine Methode `isPortOpen`, die folgende Signatur `static
boolean portIsOpen(String ip, int port, int timeout)` hat.
- Iterieren Sie über die Liste der möglichen Ports und finden so den offen Port.

Akzeptieren Sie den Auftrag? - Wenn ja, dann übermitteln wir Ihnen die
IP Adresse!

Viel Erfolg, Ethan!

Dieser Auftrag zerstört sich in 5 Sekunden selbst!"

[Check this out!](https://vimeo.com/38437470)

## Aufgabe 2: Telnet Session

Nachdem Sie nun herausgefunden haben, welcher Port offen ist, können
Sie versuchen mit Telnet herauszufinden, was die Applikation macht!

Starten hierzu eine Telnet-Sitzung und verbinden sich gegen den
entsprechenden Port!

## Aufgabe 3: Socket Server und Client in Java

Bilden Sie eine Gruppe mit mindestens 2 Personen und schreiben Sie ein einfaches Chat
Programm für 2 Computer. Schreiben Sie hierzu einen `ChatServer.java`
und einen `ChatClient.java`, so dass Sie ähnlich wie in Aufgabe 2
miteinander kommunizieren können. In dieser Aufgabe können Sie davon ausgehen, dass es nur einen Server gibt, der genau einen Client via Socket akzeptiert und mit diesem kommuniziert.

Schreiben Sie das ChatProgram in Java. Verwenden Sie den Editor ihrer Wahl, es geht auch IntelliJ!

Was müssen hierzu machen?

1. Finden Sie einen Port, auf dem ihr Server horchen wird.
1. Entwickeln Sie zunächst den `ChatServer`. Dieser soll einen `SocketServer`verwenden und auf einen Client warten, der sich gegen den entsprechenden Port verbinden möchte.
1. Schreiben sie nun einen `ChatClient`, der sich gegen den Server verbindet. -- Nun haben Sie immerhin schon einen verbindung!
1. Einigen Sie sich nun auf das Protokoll.

  - Idealerweise fängt der Client an und schickt eine Nachricht, danach erwartet er einen Nachricht vom Server.
  - Beim Server ist es genau umgekehrt. Sobald ein Client sich verbunden hat, erwartet der Server eine Nachricht vom Client und danach schickt der Server einen Antwort
  - Verwenden Sie zum Anfang dieses einfache Ping-Pong Protokoll.
  - Die Server Logik lässt sich wieder sehr gut mit `telnet` testen.
1. Wenn Sie noch Lust haben, können Sie sich mal die `run`-Methoden ansehen und evtl. eine gemeinsame Oberklasse daraus extrahieren!

Ein paar Hinweise:

1. Hier der Klassenrumpf für den `ChatServer`:

```java
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private int port;

    ChatServer(int port) {
        this.port = port;
    }

    public void run() {

        try {
          /// your code goes here!

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatServer serv = new ChatServer(????);
        serv.run();
    }
}

```

2. Hier der Klassenrumpf für den `ChatClient`:

```java
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    private String hostname;
    private int port;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void run() {

        try {
          /// your code goes here!

        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient(????, ?????);
        client.run();
    }
}
```

3. Ein- und auslesen vom Socket/ Console funktioniert ganz gut hiermit (Natürlich muss da noch irgendwo eine Schleife rein, sonst wird der Chat eher kurz!
)):

  ```java
  // zum Schreiben
  OutputStream output = socket.getOutputStream();
  PrintWriter writer = new PrintWriter(output, true);

  // zum Lesen
  InputStream input = socket.getInputStream();
  BufferedReader reader = new BufferedReader(new InputStreamReader(input));

  // Zum Einlesen von der Console
  Console console = System.console();
  String text, msg;

  // vom Socket
  msg = reader.readLine();
  System.out.println(" >> " + msg);

  // Console
  text = console.readLine(" >> ");
  writer.println(text);
```

4. Starten Sie den `ChatServer` zuerst und danach den `ChatClient`. Beides idealerweise von der Shell/Comandline!!! (Wo sind ihr Class-Dateien?)

```shell
>java ChatServer
```

```shell
>java ChatClient
```
