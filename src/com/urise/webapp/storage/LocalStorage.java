package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

import java.io.*;
import java.util.Arrays;

public class LocalStorage extends AbstractFileStorage {
    public LocalStorage() {
        super(new File("/home/sergey/java/basejava/storage"));
    }

    @Override
    protected void doWrite(Resume resume, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(resume.getFullName() + "\n");
        fileWriter.write(ContactType.EMAIL_ADDRESS.getTitle() + ": " + resume.getContacts(ContactType.EMAIL_ADDRESS) + "\n");
        fileWriter.write(ContactType.PHONE_NUMBER.getTitle() + ": " + resume.getContacts(ContactType.PHONE_NUMBER) + "\n");
        fileWriter.write(ContactType.SKYPE.getTitle() + ": " + resume.getContacts(ContactType.SKYPE) + "\n");
        Arrays.asList(SectionType.values()).forEach(it -> {
            try {
                fileWriter.write(it.getTitle() + ": " + resume.getSection(it));
            } catch (IOException e) {
                throw new StorageException("IO error", file.getName(), e);
            }
        });
        fileWriter.flush();
        fileWriter.close();
    }

    @Override
    protected Resume doRead(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader buff = new BufferedReader(new FileReader(file.getAbsolutePath()));
        String c;
        while ((c = buff.readLine()) != null) {
            content.append(c).append("\n");
        }
        return new Resume(content.toString());
    }
}
