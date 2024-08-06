import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {
    public int id;
    public String concertHall;
    public String eventCode;
    public Timestamp eventTime;
    public boolean isPromo;
    public char stadiumSector;
    public float maxWeight;
    public BigDecimal price;
    public final LocalDateTime creationTime = LocalDateTime.now();

    private static int currentID = 1000;

    // getValues methods
    public static int getNextID() {
        if (currentID == 9999) {
            System.out.println("The maximum value of id was reached. The id generation started again from 1000.");
            currentID = 1000;
        }
        return currentID++;
    }

    public int getID() {
        return id;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public boolean getIsPromo() {
        return isPromo;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public float getMaWeight() {
        return maxWeight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Timestamp getEventTime() {
        return eventTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    // constructors
    public Ticket() {
        this.id = getNextID();
    }

    public Ticket(String concertHall, String eventCode, Timestamp eventTime, boolean isPromo,
                  char stadiumSector, float maxWeight, BigDecimal price) {
        this.id = getNextID();
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.eventTime = eventTime;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxWeight = maxWeight;
        this.price = price;
    }

    // overriding object methods
    @Override
    public String toString() {
        return "Ticket ID: " + getID() + "\n" +
                "Ticket creation time is: " + getCreationTime() + "\n" +
                "Concert hall is: " + getConcertHall() + "\n" +
                "Event code is: " + getEventCode() + "\n" +
                "Event time is: " + getEventTime() + "\n" +
                "Ticket is promo:" + getIsPromo() + "\n" +
                "Stadium sector is: " + getStadiumSector() + "\n" +
                "Max allowed backpack weight: " + String.format("%.2f", getMaWeight()) + " kg.g" + "\n" +
                "Price = " + getPrice() + " EUR\n";
    }
}