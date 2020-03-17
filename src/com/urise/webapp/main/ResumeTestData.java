package com.urise.webapp.main;

import com.urise.webapp.model.ContactSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;

import static java.time.format.DateTimeFormatter.ofPattern;

public class ResumeTestData {

    public static void main(String[] args) throws MalformedURLException {
        Resume resume = new Resume("Григорий Кислин");
        resume.setContacts(ContactSection.FULL_NAME, resume.getFullName());
        resume.setContacts(ContactSection.EMAIL_ADDRESS, "gkislin@yandex.ru");
        resume.setContacts(ContactSection.PHONE_NUMBER, "+7(921) 855-0482");
        resume.setContacts(ContactSection.SKYPE, "grigory.kislin");
        Arrays.asList(ContactSection.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getContacts(it)));

        resume.setSection(SectionType.PERSONAL, new ContentText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(SectionType.OBJECTIVE, new ContentText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        String achievement1 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," + " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." + " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.";
        String achievement2 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        String achievement3 = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
        String achievement4 = "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.";
        String achievement5 = "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).";
        String achievement6 = "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.";
        ContentList contentListAchievement = new ContentList();
        String[] achievements = {achievement1, achievement2, achievement3, achievement4, achievement5, achievement6};
        for (String text : achievements) {
            contentListAchievement.setContentList(text);
            resume.setSection(SectionType.ACHIEVEMENT, contentListAchievement);
        }

        String qualification1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        String qualification2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
        String qualification3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,";
        String qualification4 = "MySQL, SQLite, MS SQL, HSQLDB";
        String qualification5 = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,";
        String qualification6 = "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,";
        String qualification7 = "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).";
        String qualification8 = "Python: Django.";
        String qualification9 = "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
        String qualification10 = "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka";
        String qualification11 = "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
        String qualification12 = "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,";
        String qualification13 = "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.";
        String qualification14 = "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования";
        String qualification15 = "Родной русский, английский \"upper intermediate\"";
        ContentList contentListQualification = new ContentList();
        String[] qualifications = {qualification1, qualification2, qualification3, qualification4, qualification5, qualification6, qualification7, qualification8, qualification9, qualification10, qualification11, qualification12, qualification13, qualification14, qualification15};
        for (String text : qualifications) {
            contentListQualification.setContentList(text);
            resume.setSection(SectionType.QUALIFICATIONS, contentListQualification);
        }

        Experience experience = new Experience();
        ExperienceSection experience_1 = new ExperienceSection("Alcatel",
                LocalDate.parse("01/" + "09/1997", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "01/2005", ofPattern("dd/MM/yyyy")),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                new URL("http://www.alcatel.ru/"));
        experience.setExperience(experience_1);
        ExperienceSection experience_2 = new ExperienceSection("Siemens AG",
                LocalDate.parse("01/" + "01/2005", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "02/2007", ofPattern("dd/MM/yyyy")),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                new URL("https://www.siemens.com/ru/ru/home.html"));
        experience.setExperience(experience_2);
        ExperienceSection experience_3 = new ExperienceSection("Enkata",
                LocalDate.parse("01/" + "03/2007", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "06/2008", ofPattern("dd/MM/yyyy")),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                new URL("http://enkata.com/"));
        experience.setExperience(experience_3);
        ExperienceSection experience_4 = new ExperienceSection("Yota",
                LocalDate.parse("01/" + "06/2008", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "12/2010", ofPattern("dd/MM/yyyy")),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                new URL("https://www.yota.ru/"));
        experience.setExperience(experience_4);
        ExperienceSection experience_5 = new ExperienceSection("Luxoft (Deutsche Bank)",
                LocalDate.parse("01/" + "12/2010", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "04/2012", ofPattern("dd/MM/yyyy")),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                new URL("http://www.luxoft.ru/"));
        experience.setExperience(experience_5);
        ExperienceSection experience_6 = new ExperienceSection("RIT Center",
                LocalDate.parse("01/" + "04/2012", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "10/2014", ofPattern("dd/MM/yyyy")),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                null);
        experience.setExperience(experience_6);
        ExperienceSection experience_7 = new ExperienceSection("Wrike",
                LocalDate.parse("01/" + "10/2014", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "01/2016", ofPattern("dd/MM/yyyy")),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                new URL("https://www.wrike.com/"));
        experience.setExperience(experience_7);
        ExperienceSection experience_8 = new ExperienceSection("Java Online Projects",
                LocalDate.parse("01/" + "10/2013", ofPattern("dd/MM/yyyy")),
                LocalDate.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.",
                new URL("http://javaops.ru/"));
        experience.setExperience(experience_8);
        resume.setSection(SectionType.EXPERIENCE, experience);

        Education education = new Education();
        EducationSection education1 = new EducationSection("Заочная физико-техническая школа при МФТИ",
                LocalDate.parse("01/" + "09/1984", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "06/1987", ofPattern("dd/MM/yyyy")),
                "Закончил с отличием.",
                new URL("http://www.school.mipt.ru/"));
        education.setExperience(education1);
        EducationSection education2 = new EducationSection("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                LocalDate.parse("01/" + "09/1993", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "07/1996", ofPattern("dd/MM/yyyy")),
                "Аспирантура (программист С, С++)",
                new URL("http://www.ifmo.ru/"));
        education.setExperience(education2);
        EducationSection education3 = new EducationSection("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                LocalDate.parse("01/" + "09/1987", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "07/1993", ofPattern("dd/MM/yyyy")),
                "Инженер (программист Fortran, C)",
                new URL("http://www.ifmo.ru/"));
        education.setExperience(education3);
        EducationSection education4 = new EducationSection("Alcatel",
                LocalDate.parse("01/" + "09/1997", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "03/1998", ofPattern("dd/MM/yyyy")),
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                new URL("http://www.alcatel.ru/"));
        education.setExperience(education4);
        EducationSection education5 = new EducationSection("Siemens AG",
                LocalDate.parse("01/" + "01/2005", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "04/2005", ofPattern("dd/MM/yyyy")),
                "3 месяца обучения мобильным IN сетям (Берлин)",
                new URL("http://www.siemens.ru/"));
        education.setExperience(education5);
        EducationSection education6 = new EducationSection("Luxoft",
                LocalDate.parse("01/" + "03/2011", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "04/2011", ofPattern("dd/MM/yyyy")),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                new URL("http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"));
        education.setExperience(education6);
        EducationSection education7 = new EducationSection("Coursera",
                LocalDate.parse("01/" + "03/2013", ofPattern("dd/MM/yyyy")),
                LocalDate.parse("01/" + "05/2013", ofPattern("dd/MM/yyyy")),
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                new URL("https://www.coursera.org/course/progfun"));
        education.setExperience(education7);


        resume.setSection(SectionType.EDUCATION, education);
        Arrays.asList(SectionType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getSection(it)));
    }
}