public class SPY implements Comparable<SPY>{

    private String Exchange;
    private String Symbol;
    private String Shortname;
    private String Longname;
    private String Sector;
    private String Industry;
    private Double Currentprice;
    private Double Marketcap;
    private Double Ebitda;
    private Double Revenuegrowth;
    private String City;
    private String State;
    private String Country;
    private String Fulltimeemployees;
    private String Longbusinesssummary;
    private Double Weight;

    public SPY(String Exchange,
     String Symbol,
     String Shortname,
     String Longname,
     String Sector,
     String Industry,
     Double Currentprice,
     Double Marketcap,
     Double Ebitda,
     Double Revenuegrowth,
     String City,
     String State,
     String Country,
     String Fulltimeemployees,
     String Longbusinesssummary,
     Double Weight) {
        this.Exchange = Exchange;
        this.Symbol = Symbol;
        this.Shortname = Shortname;
        this.Longname = Longname;
        this.Sector = Sector;
        this.Industry = Industry;
        this.Currentprice = Currentprice;
        this.Marketcap = Marketcap;
        this.Ebitda = Ebitda;
        this.Revenuegrowth = Revenuegrowth;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.Fulltimeemployees = Fulltimeemployees;
        this.Longbusinesssummary = Longbusinesssummary;
        this.Weight = Weight;
    }

    @Override
    public String toString(){
        return  "Symbol: " + Symbol +  " Currentprice: " + Currentprice + " Marketcap: " + Marketcap + " Ebitda: " + Ebitda + " Revenuegrowth: " + Revenuegrowth + "\n";
    }

    @Override
    public int compareTo(SPY other){

        return this.Symbol.compareTo(other.Symbol);
    }

    @Override
    public boolean equals(Object obj){
        SPY other = (SPY) obj;
        return this.getSymbol().equals(other.getSymbol());

    }
    public String getSymbol(){
        return this.Symbol;
    }

    public String getCity(){
        return this.City;
    }

    public String getState(){
        return this.State;
    }

    public String getCountry(){
        return this.Country;
    }

    public String getFulltimeemployees(){
        return this.Fulltimeemployees;
    }

    public String getLongbusinesssummary(){
        return this.Longbusinesssummary;
    }

    public Double getWeight(){
        return this.Weight;
    }

    public String getShortname(){
        return this.Shortname;
    }

    public String getLongname(){
        return this.Longname;
    }

    public String getSector(){
        return this.Sector;
    }

    public String getIndustry(){
        return this.Industry;
    }
    public Double getCurrentprice(){
        return this.Currentprice;
    }

    public Double getMarketcap(){
        return this.Marketcap;
    }

    public Double getEbitda(){
        return this.Ebitda;
    }

    public Double getRevenuegrowth(){
        return this.Revenuegrowth;
    }

    // Set Methods

    public void setSymbol(String s){
        this.Symbol = s;
    }

    public void setCity(String s){
        this.City = s;
    }

    public void setState(String s){
        this.State = s;
    }

    public void setCountry(String s){
        this.Country = s;
    }

    public void setFulltimeemployees(String s){
        this.Fulltimeemployees = s;
    }

    public void setLongbusinesssummary(String s){
        this.Longbusinesssummary = s;
    }

    public void setWeight(double d){
        this.Weight = d;
    }

    public void setShortname(String d){
        this.Shortname = d;
    }

    public void setLongname(String d){
        this.Longname = d;
    }

    public void setSector(String s){
        this.Sector = s;
    }

    public void setIndustry(String s){
        this.Industry = s;
    }
    public void getCurrentprice(double d){
        this.Currentprice = d;
    }

    public void getMarketcap(double d){
        this.Marketcap = d;
    }

    public void getEbitda(double d){
        this.Ebitda = d;
    }

    public void getRevenuegrowth(double d){
        this.Revenuegrowth = d;
    }





}
