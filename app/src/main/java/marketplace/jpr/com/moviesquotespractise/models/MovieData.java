package marketplace.jpr.com.moviesquotespractise.models;

public class MovieData {




    private String quote;
    private String writer;

    //Getter and Setter

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    //To String
    @Override
    public String toString() {
        return "MovieData{" +
                "quote='" + quote + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }



}
