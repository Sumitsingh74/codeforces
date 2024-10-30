import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Attendee {
    private String name;
    private String email;

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Speaker {
    private String name;
    private String topic;

    public Speaker(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }
}

class Session {
    private String title;
    private String speaker;
    private String time;
    private List<Attendee> attendees;

    public Session(String title, String speaker, String time) {
        this.title = title;
        this.speaker = speaker;
        this.time = time;
        this.attendees = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTime() {
        return time;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }
}

class Conference {
    private List<Attendee> attendees;
    private List<Speaker> speakers;
    private List<Session> sessions;

    public Conference() {
        this.attendees = new ArrayList<>();
        this.speakers = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    public void addAttendee(String name, String email) {
        Attendee attendee = new Attendee(name, email);
        attendees.add(attendee);
        System.out.println("Attendee " + name + " added successfully.");
    }

    public void addSpeaker(String name, String topic) {
        Speaker speaker = new Speaker(name, topic);
        speakers.add(speaker);
        System.out.println("Speaker " + name + " added successfully.");
    }

    public void scheduleConference(String title, String speakerName, String time) {
        for (Speaker speaker : speakers) {
            if (speaker.getName().equals(speakerName)) {
                Session session = new Session(title, speakerName, time);
                sessions.add(session);
                System.out.println("Conference '" + title + "' scheduled successfully.");
                return;
            }
        }
        System.out.println("Speaker " + speakerName + " not found.");
    }

    public void listAttendees() {
        if (attendees.isEmpty()) {
            System.out.println("No attendees registered yet.");
        } else {
            System.out.println("List of Attendees:");
            for (Attendee attendee : attendees) {
                System.out.println("Name: " + attendee.getName() + ", Email: " + attendee.getEmail());
            }
        }
    }

    public void listSpeakers() {
        if (speakers.isEmpty()) {
            System.out.println("No speakers added yet.");
        } else {
            System.out.println("List of Speakers:");
            for (Speaker speaker : speakers) {
                System.out.println("Name: " + speaker.getName() + ", Topic: " + speaker.getTopic());
            }
        }
    }

    public void listConferences() {
        if (sessions.isEmpty()) {
            System.out.println("No conferences scheduled yet.");
        } else {
            System.out.println("List of Conferences:");
            for (Session session : sessions) {
                System.out.println("Title: " + session.getTitle() + ", Speaker: " + session.getSpeaker() + ", Time: " + session.getTime());
            }
        }
    }

    public void addAttendeeToConference(String title, String attendeeName) {
        Attendee attendee = attendees.stream().filter(a -> a.getName().equals(attendeeName)).findFirst().orElse(null);
        if (attendee == null) {
            System.out.println("Attendee " + attendeeName + " not found.");
            return;
        }

        Session session = sessions.stream().filter(s -> s.getTitle().equals(title)).findFirst().orElse(null);
        if (session == null) {
            System.out.println("Conference titled '" + title + "' not found.");
            return;
        }

        session.addAttendee(attendee);
        System.out.println("Attendee " + attendeeName + " added to conference '" + title + "'.");
    }

    public void listParticipantsInConference(String title) {
        Session session = sessions.stream().filter(s -> s.getTitle().equals(title)).findFirst().orElse(null);
        if (session == null) {
            System.out.println("Conference titled '" + title + "' not found.");
            return;
        }

        System.out.println("Participants in conference '" + title + "':");
        System.out.println("Speaker: " + session.getSpeaker());
        if (session.getAttendees().isEmpty()) {
            System.out.println("No attendees for this conference yet.");
        } else {
            for (Attendee attendee : session.getAttendees()) {
                System.out.println("Attendee: " + attendee.getName());
            }
        }
    }
}

public class CMSApp {
    public static void main(String[] args) {
        Conference conference = new Conference();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nConference Management System");
            System.out.println("1. Add Attendee");
            System.out.println("2. Add Speaker");
            System.out.println("3. Schedule Conference");
            System.out.println("4. List Attendees");
            System.out.println("5. List Speakers");
            System.out.println("6. List Conferences");
            System.out.println("7. Add Attendee to Conference");
            System.out.println("8. List Participants in a Conference");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter attendee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter attendee email: ");
                    String email = scanner.nextLine();
                    conference.addAttendee(name, email);
                }
                case 2 -> {
                    System.out.print("Enter speaker name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter speaker topic: ");
                    String topic = scanner.nextLine();
                    conference.addSpeaker(name, topic);
                }
                case 3 -> {
                    System.out.print("Enter conference title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter speaker name: ");
                    String speakerName = scanner.nextLine();
                    System.out.print("Enter session time: ");
                    String time = scanner.nextLine();
                    conference.scheduleConference(title, speakerName, time);
                }
                case 4 -> conference.listAttendees();
                case 5 -> conference.listSpeakers();
                case 6 -> conference.listConferences();
                case 7 -> {
                    System.out.print("Enter conference title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter attendee name: ");
                    String attendeeName = scanner.nextLine();
                    conference.addAttendeeToConference(title, attendeeName);
                }
                case 8 -> {
                    System.out.print("Enter conference title: ");
                    String title = scanner.nextLine();
                    conference.listParticipantsInConference(title);
                }
                case 9 -> {
                    System.out.println("Exiting the Conference Management System.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
