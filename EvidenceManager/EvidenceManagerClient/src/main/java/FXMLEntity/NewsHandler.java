/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kasper
 */
public class NewsHandler {
    
    public List<News> getNews() {
        List<News> returnList = new ArrayList();
    
        for (NewsStory story : NewsStory.values()) {
            String header = story.getStory().split(":")[0];
            String body = story.getStory().split(":")[1];
            returnList.add(new News(this.genDate(), header, body));
        }
        
        return returnList;
    }
    
    private String genDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM-yy");        
        return sdf.format(new Date());
    }

}
