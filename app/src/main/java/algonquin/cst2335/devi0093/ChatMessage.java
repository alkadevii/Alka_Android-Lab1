package algonquin.cst2335.devi0093;
public class ChatMessage {
    String message;
    String timeSent;
    boolean isSentButton;
    public ChatMessage(String m, String t, boolean sent){
        message=m;
        timeSent=t;
        isSentButton=sent;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setTimeSent(String timeSent){
        this.timeSent=timeSent;
    }
    public String getTimeSent(){
        return this.timeSent;
    }
    public void setIsSentButton(boolean isSentButton){
        this.isSentButton=isSentButton;
    }
    public boolean getIsSentButton(){
        return this.isSentButton;
    }
}
