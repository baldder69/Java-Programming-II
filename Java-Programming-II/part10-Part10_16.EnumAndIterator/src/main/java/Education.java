
public enum Education {
    
    PHD("Doctoral Degree"),
    MA("Masters Degree"),
    BA("Bachelor's Degree"),
    HS("High School diploma");
    
    private String education;
    
    private Education(String education){
        this.education = education;
    }
    
    public String getEducation(){
        return this.education;
    }
    
    
}
