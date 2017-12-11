/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXMLEntity;

/**
 *
 * @author Kasper
 */
public class News {
    private String date, header, body;
    
    public News(String date, String header, String body) {
        this.date = date;
        this.header = header;
        this.body = body;
    }
    
    public String getBody() {
        return this.body;
    }
    
    @Override
    public String toString() {
        return this.header + "\n" + this.date;
    }
}
