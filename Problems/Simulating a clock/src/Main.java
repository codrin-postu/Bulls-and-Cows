class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        minutes += 1;

        if (minutes > 59) {
            minutes = 0;
            hours += 1;
        }

        if (hours > 12 ) {
            hours = 1;
        }
    }
}