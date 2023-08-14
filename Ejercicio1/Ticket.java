public class Ticket {
    private int number;
    private int a;
    private int b;

    public Ticket(int number) {
        this.number = number;
        a = (int) (Math.random() * 15000) + 1;
        b = (int) (Math.random() * 15000) + 1;  
    }

    public boolean isValid(Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        int minRange = Math.min(a, b);
        int maxRange = Math.max(a, b);
        if (number >= minRange && number <= maxRange) {
            return localidad1.isTicketValid(number) || localidad5.isTicketValid(number) || localidad10.isTicketValid(number);
        }
        return false;
    }

    public Localidad selectRandomLocation(Localidad localidad1, Localidad localidad5, Localidad localidad10) {
        int randomValue = (int) (Math.random() * 3); // Generar un número aleatorio entre 0 y 2

        switch (randomValue) {
            case 0:
                if (localidad1.hasSpace()) {
                    return localidad1;
                }
                break;
            case 1:
                if (localidad5.hasSpace()) {
                    return localidad5;
                }
                break;
            case 2:
                if (localidad10.hasSpace()) {
                    return localidad10;
                }
                break;
        }

        // Si no hay espacio disponible en ninguna localidad, retornar null
        return null;
    }
}
