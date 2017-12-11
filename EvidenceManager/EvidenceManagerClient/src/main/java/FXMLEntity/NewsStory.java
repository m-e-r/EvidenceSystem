/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

/**
 * Stories to be shown in the news feed when logging in.
 * 
 * @author Kasper
 */
public enum NewsStory {
    //To write a new story, please name it STORYx+1 where x is the latest story.
    //Also use the format header:body to seperate the header from the body.
    STORY1("Police Dog On Fire:In a tragic event involving a police dog and a fire, a police dog accidently caught on fire, after a local officer threw a tennis ball into a fire in an attempt to put it out. \"They should really just let us do our job, and stick to throwing balls elsewhere\" - says head of fire department, Michael Fireman."),
    STORY2("New Chairs:The local department will recieve new chairs in the coming year. Expect to be asked about preferences in an email later this month."),
    STORY3("Woman Saves Officer:An officer was saved from embarrasment last tuesday, after a woman who wishes to remain anonymous asked him to close his zipper at the start of an 8 hour patrol shift."),
    STORY4("Sandwich Eater Found!:The person who has been eating bites of sandwiches left in the fridge has been found and punished accordingly.");
    
    private String story;
    
    NewsStory(String story) {
        this.story = story;
    }
    
    public String getStory() {
        return this.story;
    }
}
