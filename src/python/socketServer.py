#!/usr/bin/python  # This is socketServer.py file

import socket      # Import socket module
import _thread


def on_new_client(user, clientsocket, addr):
    global users
    while True:
        msg = clientsocket.recv(1024)
        # do some checks and if msg == someWeirdSignal: break:
        print(addr, ' >> ', msg)

        msg = str.strip(msg)

        try:
            if msg == "list":
                clientsocket.send("Active user : %s \n\r" % str.join(", ", users))

            elif msg == "@all":
                msg_split = str.split(msg, ' ', 1)
                name = msg_split[0]
                for u in users:
                    u.send("From %s: %s \n\r" % (user, msg_split[1]))

            elif str.startswith(msg, "@"):
                msg_split = str.split(msg, ' ', 1)
                name = msg_split[0]
                if name in users:
                    users[name].send("From %s: %s \n\r" % (user, msg_split[1]))

            elif msg == "exit":
                users.pop(user)
                clientsocket.send("Goodbye %s!\n\r" % user)
                clientsocket.close()
        except:
            print("Some error occured!")

if __name__ == "__main__":
    s = socket.socket()          # Create a socket object
    host = socket.gethostname()  # Get local machine name
    port = 7001                  # Reserve a port for your service.

    users = {}  # user list

    print('Server started!')
    print('Waiting for clients...')

    s.bind(("", port))  # Bind to the port
    s.listen(5)         # Now wait for client connection.

    while True:
        c, addr = s.accept()  # Establish connection with client.
        print('Got connection from', addr)
        name = ''
        try:
            name_check = True
            while (name_check):
                c.send("Enter username [min 2 and max. 8 chars] ; ")
                name = c.recv(1024)
                name = str.replace(name, '\n', '')
                name = str.replace(name, '\r', '')
                name = name.strip()
                name_check = name in users or name=="@all"
                name_check = len(name) < 2 or len(name) > 8

            c.send("Welcome %s! \n\r Commands: \n\r \tlist = list of active user\n\r \texit = disconnect\n\r \t@<user> = Message to <user>\n\r \t@<all> = broadcast message\n\r " % name)
            users['@' + name] = c
            thread.start_new_thread(on_new_client, (name, c, addr))
        except:
            print("Something happened!")

    print("Close server!")
    s.close()
