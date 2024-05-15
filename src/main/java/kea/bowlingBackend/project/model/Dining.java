

@Entity
public class Dining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Dining() {
    }

    public int getId() {
        return id;
    }
}