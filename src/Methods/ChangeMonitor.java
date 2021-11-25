package Methods;

import java.io.IOException;
import java.nio.file.*;

import static Methods.WebServer.CreateServer.stopServer;
import static java.nio.file.StandardWatchEventKinds.*;

import static Methods.EchoMain.initialMethod;


public class ChangeMonitor {

    public static void fileMonitor() {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("C:\\Users\\Public\\Documents\\EchoStatsLogger");
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (kind == ENTRY_MODIFY &&
                            fileName.toString().equals("continuousStorage.json")) {
                        System.out.println("Stats file has been modified.");
                        stopServer();
                        initialMethod();



                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}