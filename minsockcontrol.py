from socket import AF_INET, SOCK_STREAM, socket

sock = socket(AF_INET, SOCK_STREAM)

class Client:
    def __init__(self, addr="localhost", port=6666):
        sock.connect((addr, port))
        sock.send(b'Python\n')
    
    def jseval(self, cmd):
        buf = b"JS "
        buf = buf + cmd.encode()
        buf = buf + "\n".encode()
        sock.send(buf)
        return sock.recv(16384)
    def close(self):
        sock.close()
