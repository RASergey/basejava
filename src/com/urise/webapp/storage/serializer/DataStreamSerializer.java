package com.urise.webapp.storage.serializer;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.*;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, Section> sectionMap = resume.getSectionMap();
            dos.writeInt(sectionMap.size());
            for (Map.Entry<SectionType, Section> entry : sectionMap.entrySet()) {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                dos.writeUTF(type.name());
                switch (type) {
                    case PERSONAL:
                    case OBJECTIVE:
                        dos.writeUTF(((TextSection) section).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        List<String> items = new ArrayList<>(((ListSection) section).getItems());
                        dos.writeInt(items.size());
                        for (String item : items) {
                            dos.writeUTF(item);
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        List<Organization> organizations = new ArrayList<>(((OrganizationSection) section).getOrganizations());
                        dos.writeInt(organizations.size());
                        for (Organization organization : organizations) {
                            dos.writeUTF(organization.getHomePage().getName());
                            dos.writeUTF(organization.getHomePage().getUrl());
                            List<Organization.Position> organizationItems = new ArrayList<>(organization.getPositions());
                            dos.writeInt(organizationItems.size());
                            for (Organization.Position position : organizationItems) {
                                dos.writeInt(position.getStartDate().getYear());
                                dos.writeInt(position.getStartDate().getMonth().getValue());
                                dos.writeInt(position.getEndDate().getYear());
                                dos.writeInt(position.getEndDate().getMonth().getValue());
                                dos.writeUTF(position.getTitle());
                                dos.writeUTF(position.getDescription());
                            }
                        }
                        break;
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        Resume resume;
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                ContactType contactType = ContactType.valueOf(dis.readUTF());
                String value = dis.readUTF();
                resume.addContacts(contactType, value);
            }
            int sectionSize = dis.readInt();
            for (int i = 0; i < sectionSize; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        resume.addSection(sectionType, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        int listSectionSize = dis.readInt();
                        for (int j = 0; j < listSectionSize; j++) {
                            resume.addSection(sectionType, new ListSection(dis.readUTF()));
                        }
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        int organizationSectionSize = dis.readInt();
                        for (int j = 0; j < organizationSectionSize; j++) {
                            resume.addSection(sectionType, new OrganizationSection(
                                    new Organization(
                                            new Link(dis.readUTF(), dis.readUTF()),
                                            addPosition(dis, new Organization.Position(
                                                    getLocalDate(dis), getLocalDate(dis)
                                                    , dis.readUTF(), dis.readUTF())))));
                        }
                        break;
                }
            }
            return resume;
        }
    }

    private List<Organization.Position> addPosition(DataInputStream dis, Organization.Position position) throws IOException {
        int size = dis.readInt();
        List<Organization.Position> positions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            positions.add(position);
        }
        return positions;
    }

    private LocalDate getLocalDate(DataInputStream dis) throws IOException {
        return LocalDate.of(dis.readInt(), Month.of(dis.readInt()), 1);
    }
}
