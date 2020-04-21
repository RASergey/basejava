package com.urise.webapp.strategies;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Strategy {

    void doWrite(Resume resume, OutputStream os) throws IOException;

    Resume doRead(InputStream is) throws IOException;
}
