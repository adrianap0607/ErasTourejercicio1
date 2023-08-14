public class Localidad {
        private int number;
        private int price;
        private int capacity;
        private int availability;
    
        public Localidad(int number, int price, int capacity) {
            this.number = number;
            this.price = price;
            this.capacity = capacity;
            this.availability = capacity;
        }
    
        public boolean hasSpace() {
            return availability > 0;
        }
    
        public boolean hasAvailability(int numTickets) {
            return availability >= numTickets;
        }
    
        public boolean isAffordable(int budget) {
            return price <= budget;
        }
    
        public boolean isTicketValid(int ticketNumber) {
            return ticketNumber >= number && ticketNumber <= number + capacity;
        }
    
        // Getters y setters
        public int getNumber() {
            return number;
        }
    
        public void setNumber(int number) {
            this.number = number;
        }
    
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getCapacity() {
            return capacity;
        }
    
        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    
        public int getAvailability() {
            return availability;
        }
    
        public void setAvailability(int availability) {
            this.availability = availability;
        }
    }
