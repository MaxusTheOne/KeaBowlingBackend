

@Entity
public class AirhockeyTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public AirhockeyTable() {
    }

    public int getId() {
        return id;
    }
}