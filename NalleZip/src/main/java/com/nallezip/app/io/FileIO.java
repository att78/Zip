/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nallezip.app.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//import sun.security.util.IOUtils;
/**
 *
 * @author tallbera
 */
public class FileIO {

    String filename;

    public FileIO(String filename) {
        this.filename = filename;
    }

    public byte[] readFile() throws IOException {
        Path route = Paths.get(filename);
        return Files.readAllBytes(route);

    }

    public void writeFile(byte[] bytes) throws IOException {
        Path route = Paths.get(filename);
        Files.write(route, bytes);

    }

}
