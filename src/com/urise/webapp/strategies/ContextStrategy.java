package com.urise.webapp.strategies;

import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ContextStrategy {
    Strategy strategy;

    public ContextStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doWrite(Resume resume, OutputStream os) throws IOException {
        strategy.write(resume, os);
    }

    public Resume doRead(InputStream is) throws IOException {
        return strategy.read(is);
    }
}
