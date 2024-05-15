

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private string uID;
    private Date reservationTime;
    private int peopleAmount;
    private string bookingType;
    private int bookingTypeID;


    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getuID() {
        return uID;
    }

    public void setuID(string uID) {
        this.uID = uID;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(int peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    public string getBookingType() {
        return bookingType;
    }

    public void setBookingType(string bookingType) {
        this.bookingType = bookingType;
    }

    public int getBookingTypeID() {
        return bookingTypeID;
    }

    public void setBookingTypeID(int bookingTypeID) {
        this.bookingTypeID = bookingTypeID;
    }
}