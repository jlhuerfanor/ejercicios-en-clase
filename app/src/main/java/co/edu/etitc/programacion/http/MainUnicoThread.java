package co.edu.etitc.programacion.http;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainUnicoThread {
    private static final Executor executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor HTTP escuchando en puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                executor.execute(() -> {
                    try(clientSocket) {
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        System.out.printf("Nuevo cliente. Puerto: %d, Puerto local: %d%n", 
                            clientSocket.getPort(), clientSocket.getLocalPort());
                        // Leer la petición (opcional, solo para limpiar el buffer)
                        var in = new java.io.BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
                        String line;
                        System.out.println("Leyendo la petición:");
                        while ((line = in.readLine()) != null && !line.isEmpty()) {
                            // Solo consumir la petición
                            System.out.println(line);
                        }
                        
                        System.out.printf("Recibido: %s%nEsperando respuesta...%n", LocalDateTime.now());
                        Thread.sleep(5000);

                        // Responder con Hola mundo!
                        out.print("HTTP/1.1 200 OK\r\n");
                        out.print("Content-Type: text/plain; charset=UTF-8\r\n");
                        out.print("Content-Length: 11\r\n");
                        out.print("Connection: close\r\n");
                        out.print("\r\n");
                        out.print("Hola mundo!");
                        out.flush();

                        clientSocket.close();
                    } catch (Exception e) {
                        System.err.println("Error en el servidor: " + e.getMessage());
                    }
                });
            }
        } catch (Exception e) {
            System.err.println("No se pudo iniciar el servidor: " + e.getMessage());
        }
    }
}
