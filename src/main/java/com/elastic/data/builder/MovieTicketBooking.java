package com.elastic.data.builder;

public class MovieTicketBooking {
    private final String movie;
    private final int totalTickets;
    private final int popcorn;
    private final int pizza;
    private final int burger;
    private final int coke;

    private MovieTicketBooking(Builder builder) {
        movie = builder.movie;
        totalTickets = builder.totalTickets;
        popcorn = builder.popcorn;
        pizza = builder.pizza;
        burger = builder.burger;
        coke = builder.coke;
    }

    public static class Builder{
        private final String movie;
        private final int totalTickets;
        private int popcorn;
        private int pizza;
        private int burger;
        private int coke;

        public Builder(String movie, int totalTickets) {
            this.movie = movie;
            this.totalTickets = totalTickets;
        }

        public Builder popcorn(int val){
            popcorn = val;
            return this;
        }

        public Builder pizza(int val){
            pizza = val;
            return this;
        }

        public Builder burger(int val){
            burger = val;
            return this;
        }

        public Builder coke(int val){
            coke = val;
            return this;
        }

        public MovieTicketBooking build()  {
            return new MovieTicketBooking(this);
        }
    }


    public String getMovie() {
        return movie;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getPopcorn() {
        return popcorn;
    }

    public int getPizza() {
        return pizza;
    }

    public int getBurger() {
        return burger;
    }

    public int getCoke() {
        return coke;
    }
}


//    MovieTicketBooking movieTest = MovieTicketBooking.Builder("3 Idiots", 5)
//            .popcorn(2)
//            .burger(3)
//            .coke(5)
//            .build();


//    MovieTicketBooking.Builder movieBuilder =
//            MovieTicketBooking.Builder("3 Idiots", 5);
//
//    MovieTicketBooking movieTest1 = movieBuilder.popcorn(2).build();
//    MovieTicketBooking movieTest2 = movieBuilder.coke(5).build();