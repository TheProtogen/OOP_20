public class DayOfWeek {

    // Function to calculate the day of the week
    public static String calculateDayOfWeek(int day, int month, int year) {
        // January and February are counted as months 13 and 14 of the previous year
        if (month < 3) {
            month += 12;
            year -= 1;
        }

        // Calculate the century and year of the century
        int century = year / 100;
        int yearOfCentury = year % 100;

        // Zeller's Congruence formula
        int h = (day + (13 * (month + 1) / 5) + yearOfCentury + (yearOfCentury / 4) + (century / 4) + (5 * century)) % 7;

        // Array to map the result to the day of the week
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Return the corresponding day of the week
        return daysOfWeek[h];
    }

    public static void main(String[] args) {
        // Example usage

        int day = 22;
        int month = 8;
        int year = 2024;

        String dayOfWeek = calculateDayOfWeek(day, month, year);
        System.out.println("The day of the week for " + day + "/" + month + "/" + year + " is: " + dayOfWeek);
    }
}