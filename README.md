# CorbaServer

### Running

- Start orbd (on Linux):
```
  sudo orbd -ORBInitialHost localhost -ORBInitialPort 900
```
- Start CorbaServer in IDE or manually in `CorbaServer` directory:
```
  java -cp out/production/CorbaServer:lib/joda-time-2.9.6.jar server.StartServer
```

- Start CorbaClient in IDE or manually in `CorbaClient` directory:
```
  java -cp out/production/CorbaClient/ corbaclient.StartClient
```
- Enter two dates in dd-MM-yyyy format
