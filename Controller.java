import java.util.ArrayList;
import java.util.List;

public class Controller {
    private StreamService streamService;
    private StudyGroupService studyGroupService;

    public Controller(StreamService streamService, StudyGroupService studyGroupService) {
        this.streamService = streamService;
        this.studyGroupService = studyGroupService;
    }

    public void sortStreams(List<Stream> streams) {
        streamService.sortStreams(streams);
    }

    public StudyGroup createStudyGroup(int teacherId, List<Integer> studentIds) {
        Teacher teacher = getTeacherById(teacherId);
        List<Student> students = getStudentsByIds(studentIds);
        return studyGroupService.createStudyGroup(teacher, students);
    }

    private Teacher getTeacherById(int teacherId) {
        return new Teacher(teacherId, "Teacher Name");
    }

    private List<Student> getStudentsByIds(List<Integer> studentIds) {
        List<Student> students = new ArrayList<>();
        for (Integer id : studentIds) {
            students.add(new Student(id, "Student Name " + id));
        }
        return students;
    }

    public static void main(String[] args) {
        // Пример использования сортировки потоков
        Group group1 = new Group("Group 1");
        Group group2 = new Group("Group 2");
        Group group3 = new Group("Group 3");

        Stream stream1 = new Stream(List.of(group1));
        Stream stream2 = new Stream(List.of(group1, group2));
        Stream stream3 = new Stream(List.of(group1, group2, group3));

        List<Stream> streams = new ArrayList<>(List.of(stream3, stream1, stream2));

        Controller controller = new Controller(new StreamService(), new StudyGroupService());
        System.out.println("До сортировки:");
        for (Stream stream : streams) {
            System.out.println(stream.getGroups().size());
        }

        controller.sortStreams(streams);

        System.out.println("После сортировки:");
        for (Stream stream : streams) {
            System.out.println(stream.getGroups().size());
        }
        // Пример использования создания учебной группы
        int teacherId = 1;
        List<Integer> studentIds = List.of(1, 2, 3);
        StudyGroup studyGroup = controller.createStudyGroup(teacherId, studentIds);
        System.out.println("Созданная учебная группа: " + studyGroup);
    }
}

